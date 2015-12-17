//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.40 build 2183.15436)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.therapies.forms.plinthwork;

import ims.core.admin.vo.ClinicalContactRefVo;
import ims.core.vo.CareContextShortVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.core.vo.Hcp;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.PersonName;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.therapies.vo.PlinthWorkActivitiesVo;
import ims.therapies.vo.PlinthWorkActivitiesVoCollection;
import ims.therapies.vo.PlinthWorkAnalysisVo;
import ims.therapies.vo.PlinthWorkAnalysisVoCollection;
import ims.therapies.vo.PlinthWorkShortVoCollection;
import ims.therapies.vo.PlinthWorkTreatmentVo;
import ims.therapies.vo.PlinthWorkTreatmentVoCollection;
import ims.therapies.vo.PlinthWorkVo;
import ims.therapies.vo.lookups.LookupHelper;
import ims.therapies.vo.lookups.PlinthWorkActivity;
import ims.therapies.vo.lookups.PlinthWorkActivityCollection;
import ims.therapies.vo.lookups.PlinthWorkBalanceAnalysis;
import ims.therapies.vo.lookups.PlinthWorkBalanceAnalysisCollection;
import ims.therapies.vo.lookups.PlinthWorkTreatment;
import ims.therapies.vo.lookups.PlinthWorkTreatmentCollection;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		open();	
	}
	private void open()
	{
		form.setMode(FormMode.VIEW);
		fillRecordBrowser();
	}
	private void fillRecordBrowser()
	{
		PlinthWorkShortVoCollection voPlinthWorkShort = domain.getPlinthWorkByCareContext(form.getGlobalContext().Core.getCurrentCareContext());
		
		loadCareContext();
		boolean currentClinicalContactFound = false;
		if(voPlinthWorkShort != null)
		{
			for(int i=0; i<voPlinthWorkShort.size(); i++)
			{
				ClinicalContactShortVo voClinicalContact = voPlinthWorkShort.get(i).getClinicalContact();
				
				if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull() && form.getGlobalContext().Core.getCurrentClinicalContact().getID_ClinicalContact().equals(voClinicalContact.getID_ClinicalContact()))
				{
					currentClinicalContactFound = true;
					loadClinicalContact(voClinicalContact, Color.Green);
				}
				else
				{
					loadClinicalContact(voClinicalContact, null);
				}
			}
		}
		
		if(!currentClinicalContactFound && form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			loadClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact(), Color.Green);
		
		browseRecord();
	}
	private void loadCareContext()
	{
		CareContextShortVo voCareContext = form.getGlobalContext().Core.getCurrentCareContext();
		form.recbrPlinth().newRow(voCareContext, voCareContext.getRecordBrowserText());
	}
	private void browseRecord()
	{
		clearScreen();
		prePopulateGrids();
		updateBrowseInformation();
		
		if(form.recbrPlinth().getValue() != null && form.recbrPlinth().getValue() instanceof ClinicalContactShortVo)
		{
			form.getLocalContext().setPlinthWork(domain.getPlinthWorkByClinicalContact((ClinicalContactRefVo) form.recbrPlinth().getValue()));
			populateScreen(form.getLocalContext().getPlinthWork());
		}
		isRecordEditable();
	}
	private void clearScreen()
	{
		form.qmbAuthoringCP().clear();
		form.dtimAuthoring().setValue(null);
		form.grdAnalysis().getRows().clear();
		form.grdPosition().getRows().clear();
		form.grdTreatment().getRows().clear();
	}
	private void isRecordEditable()
	{
		boolean isEditable = false;
		ClinicalContactShortVo voSelectedClinicalContact = form.getGlobalContext().Core.getCurrentClinicalContact();
		
		if(voSelectedClinicalContact != null)
		{
			if(form.recbrPlinth().getValue() instanceof ClinicalContactShortVo)
			{
				ClinicalContactShortVo voContact = (ClinicalContactShortVo) form.recbrPlinth().getValue();
				if(voContact.getID_ClinicalContact().equals(voSelectedClinicalContact.getID_ClinicalContact()))
					isEditable = true;
			}
		}
		
		form.btnNew().setVisible(isEditable);
		form.btnUpdate().setVisible(isEditable);
		
		if(isEditable)
		{
			if(form.getLocalContext().getPlinthWorkIsNotNull())
			{
				form.btnNew().setVisible(false);
				form.btnUpdate().setEnabled(true);
				form.btnUpdate().setVisible(true);
			}
			else
			{
				form.btnNew().setEnabled(true);
				form.btnNew().setVisible(true);
				form.btnUpdate().setVisible(false);
			}
		}
		
	}
	private void loadClinicalContact(ClinicalContactShortVo voClinicalContact, Color current)
	{
		form.recbrPlinth().newRow(voClinicalContact, "\t\t\t\t\t ClinicalContact: " + voClinicalContact.getStartDateTime()+" - "+ voClinicalContact.getSeenBy().toString(), current);
		if(current != null)
			form.recbrPlinth().setValue(voClinicalContact);
	}
	private void prePopulateGrids()
	{
		prePopulateAnalysisGrid();
		prePopulateTreatmentGrid();
		prePopulatePositionGrid();
	}
	private void prePopulateAnalysisGrid()
	{
		GenForm.grdAnalysisRow row = null;
		form.grdAnalysis().getRows().clear();
		PlinthWorkBalanceAnalysisCollection AnalysisColl = LookupHelper.getPlinthWorkBalanceAnalysis(domain.getLookupService());
		for (int i = 0; i < AnalysisColl.size(); i++)
		{
			PlinthWorkBalanceAnalysis analysis = AnalysisColl.get(i);
			row = form.grdAnalysis().getRows().newRow();
			row.setColBalanceAnalysis(analysis);
		}	
	}
	private void prePopulateTreatmentGrid()
	{
		GenForm.grdTreatmentRow row = null;
		form.grdTreatment().getRows().clear();
		PlinthWorkTreatmentCollection treatColl = LookupHelper.getPlinthWorkTreatment(domain.getLookupService());
		for (int i = 0; i < treatColl.size(); i++)
		{
			PlinthWorkTreatment treatment = treatColl.get(i);
			row = form.grdTreatment().getRows().newRow();
			row.setColTreatment(treatment);
		}
	}
	private void prePopulatePositionGrid()
	{
		GenForm.grdPositionRow row = null;
		form.grdPosition().getRows().clear();
		PlinthWorkActivityCollection activitesColl = LookupHelper.getPlinthWorkActivity(domain.getLookupService());
		for (int i = 0; i < activitesColl.size(); i++)
		{
			PlinthWorkActivity activity = activitesColl.get(i);
			row = form.grdPosition().getRows().newRow();
			row.setColPosition(activity);
		}
	}

	private void populateScreen(PlinthWorkVo voPlinth)
	{
		if(voPlinth == null) return;
		
		form.qmbAuthoringCP().newRow(voPlinth.getAuthoringCP(), voPlinth.getAuthoringCP().toString());
		form.qmbAuthoringCP().setValue(voPlinth.getAuthoringCP());
		form.dtimAuthoring().setValue(voPlinth.getAuthoringDateTime());
		
		if(voPlinth.getAnalysis() != null && voPlinth.getAnalysis().size()>0)
			populateAnalysisGrid(voPlinth.getAnalysis());
		
		if(voPlinth.getTreatment() != null)
			populateTreatmentGrid(voPlinth.getTreatment());
		
		if(voPlinth.getActivities() != null)
			populateActivitiesGrid(voPlinth.getActivities());
	}
	private void populateAnalysisGrid(PlinthWorkAnalysisVoCollection voAnalysisColl)
	{
		if(voAnalysisColl!= null)
		{
			GenForm.grdAnalysisRow row;
			for(int y=0; y<voAnalysisColl.size(); y++)
			{
				PlinthWorkAnalysisVo voAna = voAnalysisColl.get(y);
				int a =0;
				for(a=0; a<form.grdAnalysis().getRows().size(); a++)
				{
					row = form.grdAnalysis().getRows().get(a);
					if(row.getColBalanceAnalysis().equals(voAna.getBalanceAnalysis()))
					{
						row.setColDynamic(voAna.getDynamic());
						row.setColStatic(voAna.getStaticAnalysis());
						break;
					}
				}
				if(a == form.grdAnalysis().getRows().size())
				{
					row = form.grdAnalysis().getRows().newRow();
					row.setValue(voAna);
					row.setColBalanceAnalysis(voAna.getBalanceAnalysis());
					row.setColDynamic(voAna.getDynamic());
					row.setColStatic(voAna.getStaticAnalysis());
				}
			}
		}
	}
	private void populateTreatmentGrid(PlinthWorkTreatmentVoCollection voTreatColl)
	{
		if(voTreatColl!= null)
		{
			GenForm.grdTreatmentRow row;
			for(int y=0; y<voTreatColl.size(); y++)
			{
				PlinthWorkTreatmentVo voTreat = voTreatColl.get(y);
				int t =0;
				for(t=0; t<form.grdTreatment().getRows().size(); t++)
				{
					row = form.grdTreatment().getRows().get(t);
					if(row.getColTreatment().equals(voTreat.getTreatment()))
					{
						row.setColTreatment(voTreat.getTreatment());
						row.setColComments(voTreat.getDetails());
						break;
					}
				}
				if(t == form.grdTreatment().getRows().size())
				{
					row = form.grdTreatment().getRows().newRow();
					row.setValue(voTreat);
					row.setColTreatment(voTreat.getTreatment());
					row.setColComments(voTreat.getDetails());
				}
			}
		}
	}
	private void populateActivitiesGrid(PlinthWorkActivitiesVoCollection voActivitiesColl)
	{
		if(voActivitiesColl!= null)
		{
			GenForm.grdPositionRow row;
			for(int y=0; y<voActivitiesColl.size(); y++)
			{
				PlinthWorkActivitiesVo voAct = voActivitiesColl.get(y);
				int p =0;
				for(p=0; p<form.grdPosition().getRows().size(); p++)
				{
					row = form.grdPosition().getRows().get(p);
					if(row.getColPosition().equals(voAct.getPosition()))
					{
						row.setColPosition(voAct.getPosition());
						row.setColActivity(voAct.getActivity());
						break;
					}
				}
				if(p == form.grdPosition().getRows().size())
				{
					row = form.grdPosition().getRows().newRow();
					row.setValue(voAct);
					row.setColPosition(voAct.getPosition());
					row.setColActivity(voAct.getActivity());
				}
			}
		}
	}
	
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		PlinthWorkVo voPlinthWork = null;
		if(form.getLocalContext().getPlinthWork() == null)
			voPlinthWork = new PlinthWorkVo();
		else
			voPlinthWork = form.getLocalContext().getPlinthWork();
		
		voPlinthWork.setAuthoringCP(form.qmbAuthoringCP().getValue());
		voPlinthWork.setAuthoringDateTime(form.dtimAuthoring().getValue());
		
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull())
			voPlinthWork.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
		
		voPlinthWork.setAnalysis(populateDataFromGridAnalysis());
		
		//Treatment
		voPlinthWork.setTreatment(populateDataFromGridTreatment());
		
		//Activities
		voPlinthWork.setActivities(populateDataFromGridActivities());
		
		String[] errors = voPlinthWork.validate();
		if (errors != null)
		{
			engine.showErrors("Validation Errors", errors);
			return;
		}
		
		try
		{
			domain.savePlinthWork(voPlinthWork);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage("A Plinth Work record already exists. " + e.getMessage());
			open();
			return;
		}
	
		open();
	}
	private PlinthWorkActivitiesVoCollection populateDataFromGridActivities()
	{
		PlinthWorkActivitiesVoCollection voActsColl = null;
		GenForm.grdPositionRow rowPos;
		for(int i=0; i<form.grdPosition().getRows().size(); i++)
		{
			rowPos = form.grdPosition().getRows().get(i);
			PlinthWorkActivitiesVo voAct = rowPos.getValue();
			if(voAct == null)
				voAct = new PlinthWorkActivitiesVo();
			
			voAct.setPosition(rowPos.getColPosition());
			voAct.setActivity(rowPos.getColActivity());
			if(rowPos.getColActivity() != null)
			{
				if(voActsColl == null)
					voActsColl = new PlinthWorkActivitiesVoCollection();	
				voActsColl.add(voAct);
			}		
		}
		return voActsColl;
	}
	private PlinthWorkTreatmentVoCollection populateDataFromGridTreatment()
	{
		PlinthWorkTreatmentVoCollection voTreatColl = null;	
		GenForm.grdTreatmentRow rowTreat;
		for(int i=0; i<form.grdTreatment().getRows().size(); i++)
		{
			rowTreat = form.grdTreatment().getRows().get(i);
			PlinthWorkTreatmentVo voTreat = rowTreat.getValue();
			if(voTreat == null)
				voTreat = new PlinthWorkTreatmentVo();
			
			voTreat.setTreatment(rowTreat.getColTreatment());
			voTreat.setDetails(rowTreat.getColComments());
			if(rowTreat.getColComments() != null)
			{
				if(voTreatColl == null)
					voTreatColl = new PlinthWorkTreatmentVoCollection();
				voTreatColl.add(voTreat);
			}
				
		}
		return voTreatColl;
	}
	private PlinthWorkAnalysisVoCollection populateDataFromGridAnalysis()
	{
		PlinthWorkAnalysisVoCollection voAnalysisColl = null;	
		
		GenForm.grdAnalysisRow row;
		for(int i=0; i<form.grdAnalysis().getRows().size(); i++)
		{
			row = form.grdAnalysis().getRows().get(i);
			PlinthWorkAnalysisVo voAnalysis = row.getValue();
			if(voAnalysis == null)
				voAnalysis = new PlinthWorkAnalysisVo();
			
			voAnalysis.setBalanceAnalysis(row.getColBalanceAnalysis());
			voAnalysis.setDynamic(row.getColDynamic());
			voAnalysis.setStaticAnalysis(row.getColStatic());
			if(row.getColStatic() != null || row.getColDynamic()!= null)
			{
				if(voAnalysisColl == null)
					voAnalysisColl = new PlinthWorkAnalysisVoCollection();
				voAnalysisColl.add(voAnalysis);
			}		
		}
		return voAnalysisColl;
	}
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		enableAuthoringControls(false);
	}
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);	
		enableAuthoringControls(true);
		setDefaultValues();
	}
	private void enableAuthoringControls(boolean enable)
	{
		form.qmbAuthoringCP().setEnabled(enable);
		form.dtimAuthoring().setEnabled(enable);
	}
	private void setDefaultValues()
	{
		Hcp voHcp = (Hcp) domain.getHcpUser();
		if(voHcp != null)
		{
			form.qmbAuthoringCP().newRow(voHcp, voHcp.toString());
			form.qmbAuthoringCP().setValue(voHcp);
		}
	
		form.dtimAuthoring().setValue(new DateTime());
	}
	protected void onQmbAuthoringCPTextSubmited(String value) throws PresentationLogicException
	{
		form.qmbAuthoringCP().clear();
		HcpFilter filter = new HcpFilter();
		PersonName name = new PersonName();
		name.setSurname(value);
		filter.setQueryName(name);
		
		HcpCollection coll = domain.listMedics(filter);
		for (int i = 0; i < coll.size(); i++)
		{
			Hcp med = coll.get(i);
			form.qmbAuthoringCP().newRow(med, med.toString());			
		}
		if (coll.size() == 1)
		{
			form.qmbAuthoringCP().setValue(coll.get(0));
		}
		else if (coll.size() > 1)
		{
			form.qmbAuthoringCP().showOpened();		
		}		
		
	}
	private void updateBrowseInformation()
	{
		form.lblBrowserStatus().setValue(form.recbrPlinth().getRecordState("Assessment", "Assessments"));
	}
	protected void onRecbrPlinthValueChanged() throws PresentationLogicException
	{
		browseRecord();
	}
	protected void onFormModeChanged()
	{
		
	}
}
//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.80 build 4847.21738)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.eas.forms.diagnosticimagetransferworklist;

import java.util.ArrayList;
import java.util.Comparator;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.eas.forms.diagnosticimagetransferworklist.GenForm.grdResultsRow;
import ims.eas.vo.DiagnosticImageTransferSearchCriteriaVo;
import ims.eas.vo.DiagnosticImageTransferVo;
import ims.eas.vo.DiagnosticImageTransferVoCollection;
import ims.eas.vo.enums.EasAction;
import ims.eas.vo.lookups.EASStatus;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;


public class Logic extends BaseLogic
{
	public class DiagnosticImageComparator implements Comparator<DiagnosticImageTransferVo>
	{
		public int compare(DiagnosticImageTransferVo arg0, DiagnosticImageTransferVo arg1)
		{
			int dateOrder = arg0.getDateSeen().compareTo(arg1.getDateSeen());
			
			if (dateOrder == 0)
			{
				if (arg0.getPatient().getHospnum() != null && arg1.getPatient().getHospnum() != null)
					return arg0.getPatient().getHospnum().getValue().compareTo(arg1.getPatient().getHospnum().getValue());
				
				if (arg0.getPatient().getHospnum() != null && arg1.getPatient().getHospnum() == null)
					return 1;
				
				if (arg0.getPatient().getHospnum() == null && arg1.getPatient().getHospnum() != null)
					return -1;
			}

			return dateOrder;
		}
	}


	private static final long serialVersionUID = 1L;

	//---------------------------------------------------------------------------------------------------------------
	//	Event handler functions
	//---------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// Initialise the form (set global & local context, set default values, etc)
		initialize();
		
		// If there is a search criteria saved perform save after it
		if (form.getGlobalContext().EAS.getDiagnosticImageTransferWorklistSearchCriteria() != null)
		{
			search(false);
		}
		
		updateControlsState();
	}
	
	
	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if (form.getForms().EAS.RemovalReason.equals(formName) && DialogResult.OK.equals(result))
		{
			try
			{
				domain.recordRemovalReason(form.grdResults().getValue(), form.getGlobalContext().EAS.getRemovalReason().getRemovalReason());
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				search(false);
			}
		}
		
		search(false);
		
		updateControlsState();
	}
	
	
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// If the search criteria is valid - retain it in global context and perform search
		if (validateSearchCriteria())
		{
			saveSearchCriteria();
			
			search(true);
		}
		
		updateControlsState();
	}


	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		// Clear search criteria
		form.getGlobalContext().EAS.setDiagnosticImageTransferWorklistSearchCriteria(null);
		
		// Clear screen
		clear();
		
		updateControlsState();
	}


	@Override
	protected void onQmbResponsibleHCPTextSubmited(String value) throws PresentationLogicException
	{
		populateResponsibleHcp(domain.listHCP(value, true));
	}


	@Override
	protected void onQmbSeenByTextSubmited(String value) throws PresentationLogicException
	{
		populateSeenBy(domain.listHCP(value, false));
	}
	
	
	@Override
	protected void onGrdResultsSelectionChanged()
	{
		if (form.grdResults().getSelectedRow() != null)
		{
			DiagnosticImageTransferVo easRecord = form.grdResults().getSelectedRow().getValue();
			form.getGlobalContext().Core.setPatientShort(easRecord.getPatient());
		}
		
		updateControlsState();
	}
	
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.EASNamespace.TransferImage.REQUEST:
				engine.open(form.getForms().EAS.RequestImageTransfer, new Object[] {form.grdResults().getValue()});
				break;
				
			case GenForm.ContextMenus.EASNamespace.TransferImage.REMOVE:
				engine.open(form.getForms().EAS.RemovalReason);
				break;
				
			case GenForm.ContextMenus.EASNamespace.TransferImage.VIEW_SUMMARY:
				viewSummaryEAS();
				break;
		}
		
		updateControlsState();
	}

	
	//---------------------------------------------------------------------------------------------------------------
	//
	//---------------------------------------------------------------------------------------------------------------


	private void initialize()
	{
		clearSearchControls();

		if (form.getGlobalContext().EAS.getDiagnosticImageTransferWorklistSearchCriteria() == null)
			form.cmbEASStatus().setValue(EASStatus.AUTHORISED);
		else
			populateSearchCriteria(form.getGlobalContext().EAS.getDiagnosticImageTransferWorklistSearchCriteria());
	}


	private void clear()
	{
		clearSearchControls();
		
		form.getGlobalContext().Core.setPatientShort(null);
	}


	private void clearSearchControls()
	{
		form.dteSeenFrom().setValue(null);
		form.dteSeenTo().setValue(null);
		
		form.dteDTAFrom().setValue(null);
		form.dteDTATo().setValue(null);
		
		form.qmbSeenBy().clear();
		form.qmbResponsibleHCP().clear();
		
		form.cmbEASStatus().setValue(null);
		
		form.chkRemoved().setValue(null);
		
		form.grdResults().getRows().clear();
	}


	private boolean validateSearchCriteria()
	{
		ArrayList<String> errorList = new ArrayList<String>();
		
		if (form.dteSeenFrom().getValue() != null &&  form.dteSeenTo().getValue() != null)
		{
			if (form.dteSeenFrom().getValue().isGreaterThan(form.dteSeenTo().getValue()))
			{
				errorList.add("'Seen date From' can not be set after 'Seen date To'.");
			}
		}
		
		if (form.dteDTAFrom().getValue() != null && form.dteDTATo().getValue() != null)
		{
			if (form.dteDTAFrom().getValue().isGreaterThan(form.dteDTATo().getValue()))
			{
				errorList.add("'DTT date From' cannot be set after 'DTT date To'."); //WDEV-17724
			}
		}
		
		
		if (errorList.size() > 0)
		{
			engine.showErrors(errorList.toArray(new String[errorList.size()]));
			return false;
		}

		return true;
	}

	
	private void saveSearchCriteria()
	{
		DiagnosticImageTransferSearchCriteriaVo searchCriteria = new DiagnosticImageTransferSearchCriteriaVo();
		
		searchCriteria.setSeenFrom(form.dteSeenFrom().getValue());
		searchCriteria.setSeenTo(form.dteSeenTo().getValue());
		searchCriteria.setDTAFrom(form.dteDTAFrom().getValue());
		searchCriteria.setDTATo(form.dteDTATo().getValue());
		searchCriteria.setSeenBy(form.qmbSeenBy().getValue());
		searchCriteria.setResponsibleHcp(form.qmbResponsibleHCP().getValue());
		searchCriteria.setEASStatus(form.cmbEASStatus().getValue());
		searchCriteria.setRemoved(form.chkRemoved().getValue());
		
		form.getGlobalContext().EAS.setDiagnosticImageTransferWorklistSearchCriteria(searchCriteria);
	}
	
	
	private void populateSearchCriteria(DiagnosticImageTransferSearchCriteriaVo searchCriteria)
	{
		clearSearchControls();
		
		if (searchCriteria == null)
			return;
		
		form.dteSeenFrom().setValue(searchCriteria.getSeenFrom());
		form.dteSeenTo().setValue(searchCriteria.getSeenTo());
		form.dteDTAFrom().setValue(searchCriteria.getDTAFrom());
		form.dteDTATo().setValue(searchCriteria.getDTATo());
		
		if (searchCriteria.getResponsibleHcp() != null)
		{
    		form.qmbResponsibleHCP().newRow(searchCriteria.getResponsibleHcp(), searchCriteria.getResponsibleHcp().toString());
    		form.qmbResponsibleHCP().setValue(searchCriteria.getResponsibleHcp());
		}

		if (searchCriteria.getSeenBy() != null)
		{
    		form.qmbSeenBy().newRow(searchCriteria.getSeenBy(), searchCriteria.getSeenBy().toString());
    		form.qmbSeenBy().setValue(searchCriteria.getSeenBy());
		}
		
		form.cmbEASStatus().setValue(searchCriteria.getEASStatus());
		
		form.chkRemoved().setValue(Boolean.TRUE.equals(searchCriteria.getRemoved()));
	}


	
	private void search(boolean showNoResultsMessage)
	{
		DiagnosticImageTransferVoCollection diagnosticImages = domain.listDiagnosticImages(form.dteSeenFrom().getValue(), form.dteSeenTo().getValue(),
																							form.dteDTAFrom().getValue(), form.dteDTATo().getValue(),
                                                        									form.qmbSeenBy().getValue(), form.qmbResponsibleHCP().getValue(),
                                                        									form.cmbEASStatus().getValue(),
                                                        									form.chkRemoved().getValue());

		if (showNoResultsMessage && (diagnosticImages == null || diagnosticImages.size() == 0))
		{
			engine.showMessage("No results found.");
		}
		
		populateSearchResults(diagnosticImages);
	}


	private void updateControlsState()
	{
		form.getContextMenus().EAS.hideAllTransferImageMenuItems();
		
		boolean recordSelected = form.grdResults().getSelectedRow() != null;
		boolean notRemoved = recordSelected && !Boolean.TRUE.equals(form.grdResults().getSelectedRow().getValue().getRemovedStat());
		
		
		form.getContextMenus().EAS.getTransferImageREMOVEItem().setVisible(recordSelected && notRemoved);
		form.getContextMenus().EAS.getTransferImageREQUESTItem().setVisible(recordSelected && notRemoved);
		form.getContextMenus().EAS.getTransferImageVIEW_SUMMARYItem().setVisible(recordSelected);
	}

	
	private void populateSearchResults(DiagnosticImageTransferVoCollection diagnosticImages)
	{
		form.grdResults().getRows().clear();
		
		if (diagnosticImages == null)
			return;
		
		diagnosticImages.sort(new DiagnosticImageComparator());
		
		for (DiagnosticImageTransferVo imageRecord : diagnosticImages)
		{
			grdResultsRow row = form.grdResults().getRows().newRow();
			
			row.setColHospNo(imageRecord.getPatient().getHospnum() != null ? imageRecord.getPatient().getHospnum().getValue() : "");
			row.setTooltipForColHospNo(imageRecord.getPatient().getHospnum() != null ? imageRecord.getPatient().getHospnum().getValue() : "");
			
			row.setColDateSeen(imageRecord.getDateSeen());
			row.setTooltipForColDateSeen(imageRecord.getDateSeen().toString());
			
			row.setColSurname(imageRecord.getPatient().getName().getSurname());
			row.setTooltipForColSurname(imageRecord.getPatient().getName().getSurname());
			
			row.setColForename(imageRecord.getPatient().getName().getForename());
			row.setTooltipForColForename(imageRecord.getPatient().getName().getForename());
			
			row.setColDecisionToTreat(imageRecord.getDateDecisionToTreat());
			row.setTooltipForColDecisionToTreat(imageRecord.getDateDecisionToTreat().toString());
			
			row.setColSeenBy(imageRecord.getSeenBy() != null ? imageRecord.getSeenBy().toString() : null);
			row.setTooltipForColSeenBy(imageRecord.getSeenBy() != null ? imageRecord.getSeenBy().toString() : null);

			row.setColStatus(imageRecord.getEASStatus().getStatus().getText());
			row.setTooltipForColStatus(imageRecord.getEASStatus().getStatus().getText());

			row.setValue(imageRecord);
		}
	}


	private void populateSeenBy(HcpLiteVoCollection listHCP)
	{
		form.qmbSeenBy().clear();
		
		if (listHCP == null)
			return;
		
		for (HcpLiteVo hcp : listHCP)
		{
			form.qmbSeenBy().newRow(hcp, hcp.toString());
		}
		
		if (listHCP.size() == 1)
			form.qmbSeenBy().setValue(listHCP.get(0));
		else
			form.qmbSeenBy().showOpened();
	}


	private void populateResponsibleHcp(HcpLiteVoCollection listHCP)
	{
		form.qmbResponsibleHCP().clear();
		
		if (listHCP == null)
			return;
		
		for (HcpLiteVo hcp : listHCP)
		{
			form.qmbResponsibleHCP().newRow(hcp, hcp.toString());
		}
		
		if (listHCP.size() == 1)
			form.qmbResponsibleHCP().setValue(listHCP.get(0));
		else
			form.qmbResponsibleHCP().showOpened();
	}


	private void viewSummaryEAS()
	{
		if (form.grdResults().getSelectedRow() != null)
		{
    		form.getGlobalContext().EAS.setElectronicActionSheet(domain.getEAS(form.grdResults().getSelectedRow().getValue()));
    
    		engine.open(form.getForms().EAS.PatientElectronicActionSheet, new  Object[]{(EasAction.VIEW_SUMMARY)});
		}
	}
}

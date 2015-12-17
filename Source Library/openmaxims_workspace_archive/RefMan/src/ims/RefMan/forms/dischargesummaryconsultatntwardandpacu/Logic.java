// This code was generated by George Cristian Josan using IMS Development Environment (version 1.70 build 3547.20232)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.dischargesummaryconsultatntwardandpacu;

import ims.RefMan.vo.CatsReferralWizardVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardLiteVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardLiteVoCollection;
import ims.RefMan.vo.DischargeSummaryPacuAndWardRefVo;
import ims.RefMan.vo.DischargeSummaryPacuAndWardVo;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.vo.PatientDiagnosisLiteVo;
import ims.core.vo.PatientDiagnosisLiteVoCollection;
import ims.core.vo.PatientDocumentVo;
import ims.core.vo.ServerDocumentVo;
import ims.core.vo.lookups.DocumentCategory;
import ims.core.vo.lookups.DocumentCreationType;
import ims.core.vo.lookups.FileType;
import ims.core.vo.lookups.PreActiveActiveInactiveStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.FormOpenException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;

import java.security.SecureRandom;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	private static final int REPORT_DISCHARGE_SUMMARY = 1;
	private static final int REPORT_DISCHARGE_REPORT = 2;
	private static final int REPORT_PATIENT_PRESCRIPTION = 3;

	private static final int COL_DIAG_DESCRIPTION = 1;
	private static final int COL_DIAG_DATE = 2;
	private static final int COL_DIAG_DIAGNOSE = 3;

	//-------------------------------------------------------------------------------------------------------------------------------------------
	//	EVENTS REGION
	//-------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}


	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
			open();
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	@Override
	protected void onBtnDischargeSummaryClick() throws ims.framework.exceptions.PresentationLogicException
	{
		printReport(REPORT_DISCHARGE_SUMMARY);
	}
	
	@Override
	protected void onBtnDischargeReportClick() throws ims.framework.exceptions.PresentationLogicException
	{
		printReport(REPORT_DISCHARGE_REPORT);
	}
	
	@Override
	protected void onRecordBrowserValueChanged() throws PresentationLogicException
	{
		form.getLocalContext().setDischargeSummaryWardAndPACU(domain.getDischargeSummary(form.recordBrowser().getValue()));
		populateScreenFromInstance(form.getLocalContext().getDischargeSummaryWardAndPACU());
		
		updateControlsState();
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------------
	//	FUNCTION REGION
	//-------------------------------------------------------------------------------------------------------------------------------------------
	public void initialize() throws FormOpenException
	{
		// Set local context to default values
		form.getLocalContext().setDischargeSummaryCollection(null);
		form.getLocalContext().setDischargeSummaryWardAndPACU(null);
		
		// Initialize dynamic grid diagnosis
		initialiseDynamicGrid();
		
		super.initialize();
	}

	private void initialiseDynamicGrid()
	{
		form.lyrContent().tabConsultant().dyngrDiagnosis().clear();
		
		form.lyrContent().tabConsultant().dyngrDiagnosis().setSelectable(true);
		
		DynamicGridColumn column = form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().newColumn("Description");
		column.setIdentifier(COL_DIAG_DESCRIPTION);
		column.setWidth(300);
		column.setDynamicWidthSupported(true);
		
		column = form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().newColumn("Date");
		column.setIdentifier(COL_DIAG_DATE);
		column.setWidth(120);
		column.setDynamicWidthSupported(true);
		
		column = form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().newColumn("Diagnose");
		column.setIdentifier(COL_DIAG_DIAGNOSE);
		column.setWidth(-1);
		column.setDynamicWidthSupported(true);
	}

	public void open() throws ims.framework.exceptions.PresentationLogicException
	{	
		form.getLocalContext().setDischargeSummaryWardAndPACU(domain.getDischargeSummary(form.getLocalContext().getDischargeSummaryWardAndPACU()));
		
		// Based on CatsReferral provided (mandatory global context) retrieve from domain the discharge summary collection
		form.getLocalContext().setDischargeSummaryCollection(domain.listDischargeSummaryCollection(form.getGlobalContext().RefMan.getCatsReferral()));
		
		// Populate the record browser with the discharge summary collection
		populateRecordBrowser(form.getLocalContext().getDischargeSummaryCollection());
		
		// Populate the instance controls with selected discharge summary (null, first in collection, or last edited in form)
		populateScreenFromInstance(form.getLocalContext().getDischargeSummaryWardAndPACU());
		
		// Get the in patient episode record (if any)
		form.getLocalContext().setInpatient(domain.getInpatientEpisode(form.getGlobalContext().RefMan.getCatsReferral()));
		// If current referral doesn't have an inpatient check if an inpatient for patient exits
		if (!form.getLocalContext().getInpatientIsNotNull())
			form.getLocalContext().setHasInpatient(domain.hasInpatientEpisode(form.getGlobalContext().Core.getPatientShort()));
		else
			form.getLocalContext().setHasInpatient(Boolean.TRUE);

		// Set form mode to VIEW
		form.setMode(FormMode.VIEW);
	}
	
	public void clearInstanceControls()
	{
		form.lyrContent().tabConsultant().txtSummaryOfAdmission().setValue(null);
		form.lyrContent().tabConsultant().txtActionsforGPCommunity().setValue(null);
		
		form.lyrContent().tabConsultant().dyngrDiagnosis().getRows().clear();
		
		form.lyrContent().tabConsultant().txtFurtherManagementInstructions().setValue(null);
	}

	public void updateControlsState()
	{
		if (FormMode.VIEW.equals(form.getMode()))
		{
			form.btnEdit().setVisible(true);
			form.btnEdit().setEnabled(form.getLocalContext().getDischargeSummaryWardAndPACUIsNotNull() 									// Button 'Edit" is visible only for selected record
										&& (Boolean.TRUE.equals(form.getLocalContext().getDischargeSummaryWardAndPACU().getIsCurrent())	// & selected record is the latest record
										&& !Boolean.TRUE.equals(form.getLocalContext().getHasInpatient())								// & no Inpatient Episode exists
										|| !form.getLocalContext().getDischargeSummaryWardAndPACU().getDischargeEpisodeIsNotNull()));	// & selected record is not discharged yet.
		}
	}
	
	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO: Add you code here.
	}
	
	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setDischargeSummaryWardAndPACU(populateInstanceFromScreen(form.getLocalContext().getDischargeSummaryWardAndPACU()));

		String [] errors = form.getLocalContext().getDischargeSummaryWardAndPACU().validate();
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		boolean bSaveCatsAswell = false;
		CatsReferralWizardVo voCats = domain.getCatsReferral(form.getGlobalContext().RefMan.getCatsReferral());
		if (voCats.getRequiresDischargeRep() == null)
		{
			voCats.setRequiresDischargeRep(Boolean.TRUE);
			bSaveCatsAswell = true;
			String [] errors2 = voCats.validate();
			
			if (errors2 != null && errors2.length > 0)
			{
				engine.showErrors(errors2);
				return false;
			}
		}
		
		try
			{
				if (bSaveCatsAswell)
					form.getLocalContext().setDischargeSummaryWardAndPACU(domain.saveDischargeSummaryWardAndPacuPlusCatsReferral(form.getLocalContext().getDischargeSummaryWardAndPACU(), voCats));
				else
					form.getLocalContext().setDischargeSummaryWardAndPACU(domain.save(form.getLocalContext().getDischargeSummaryWardAndPACU()));
			}
			catch (DomainInterfaceException e)
			{
				engine.showMessage(e.getMessage());
				return false;
			}
			catch (StaleObjectException e)
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				return true;
			}
			catch (ForeignKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
				return false;
			}
			catch (UniqueKeyViolationException e)
			{
				engine.showMessage(e.getMessage());
				return false;
			}

		return true;
	}
	
	public void updateInstance()
	{
		form.setMode(FormMode.EDIT);
	}

	//-------------------------------------------------------------------------------------------------------------------------------------------
	//	DATA EXCHANGE REGION - GENERAL
	//-------------------------------------------------------------------------------------------------------------------------------------------
	
	// General data
	
	private void populateRecordBrowser(DischargeSummaryPacuAndWardLiteVoCollection dischargeSummaryCollection)
	{
		// Clear the browser
		form.recordBrowser().clear();
		
		//
		if (dischargeSummaryCollection == null)
		{
			form.getLocalContext().setDischargeSummaryWardAndPACU(null);
			return;
		}
		
		for (int i = 0; i < dischargeSummaryCollection.size(); i++)
		{
			DischargeSummaryPacuAndWardLiteVo dischargeSummary = dischargeSummaryCollection.get(i);
			
			// If the discharge summary is null - skip to next discharge summary
			if (dischargeSummary == null)
				continue;
			
			// Build text to display on record browser for discharge summary
			StringBuffer text = new StringBuffer();
			text.append(dischargeSummary.getDischargeDateIsNotNull() ? dischargeSummary.getDischargeDate() : "");
			text.append(" - ");
			text.append(dischargeSummary.getDischargeTypeIsNotNull() ? dischargeSummary.getDischargeType() : "");
			text.append(" - ");
			text.append(dischargeSummary.getAuthoringInformationIsNotNull() && dischargeSummary.getAuthoringInformation().getAuthoringHcpIsNotNull() ? dischargeSummary.getAuthoringInformation().getAuthoringHcp().getName().toString() : "");

			// Add the discharge summary to record browser
			boolean isFromCurrentReferral = dischargeSummary.getCatsReferral().getID_CatsReferral().intValue() == form.getGlobalContext().RefMan.getCatsReferral().getID_CatsReferral().intValue();
			
			if (isFromCurrentReferral)
				form.recordBrowser().newRow(dischargeSummary, text.toString());
		}
		
		if (!form.getLocalContext().getDischargeSummaryWardAndPACUIsNotNull())
		{
			if (form.recordBrowser().getValues().size() > 0 && form.recordBrowser().getValues().get(0) instanceof DischargeSummaryPacuAndWardLiteVo)
			{
				DischargeSummaryPacuAndWardVo latestDischarge = domain.getDischargeSummary((DischargeSummaryPacuAndWardRefVo) form.recordBrowser().getValues().get(0));
				form.getLocalContext().setDischargeSummaryWardAndPACU(latestDischarge);
			}
		}
	}

	private void populateScreenFromInstance(DischargeSummaryPacuAndWardVo dischargeSummaryWardAndPACU)
	{
		// Clear instance controls
		clearInstanceControls();
		
		if (dischargeSummaryWardAndPACU == null)
			return;
		
		form.lyrContent().tabConsultant().txtSummaryOfAdmission().setValue(dischargeSummaryWardAndPACU.getAdmissionSummary());
		form.lyrContent().tabConsultant().txtFurtherManagementInstructions().setValue(dischargeSummaryWardAndPACU.getFurtherManagementInstructions());
		form.lyrContent().tabConsultant().txtActionsforGPCommunity().setValue(dischargeSummaryWardAndPACU.getActionsforGPandCommunity());
		
		// Set diagnosis
		populateDiagnosisScreenFromCollection(dischargeSummaryWardAndPACU.getDiagnosis());
	}

	@SuppressWarnings("unused")
	private DischargeSummaryPacuAndWardVo populateInstanceFromScreen()
	{
		return populateInstanceFromScreen(null);
	}
	
	private DischargeSummaryPacuAndWardVo populateInstanceFromScreen(DischargeSummaryPacuAndWardVo dischargeSummary)
	{
		if (dischargeSummary == null)
		{
			dischargeSummary = new DischargeSummaryPacuAndWardVo();
		}
		
		dischargeSummary.setAdmissionSummary(form.lyrContent().tabConsultant().txtSummaryOfAdmission().getValue());
		dischargeSummary.setFurtherManagementInstructions(form.lyrContent().tabConsultant().txtFurtherManagementInstructions().getValue());
		dischargeSummary.setActionsforGPandCommunity(form.lyrContent().tabConsultant().txtActionsforGPCommunity().getValue());
		
		// Get diagnosis
		dischargeSummary.setDiagnosis(populateDiagnosisCollectionFromScreen());

		return dischargeSummary;
	}

	// Diagnosis
	private PatientDiagnosisLiteVoCollection populateDiagnosisCollectionFromScreen()
	{
		return populateDiagnosisCollectionFromScreen(null);
	}

	private PatientDiagnosisLiteVoCollection populateDiagnosisCollectionFromScreen(PatientDiagnosisLiteVoCollection diagnosis)
	{
		if (diagnosis == null)
		{
			diagnosis = new PatientDiagnosisLiteVoCollection();
		}

		for (int i = 0; i < form.lyrContent().tabConsultant().dyngrDiagnosis().getRows().size(); i++)
		{
			diagnosis.add(getDiagnosisRowValue(form.lyrContent().tabConsultant().dyngrDiagnosis().getRows().get(i)));
		}
		
		return diagnosis;
	}

	private PatientDiagnosisLiteVo getDiagnosisRowValue(DynamicGridRow row)
	{
		if (row == null)
			throw new CodingRuntimeException("MAJOR LOGICAL ERROR - Can not read value from null row");
		
		if (row.getValue() == null || !(row.getValue() instanceof PatientDiagnosisLiteVo))
		{
			row.setValue(new PatientDiagnosisLiteVo());
		}
		
		PatientDiagnosisLiteVo diagnosis = (PatientDiagnosisLiteVo) row.getValue();
//		
//		DynamicGridCell cell = row.getCells().get(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DESCRIPTION));
//		diagnosis.setDiagnosisDescription(cell.getValue() != null ? cell.getValue().toString() : null);
//		
//		cell = row.getCells().get(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DATE));
//		diagnosis.setDiagnosedDate(cell.getValue() != null ? ((Date) cell.getValue()).toPartialDate() : null);
//		
//		cell = row.getCells().get(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DIAGNOSE));
//		diagnosis.setDiagnosis(cell.getIdentifier()!= null ? (DiagLiteVo) (cell.getIdentifier()) : null);
		
		return diagnosis;
	}

	private void populateDiagnosisScreenFromCollection(PatientDiagnosisLiteVoCollection diagnosis)
	{
		// Clear previous diagnosis
		form.lyrContent().tabConsultant().dyngrDiagnosis().getRows().clear();
		
		if (diagnosis == null)
			return;
		
		for (int i = 0; i < diagnosis.size(); i++)
		{
			setDiagnosisRow(form.lyrContent().tabConsultant().dyngrDiagnosis().getRows().newRow(), diagnosis.get(i));
		}
	}
	
	private void printReport(int reportType)
	{
		// Check mandatory seed
		if (!form.getLocalContext().getDischargeSummaryWardAndPACUIsNotNull())
		{
			engine.showMessage("A discharge summary must be selected to view report.");
			return;
		}
		
		// Build report
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		String urlPdfUploadServer = ConfigFlag.GEN.PDF_UPLOAD_URL.getValue();
		
		if (urlPdfUploadServer == "")
		{
			engine.showMessage("PDF_UPLOAD_URL flag need to be set");
			return;
		}
		
		String fileName = generateName() + ".pdf";
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
		
		String documentName = null;
		DocumentCategory documentCategory = null;
		Integer reportID = 174;

		switch (reportType)
		{
			case REPORT_DISCHARGE_REPORT:
				documentName = "Discharge Report (Ward and PACU)";
				documentCategory = DocumentCategory.DISCHARGE_SUPPLEMENTARY;
				reportID = 174;
				break;
				
			case REPORT_DISCHARGE_SUMMARY:
				documentName = "Discharge Summary (Ward and PACU)";
				documentCategory = DocumentCategory.DISCHARGE_SUMMARY;
				reportID = 173;
				break;
				
			case REPORT_PATIENT_PRESCRIPTION:
				documentName = "Patient Prescription";
				documentCategory =DocumentCategory.PRESCRIPTIONS;
				reportID = 193;
				break;
		}

		Object[] obj = domain.getSystemReportAndTemplate(new Integer(reportID));
		client.addSeed(new SeedValue("CatsReferral_id", form.getGlobalContext().RefMan.getCatsReferral().getID_CatsReferral(), Integer.class));
		
		if (obj == null || obj.length < 2)
		{
			engine.showMessage("Could not get report and template!");
			return;
		}
		
		if (obj[0] == null || obj[1] == null)
		{
			engine.showMessage("The report has not been deployed");
			return;
		}
		
		String[] dischargeReport = domain.getSystemReportAndTemplate(reportID);
		
		if (dischargeReport == null)
		{
			engine.showMessage("No template was assigned to this dialog!");
			return;
		}
		
		
		
		try
		{
			String result = client.buildReportAsUrlInlineFrame((String)obj[0], (String)obj[1], urlReportServer, "PDF", "", 1);
			
			byte[] buffer = client.buildReport((String) obj[0], (String) obj[1], urlReportServer, "PDF", "", 1);
			
			if (buffer == null || buffer.length == 0)
			{
				engine.showMessage("PDF file size is 0");
				return;
			}
			
			try
			{
				form.lyrContent().tabDischargeSummary().htmReportPreview().setHTML(result);
				
				engine.uploadFile(ConfigFlag.GEN.PDF_UPLOAD_URL.getValue(), buffer, fileName, ConfigFlag.GEN.FILE_UPLOAD_DIR.getValue());
			}
			catch (Exception exception)
			{
				engine.showMessage(exception.getMessage());
			}

			saveReport(fileName, documentName, documentCategory);
		}
		catch (QueryBuilderClientException exception)
		{
			engine.showMessage(exception.getMessage());
		}
	}

	private void setDiagnosisRow(DynamicGridRow row, PatientDiagnosisLiteVo diagnosis)
	{
		if (row == null)
			throw new CodingRuntimeException("Major Logical Error - Can not set a dose to null row");
		
		row.setValue(diagnosis);
		
		if (diagnosis == null)
			return;
		
		DynamicGridCell cell = row.getCells().newCell(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DESCRIPTION), DynamicCellType.STRING);
		cell.setReadOnly(true);
		cell.setStringMaxLength(diagnosis.getDiagnosisDescriptionMaxLength());
		cell.setValidationMessage("Dose length is restricted to " + diagnosis.getDiagnosisDescriptionMaxLength() + " characters.");
		cell.setValue(diagnosis.getDiagnosisDescription());
		cell.setWidth(300);
		
		cell = row.getCells().newCell(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DATE), DynamicCellType.STRING); //wdev-9098
		cell.setReadOnly(true);
		cell.setValue(diagnosis.getDiagnosedDateIsNotNull() ? diagnosis.getDiagnosedDate().toString() : null);	//wdev-9098
		cell.setWidth(120);
		
		cell = row.getCells().newCell(form.lyrContent().tabConsultant().dyngrDiagnosis().getColumns().getByIdentifier(COL_DIAG_DIAGNOSE), DynamicCellType.STRING);
		cell.setReadOnly(true);
		cell.setIdentifier(diagnosis.getDiagnosis());
		cell.setValue(diagnosis.getDiagnosis() != null ? diagnosis.getDiagnosis().getDiagnosisName() : "No diagnosis name provided");
		cell.setWidth(-1);
	}

	private String generateName()
	{
		  String str = "";
		  
		  try
		  {
			  // Get Random Segment
		      SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
		      str += Integer.toHexString(prng.nextInt());
		      while (str.length () < 8)
	          {
	              str = '0' + str;
	          }
			  
			  // Get CurrentTimeMillis() segment
		      str += Long.toHexString(System.currentTimeMillis());
		      while (str.length () < 12)
	          {
	              str = '0' + str;
	          }

			  // Get Random Segment
		      SecureRandom secondPrng = SecureRandom.getInstance("SHA1PRNG");
		      str += Integer.toHexString(secondPrng.nextInt());
		      while (str.length () < 8)
	          {	
	              str = '0' + str;
	          }

		      // Get IdentityHash() segment
		      str += Long.toHexString(System.identityHashCode((Object) this));
		      while (str.length() < 8)
		      {
		          str = '0' + str; 
		      }	  
		      // Get Third Random Segment
		      byte bytes[] = new byte[16]; 
		      SecureRandom thirdPrng = SecureRandom.getInstance("SHA1PRNG");
		      thirdPrng.nextBytes(bytes);
		      str += Integer.toHexString(thirdPrng.nextInt());
		      while (str.length () < 8)
	          {
	              str = '0' + str;
	          }
		  }
		  catch(java.security.NoSuchAlgorithmException ex)
		  {
		      ex.getMessage();
		  }
		  
		  return str;
	}

	private boolean saveReport(String fileName, String documentName, DocumentCategory documentCategory)
	{
		PatientDocumentVo document = populatePatientDocument(populateServerDocument(fileName), documentName, documentCategory);

		String[] errors = document.validate();
		
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.saveReport(document, form.getGlobalContext().RefMan.getCatsReferral());
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}
		
		return true;
	}

	private ServerDocumentVo populateServerDocument(String fileName)
	{
		DateTime date = new DateTime();
		
		int year = date.getDate().getYear();
		int month = date.getDate().getMonth();
		int day = date.getDate().getDay();

		String filePath = year + "/" + month + "/" + day + "/" + fileName;
		
		ServerDocumentVo document = new ServerDocumentVo();
		
		document.setFileName(filePath);
		document.setFileType(FileType.PDF);

		return document;
	}

	private PatientDocumentVo populatePatientDocument(ServerDocumentVo serverDocument, String documentName, DocumentCategory documentCategory)
	{
		PatientDocumentVo document = new PatientDocumentVo();
		
		document.setPatient(domain.getPatientRef(form.getGlobalContext().RefMan.getCatsReferral()));
		document.setCareContext(domain.getCareContextRef(form.getGlobalContext().RefMan.getCatsReferral()));
		document.setEpisodeofCare(domain.getEpisodeOfCareRef(form.getGlobalContext().RefMan.getCatsReferral()));
		document.setReferral(null);
		
		document.setName(documentName);
		document.setServerDocument(serverDocument);
		document.setCreationType(DocumentCreationType.GENERATED);
		document.setCategory(documentCategory);
		
		document.setRecordingUser((MemberOfStaffRefVo) domain.getMosUser(engine.getLoggedInUser().getUsername()));
		document.setRecordingDateTime(new DateTime());
		document.setStatus(PreActiveActiveInactiveStatus.ACTIVE);

		return document;
	}
}
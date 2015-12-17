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
// This code was generated by Silviu Checherita using IMS Development Environment (version 1.80 build 5360.17707)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.admin.domain.PatientSearchConfiguration;
import ims.admin.domain.impl.PatientSearchConfigurationImpl;
import ims.admin.vo.AppUserVo;
import ims.admin.vo.PDSConfigurationVo;
import ims.admin.vo.domain.AppUserVoAssembler;
import ims.configuration.InitConfig;
import ims.configuration.gen.ConfigFlag;
import ims.core.configuration.domain.objects.AppUser;
import ims.core.configuration.vo.AppUserRefVo;
import ims.core.domain.PDSDemographics;
import ims.core.domain.base.impl.BasePDSPatientSearchImpl;
import ims.core.patient.domain.objects.PDSAdvancedSearchRequest;
import ims.core.patient.domain.objects.Patient;
import ims.core.patient.vo.PDSAdvancedSearchRequestRefVo;
import ims.core.patient.vo.PatientRefVo;
import ims.core.resource.people.domain.objects.Gp;
import ims.core.resource.people.vo.GpRefVo;
import ims.core.resource.place.domain.objects.Organisation;
import ims.core.resource.place.vo.OrganisationRefVo;
import ims.core.vo.GpShortVo;
import ims.core.vo.OrganisationWithSitesVo;
import ims.core.vo.PDSAdvancedSearchRequestVo;
import ims.core.vo.PDSPatientFilterSearchCriteriaVo;
import ims.core.vo.PatientId;
import ims.core.vo.PatientLiteVoCollection;
import ims.core.vo.PatientShort;
import ims.core.vo.PatientShortCollection;
import ims.core.vo.domain.GpShortVoAssembler;
import ims.core.vo.domain.OrganisationWithSitesVoAssembler;
import ims.core.vo.domain.PDSAdvancedSearchRequestVoAssembler;
import ims.core.vo.domain.PatientAssembler;
import ims.core.vo.domain.PatientLiteVoAssembler;
import ims.core.vo.domain.PatientShortAssembler;
import ims.core.vo.lookups.NameType;
import ims.core.vo.lookups.PatIdType;
import ims.core.vo.lookups.Sex;
import ims.core.vo.lookups.TimeUnitsSecondsToYears;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.utils.Date;
import ims.framework.utils.PartialDate;

import java.util.ArrayList;
import java.util.List;

public class PDSPatientSearchImpl extends BasePDSPatientSearchImpl
{
	private static final long serialVersionUID = 1L;
	//private static final String NHS = "NHS Number";
	
	public PatientShortCollection getPatient(PDSPatientFilterSearchCriteriaVo filter, Boolean remote) throws DomainInterfaceException
	{
		if(InitConfig.getConfigType().equals("HIB")) 
			return searchPatientsLocal(filter,true, true);
		
		return new PatientShortCollection();
	}
	
	public PatientShortCollection listAllPatients(PDSPatientFilterSearchCriteriaVo filter) throws DomainInterfaceException 
	{
		//WDEV-21588
		if (Boolean.TRUE.equals(ConfigFlag.UI.HIDE_MERGED_PATIENTS_ON_PATIENT_SEARCH.getValue()))
		{
			return searchPatientsLocal(filter, false, true);
		}
		else
		{
			return searchPatientsLocal(filter, true, true);
		}
	}

	/**
	* Saves a Merge Request
	*/
	public void saveMergeRequest(ims.core.vo.MergeRequestVo mergeVo) throws ims.domain.exceptions.DomainInterfaceException, ims.domain.exceptions.StaleObjectException
	{
		// TODO: Add your code here.
	}

	/**
	* list only active patients excluding mergedFrom Patients
	*/
	public PatientShortCollection listActivePatients(PDSPatientFilterSearchCriteriaVo filter) throws DomainInterfaceException
	{
		//WDEV-21588
		if (Boolean.TRUE.equals(ConfigFlag.UI.HIDE_MERGED_PATIENTS_ON_PATIENT_SEARCH.getValue()))
		{
			return searchPatientsLocal(filter, false, false);
		}
		else
		{
			return searchPatientsLocal(filter, true, false);
		}
	}

	public ims.core.vo.PasEventVo getPasEvent(String pasEpisodeId, ims.core.vo.Patient patient, String visitID)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public Boolean validateMergeRequest(ims.core.vo.MergeRequestVo mergeRequest)
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public ims.dto.client.Patient getCCODTOPatient(String pkey) throws ims.domain.exceptions.DomainInterfaceException
	{
		// TODO: Add your code here and change the return value.
		return null;
	}
	
	public PDSConfigurationVo getPDSConfiguration() 
	{
		PatientSearchConfiguration impl = (PatientSearchConfiguration) getDomainImpl(PatientSearchConfigurationImpl.class);
		return impl.getPatientSearchConfig();
	}
	
	private PatientShortCollection searchPatientsLocal(PDSPatientFilterSearchCriteriaVo filter, boolean bReturnMergedPatients, boolean bShowInactivePatients)  
	{
		int maxPatientNo = ConfigFlag.DOM.PAT_SEARCH_MAX_SIZE.getValue();
		boolean includeAlias = (filter.getIncludeAliasIsNotNull() ? filter.getIncludeAlias() : false);
		boolean extendedDoBRange = (filter.getExtendedDoBIsNotNull() ? filter.getExtendedDoB() : false);
		boolean extendedDoDRange = (filter.getExtendedDoDIsNotNull() ? filter.getExtendedDoD() : false);
		
		DomainFactory factory = getDomainFactory();

		StringBuffer filterString = new StringBuffer();
		ArrayList<String> paramName = new ArrayList<String>();
		ArrayList<Object> paramValue = new ArrayList<Object>();
		List patients = null;
		String condition = "";
		
		boolean isCaseSensitivePatIdSearch = ConfigFlag.DOM.CASE_SENSITIVE_PATID.getValue(); 
		
		if ((filter.getPersId() != null && filter.getPersId().getValue() != null) || filter.getNHSNumber() != null)
		{
			StringBuffer hql = new StringBuffer(" FROM Patient p " +
					" JOIN p.identifiers AS ids" +
					" WHERE ids.type = :idType ");

			condition = " AND ";
			
			String idVal=null;
			PatIdType idType = null;
			
			if (filter.getNHSNumber()!=null )
			{
				idVal=filter.getNHSNumber().trim();
				idVal = idVal.replace(" ", "");
				idType=PatIdType.NHSN;
			}
			else
			{
				idVal = filter.getPersId().getValue().trim();
				idType = filter.getPersId().getType();
				
				if (PatIdType.NHSN.equals(filter.getPersId().getType()))
					idVal = filter.getPersId().getValue().replace(" ", "");
			}
			
			if(!isCaseSensitivePatIdSearch)
			{
				idVal = idVal.toUpperCase();
			}
			
			if ((filter.getPersId()!=null && filter.getPersId().getType().equals(PatIdType.NHSN)) || filter.getNHSNumber() != null)
			{
				hql.append(condition + (!isCaseSensitivePatIdSearch ? " UPPER(ids.value)" : " ids.value") + " LIKE :idValue");
				condition = " AND ";
				idVal += "%";
			}
			else
			{
				hql.append(condition + (!isCaseSensitivePatIdSearch ? " UPPER(ids.value)" : " ids.value") + " = :idValue");
				condition = " AND ";
			}
			
			if(!bReturnMergedPatients == true)
			{
				hql.append(condition + " (p.associatedPatient IS NULL) ");
				condition = " AND ";
			}

			if (!bShowInactivePatients)
			{
				hql.append(condition + " (p.isActive = :isActive OR (p.isActive=0 AND p.associatedPatient IS NOT NULL))" );	//WDEV-21588	
				condition = " AND ";
			}
			
			if (Boolean.TRUE.equals(filter.getExcludeQuickRegistrationPatients()))
			{
				hql.append(ConfigFlag.GEN.PATIENT_SEARCH_RETRIEVE_QUICKREGISTRATION_PATIENTS.getValue() ? "" : (condition + " AND ((p.isQuickRegistrationPatient IS NULL) OR (p.isQuickRegistrationPatient = 0)) ")); //WDEV-21171
			}
			
			if (!bShowInactivePatients)
				patients = factory.find(hql.toString(), new String[]{"idValue", "idType", "isActive"}, new Object[]{idVal, getDomLookup(idType),Boolean.TRUE});
			else
				patients = factory.find(hql.toString(), new String[]{"idValue", "idType"}, new Object[]{idVal, getDomLookup(idType)});
		}
		else
		{
			/*
			if ((filter.getPersId() != null && filter.getPersId().getValue() != null && filter.getPersId().getType().equals(PatIdType.NHSN)) || filter.getNHSNumber() != null)
			{
				filterString = new StringBuffer(" FROM Patient p ");
				
				if(includeAlias)
				{
					filterString.append(" LEFT JOIN p.otherNames AS oths ");
				}

				filterString.append(" JOIN p.identifiers AS ids WHERE ids.type = :idType ");
				
				String idVal = null;
				
				if(filter.getNHSNumber() != null)
					idVal = filter.getNHSNumber().trim();
				
				if(idVal == null)
					idVal = filter.getPersId().getValue().trim();
				
				idVal = idVal.replace(" ", "");
				if(!isCaseSensitivePatIdSearch)
				{
					idVal = idVal.toUpperCase();
				}
				filterString.append(" AND" + (!isCaseSensitivePatIdSearch ? " UPPER(ids.value)" : " ids.value") + " LIKE :idValue"); 
				idVal += "%";
				
				paramName.add("idType");
				paramValue.add(getDomLookup(PatIdType.NHSN));	
				paramName.add("idValue");
				paramValue.add(idVal);	
				
				condition=" AND ";
			}
			*/
			
			String strSearchSurname = "";
			String strSearchForename = "";

			if (filter.getSurname() != null)
			{
				if (includeAlias)
				{
					filterString.append(condition + " ( (oths.upperSurname LIKE :aliassurname AND oths.nameType = :nameType) OR ( ");

					paramName.add("nameType");
					paramValue.add(getDomLookup(NameType.ALIAS));
				}

				filterString.append(condition + " p.name.upperSurname LIKE :surname");
				
				paramName.add("surname");
				
				if (Boolean.FALSE.equals(ConfigFlag.GEN.PATIENT_SEARCH_ALLOW_NUMERIC_CHARS.getValue()))
					filter.setSurname(filter.getSurname().replaceAll("\\d", "")); 
								
				strSearchSurname = filter.getSurname().toUpperCase().trim();
				
				//WDEV-22602 - Note: Need to retain these characters for PDS searches, so have substituted only in what is being sent in the query
				//WDEV-21529
				//WDEV-21937
//				filter.setSurname(filter.getSurname().replaceAll("'", ""));
//				filter.setSurname(filter.getSurname().replaceAll("-", ""));				
				strSearchSurname = strSearchSurname.replaceAll("'", "");
				strSearchSurname = strSearchSurname.replaceAll("-", "");

				if(strSearchSurname.length() >= 40)
				{
					strSearchSurname = strSearchSurname.substring(0,40);
					strSearchSurname += '%';
				}
				else
				{
					strSearchSurname += '%';
				}

				paramValue.add(strSearchSurname);
				if (includeAlias)
				{
					paramName.add("aliassurname");
					paramValue.add(strSearchSurname);
					
					filterString.append(" ) ) ");
				}
				
				condition = " AND ";
			}
			
			String ret = "";
			if(filter!=null &&  filter.getForenameIsNotNull())
				ret = filter.getForename().replaceAll("%", "");
			

			if (filter.getForename() != null && ret.length()!=0)
			{
				filterString.append(condition + " p.name.upperForename LIKE :forename");
				paramName.add("forename");

				if (Boolean.FALSE.equals(ConfigFlag.GEN.PATIENT_SEARCH_ALLOW_NUMERIC_CHARS.getValue()))
					filter.setForename(filter.getForename().replaceAll("\\d", ""));
				
				//WDEV-22602 - Note: Need to retain these characters for PDS searches, so have substituted only in what is being sent in the query
				//WDEV-21529
				//WDEV-21937
//				filter.setForename(filter.getForename().replaceAll("'", ""));
//				filter.setForename(filter.getForename().replaceAll("-", ""));				
				strSearchForename = filter.getForename().toUpperCase().trim();				
				strSearchForename = strSearchForename.replaceAll("'", "");
				strSearchForename = strSearchForename.replaceAll("-", "");

				
				if(strSearchForename.length() >= 9)
				{
					strSearchForename = strSearchForename.substring(0,9);
					strSearchForename += '%';
				}
				else
				{
					strSearchForename += '%';
				}

				paramValue.add(strSearchForename);					
				condition = " AND ";
			}
			
			PDSConfigurationVo pdsConfig = getPDSConfiguration();//WDEV-21622
			
			if (filter.getDob() != null && !filter.getDob().toString().equals("__/__/____"))
			{
				filterString.append(condition + " p.dob  BETWEEN :dobFrom AND :dobTo");
				paramName.add("dobFrom");
				paramName.add("dobTo");
				if (!extendedDoBRange)
				{
					Integer[] range = filter.getDob().toSearchRange();
					paramValue.add(range[0]);
					paramValue.add(range[1]);
				}
				else
				{
					//WDEV-21622
					Date dobFrom =pdsConfig!=null ? getDateFromExtended(pdsConfig.getDOB_DATE_RANGE(),pdsConfig.getDOB_DATE_RANGE_TYPE(),filter.getDob()) : getDateFrom(filter.getDob());
					Date dobTo = pdsConfig!=null ? getDateToExtended(pdsConfig.getDOB_DATE_RANGE(),pdsConfig.getDOB_DATE_RANGE_TYPE(),filter.getDob()) : getDateTo(filter.getDob());
					paramValue.add(dateToInteger(dobFrom));
					paramValue.add(dateToInteger(dobTo));
				}
		        condition = " and ";
			}
			
			if (filter.getDoD() != null && !filter.getDoD().toString().equals("__/__/____"))
			{
				filterString.append(condition + " p.dod  BETWEEN :dodFrom AND :dodTo");
				paramName.add("dodFrom");
				paramName.add("dodTo");
				if (!extendedDoDRange)
				{	
					Integer[] range = filter.getDoD().toSearchRange();
					paramValue.add(intToDate(range[0]).getDate());
					paramValue.add(intToDate(range[1]).getDate());
				}
				else
				{
					//WDEV-21622
					Date dodFrom =pdsConfig!=null ? getDateFromExtended(pdsConfig.getDOD_DATE_RANGE(),pdsConfig.getDOD_DATE_RANGE_TYPE(),filter.getDoD()) : getDateFrom(filter.getDoD());
					Date dodTo = pdsConfig!=null ? getDateToExtended(pdsConfig.getDOD_DATE_RANGE(),pdsConfig.getDOD_DATE_RANGE_TYPE(),filter.getDoD()) : getDateTo(filter.getDoD());
					paramValue.add(dodFrom.getDate());
					paramValue.add(dodTo.getDate());
				}
		        condition = " and ";
			}
			
			if (filter.getSex() != null)
			{
				filterString.append(condition + " p.sex = :sex");
				paramName.add("sex");
				paramValue.add(getDomLookup(filter.getSex()));
				condition = " and ";
			}
			
			if (filter.getAddressIsNotNull())
			{
				filterString.append(condition + " (UPPER(p.address.line1) LIKE :partialAddress ");
				filterString.append(" OR upper(p.address.line2) LIKE :partialAddress");
				filterString.append(" OR upper(p.address.line3) LIKE :partialAddress");
				filterString.append(" OR upper(p.address.line4) LIKE :partialAddress");
				filterString.append(" OR upper(p.address.line5) LIKE :partialAddress )");

				paramName.add("partialAddress");
				paramValue.add(filter.getAddress().toUpperCase() + "%");
				condition = " AND ";
			}
			
			if (filter.getPostCode() != null)
			{
				filterString.append(condition + " (UPPER(REPLACE(p.address.postCode,' ','')) = :postCode )");

				paramName.add("postCode");
				paramValue.add(filter.getPostCode().replace(" ","").toUpperCase());
				condition = " AND ";
			}
			
			if (filter.getCounty() != null)
			{
				filterString.append(condition + " p.address.county = :county");
				paramName.add("county");
				paramValue.add(getDomLookup(filter.getCounty()));
				condition = " AND ";
			}
            
			if(!bReturnMergedPatients == true)
			{
				filterString.append(condition + " (p.associatedPatient IS NULL) ");
				condition = " AND "; //WDEV-22346
			}

			if (!bShowInactivePatients)
			{
				filterString.append(condition + " (p.isActive = :isActive OR (p.isActive=0 AND p.associatedPatient IS NOT NULL)) " ); //WDEV-21588
				paramName.add("isActive");
				paramValue.add(Boolean.TRUE);		
				condition = " AND ";
			}
			
			if (Boolean.TRUE.equals(filter.getExcludeQuickRegistrationPatients()))
			{
				if (condition.length() == 0)
				{	
					condition = " AND ";
				}
				filterString.append(ConfigFlag.GEN.PATIENT_SEARCH_RETRIEVE_QUICKREGISTRATION_PATIENTS.getValue() ? "" : (condition + " ((p.isQuickRegistrationPatient is null) OR (p.isQuickRegistrationPatient = 0)) ")); //WDEV-21171
			}
			
			//filterString.append(condition + " p.sex IS NOT NULL AND (p.sCN IS NOT NULL OR (p.identifiers.type.id IN (-9)) AND p.dob IS NOT NULL ");
			
			if ((filter.getPersId() != null && filter.getPersId().getValue() != null && filter.getPersId().getType().equals(PatIdType.NHSN)) || filter.getNHSNumber() != null)
				patients = factory.find(filterString.toString(), paramName, paramValue, maxPatientNo);
			else if (includeAlias && filter.getSurname() != null) 
				patients = factory.find("FROM ims.core.patient.domain.objects.Patient p LEFT JOIN p.otherNames AS oths WHERE " + filterString.toString() + " ORDER BY p.name.upperSurname ASC , p.name.upperForename ASC", paramName, paramValue, maxPatientNo);
			else
				patients = factory.find("FROM ims.core.patient.domain.objects.Patient p WHERE " + filterString.toString() + " ORDER BY p.name.upperSurname ASC , p.name.upperForename ASC", paramName, paramValue, maxPatientNo);
		}
		
		if (patients != null)
		{
			if(patients.size() == 1)
			{
				Patient domPatient = (Patient) patients.get(0);
				boolean isMergedPatient = false;
				while(domPatient.getAssociatedPatient() != null)
				{
					domPatient = domPatient.getAssociatedPatient();
					isMergedPatient = true;
				}
					
				if(isMergedPatient)
				{
					raiseAlert(domPatient.getMergedMessage((ims.core.patient.domain.objects.Patient)patients.get(0)));
					patients.set(0, domPatient);
				}
			}
							
			PatientShortCollection coll = (PatientShortAssembler.createPatientShortCollectionFromPatient(patients)).sort();
				
			for(PatientShort ps : coll)
			{
					if(ps.getAge() == null)
							ps.calculateAge();
			}
			
			return coll;
		}
		return null;
	}

	//WDEV-21622
	private Date getDateToExtended(Integer rangeValue, TimeUnitsSecondsToYears rangeType, PartialDate date)
	{
		Date dateFrom=getDateTo(date);
		
		if (rangeValue==null || rangeType==null || dateFrom==null)
			return dateFrom;
		
		Date newDate=null;
		
		if (TimeUnitsSecondsToYears.DAYS.equals(rangeType))
		{
			newDate=dateFrom.addDay(rangeValue);
		}
		else if (TimeUnitsSecondsToYears.MONTHS.equals(rangeType))
		{
			newDate=dateFrom.addMonth(rangeValue);
		}
		else if (TimeUnitsSecondsToYears.YEARS.equals(rangeType))
		{
			newDate=dateFrom.addYear(rangeValue);
		}
		
		return newDate;
	}

	//WDEV-21622
	private Date getDateTo(PartialDate partialDate)
	{
		if (partialDate==null)
			return null;
		
		Integer month = partialDate.getMonth()!=null ? partialDate.getMonth() : 12 ;
		Integer day = partialDate.getDay()!=null ? partialDate.getDay() : Date.getNumberOfDays(partialDate.getYear(), month);
		
		return new Date(partialDate.getYear(), month, day);	
	}

	//WDEV-21622
	private Date getDateFromExtended(Integer rangeValue, TimeUnitsSecondsToYears rangeType, PartialDate date)
	{
		Date dateFrom=getDateFrom(date);
		
		if (rangeValue==null || rangeType==null || dateFrom==null)
			return dateFrom;
		
		Date newDate=null;
		
		if (TimeUnitsSecondsToYears.DAYS.equals(rangeType))
		{
			newDate=dateFrom.addDay(-rangeValue);
		}
		else if (TimeUnitsSecondsToYears.MONTHS.equals(rangeType))
		{
			newDate=dateFrom.addMonth(-rangeValue);
		}
		else if (TimeUnitsSecondsToYears.YEARS.equals(rangeType))
		{
			newDate=dateFrom.addYear(-rangeValue);
		}
		
		return newDate;
	}

	//WDEV-21622
	private Date getDateFrom(PartialDate partialDate)
	{
		if (partialDate==null)
			return null;
		
		Integer day = partialDate.getDay()!=null ? partialDate.getDay() : 1 ;
		Integer month = partialDate.getMonth()!=null ? partialDate.getMonth() : 1 ;
		
		return new Date(partialDate.getYear(), month, day);	
	}
	
	private Integer dateToInteger(Date date)
	{
		Integer day = date.getDay();
		Integer month = date.getMonth();
		Integer year = date.getYear();
		
		return Integer.parseInt(year.toString() + (month.toString().length() == 2 ? month.toString() : "0" + month.toString()) + (day.toString().length() == 2 ? day.toString() : "0" + day.toString()));
	}
	
	private Date intToDate(Integer number)
	{
		int year = Integer.parseInt(Integer.toString(number).substring(0, 4));
		int month = Integer.parseInt(Integer.toString(number).substring(4, 6));
		int day = Integer.parseInt(Integer.toString(number).substring(6, 8));
		
		return new Date(year, month, day);
	}


	public PDSAdvancedSearchRequestVo getPDSAdvancedSearchRequest(PDSAdvancedSearchRequestRefVo request) 
	{
		if (request != null)
		{
			PDSAdvancedSearchRequest req = (PDSAdvancedSearchRequest) getDomainFactory().getDomainObject(PDSAdvancedSearchRequest.class,request.getID_PDSAsyncRequest());
			PDSAdvancedSearchRequestVo voReq = PDSAdvancedSearchRequestVoAssembler.create(req);
			return voReq;
			
		}
		return null;
	}


	public PDSAdvancedSearchRequestVo saveRequest(PDSAdvancedSearchRequestVo value) throws StaleObjectException 
	{
		if (value == null )
			throw new CodingRuntimeException("Cannot save null.");

		if (!value.isValidated())
				throw new DomainRuntimeException("Not Validated.");
		
		DomainFactory factory = getDomainFactory();
		
		PDSAdvancedSearchRequest domPDSRequest = PDSAdvancedSearchRequestVoAssembler.extractPDSAdvancedSearchRequest(factory, value);
		factory.save(domPDSRequest);
		return PDSAdvancedSearchRequestVoAssembler.create(domPDSRequest);
	}

	public ims.core.vo.Patient getPatientFromPatientShort(PatientShort patient) throws StaleObjectException 
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		return impl.getPatient(patient);
	}

	public ims.core.vo.Patient saveLocalPatient(ims.core.vo.Patient patient) throws StaleObjectException 
	{
		if (patient == null)
			throw new DomainRuntimeException("Cannot save null record.");
		
		if (!patient.isValidated())
			throw new DomainRuntimeException("Record not validated.");
		
		DomainFactory domainFactory = getDomainFactory();
		
		Patient domPatient = PatientAssembler.extractPatient(domainFactory, patient);
		domainFactory.save(domPatient);	
		ims.core.vo.Patient item = PatientAssembler.create(domPatient);
		return item;
	}


	public AppUserVo getAppUser(AppUserRefVo appUserRef) 
	{
		if (appUserRef != null)
		{	
		 AppUser user = (AppUser) getDomainFactory().getDomainObject(AppUser.class,appUserRef.getID_AppUser());
			AppUserVo voUser = AppUserVoAssembler.create(user);
			return voUser;
			
		}
		return null;
	}

	public OrganisationWithSitesVo getGPPractice(OrganisationRefVo organisationRef)
	{
		if(organisationRef == null)
			throw new CodingRuntimeException("Cannot get Organisation on null Id.");
		
		return OrganisationWithSitesVoAssembler.create((Organisation) getDomainFactory().getDomainObject(Organisation.class, organisationRef.getID_Organisation()));
	
	}

	@Override
	public PatientLiteVoCollection listPatientsByIdentifier(PatientId patId)
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		return impl.listPatientsByIdentifier(patId);
	}

	@Override
	public PatientLiteVoCollection listPatientsByKeyFields(String snm, String fnm, Integer dob, Sex gender) throws DomainInterfaceException
	{
		if(snm == null || snm.length() == 0)
			throw new CodingRuntimeException("Invalid surname for listPatientsByKeyFields !");
		if(fnm == null || fnm.length() == 0)
			throw new CodingRuntimeException("Invalid forename for listPatientsByKeyFields !");

		DomainFactory factory = getDomainFactory();
		
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
	
		// WDEV-21866 - Listing patients by key fields, use the first 3 characters of surname, first char of forrename and 2 out of 3 elements of dob
		String hql = "select pat from Patient as pat where pat.name.upperSurname like :SNM and pat.name.upperForename like :FNM ";

		markers.add("SNM");
		if (snm.length() > 3)
			values.add(snm.substring(0, 3) + "%");
		else
			values.add(snm);
		
		markers.add("FNM");
		if (fnm.length() > 1)
			values.add(fnm.substring(0,1) + "%");
		else
			values.add(fnm);
		
		if(dob != null)
		{
			// WDEV-21866 Need to match by two parts of DOB i.e. YYMM
			String fullDob = dob.toString();
			if (fullDob.length() == 8)
			{

				String yymmFrom = fullDob.substring(0, 6) + "01";
				String yymmTo = fullDob.substring(0,6) + "31";

				markers.add("yymmFrom");
				values.add(new Integer(yymmFrom));
				
				markers.add("yymmTo");
				values.add(new Integer(yymmTo));
				
				hql += " and pat.dob >= :yymmFrom and pat.dob <= :yymmTo ";
				
			}
		}
		

		if(gender != null)
		{
			markers.add("SEX");
			values.add(gender.getId());
			
			hql += " and pat.sex.id = :SEX";
		}
		
		hql += " and not exists (select 1 from Patient as ppp left join ppp.identifiers as idd left join idd.type as lkp where ppp.id = pat.id and lkp.id = -9)";
		
		List patientList = factory.find(hql.toString(), markers,values);
		
		if (patientList != null && !patientList.isEmpty())
		{
			return PatientLiteVoAssembler.createPatientLiteVoCollectionFromPatient(patientList);
		}
		
		return null;
	}

	@Override
	public ims.core.vo.Patient getPatient(PatientRefVo patRef)
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		return impl.getPatient(patRef);
	}

	@Override
	public ims.core.vo.Patient savePatient(ims.core.vo.Patient patient, Boolean fromInterface, Boolean triggerGeneralUpdateRequest) throws DomainInterfaceException, StaleObjectException, UniqueKeyViolationException
	{
		PDSDemographics impl = (PDSDemographics) getDomainImpl(PDSDemographicsImpl.class);
		
		return impl.savePatient(patient, fromInterface, triggerGeneralUpdateRequest);
	}

	@Override
	public GpShortVo getGP(GpRefVo ref) {
		if (ref != null)
		{	
			Gp gp = (Gp) getDomainFactory().getDomainObject(Gp.class,ref.getID_Gp());
			GpShortVo voGp = GpShortVoAssembler.create(gp);
			return voGp;
		}
		return null;
	}
}
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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5127.24028)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.domain.impl;

import ims.clinical.domain.InternalReferral;
import ims.clinical.domain.base.impl.BaseInternalReferralsEditNoteDialogImpl;
import ims.clinical.domain.objects.ClinicalReferrals;
import ims.clinical.vo.ClinicalReferralsRefVo;
import ims.clinical.vo.ClinicalReferralsVo;
import ims.clinical.vo.PatientDocumentForClinicalReferralVo;
import ims.clinical.vo.domain.ClinicalReferralToUpdateForClinicalReferralNoteVoAssembler;
import ims.clinical.vo.domain.PatientDocumentForClinicalReferralVoAssembler;
import ims.core.documents.domain.objects.PatientDocument;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.List;

public class InternalReferralsEditNoteDialogImpl extends BaseInternalReferralsEditNoteDialogImpl
{

	private static final long serialVersionUID = 1L;

	public ims.clinical.vo.ClinicalReferralToUpdateForClinicalReferralNoteVo saveNoteAndUpdateReferral(ims.clinical.vo.ClinicalReferralToUpdateForClinicalReferralNoteVo referralToSave, PatientDocumentForClinicalReferralVo patientDocument) throws ims.domain.exceptions.StaleObjectException  //WDEV-18959
	{
		if (referralToSave == null)
			throw new CodingRuntimeException("The ClinicalReferralToUpdateForClinicalReferralNoteVo object to be updated cannot be null");
		if (!referralToSave.isValidated())
			throw new CodingRuntimeException("Cannot save an invalid ClinicalReferralToUpdateForClinicalReferralNoteVo object");

		DomainFactory factory = getDomainFactory();

		ClinicalReferrals referralDO = ClinicalReferralToUpdateForClinicalReferralNoteVoAssembler.extractClinicalReferrals(factory, referralToSave);
		
		//WDEV-18959
		if (patientDocument!=null)
		{	
    		PatientDocument doPatientDocument = PatientDocumentForClinicalReferralVoAssembler.extractPatientDocument(factory, patientDocument);
    		referralDO.getReferralDocument().add(doPatientDocument);
    		//factory.save(doPatientDocument);
		}
		factory.save(referralDO);
		
		
		
		return ClinicalReferralToUpdateForClinicalReferralNoteVoAssembler.create(referralDO); 
	}
	
	public ims.clinical.vo.ClinicalReferralToUpdateForClinicalReferralNoteVo getPatientReferralDetails(ims.clinical.vo.ClinicalReferralsRefVo clinicalReferralRef)
	{
		if (clinicalReferralRef == null)
			throw new CodingRuntimeException("Major logical error: ClinicalReferralsRefVo reference cannot be null");
		
		DomainFactory factory = getDomainFactory();
		ClinicalReferrals referralDO = (ClinicalReferrals) factory.getDomainObject(ClinicalReferrals.class, clinicalReferralRef.getID_ClinicalReferrals());
		
		return ClinicalReferralToUpdateForClinicalReferralNoteVoAssembler.create(referralDO);
	}

	public Boolean isStale(ClinicalReferralsRefVo referralRef)
	{
		if(referralRef == null)
            return false;

		DomainFactory factory = getDomainFactory();

		List<?> listOfReferrals = factory.find("select ref.id from ClinicalReferrals as ref where ref.id = :referralId and ref.version > :referralVer", new String[] {"referralId", "referralVer"}, new Object[] {referralRef.getID_ClinicalReferrals(), referralRef.getVersion_ClinicalReferrals()});

		if(listOfReferrals != null && listOfReferrals .size() > 0)
            return true;

		return false;
	}

	public ClinicalReferralsVo saveFullReferral(ClinicalReferralsVo referralToSave) throws StaleObjectException
	{
		InternalReferral impl = (InternalReferral) getDomainImpl(InternalReferralImpl.class);

		return impl.saveClinicalReferral(referralToSave);
	}

	//WDEV-18959
	public String[] getSystemReportAndTemplate(Integer imsId)
	{
		String[] result = null;		
		DomainFactory factory = getDomainFactory();
		
		List<?> lst = factory.find("select r.reportXml, t.templateXml from ReportBo as r left join r.templates as t where (r.imsId= :imsid) order by t.name", new String[] {"imsid"}, new Object[] {imsId});
		
		if(lst.iterator().hasNext())
		{
			Object[] obj = (Object[])lst.iterator().next();
			
			result = new String[] {(String)obj[0], (String)obj[1]};
		}
		
		return result;
	}
	
}
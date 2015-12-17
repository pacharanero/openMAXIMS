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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.domain.impl;

import ims.correspondence.domain.CorrespondenceDetails;
import ims.core.admin.pas.vo.PASEventRefVo;
import ims.core.domain.ADT;
import ims.core.domain.impl.ADTImpl;
import ims.core.vo.PasEventVo;
import ims.correspondence.vo.CorrespondenceDetailsRefVo;
import ims.correspondence.vo.CorrespondenceDetailsVo;
import ims.correspondence.vo.CorrespondenceDetailsVoCollection;
import ims.correspondence.vo.domain.CorrespondenceDetailsVoAssembler;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;

public class DocumentReferenceSearchImpl extends DomainImpl implements ims.correspondence.domain.DocumentReferenceSearch, ims.domain.impl.Transactional
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CorrespondenceDetailsVo getCorrespondenceDetails(CorrespondenceDetailsRefVo voCorrespDetRef)
	{
		if (voCorrespDetRef == null)
			throw new CodingRuntimeException("Mandatory Argument - Correspondence Details Required");
		
		CorrespondenceDetails cspDet = (CorrespondenceDetails)getDomainImpl(CorrespondenceDetailsImpl.class);	
		return cspDet.getCorrespondenceDetails(voCorrespDetRef);	

	}
	public PasEventVo getPasEvent(PASEventRefVo pasEventRefVo) 
	{
		if (pasEventRefVo == null)
			throw new CodingRuntimeException("Mandatory Argument - PAS Event Required");
		
		ADT impl = (ADT)getDomainImpl(ADTImpl.class);
		return impl.getPasEvent(pasEventRefVo);
	}
	
	public CorrespondenceDetailsVoCollection getCorrespondenceForPASEventId(Integer id) 
	{
		return CorrespondenceDetailsVoAssembler.createCorrespondenceDetailsVoCollectionFromCorrespondenceDetails(
				getDomainFactory().find("select c1_1 from CorrespondenceDetails as c1_1 left join c1_1.pasEvent as p1_1 left join c1_1.currentDocument as d1_1 where ( p1_1.id = :id )", new String[] {"id"}, new Object[] {id}));
	}
}
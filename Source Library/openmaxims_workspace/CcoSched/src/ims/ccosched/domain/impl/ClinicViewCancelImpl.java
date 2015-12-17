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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.71 build 3762.24956)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.ccosched.domain.impl;

import ims.ccosched.domain.BookingConfirmation;
import ims.ccosched.domain.ClinicViewCancel;
import ims.configuration.InitConfig;
import ims.core.admin.vo.EpisodeOfCareRefVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.dto.DTODomainImplementation;

public class ClinicViewCancelImpl extends DTODomainImplementation implements ClinicViewCancel
{

	private static final org.apache.log4j.Logger LOG = ims.utils.Logging.getLogger(ClinicViewCancelImpl.class);

	private static final long serialVersionUID = 1L;
	
	public boolean dtoOnly()
	{
		return InitConfig.getConfigType().equals("DTO");
	}

	/** wdev-8873
	 * Look for an existing patient journey for the given rkey.  If one found, instantiate an event with Cancel Details
	 */
	public void instantiateEvent(String rkey, String firstApptId,String firstApptDt, String activity,EpisodeOfCareRefVo episode) throws DomainInterfaceException, StaleObjectException 
	{
		BookingConfirmation impl = (BookingConfirmation) getDomainImpl(BookingConfirmationImpl.class);
		
		impl.instantiateEvent(rkey, firstApptId, firstApptDt, "C" + activity, "Event sent from Clinic View Cancel Screen", episode);

	}
	

}
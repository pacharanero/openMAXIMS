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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.62 build 3111.36466)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.scheduling.domain.impl;

import ims.scheduling.domain.ProfilesSlotGeneric;
import ims.scheduling.domain.base.impl.BaseSessionSlotDialogImpl;

public class SessionSlotDialogImpl extends BaseSessionSlotDialogImpl
{
	private static final long serialVersionUID = 1L;
	
	/**
	* listActivities
	*/
	public ims.core.vo.ActivityVoCollection listActivities()
	{
		ProfilesSlotGeneric impl = (ProfilesSlotGeneric) getDomainImpl(ProfilesSlotGenericImpl.class);
		return impl.listActivities();
	}
}
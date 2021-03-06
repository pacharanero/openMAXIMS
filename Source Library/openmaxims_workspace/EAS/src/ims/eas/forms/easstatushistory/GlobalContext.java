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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.eas.forms.easstatushistory;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		EAS = new EASContext(context);
	}
	public final class EASContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private EASContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getEasStatusHistoryIsNotNull()
		{
			return !cx_EASEasStatusHistory.getValueIsNull(context);
		}
		public ims.eas.vo.EASStatusRecordVoCollection getEasStatusHistory()
		{
			return (ims.eas.vo.EASStatusRecordVoCollection)cx_EASEasStatusHistory.getValue(context);
		}
		public void setEasStatusHistory(ims.eas.vo.EASStatusRecordVoCollection value)
		{
			cx_EASEasStatusHistory.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_EASEasStatusHistory = new ims.framework.ContextVariable("EAS.EasStatusHistory", "_cv_EAS.EasStatusHistory");

		private ims.framework.Context context;
	}

	public EASContext EAS;
}

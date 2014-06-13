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
// This code was generated by Charlotte Murphy using IMS Development Environment (version 1.30 build 2012.21169)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.coe.forms.rptmna;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.lookups.PatIdType;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		String dsn = "";
		String host = "";
		String userName = "";
		String password = "";

		dsn = ConfigFlag.UI.REPORTS_DSN.getValue();
		host = ConfigFlag.UI.REPORTS_HOST.getValue();
		userName =  ConfigFlag.UI.REPORTS_USER.getValue();
		password = ConfigFlag.UI.REPORTS_PASS.getValue();
				
		String html = "";
		if(form.getGlobalContext().Core.getCurrentClinicalContactIsNotNull()){
			PatIdType mnaIdType = PatIdType.getNegativeInstance(ConfigFlag.UI.DISPLAY_PATID_TYPE.getValue());
			Integer mNA_id = form.getGlobalContext().COE.getMNARecord().getID_Assessment();
			String server = ConfigFlag.UI.REPORT_SERVER.getValue();
			html = "<IFRAME src='http://" + server + "/MNA Report.asp?MNAid=" + mNA_id + "&idtype=" + mnaIdType.getId() + "&dsn=" + dsn + "&host=" + host + "&userName=" + userName + "&password=" + password + "' style=\"width:100%; height:100%;\">";
		}
		form.htmRptMNA().setHTML(html);
	}
}
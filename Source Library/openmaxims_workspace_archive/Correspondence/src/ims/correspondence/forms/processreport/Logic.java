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
// This code was generated by Sean Nesbitt using IMS Development Environment (version 1.28 build 1999.20982)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.correspondence.forms.processreport;

import ims.configuration.gen.ConfigFlag;
import ims.core.vo.DocumentVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.framework.enumerations.DialogResult;
import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{		
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		if(urlQueryServer == null || urlQueryServer.length() == 0)
		{
			form.htmViewer().setHTML("<center>The <b>QUERY_SERVER_URL</b> config flag was not set !</center>");
			return;
		}

		if(urlReportServer == null || urlReportServer.length() == 0)
		{
			form.htmViewer().setHTML("<center>The <b>REPORT_SERVER_URL</b> config flag was not set !</center>");
			return;
		}
		
		if(form.getGlobalContext().Core.getDocumentIDIsNotNull())
		{
		
			QueryBuilderClient client = new QueryBuilderClient(urlQueryServer,engine.getSessionId());
			
 			//Get Document
			if (form.getGlobalContext().Core.getDocumentIDIsNotNull())
			{
				DocumentVo voDoc = new DocumentVo();
				voDoc.setID_Document(form.getGlobalContext().Core.getDocumentID());
				voDoc = domain.getDocument(voDoc);
				if (null == voDoc)
					return;
				
				String resultUrl = "";
				byte[] resultPdf = null;
								
				try
				{					 
					if (voDoc.getContentIsNotNull())
					{
						resultPdf = client.convertReport(urlReportServer,voDoc.getContent().getBytes(),"PDF","",1);
						resultUrl = client.prepareReportForViewingInlineFrame(resultPdf,"PDF");
						form.htmViewer().setHTML(resultUrl);
						return;
					}
					else
					{
						engine.showMessage("No Document Content found for report.: ");
						return;
					}
				} 
				catch (QueryBuilderClientException e1)
				{
					engine.showMessage("Error preparing report: " + e1.getMessage());
					return;
				}
			}
			
			return;
		}

		form.htmViewer().setHTML("<center>No report to build or view, you have not passed down the right parameters !</center>");
		
		/*if(form.getGlobalContext().Core.getReportIDIsNotNull() && form.getGlobalContext().Core.getTemplateIDIsNotNull())
		{
			form.htmViewer().setHTML((new QueryBuilderClient(urlQueryServer,engine.getSessionId())).getWaitUrl());
			return;
		}*/
		
		//we should not get here
		
	}
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	protected void onHtmViewerHTMLViewerClick(int value) throws ims.framework.exceptions.PresentationLogicException
	{
		try
		{
			form.htmViewer().setHTML(getIFrameCode());
		} 
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.toString());
		}
	}
	/*
	 *  This is specific to CSP and will generate a report based on the DocumentDetails_id seed
	 */
	private String getIFrameCode() throws DomainInterfaceException
	{
		StringBuffer sb = new StringBuffer(1000);
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();
		
		String[] obj = null;
		
		obj = domain.getReportAndTemplate(form.getGlobalContext().Core.getReportID(), form.getGlobalContext().Core.getTemplateID());

		if(obj == null || obj.length == 0)
		{
			engine.showMessage("I could not get the report and template !");
			return sb.toString();
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer,engine.getSessionId());
				
		//get report seed name
		if (form.getGlobalContext().Correspondence.getDocDetailIdReportSeedIsNotNull())
			client.addSeed(new SeedValue("DocumentDetails_id",form.getGlobalContext().Correspondence.getDocDetailIdReportSeed(),Integer.class));
		
		String result = "";
		
		try
		{
			result = client.buildReportAsUrlInlineFrame(obj[0], obj[1], urlReportServer, "PDF", "",1);
			sb.append(result);
			
		} catch (QueryBuilderClientException e1)
		{
			return e1.toString();
		} 
		
		return sb.toString();
	}
	


}
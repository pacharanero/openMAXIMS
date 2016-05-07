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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4680.16533)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.admin.forms.reportaccess;

import ims.admin.forms.reportaccess.GenForm.grdReportsRow;
import ims.admin.vo.SystemReportVo;
import ims.admin.vo.SystemReportVoCollection;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int CanEditQueryColumnSelected = 1;
	private static final int CanEditTemplateColumnSelected = 2;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		initialize();
	}

	private void initialize()
	{
		form.grdReports().setReadOnly(false);
		form.grdReports().setEnabled(true);
		form.ccSearchReport().initialize(Boolean.TRUE);
	}

	@Override
	protected void onGrdReportsGridCheckBoxClicked(int column, grdReportsRow row, boolean isChecked) throws PresentationLogicException
	{
		SystemReportVo report = row.getValue();

		if (CanEditQueryColumnSelected == column)
		{
			report.setQueryEditable(isChecked);

			if (report.getImsIdIsNotNull())
			{
				if (isChecked)
				{
					row.setTextColor(Color.DodgerBlue);
				}
				else
				{
					row.setTextColor(Color.Blue);
				}
			}

		}
		else if (CanEditTemplateColumnSelected == column)
		{
			report.setTemplateEditable(isChecked);
		}

		if (!save(report, row))
		{
			form.ccSearchReport().doSearch();
		}

	}

	private boolean save(SystemReportVo report, grdReportsRow selectedRow)
	{
		SystemReportVo savedReport;
		String[] errors = report.validate();

		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			savedReport = domain.saveReport(report);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			return false;
		}

		selectedRow.setValue(domain.getReport(savedReport));

		return true;
	}

	@Override
	protected void onCcSearchReportValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		if (ims.admin.vo.enums.ReportSearchAction.SEARCH.equals(form.ccSearchReport().getEvent()))
		{
			form.grdReports().getRows().clear();
			listReports(form.ccSearchReport().getReportCollection());
			form.ccSearchReport().clearEvent();
		}
		else if (ims.admin.vo.enums.ReportSearchAction.CLEAR.equals(form.ccSearchReport().getEvent()))
		{
			form.grdReports().getRows().clear();
			form.ccSearchReport().clearEvent();
		}
	}

	private void listReports(SystemReportVoCollection reportCollection)
	{
		if (reportCollection == null || reportCollection.size() == 0)
		{
			engine.showMessage("No reports found matching your search criteria !");
			return;
		}

		for (int i = 0; i < reportCollection.size(); i++)
		{
			populateRow(reportCollection.get(i));
		}
	}

	private void populateRow(SystemReportVo report)
	{
		grdReportsRow newRow = form.grdReports().getRows().newRow();

		newRow.setcolName(report.getReportName());

		if (Boolean.TRUE.equals(report.getQueryEditable()))
		{
			newRow.setcolQuery(Boolean.TRUE);

			if (report.getImsIdIsNotNull())
			{
				newRow.setTextColor(Color.DodgerBlue);
			}
		}
		else
		{
			newRow.setcolQuery(Boolean.FALSE);

			if (report.getImsIdIsNotNull())
			{
				newRow.setTextColor(Color.Blue);
			}
		}

		if (Boolean.TRUE.equals(report.getTemplateEditable()))
		{
			newRow.setcolTemplate(Boolean.TRUE);
		}
		else
		{
			newRow.setcolTemplate(Boolean.FALSE);
		}

		newRow.setValue(report);
	}
}
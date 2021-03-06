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

package ims.core.forms.pdsaddresssearch;

import ims.framework.delegates.*;

abstract public class Handlers implements ims.framework.UILogic, IFormUILogicCode
{
	abstract protected void bindcmbAreaOfResidenceLookup();
	abstract protected void defaultcmbAreaOfResidenceLookupValue();
	abstract protected void bindcmbCountryLookup();
	abstract protected void defaultcmbCountryLookupValue();
	abstract protected void onFormModeChanged();
	abstract protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbAreaOfResidenceValueSet(Object value);
	abstract protected void onImbHistoricalAddressesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkCareHomeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onBtnViewOtherAddressesClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtAddress5ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onChkNoFixedValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onImbPostCodeSearchClick() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtAddress2ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtAddress3ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtAddress4ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtAddress1ValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtPostValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void onTxtPctCodeValueChanged() throws ims.framework.exceptions.PresentationLogicException;
	abstract protected void oncmbCountryValueSet(Object value);
	abstract protected void onCmbCountyValueChanged() throws ims.framework.exceptions.PresentationLogicException;

	public final void setContext(ims.framework.UIComponentEngine engine, GenForm form)
	{
		this.engine = engine;
		this.form = form;

		this.form.setFormModeChangedEvent(new FormModeChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle()
			{
				onFormModeChanged();
			}
		});
		this.form.setFormOpenEvent(new FormOpen()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object[] args) throws ims.framework.exceptions.PresentationLogicException
			{
				bindLookups();
				onFormOpen(args);
			}
		});
		this.form.setFormDialogClosedEvent(new FormDialogClosed()
		{
			private static final long serialVersionUID = 1L;
			public void handle(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
			{
				onFormDialogClosed(formName, result);
			}
		});
		this.form.cmbAreaOfResidence().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbAreaOfResidenceValueSet(value);
			}
		});
		this.form.imbHistoricalAddresses().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbHistoricalAddressesClick();
			}
		});
		this.form.chkCareHome().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkCareHomeValueChanged();
			}
		});
		this.form.btnViewOtherAddresses().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onBtnViewOtherAddressesClick();
			}
		});
		this.form.txtAddress5().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtAddress5ValueChanged();
			}
		});
		this.form.chkNoFixed().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onChkNoFixedValueChanged();
			}
		});
		this.form.imbPostCodeSearch().setClickEvent(new Click()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onImbPostCodeSearchClick();
			}
		});
		this.form.txtAddress2().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtAddress2ValueChanged();
			}
		});
		this.form.txtAddress3().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtAddress3ValueChanged();
			}
		});
		this.form.txtAddress4().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtAddress4ValueChanged();
			}
		});
		this.form.txtAddress1().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtAddress1ValueChanged();
			}
		});
		this.form.txtPost().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtPostValueChanged();
			}
		});
		this.form.txtPctCode().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onTxtPctCodeValueChanged();
			}
		});
		this.form.cmbCountry().setValueSetEvent(new ComboBoxValueSet()
		{
			private static final long serialVersionUID = 1L;
			public void handle(Object value)
			{
				oncmbCountryValueSet(value);
			}
		});
		this.form.cmbCountry().setValueChangedEvent(new ValueChanged()
		{
			private static final long serialVersionUID = 1L;
			public void handle() throws ims.framework.exceptions.PresentationLogicException
			{
				onCmbCountyValueChanged();
			}
		});
	}
	protected void bindLookups()
	{
		bindcmbAreaOfResidenceLookup();
		bindcmbCountryLookup();
	}
	protected void rebindAllLookups()
	{
		bindcmbAreaOfResidenceLookup();
		bindcmbCountryLookup();
	}
	protected void defaultAllLookupValues()
	{
		defaultcmbAreaOfResidenceLookupValue();
		defaultcmbCountryLookupValue();
	}

	public void free()
	{
		this.engine = null;
		this.form = null;
	}
	protected ims.framework.UIComponentEngine engine;
	protected GenForm form;
}

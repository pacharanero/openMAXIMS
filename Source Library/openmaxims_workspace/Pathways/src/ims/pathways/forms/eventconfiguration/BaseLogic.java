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

package ims.pathways.forms.eventconfiguration;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.pathways.domain.EventConfiguration.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.pathways.domain.EventConfiguration domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	public void clearContextInformation()
	{
		engine.clearPatientContextInformation();
	}
	protected final void oncmbEventTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbEventType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventCreationType existingInstance = (ims.pathways.vo.lookups.EventCreationType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbEventTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.pathways.vo.lookups.EventCreationType)
		{
			ims.pathways.vo.lookups.EventCreationType instance = (ims.pathways.vo.lookups.EventCreationType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbEventTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.pathways.vo.lookups.EventCreationType existingInstance = (ims.pathways.vo.lookups.EventCreationType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbEventType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbEventTypeLookup()
	{
		this.form.cmbEventType().clear();
		ims.pathways.vo.lookups.EventCreationTypeCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getEventCreationType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbEventType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbEventTypeLookupValue(int id)
	{
		ims.pathways.vo.lookups.EventCreationType instance = ims.pathways.vo.lookups.LookupHelper.getEventCreationTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbEventType().setValue(instance);
	}
	protected final void defaultcmbEventTypeLookupValue()
	{
		this.form.cmbEventType().setValue((ims.pathways.vo.lookups.EventCreationType)domain.getLookupService().getDefaultInstance(ims.pathways.vo.lookups.EventCreationType.class, engine.getFormName().getID(), ims.pathways.vo.lookups.EventCreationType.TYPE_ID));
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.PreActiveActiveInactiveStatus)
		{
			ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.PreActiveActiveInactiveStatus existingInstance = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.core.vo.lookups.PreActiveActiveInactiveStatus instance = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.core.vo.lookups.PreActiveActiveInactiveStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.PreActiveActiveInactiveStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.PreActiveActiveInactiveStatus.TYPE_ID));
	}
	protected final void bindgrdExternalEventMappingsColStatusLookup()
	{
		this.form.lyrTargets().tabExternalMappings().grdExternalEventMappings().ColStatusComboBox().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrTargets().tabExternalMappings().grdExternalEventMappings().ColStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdRTTColActionLookup()
	{
		this.form.lyrTargets().tabRTT().grdRTT().ColActionComboBox().clear();
		ims.pathways.vo.lookups.RTTActionCollection lookupCollection = ims.pathways.vo.lookups.LookupHelper.getRTTAction(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrTargets().tabRTT().grdRTT().ColActionComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgrdRTTColStatusLookup()
	{
		this.form.lyrTargets().tabRTT().grdRTT().ColStatusComboBox().clear();
		ims.core.vo.lookups.PreActiveActiveInactiveStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getPreActiveActiveInactiveStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyrTargets().tabRTT().grdRTT().ColStatusComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncmbTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.Status_Reason existingInstance = (ims.scheduling.vo.lookups.Status_Reason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.Status_Reason)
		{
			ims.scheduling.vo.lookups.Status_Reason instance = (ims.scheduling.vo.lookups.Status_Reason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.Status_Reason existingInstance = (ims.scheduling.vo.lookups.Status_Reason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbTypeLookup()
	{
		this.form.cmbType().clear();
		ims.scheduling.vo.lookups.Status_ReasonCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getStatus_Reason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbTypeLookupValue(int id)
	{
		ims.scheduling.vo.lookups.Status_Reason instance = ims.scheduling.vo.lookups.LookupHelper.getStatus_ReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbType().setValue(instance);
	}
	protected final void defaultcmbTypeLookupValue()
	{
		this.form.cmbType().setValue((ims.scheduling.vo.lookups.Status_Reason)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.Status_Reason.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.Status_Reason.TYPE_ID));
	}
	protected final void oncmbReasonValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReason().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.CancelAppointmentReason existingInstance = (ims.scheduling.vo.lookups.CancelAppointmentReason)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.scheduling.vo.lookups.CancelAppointmentReason)
		{
			ims.scheduling.vo.lookups.CancelAppointmentReason instance = (ims.scheduling.vo.lookups.CancelAppointmentReason)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.scheduling.vo.lookups.CancelAppointmentReason existingInstance = (ims.scheduling.vo.lookups.CancelAppointmentReason)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReason().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonLookup()
	{
		this.form.cmbReason().clear();
		ims.scheduling.vo.lookups.CancelAppointmentReasonCollection lookupCollection = ims.scheduling.vo.lookups.LookupHelper.getCancelAppointmentReason(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReason().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonLookupValue(int id)
	{
		ims.scheduling.vo.lookups.CancelAppointmentReason instance = ims.scheduling.vo.lookups.LookupHelper.getCancelAppointmentReasonInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReason().setValue(instance);
	}
	protected final void defaultcmbReasonLookupValue()
	{
		this.form.cmbReason().setValue((ims.scheduling.vo.lookups.CancelAppointmentReason)domain.getLookupService().getDefaultInstance(ims.scheduling.vo.lookups.CancelAppointmentReason.class, engine.getFormName().getID(), ims.scheduling.vo.lookups.CancelAppointmentReason.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.pathways.domain.EventConfiguration domain;
}

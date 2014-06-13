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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.coe.forms.assessbowels;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.coe.domain.AssessBowels.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.coe.domain.AssessBowels domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncomboBoxBowelsOpenValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxBowelsOpen().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.BowelsOpen existingInstance = (ims.coe.vo.lookups.BowelsOpen)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxBowelsOpenLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.BowelsOpen)
		{
			ims.coe.vo.lookups.BowelsOpen instance = (ims.coe.vo.lookups.BowelsOpen)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxBowelsOpenLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.BowelsOpen existingInstance = (ims.coe.vo.lookups.BowelsOpen)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxBowelsOpen().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxBowelsOpenLookup()
	{
		this.form.container1().comboBoxBowelsOpen().clear();
		ims.coe.vo.lookups.BowelsOpenCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getBowelsOpen(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxBowelsOpen().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxBowelsOpenLookupValue(int id)
	{
		ims.coe.vo.lookups.BowelsOpen instance = ims.coe.vo.lookups.LookupHelper.getBowelsOpenInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxBowelsOpen().setValue(instance);
	}
	protected final void defaultcomboBoxBowelsOpenLookupValue()
	{
		this.form.container1().comboBoxBowelsOpen().setValue((ims.coe.vo.lookups.BowelsOpen)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.BowelsOpen.class, engine.getFormName().getID(), ims.coe.vo.lookups.BowelsOpen.TYPE_ID));
	}
	protected final void onanswerBoxLaxativesValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxLaxatives().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxLaxativesLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxLaxativesLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxLaxatives().addOption(instance);
		}
	}
	protected final void bindanswerBoxLaxativesLookup()
	{
		this.form.container1().answerBoxLaxatives().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxLaxatives().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxLaxativesLookupValue()
	{
		this.form.container1().answerBoxLaxatives().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onanswerBoxNoticedStainingValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxNoticedStaining().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxNoticedStainingLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxNoticedStainingLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxNoticedStaining().addOption(instance);
		}
	}
	protected final void bindanswerBoxNoticedStainingLookup()
	{
		this.form.container1().answerBoxNoticedStaining().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxNoticedStaining().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxNoticedStainingLookupValue()
	{
		this.form.container1().answerBoxNoticedStaining().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onanswerBoxLeakagePastValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxLeakagePast().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxLeakagePastLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxLeakagePastLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxLeakagePast().addOption(instance);
		}
	}
	protected final void bindanswerBoxLeakagePastLookup()
	{
		this.form.container1().answerBoxLeakagePast().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxLeakagePast().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxLeakagePastLookupValue()
	{
		this.form.container1().answerBoxLeakagePast().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onanswerBoxLeakagePresentValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxLeakagePresent().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxLeakagePresentLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxLeakagePresentLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxLeakagePresent().addOption(instance);
		}
	}
	protected final void bindanswerBoxLeakagePresentLookup()
	{
		this.form.container1().answerBoxLeakagePresent().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxLeakagePresent().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxLeakagePresentLookupValue()
	{
		this.form.container1().answerBoxLeakagePresent().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void onanswerBoxProneToConsValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxProneToCons().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxProneToConsLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxProneToConsLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxProneToCons().addOption(instance);
		}
	}
	protected final void bindanswerBoxProneToConsLookup()
	{
		this.form.container1().answerBoxProneToCons().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxProneToCons().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxProneToConsLookupValue()
	{
		this.form.container1().answerBoxProneToCons().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void oncomboBoxAmountValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxAmount().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaAmount existingInstance = (ims.coe.vo.lookups.DiarrhoeaAmount)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxAmountLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DiarrhoeaAmount)
		{
			ims.coe.vo.lookups.DiarrhoeaAmount instance = (ims.coe.vo.lookups.DiarrhoeaAmount)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxAmountLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaAmount existingInstance = (ims.coe.vo.lookups.DiarrhoeaAmount)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxAmount().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxAmountLookup()
	{
		this.form.container1().comboBoxAmount().clear();
		ims.coe.vo.lookups.DiarrhoeaAmountCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaAmount(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxAmount().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxAmountLookupValue(int id)
	{
		ims.coe.vo.lookups.DiarrhoeaAmount instance = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaAmountInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxAmount().setValue(instance);
	}
	protected final void defaultcomboBoxAmountLookupValue()
	{
		this.form.container1().comboBoxAmount().setValue((ims.coe.vo.lookups.DiarrhoeaAmount)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DiarrhoeaAmount.class, engine.getFormName().getID(), ims.coe.vo.lookups.DiarrhoeaAmount.TYPE_ID));
	}
	protected final void oncomboBoxColourValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxColour().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaColour existingInstance = (ims.coe.vo.lookups.DiarrhoeaColour)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxColourLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DiarrhoeaColour)
		{
			ims.coe.vo.lookups.DiarrhoeaColour instance = (ims.coe.vo.lookups.DiarrhoeaColour)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxColourLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaColour existingInstance = (ims.coe.vo.lookups.DiarrhoeaColour)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxColour().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxColourLookup()
	{
		this.form.container1().comboBoxColour().clear();
		ims.coe.vo.lookups.DiarrhoeaColourCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaColour(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxColour().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxColourLookupValue(int id)
	{
		ims.coe.vo.lookups.DiarrhoeaColour instance = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaColourInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxColour().setValue(instance);
	}
	protected final void defaultcomboBoxColourLookupValue()
	{
		this.form.container1().comboBoxColour().setValue((ims.coe.vo.lookups.DiarrhoeaColour)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DiarrhoeaColour.class, engine.getFormName().getID(), ims.coe.vo.lookups.DiarrhoeaColour.TYPE_ID));
	}
	protected final void oncomboBoxOdourValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxOdour().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaOdour existingInstance = (ims.coe.vo.lookups.DiarrhoeaOdour)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxOdourLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DiarrhoeaOdour)
		{
			ims.coe.vo.lookups.DiarrhoeaOdour instance = (ims.coe.vo.lookups.DiarrhoeaOdour)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxOdourLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaOdour existingInstance = (ims.coe.vo.lookups.DiarrhoeaOdour)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxOdour().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxOdourLookup()
	{
		this.form.container1().comboBoxOdour().clear();
		ims.coe.vo.lookups.DiarrhoeaOdourCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaOdour(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxOdour().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxOdourLookupValue(int id)
	{
		ims.coe.vo.lookups.DiarrhoeaOdour instance = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaOdourInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxOdour().setValue(instance);
	}
	protected final void defaultcomboBoxOdourLookupValue()
	{
		this.form.container1().comboBoxOdour().setValue((ims.coe.vo.lookups.DiarrhoeaOdour)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DiarrhoeaOdour.class, engine.getFormName().getID(), ims.coe.vo.lookups.DiarrhoeaOdour.TYPE_ID));
	}
	protected final void oncomboBoxConsistencyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxConsistency().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaConsistency existingInstance = (ims.coe.vo.lookups.DiarrhoeaConsistency)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxConsistencyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DiarrhoeaConsistency)
		{
			ims.coe.vo.lookups.DiarrhoeaConsistency instance = (ims.coe.vo.lookups.DiarrhoeaConsistency)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxConsistencyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaConsistency existingInstance = (ims.coe.vo.lookups.DiarrhoeaConsistency)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxConsistency().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxConsistencyLookup()
	{
		this.form.container1().comboBoxConsistency().clear();
		ims.coe.vo.lookups.DiarrhoeaConsistencyCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaConsistency(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxConsistency().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxConsistencyLookupValue(int id)
	{
		ims.coe.vo.lookups.DiarrhoeaConsistency instance = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaConsistencyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxConsistency().setValue(instance);
	}
	protected final void defaultcomboBoxConsistencyLookupValue()
	{
		this.form.container1().comboBoxConsistency().setValue((ims.coe.vo.lookups.DiarrhoeaConsistency)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DiarrhoeaConsistency.class, engine.getFormName().getID(), ims.coe.vo.lookups.DiarrhoeaConsistency.TYPE_ID));
	}
	protected final void oncomboBoxFreqValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxFreq().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaFrequency existingInstance = (ims.coe.vo.lookups.DiarrhoeaFrequency)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxFreqLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.coe.vo.lookups.DiarrhoeaFrequency)
		{
			ims.coe.vo.lookups.DiarrhoeaFrequency instance = (ims.coe.vo.lookups.DiarrhoeaFrequency)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxFreqLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.coe.vo.lookups.DiarrhoeaFrequency existingInstance = (ims.coe.vo.lookups.DiarrhoeaFrequency)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxFreq().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxFreqLookup()
	{
		this.form.container1().comboBoxFreq().clear();
		ims.coe.vo.lookups.DiarrhoeaFrequencyCollection lookupCollection = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaFrequency(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxFreq().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxFreqLookupValue(int id)
	{
		ims.coe.vo.lookups.DiarrhoeaFrequency instance = ims.coe.vo.lookups.LookupHelper.getDiarrhoeaFrequencyInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxFreq().setValue(instance);
	}
	protected final void defaultcomboBoxFreqLookupValue()
	{
		this.form.container1().comboBoxFreq().setValue((ims.coe.vo.lookups.DiarrhoeaFrequency)domain.getLookupService().getDefaultInstance(ims.coe.vo.lookups.DiarrhoeaFrequency.class, engine.getFormName().getID(), ims.coe.vo.lookups.DiarrhoeaFrequency.TYPE_ID));
	}
	protected final void onanswerBoxProneDiarrValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().answerBoxProneDiarr().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindanswerBoxProneDiarrLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.YesNoUnknown)
		{
			ims.core.vo.lookups.YesNoUnknown instance = (ims.core.vo.lookups.YesNoUnknown)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindanswerBoxProneDiarrLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.YesNoUnknown existingInstance = (ims.core.vo.lookups.YesNoUnknown)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().answerBoxProneDiarr().addOption(instance);
		}
	}
	protected final void bindanswerBoxProneDiarrLookup()
	{
		this.form.container1().answerBoxProneDiarr().clear();
		ims.core.vo.lookups.YesNoUnknownCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getYesNoUnknown(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().answerBoxProneDiarr().addOption(lookupCollection.get(x));
		}
	}
	protected final void defaultanswerBoxProneDiarrLookupValue()
	{
		this.form.container1().answerBoxProneDiarr().setValue((ims.core.vo.lookups.YesNoUnknown)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.YesNoUnknown.class, engine.getFormName().getID(), ims.core.vo.lookups.YesNoUnknown.TYPE_ID));
	}
	protected final void bindgridMedicationColRouteLookup()
	{
		this.form.container1().gridMedication().ColRouteComboBox().clear();
		ims.core.vo.lookups.MedicationRouteCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicationRoute(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().gridMedication().ColRouteComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void bindgridMedicationColFrequencyLookup()
	{
		this.form.container1().gridMedication().ColFrequencyComboBox().clear();
		ims.core.vo.lookups.MedicationFrequencyCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getMedicationFrequency(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().gridMedication().ColFrequencyComboBox().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void oncomboBoxOstomyValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.container1().comboBoxOstomy().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BowelOstomyType existingInstance = (ims.nursing.vo.lookups.BowelOstomyType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcomboBoxOstomyLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.BowelOstomyType)
		{
			ims.nursing.vo.lookups.BowelOstomyType instance = (ims.nursing.vo.lookups.BowelOstomyType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcomboBoxOstomyLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.BowelOstomyType existingInstance = (ims.nursing.vo.lookups.BowelOstomyType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.container1().comboBoxOstomy().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcomboBoxOstomyLookup()
	{
		this.form.container1().comboBoxOstomy().clear();
		ims.nursing.vo.lookups.BowelOstomyTypeCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getBowelOstomyType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.container1().comboBoxOstomy().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcomboBoxOstomyLookupValue(int id)
	{
		ims.nursing.vo.lookups.BowelOstomyType instance = ims.nursing.vo.lookups.LookupHelper.getBowelOstomyTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.container1().comboBoxOstomy().setValue(instance);
	}
	protected final void defaultcomboBoxOstomyLookupValue()
	{
		this.form.container1().comboBoxOstomy().setValue((ims.nursing.vo.lookups.BowelOstomyType)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.BowelOstomyType.class, engine.getFormName().getID(), ims.nursing.vo.lookups.BowelOstomyType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.coe.domain.AssessBowels domain;
}
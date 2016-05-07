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

package ims.oncology.vo;

/**
 * Linked to Oncology.ChemotherapyCycleDetails business object (ID: 1074100005).
 */
public class ChemotherapyCycleDetailsVo extends ims.oncology.vo.ChemotherapyCycleDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ChemotherapyCycleDetailsVo()
	{
	}
	public ChemotherapyCycleDetailsVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChemotherapyCycleDetailsVo(ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cyclenumber = bean.getCycleNumber();
		this.cyclestartdate = bean.getCycleStartDate() == null ? null : bean.getCycleStartDate().buildDate();
		this.cycleduration = bean.getCycleDuration();
		this.daydetails = ims.oncology.vo.ChemoTherapyDayDetailsVoCollection.buildFromBeanCollection(bean.getDayDetails());
		this.isactive = bean.getIsActive();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.cyclenumber = bean.getCycleNumber();
		this.cyclestartdate = bean.getCycleStartDate() == null ? null : bean.getCycleStartDate().buildDate();
		this.cycleduration = bean.getCycleDuration();
		this.daydetails = ims.oncology.vo.ChemoTherapyDayDetailsVoCollection.buildFromBeanCollection(bean.getDayDetails());
		this.isactive = bean.getIsActive();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.ChemotherapyCycleDetailsVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CYCLENUMBER"))
			return getCycleNumber();
		if(fieldName.equals("CYCLESTARTDATE"))
			return getCycleStartDate();
		if(fieldName.equals("CYCLEDURATION"))
			return getCycleDuration();
		if(fieldName.equals("DAYDETAILS"))
			return getDayDetails();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCycleNumberIsNotNull()
	{
		return this.cyclenumber != null;
	}
	public Integer getCycleNumber()
	{
		return this.cyclenumber;
	}
	public void setCycleNumber(Integer value)
	{
		this.isValidated = false;
		this.cyclenumber = value;
	}
	public boolean getCycleStartDateIsNotNull()
	{
		return this.cyclestartdate != null;
	}
	public ims.framework.utils.Date getCycleStartDate()
	{
		return this.cyclestartdate;
	}
	public void setCycleStartDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.cyclestartdate = value;
	}
	public boolean getCycleDurationIsNotNull()
	{
		return this.cycleduration != null;
	}
	public Integer getCycleDuration()
	{
		return this.cycleduration;
	}
	public void setCycleDuration(Integer value)
	{
		this.isValidated = false;
		this.cycleduration = value;
	}
	public boolean getDayDetailsIsNotNull()
	{
		return this.daydetails != null;
	}
	public ims.oncology.vo.ChemoTherapyDayDetailsVoCollection getDayDetails()
	{
		return this.daydetails;
	}
	public void setDayDetails(ims.oncology.vo.ChemoTherapyDayDetailsVoCollection value)
	{
		this.isValidated = false;
		this.daydetails = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.daydetails != null)
		{
			if(!this.daydetails.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.cyclenumber == null)
			listOfErrors.add("CycleNumber is mandatory");
		if(this.daydetails != null)
		{
			String[] listOfOtherErrors = this.daydetails.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		ChemotherapyCycleDetailsVo clone = new ChemotherapyCycleDetailsVo(this.id, this.version);
		
		clone.cyclenumber = this.cyclenumber;
		if(this.cyclestartdate == null)
			clone.cyclestartdate = null;
		else
			clone.cyclestartdate = (ims.framework.utils.Date)this.cyclestartdate.clone();
		clone.cycleduration = this.cycleduration;
		if(this.daydetails == null)
			clone.daydetails = null;
		else
			clone.daydetails = (ims.oncology.vo.ChemoTherapyDayDetailsVoCollection)this.daydetails.clone();
		clone.isactive = this.isactive;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(ChemotherapyCycleDetailsVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChemotherapyCycleDetailsVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChemotherapyCycleDetailsVo compareObj = (ChemotherapyCycleDetailsVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getCycleNumber() == null && compareObj.getCycleNumber() != null)
				return -1;
			if(this.getCycleNumber() != null && compareObj.getCycleNumber() == null)
				return 1;
			if(this.getCycleNumber() != null && compareObj.getCycleNumber() != null)
				retVal = this.getCycleNumber().compareTo(compareObj.getCycleNumber());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.cyclenumber != null)
			count++;
		if(this.cyclestartdate != null)
			count++;
		if(this.cycleduration != null)
			count++;
		if(this.daydetails != null)
			count++;
		if(this.isactive != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected Integer cyclenumber;
	protected ims.framework.utils.Date cyclestartdate;
	protected Integer cycleduration;
	protected ims.oncology.vo.ChemoTherapyDayDetailsVoCollection daydetails;
	protected Boolean isactive;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
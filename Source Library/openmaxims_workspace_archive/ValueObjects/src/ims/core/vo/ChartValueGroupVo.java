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

package ims.core.vo;

/**
 * Linked to core.charting.DatasetType business object (ID: 1081100001).
 */
public class ChartValueGroupVo extends ims.core.charting.vo.DatasetTypeRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IChartValueGroup
{
	private static final long serialVersionUID = 1L;

	public ChartValueGroupVo()
	{
	}
	public ChartValueGroupVo(Integer id, int version)
	{
		super(id, version);
	}
	public ChartValueGroupVo(ims.core.vo.beans.ChartValueGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.values = ims.core.vo.ChartValueVoCollection.buildFromBeanCollection(bean.getValues());
		this.minfactor = bean.getMinFactor();
		this.maxfactor = bean.getMaxFactor();
		this.minvalue = bean.getMinValue();
		this.maxvalue = bean.getMaxValue();
		this.units = bean.getUnits();
		this.refrange = bean.getRefRange();
		this.image = bean.getImage() == null ? null : bean.getImage().buildImage();
		this.color = bean.getColor() == null ? null : bean.getColor().buildColor();
		this.linetype = bean.getLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getLineType());
		this.sortorder = bean.getSortOrder();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.ChartValueGroupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.values = ims.core.vo.ChartValueVoCollection.buildFromBeanCollection(bean.getValues());
		this.minfactor = bean.getMinFactor();
		this.maxfactor = bean.getMaxFactor();
		this.minvalue = bean.getMinValue();
		this.maxvalue = bean.getMaxValue();
		this.units = bean.getUnits();
		this.refrange = bean.getRefRange();
		this.image = bean.getImage() == null ? null : bean.getImage().buildImage();
		this.color = bean.getColor() == null ? null : bean.getColor().buildColor();
		this.linetype = bean.getLineType() == null ? null : ims.core.vo.lookups.LineType.buildLookup(bean.getLineType());
		this.sortorder = bean.getSortOrder();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.ChartValueGroupVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.ChartValueGroupVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.ChartValueGroupVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("VALUES"))
			return getValues();
		if(fieldName.equals("MINFACTOR"))
			return getMinFactor();
		if(fieldName.equals("MAXFACTOR"))
			return getMaxFactor();
		if(fieldName.equals("MINVALUE"))
			return getMinValue();
		if(fieldName.equals("MAXVALUE"))
			return getMaxValue();
		if(fieldName.equals("UNITS"))
			return getUnits();
		if(fieldName.equals("REFRANGE"))
			return getRefRange();
		if(fieldName.equals("IMAGE"))
			return getImage();
		if(fieldName.equals("COLOR"))
			return getColor();
		if(fieldName.equals("LINETYPE"))
			return getLineType();
		if(fieldName.equals("SORTORDER"))
			return getSortOrder();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 255;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getValuesIsNotNull()
	{
		return this.values != null;
	}
	public ims.core.vo.ChartValueVoCollection getValues()
	{
		return this.values;
	}
	public void setValues(ims.core.vo.ChartValueVoCollection value)
	{
		this.isValidated = false;
		this.values = value;
	}
	public boolean getMinFactorIsNotNull()
	{
		return this.minfactor != null;
	}
	public Integer getMinFactor()
	{
		return this.minfactor;
	}
	public void setMinFactor(Integer value)
	{
		this.isValidated = false;
		this.minfactor = value;
	}
	public boolean getMaxFactorIsNotNull()
	{
		return this.maxfactor != null;
	}
	public Integer getMaxFactor()
	{
		return this.maxfactor;
	}
	public void setMaxFactor(Integer value)
	{
		this.isValidated = false;
		this.maxfactor = value;
	}
	public boolean getMinValueIsNotNull()
	{
		return this.minvalue != null;
	}
	public Float getMinValue()
	{
		return this.minvalue;
	}
	public void setMinValue(Float value)
	{
		this.isValidated = false;
		this.minvalue = value;
	}
	public boolean getMaxValueIsNotNull()
	{
		return this.maxvalue != null;
	}
	public Float getMaxValue()
	{
		return this.maxvalue;
	}
	public void setMaxValue(Float value)
	{
		this.isValidated = false;
		this.maxvalue = value;
	}
	public boolean getUnitsIsNotNull()
	{
		return this.units != null;
	}
	public String getUnits()
	{
		return this.units;
	}
	public static int getUnitsMaxLength()
	{
		return 255;
	}
	public void setUnits(String value)
	{
		this.isValidated = false;
		this.units = value;
	}
	public boolean getRefRangeIsNotNull()
	{
		return this.refrange != null;
	}
	public String getRefRange()
	{
		return this.refrange;
	}
	public static int getRefRangeMaxLength()
	{
		return 255;
	}
	public void setRefRange(String value)
	{
		this.isValidated = false;
		this.refrange = value;
	}
	public boolean getImageIsNotNull()
	{
		return this.image != null;
	}
	public ims.framework.utils.Image getImage()
	{
		return this.image;
	}
	public void setImage(ims.framework.utils.Image value)
	{
		this.isValidated = false;
		this.image = value;
	}
	public boolean getColorIsNotNull()
	{
		return this.color != null;
	}
	public ims.framework.utils.Color getColor()
	{
		return this.color;
	}
	public void setColor(ims.framework.utils.Color value)
	{
		this.isValidated = false;
		this.color = value;
	}
	public boolean getLineTypeIsNotNull()
	{
		return this.linetype != null;
	}
	public ims.core.vo.lookups.LineType getLineType()
	{
		return this.linetype;
	}
	public void setLineType(ims.core.vo.lookups.LineType value)
	{
		this.isValidated = false;
		this.linetype = value;
	}
	public boolean getSortOrderIsNotNull()
	{
		return this.sortorder != null;
	}
	public Integer getSortOrder()
	{
		return this.sortorder;
	}
	public void setSortOrder(Integer value)
	{
		this.isValidated = false;
		this.sortorder = value;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Chart Group: ");
		if(this.name != null)
			sb.append(this.name);
		return sb.toString();
	}
	/**
	* IChartValueGroup methods
	*/
	public ims.vo.interfaces.IChartValue[] getIChartValueGroupValues() 
	{
		if(getValues() == null)
			return null;		
		int size = getValues().size();		
		ims.vo.interfaces.IChartValue[] result = new ims.vo.interfaces.IChartValue[size];		
		for(int x = 0; x < size; x++)
		{
			result[x] = getValues().get(x);
		}		
		return result;
	}
	public String getIChartValueGroupName() 
	{		
		return getName();
	}
	public Float getIChartValueGroupMinValue()
	{
		return getMinValue();
	}
	public Float getIChartValueGroupMaxValue()
	{
		return getMaxValue();
	}
	public String getIChartValueGroupUnits()
	{
		return getUnits();
	}
	public String getIChartValueGroupRefRange()
	{
		return getRefRange();
	}
	public ims.framework.utils.Image getIChartValueGroupImage()
	{
		return getImage();
	}
	public ims.framework.utils.Color getIChartValueGroupColor()
	{
		return getColor();
	}
	public ims.core.vo.lookups.LineType getIChartValueGroupLineType()
	{
		return getLineType();
	}
	public Integer getIChartValueGroupMaxFactor() 
	{
		return getMaxFactor();
	}
	public Integer getIChartValueGroupMinFactor() 
	{
		return getMinFactor();
	}
	public Integer getIChartValueGroupSortOrder() 
	{
		return getSortOrder();
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
		if(this.values != null)
		{
			if(!this.values.isValidated())
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Chart group name is invalid");
		if(this.values != null)
		{
			String[] listOfOtherErrors = this.values.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.minfactor == null)
			listOfErrors.add("MinFactor is mandatory");
		if(this.maxfactor == null)
			listOfErrors.add("MaxFactor is mandatory");
		if(this.minvalue == null)
			listOfErrors.add("Chart group min value is invalid");
		if(this.maxvalue == null)
			listOfErrors.add("Chart group max value is invalid");
		if(this.image == null)
			listOfErrors.add("Chart group image is invalid");
		if(this.color == null)
			listOfErrors.add("Chart group color is invalid");
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
	
		ChartValueGroupVo clone = new ChartValueGroupVo(this.id, this.version);
		
		clone.name = this.name;
		if(this.values == null)
			clone.values = null;
		else
			clone.values = (ims.core.vo.ChartValueVoCollection)this.values.clone();
		clone.minfactor = this.minfactor;
		clone.maxfactor = this.maxfactor;
		clone.minvalue = this.minvalue;
		clone.maxvalue = this.maxvalue;
		clone.units = this.units;
		clone.refrange = this.refrange;
		clone.image = this.image;
		if(this.color == null)
			clone.color = null;
		else
			clone.color = (ims.framework.utils.Color)this.color.clone();
		if(this.linetype == null)
			clone.linetype = null;
		else
			clone.linetype = (ims.core.vo.lookups.LineType)this.linetype.clone();
		clone.sortorder = this.sortorder;
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
		if (!(ChartValueGroupVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ChartValueGroupVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ChartValueGroupVo compareObj = (ChartValueGroupVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getName() == null && compareObj.getName() != null)
				return -1;
			if(this.getName() != null && compareObj.getName() == null)
				return 1;
			if(this.getName() != null && compareObj.getName() != null)
			{
				if(caseInsensitive)
					retVal = this.getName().toLowerCase().compareTo(compareObj.getName().toLowerCase());
				else
					retVal = this.getName().compareTo(compareObj.getName());
			}
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
		if(this.name != null)
			count++;
		if(this.values != null)
			count++;
		if(this.minfactor != null)
			count++;
		if(this.maxfactor != null)
			count++;
		if(this.minvalue != null)
			count++;
		if(this.maxvalue != null)
			count++;
		if(this.units != null)
			count++;
		if(this.refrange != null)
			count++;
		if(this.image != null)
			count++;
		if(this.color != null)
			count++;
		if(this.linetype != null)
			count++;
		if(this.sortorder != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 12;
	}
	protected String name;
	protected ims.core.vo.ChartValueVoCollection values;
	protected Integer minfactor;
	protected Integer maxfactor;
	protected Float minvalue;
	protected Float maxvalue;
	protected String units;
	protected String refrange;
	protected ims.framework.utils.Image image;
	protected ims.framework.utils.Color color;
	protected ims.core.vo.lookups.LineType linetype;
	protected Integer sortorder;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
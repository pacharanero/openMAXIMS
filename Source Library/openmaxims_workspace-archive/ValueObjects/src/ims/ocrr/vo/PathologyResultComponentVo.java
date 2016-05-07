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

package ims.ocrr.vo;

/**
 * Linked to OCRR.OrderingResults.ResultComponent business object (ID: 1070100008).
 */
public class PathologyResultComponentVo extends ims.ocrr.orderingresults.vo.ResultComponentRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathologyResultComponentVo()
	{
	}
	public PathologyResultComponentVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathologyResultComponentVo(ims.ocrr.vo.beans.PathologyResultComponentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.formattedtext = bean.getFormattedText();
		this.resultval = bean.getResultVal();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
		this.refrange = bean.getRefRange();
		this.isabnormal = bean.getIsAbnormal();
		this.resultcomponentcomments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getResultComponentComments());
		this.resvaltype = bean.getResValType() == null ? null : ims.ocrr.vo.lookups.ResultValueType.buildLookup(bean.getResValType());
		this.analyte = bean.getAnalyte() == null ? null : bean.getAnalyte().buildVo();
		this.edsubtype = bean.getEDSubType() == null ? null : ims.ocrr.vo.lookups.ResultEDSubtype.buildLookup(bean.getEDSubType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathologyResultComponentVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.formattedtext = bean.getFormattedText();
		this.resultval = bean.getResultVal();
		this.unitofmeasure = bean.getUnitOfMeasure() == null ? null : ims.ocrr.vo.lookups.ResultUnitOfMeasure.buildLookup(bean.getUnitOfMeasure());
		this.refrange = bean.getRefRange();
		this.isabnormal = bean.getIsAbnormal();
		this.resultcomponentcomments = ims.ocrr.vo.ResultComponentCommentsVoCollection.buildFromBeanCollection(bean.getResultComponentComments());
		this.resvaltype = bean.getResValType() == null ? null : ims.ocrr.vo.lookups.ResultValueType.buildLookup(bean.getResValType());
		this.analyte = bean.getAnalyte() == null ? null : bean.getAnalyte().buildVo(map);
		this.edsubtype = bean.getEDSubType() == null ? null : ims.ocrr.vo.lookups.ResultEDSubtype.buildLookup(bean.getEDSubType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathologyResultComponentVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathologyResultComponentVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathologyResultComponentVoBean();
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
		if(fieldName.equals("FORMATTEDTEXT"))
			return getFormattedText();
		if(fieldName.equals("RESULTVAL"))
			return getResultVal();
		if(fieldName.equals("UNITOFMEASURE"))
			return getUnitOfMeasure();
		if(fieldName.equals("REFRANGE"))
			return getRefRange();
		if(fieldName.equals("ISABNORMAL"))
			return getIsAbnormal();
		if(fieldName.equals("RESULTCOMPONENTCOMMENTS"))
			return getResultComponentComments();
		if(fieldName.equals("RESVALTYPE"))
			return getResValType();
		if(fieldName.equals("ANALYTE"))
			return getAnalyte();
		if(fieldName.equals("EDSUBTYPE"))
			return getEDSubType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFormattedTextIsNotNull()
	{
		return this.formattedtext != null;
	}
	public String getFormattedText()
	{
		return this.formattedtext;
	}
	public static int getFormattedTextMaxLength()
	{
		return 4000;
	}
	public void setFormattedText(String value)
	{
		this.isValidated = false;
		this.formattedtext = value;
	}
	public boolean getResultValIsNotNull()
	{
		return this.resultval != null;
	}
	public String getResultVal()
	{
		return this.resultval;
	}
	public static int getResultValMaxLength()
	{
		return 1000;
	}
	public void setResultVal(String value)
	{
		this.isValidated = false;
		this.resultval = value;
	}
	public boolean getUnitOfMeasureIsNotNull()
	{
		return this.unitofmeasure != null;
	}
	public ims.ocrr.vo.lookups.ResultUnitOfMeasure getUnitOfMeasure()
	{
		return this.unitofmeasure;
	}
	public void setUnitOfMeasure(ims.ocrr.vo.lookups.ResultUnitOfMeasure value)
	{
		this.isValidated = false;
		this.unitofmeasure = value;
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
		return 60;
	}
	public void setRefRange(String value)
	{
		this.isValidated = false;
		this.refrange = value;
	}
	public boolean getIsAbnormalIsNotNull()
	{
		return this.isabnormal != null;
	}
	public Boolean getIsAbnormal()
	{
		return this.isabnormal;
	}
	public void setIsAbnormal(Boolean value)
	{
		this.isValidated = false;
		this.isabnormal = value;
	}
	public boolean getResultComponentCommentsIsNotNull()
	{
		return this.resultcomponentcomments != null;
	}
	public ims.ocrr.vo.ResultComponentCommentsVoCollection getResultComponentComments()
	{
		return this.resultcomponentcomments;
	}
	public void setResultComponentComments(ims.ocrr.vo.ResultComponentCommentsVoCollection value)
	{
		this.isValidated = false;
		this.resultcomponentcomments = value;
	}
	public boolean getResValTypeIsNotNull()
	{
		return this.resvaltype != null;
	}
	public ims.ocrr.vo.lookups.ResultValueType getResValType()
	{
		return this.resvaltype;
	}
	public void setResValType(ims.ocrr.vo.lookups.ResultValueType value)
	{
		this.isValidated = false;
		this.resvaltype = value;
	}
	public boolean getAnalyteIsNotNull()
	{
		return this.analyte != null;
	}
	public ims.ocrr.vo.AnalyteLiteVo getAnalyte()
	{
		return this.analyte;
	}
	public void setAnalyte(ims.ocrr.vo.AnalyteLiteVo value)
	{
		this.isValidated = false;
		this.analyte = value;
	}
	public boolean getEDSubTypeIsNotNull()
	{
		return this.edsubtype != null;
	}
	public ims.ocrr.vo.lookups.ResultEDSubtype getEDSubType()
	{
		return this.edsubtype;
	}
	public void setEDSubType(ims.ocrr.vo.lookups.ResultEDSubtype value)
	{
		this.isValidated = false;
		this.edsubtype = value;
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
		if(this.resultcomponentcomments != null)
		{
			if(!this.resultcomponentcomments.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.analyte != null)
		{
			if(!this.analyte.isValidated())
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
		if(this.resultval != null)
			if(this.resultval.length() > 1000)
				listOfErrors.add("The length of the field [resultval] in the value object [ims.ocrr.vo.PathologyResultComponentVo] is too big. It should be less or equal to 1000");
		if(this.refrange != null)
			if(this.refrange.length() > 60)
				listOfErrors.add("The length of the field [refrange] in the value object [ims.ocrr.vo.PathologyResultComponentVo] is too big. It should be less or equal to 60");
		if(this.isabnormal == null)
			listOfErrors.add("isAbnormal is mandatory");
		if(this.resultcomponentcomments != null)
		{
			String[] listOfOtherErrors = this.resultcomponentcomments.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.resvaltype == null)
			listOfErrors.add("ResValType is mandatory");
		if(this.analyte == null)
			listOfErrors.add("Analyte is mandatory");
		if(this.analyte != null)
		{
			String[] listOfOtherErrors = this.analyte.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		PathologyResultComponentVo clone = new PathologyResultComponentVo(this.id, this.version);
		
		clone.formattedtext = this.formattedtext;
		clone.resultval = this.resultval;
		if(this.unitofmeasure == null)
			clone.unitofmeasure = null;
		else
			clone.unitofmeasure = (ims.ocrr.vo.lookups.ResultUnitOfMeasure)this.unitofmeasure.clone();
		clone.refrange = this.refrange;
		clone.isabnormal = this.isabnormal;
		if(this.resultcomponentcomments == null)
			clone.resultcomponentcomments = null;
		else
			clone.resultcomponentcomments = (ims.ocrr.vo.ResultComponentCommentsVoCollection)this.resultcomponentcomments.clone();
		if(this.resvaltype == null)
			clone.resvaltype = null;
		else
			clone.resvaltype = (ims.ocrr.vo.lookups.ResultValueType)this.resvaltype.clone();
		if(this.analyte == null)
			clone.analyte = null;
		else
			clone.analyte = (ims.ocrr.vo.AnalyteLiteVo)this.analyte.clone();
		if(this.edsubtype == null)
			clone.edsubtype = null;
		else
			clone.edsubtype = (ims.ocrr.vo.lookups.ResultEDSubtype)this.edsubtype.clone();
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
		if (!(PathologyResultComponentVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathologyResultComponentVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathologyResultComponentVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathologyResultComponentVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.formattedtext != null)
			count++;
		if(this.resultval != null)
			count++;
		if(this.unitofmeasure != null)
			count++;
		if(this.refrange != null)
			count++;
		if(this.isabnormal != null)
			count++;
		if(this.resultcomponentcomments != null)
			count++;
		if(this.resvaltype != null)
			count++;
		if(this.analyte != null)
			count++;
		if(this.edsubtype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected String formattedtext;
	protected String resultval;
	protected ims.ocrr.vo.lookups.ResultUnitOfMeasure unitofmeasure;
	protected String refrange;
	protected Boolean isabnormal;
	protected ims.ocrr.vo.ResultComponentCommentsVoCollection resultcomponentcomments;
	protected ims.ocrr.vo.lookups.ResultValueType resvaltype;
	protected ims.ocrr.vo.AnalyteLiteVo analyte;
	protected ims.ocrr.vo.lookups.ResultEDSubtype edsubtype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
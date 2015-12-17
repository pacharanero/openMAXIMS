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
 * Linked to Oncology.PatAction business object (ID: 1105100038).
 */
public class PatTreatPlanActionChemotherapyDialogVo extends ims.oncology.vo.PatActionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatTreatPlanActionChemotherapyDialogVo()
	{
	}
	public PatTreatPlanActionChemotherapyDialogVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatTreatPlanActionChemotherapyDialogVo(ims.oncology.vo.beans.PatTreatPlanActionChemotherapyDialogVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		// Interface field type not supported.
		this.plannedregime = bean.getPlannedRegime() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getPlannedRegime());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.oncology.vo.beans.PatTreatPlanActionChemotherapyDialogVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		// Interface field type not supported.
		this.plannedregime = bean.getPlannedRegime() == null ? null : ims.oncology.vo.lookups.RegimenAcronym.buildLookup(bean.getPlannedRegime());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.oncology.vo.beans.PatTreatPlanActionChemotherapyDialogVoBean bean = null;
		if(map != null)
			bean = (ims.oncology.vo.beans.PatTreatPlanActionChemotherapyDialogVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.oncology.vo.beans.PatTreatPlanActionChemotherapyDialogVoBean();
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
		if(fieldName.equals("TREATINGCONSULTANT"))
			return getTreatingConsultant();
		if(fieldName.equals("PLANNEDREGIME"))
			return getPlannedRegime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTreatingConsultantIsNotNull()
	{
		return this.treatingconsultant != null;
	}
	public ims.vo.interfaces.IMos getTreatingConsultant()
	{
		return this.treatingconsultant;
	}
	public void setTreatingConsultant(ims.vo.interfaces.IMos value)
	{
		this.isValidated = false;
		this.treatingconsultant = (ims.core.vo.Hcp)value;
	}
	public boolean getPlannedRegimeIsNotNull()
	{
		return this.plannedregime != null;
	}
	public ims.oncology.vo.lookups.RegimenAcronym getPlannedRegime()
	{
		return this.plannedregime;
	}
	public void setPlannedRegime(ims.oncology.vo.lookups.RegimenAcronym value)
	{
		this.isValidated = false;
		this.plannedregime = value;
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
	
		PatTreatPlanActionChemotherapyDialogVo clone = new PatTreatPlanActionChemotherapyDialogVo(this.id, this.version);
		
		clone.treatingconsultant = this.treatingconsultant;
		if(this.plannedregime == null)
			clone.plannedregime = null;
		else
			clone.plannedregime = (ims.oncology.vo.lookups.RegimenAcronym)this.plannedregime.clone();
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
		if (!(PatTreatPlanActionChemotherapyDialogVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatTreatPlanActionChemotherapyDialogVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatTreatPlanActionChemotherapyDialogVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatTreatPlanActionChemotherapyDialogVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.treatingconsultant != null)
			count++;
		if(this.plannedregime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.core.vo.Hcp treatingconsultant;
	protected ims.oncology.vo.lookups.RegimenAcronym plannedregime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
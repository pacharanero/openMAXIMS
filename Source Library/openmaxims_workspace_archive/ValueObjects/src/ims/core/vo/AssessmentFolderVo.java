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
 * Linked to Assessment.Configuration.AssessmentFolder business object (ID: 1028100019).
 */
public class AssessmentFolderVo extends ims.assessment.configuration.vo.AssessmentFolderRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AssessmentFolderVo()
	{
	}
	public AssessmentFolderVo(Integer id, int version)
	{
		super(id, version);
	}
	public AssessmentFolderVo(ims.core.vo.beans.AssessmentFolderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.folder = bean.getFolder();
		this.userdefinedforms = ims.assessment.vo.UserDefinedObjectVoCollection.buildFromBeanCollection(bean.getUserDefinedForms());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.AssessmentFolderVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.folder = bean.getFolder();
		this.userdefinedforms = ims.assessment.vo.UserDefinedObjectVoCollection.buildFromBeanCollection(bean.getUserDefinedForms());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.AssessmentFolderVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.AssessmentFolderVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.AssessmentFolderVoBean();
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
		if(fieldName.equals("FOLDER"))
			return getFolder();
		if(fieldName.equals("USERDEFINEDFORMS"))
			return getUserDefinedForms();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getFolderIsNotNull()
	{
		return this.folder != null;
	}
	public String getFolder()
	{
		return this.folder;
	}
	public static int getFolderMaxLength()
	{
		return 255;
	}
	public void setFolder(String value)
	{
		this.isValidated = false;
		this.folder = value;
	}
	public boolean getUserDefinedFormsIsNotNull()
	{
		return this.userdefinedforms != null;
	}
	public ims.assessment.vo.UserDefinedObjectVoCollection getUserDefinedForms()
	{
		return this.userdefinedforms;
	}
	public void setUserDefinedForms(ims.assessment.vo.UserDefinedObjectVoCollection value)
	{
		this.isValidated = false;
		this.userdefinedforms = value;
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
		if(this.userdefinedforms != null)
		{
			if(!this.userdefinedforms.isValidated())
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
		if(this.folder != null)
			if(this.folder.length() > 255)
				listOfErrors.add("The length of the field [folder] in the value object [ims.core.vo.AssessmentFolderVo] is too big. It should be less or equal to 255");
		if(this.userdefinedforms != null)
		{
			String[] listOfOtherErrors = this.userdefinedforms.validate();
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
	
		AssessmentFolderVo clone = new AssessmentFolderVo(this.id, this.version);
		
		clone.folder = this.folder;
		if(this.userdefinedforms == null)
			clone.userdefinedforms = null;
		else
			clone.userdefinedforms = (ims.assessment.vo.UserDefinedObjectVoCollection)this.userdefinedforms.clone();
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
		if (!(AssessmentFolderVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AssessmentFolderVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AssessmentFolderVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AssessmentFolderVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.folder != null)
			count++;
		if(this.userdefinedforms != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String folder;
	protected ims.assessment.vo.UserDefinedObjectVoCollection userdefinedforms;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
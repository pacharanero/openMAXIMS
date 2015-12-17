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

package ims.admin.vo;

/**
 * Linked to core.configuration.AppTopButtonSection business object (ID: 1028100037).
 */
public class AppTopButtonSectionVo extends ims.core.configuration.vo.AppTopButtonSectionRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.ITopButtonSection
{
	private static final long serialVersionUID = 1L;

	public AppTopButtonSectionVo()
	{
	}
	public AppTopButtonSectionVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppTopButtonSectionVo(ims.admin.vo.beans.AppTopButtonSectionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.text = bean.getText();
		this.buttons = ims.admin.vo.AppTopButtonVoCollection.buildFromBeanCollection(bean.getButtons());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppTopButtonSectionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.text = bean.getText();
		this.buttons = ims.admin.vo.AppTopButtonVoCollection.buildFromBeanCollection(bean.getButtons());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppTopButtonSectionVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppTopButtonSectionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppTopButtonSectionVoBean();
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
		if(fieldName.equals("TEXT"))
			return getText();
		if(fieldName.equals("BUTTONS"))
			return getButtons();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTextIsNotNull()
	{
		return this.text != null;
	}
	public String getText()
	{
		return this.text;
	}
	public static int getTextMaxLength()
	{
		return 255;
	}
	public void setText(String value)
	{
		this.isValidated = false;
		this.text = value;
	}
	public boolean getButtonsIsNotNull()
	{
		return this.buttons != null;
	}
	public ims.admin.vo.AppTopButtonVoCollection getButtons()
	{
		return this.buttons;
	}
	public void setButtons(ims.admin.vo.AppTopButtonVoCollection value)
	{
		this.isValidated = false;
		this.buttons = value;
	}
	/**
	* ITopButtonSection
	*/
		public ims.framework.interfaces.ITopButton[] getITopButtonSectionButtons() 
		{
			if(buttons == null)
				return new ims.framework.interfaces.ITopButton[0];
			
			ims.framework.interfaces.ITopButton[] result = new ims.framework.interfaces.ITopButton[buttons.size()];		
			for(int x = 0; x < buttons.size(); x++)
			{
				result[x] = buttons.get(x);
			}
			
			return result;
		}
		public int getITopButtonSectionID() 
		{
			return id == null ? 0 : id.intValue();
		}
		public String getITopButtonSectionText() 
		{
			return text == null ? " " : text;
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
		if(this.buttons != null)
		{
			if(!this.buttons.isValidated())
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
		if(this.text != null)
			if(this.text.length() > 255)
				listOfErrors.add("The length of the field [text] in the value object [ims.admin.vo.AppTopButtonSectionVo] is too big. It should be less or equal to 255");
		if(this.buttons != null)
		{
			String[] listOfOtherErrors = this.buttons.validate();
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
	
		AppTopButtonSectionVo clone = new AppTopButtonSectionVo(this.id, this.version);
		
		clone.text = this.text;
		if(this.buttons == null)
			clone.buttons = null;
		else
			clone.buttons = (ims.admin.vo.AppTopButtonVoCollection)this.buttons.clone();
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
		if (!(AppTopButtonSectionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppTopButtonSectionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppTopButtonSectionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppTopButtonSectionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.text != null)
			count++;
		if(this.buttons != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected String text;
	protected ims.admin.vo.AppTopButtonVoCollection buttons;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
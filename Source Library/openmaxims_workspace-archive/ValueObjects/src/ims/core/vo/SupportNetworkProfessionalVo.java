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
 * Linked to core.clinical.SupportNetworkProfessional business object (ID: 1003100006).
 */
public class SupportNetworkProfessionalVo extends ims.core.clinical.vo.SupportNetworkProfessionalRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public SupportNetworkProfessionalVo()
	{
	}
	public SupportNetworkProfessionalVo(Integer id, int version)
	{
		super(id, version);
	}
	public SupportNetworkProfessionalVo(ims.core.vo.beans.SupportNetworkProfessionalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscurractiveprofsupp = bean.getIsCurrActiveProfSupp();
		this.isadmissionhcp = bean.getIsAdmissionHCP();
		this.hcpsubtype = bean.getHcpSubType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpSubType());
		this.currentlocation = bean.getCurrentLocation() == null ? null : bean.getCurrentLocation().buildVo();
		this.mos = bean.getMOS() == null ? null : bean.getMOS().buildVo();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.suppliedprofessional = bean.getSuppliedProfessional() == null ? null : bean.getSuppliedProfessional().buildVo();
		this.profession = bean.getProfession() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getProfession());
		this.authornginfo = bean.getAuthorngInfo() == null ? null : bean.getAuthorngInfo().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.SupportNetworkProfessionalVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.iscurractiveprofsupp = bean.getIsCurrActiveProfSupp();
		this.isadmissionhcp = bean.getIsAdmissionHCP();
		this.hcpsubtype = bean.getHcpSubType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpSubType());
		this.currentlocation = bean.getCurrentLocation() == null ? null : bean.getCurrentLocation().buildVo(map);
		this.mos = bean.getMOS() == null ? null : bean.getMOS().buildVo(map);
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.suppliedprofessional = bean.getSuppliedProfessional() == null ? null : bean.getSuppliedProfessional().buildVo(map);
		this.profession = bean.getProfession() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getProfession());
		this.authornginfo = bean.getAuthorngInfo() == null ? null : bean.getAuthorngInfo().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.SupportNetworkProfessionalVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.SupportNetworkProfessionalVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.SupportNetworkProfessionalVoBean();
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
		if(fieldName.equals("ISCURRACTIVEPROFSUPP"))
			return getIsCurrActiveProfSupp();
		if(fieldName.equals("ISADMISSIONHCP"))
			return getIsAdmissionHCP();
		if(fieldName.equals("HCPSUBTYPE"))
			return getHcpSubType();
		if(fieldName.equals("CURRENTLOCATION"))
			return getCurrentLocation();
		if(fieldName.equals("MOS"))
			return getMOS();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("SUPPLIEDPROFESSIONAL"))
			return getSuppliedProfessional();
		if(fieldName.equals("PROFESSION"))
			return getProfession();
		if(fieldName.equals("AUTHORNGINFO"))
			return getAuthorngInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsCurrActiveProfSuppIsNotNull()
	{
		return this.iscurractiveprofsupp != null;
	}
	public Boolean getIsCurrActiveProfSupp()
	{
		return this.iscurractiveprofsupp;
	}
	public void setIsCurrActiveProfSupp(Boolean value)
	{
		this.isValidated = false;
		this.iscurractiveprofsupp = value;
	}
	public boolean getIsAdmissionHCPIsNotNull()
	{
		return this.isadmissionhcp != null;
	}
	public Boolean getIsAdmissionHCP()
	{
		return this.isadmissionhcp;
	}
	public void setIsAdmissionHCP(Boolean value)
	{
		this.isValidated = false;
		this.isadmissionhcp = value;
	}
	public boolean getHcpSubTypeIsNotNull()
	{
		return this.hcpsubtype != null;
	}
	public ims.core.vo.lookups.HcpDisType getHcpSubType()
	{
		return this.hcpsubtype;
	}
	public void setHcpSubType(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.hcpsubtype = value;
	}
	public boolean getCurrentLocationIsNotNull()
	{
		return this.currentlocation != null;
	}
	public ims.core.vo.LocShortVo getCurrentLocation()
	{
		return this.currentlocation;
	}
	public void setCurrentLocation(ims.core.vo.LocShortVo value)
	{
		this.isValidated = false;
		this.currentlocation = value;
	}
	public boolean getMOSIsNotNull()
	{
		return this.mos != null;
	}
	public ims.core.vo.MemberOfStaffShortVo getMOS()
	{
		return this.mos;
	}
	public void setMOS(ims.core.vo.MemberOfStaffShortVo value)
	{
		this.isValidated = false;
		this.mos = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
	}
	public boolean getSuppliedProfessionalIsNotNull()
	{
		return this.suppliedprofessional != null;
	}
	public ims.core.vo.SuppNetworkServiceProfessionDetailVo getSuppliedProfessional()
	{
		return this.suppliedprofessional;
	}
	public void setSuppliedProfessional(ims.core.vo.SuppNetworkServiceProfessionDetailVo value)
	{
		this.isValidated = false;
		this.suppliedprofessional = value;
	}
	public boolean getProfessionIsNotNull()
	{
		return this.profession != null;
	}
	public ims.core.vo.lookups.HcpDisType getProfession()
	{
		return this.profession;
	}
	public void setProfession(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.profession = value;
	}
	public boolean getAuthorngInfoIsNotNull()
	{
		return this.authornginfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthorngInfo()
	{
		return this.authornginfo;
	}
	public void setAuthorngInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authornginfo = value;
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
		if(this.currentlocation != null)
		{
			if(!this.currentlocation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.suppliedprofessional != null)
		{
			if(!this.suppliedprofessional.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authornginfo != null)
		{
			if(!this.authornginfo.isValidated())
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
		if(this.currentlocation != null)
		{
			String[] listOfOtherErrors = this.currentlocation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.suppliedprofessional != null)
		{
			String[] listOfOtherErrors = this.suppliedprofessional.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.authornginfo == null)
			listOfErrors.add("Authoring HCP and Date/Time are mandatory");
		if(this.authornginfo != null)
		{
			String[] listOfOtherErrors = this.authornginfo.validate();
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
	
		SupportNetworkProfessionalVo clone = new SupportNetworkProfessionalVo(this.id, this.version);
		
		clone.iscurractiveprofsupp = this.iscurractiveprofsupp;
		clone.isadmissionhcp = this.isadmissionhcp;
		if(this.hcpsubtype == null)
			clone.hcpsubtype = null;
		else
			clone.hcpsubtype = (ims.core.vo.lookups.HcpDisType)this.hcpsubtype.clone();
		if(this.currentlocation == null)
			clone.currentlocation = null;
		else
			clone.currentlocation = (ims.core.vo.LocShortVo)this.currentlocation.clone();
		if(this.mos == null)
			clone.mos = null;
		else
			clone.mos = (ims.core.vo.MemberOfStaffShortVo)this.mos.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.suppliedprofessional == null)
			clone.suppliedprofessional = null;
		else
			clone.suppliedprofessional = (ims.core.vo.SuppNetworkServiceProfessionDetailVo)this.suppliedprofessional.clone();
		if(this.profession == null)
			clone.profession = null;
		else
			clone.profession = (ims.core.vo.lookups.HcpDisType)this.profession.clone();
		if(this.authornginfo == null)
			clone.authornginfo = null;
		else
			clone.authornginfo = (ims.core.vo.AuthoringInformationVo)this.authornginfo.clone();
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
		if (!(SupportNetworkProfessionalVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A SupportNetworkProfessionalVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		SupportNetworkProfessionalVo compareObj = (SupportNetworkProfessionalVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getSysInfo() == null && compareObj.getSysInfo() != null)
				return -1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() == null)
				return 1;
			if(this.getSysInfo() != null && compareObj.getSysInfo() != null)
				retVal = this.getSysInfo().compareTo(compareObj.getSysInfo());
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
		if(this.iscurractiveprofsupp != null)
			count++;
		if(this.isadmissionhcp != null)
			count++;
		if(this.hcpsubtype != null)
			count++;
		if(this.currentlocation != null)
			count++;
		if(this.mos != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.suppliedprofessional != null)
			count++;
		if(this.profession != null)
			count++;
		if(this.authornginfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected Boolean iscurractiveprofsupp;
	protected Boolean isadmissionhcp;
	protected ims.core.vo.lookups.HcpDisType hcpsubtype;
	protected ims.core.vo.LocShortVo currentlocation;
	protected ims.core.vo.MemberOfStaffShortVo mos;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.SuppNetworkServiceProfessionDetailVo suppliedprofessional;
	protected ims.core.vo.lookups.HcpDisType profession;
	protected ims.core.vo.AuthoringInformationVo authornginfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
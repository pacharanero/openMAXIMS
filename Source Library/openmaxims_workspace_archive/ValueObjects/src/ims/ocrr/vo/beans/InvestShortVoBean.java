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

package ims.ocrr.vo.beans;

public class InvestShortVoBean extends ims.vo.ValueObjectBean
{
	public InvestShortVoBean()
	{
	}
	public InvestShortVoBean(ims.ocrr.vo.InvestShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexShortVoBean)vo.getInvestigationIndex().getBean();
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.LocSvcProviderSysVoBean)vo.getProviderService().getBean();
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
		this.isaddon = vo.getIsAddon();
		this.minreorderperiodval = vo.getMinReorderPeriodVal();
		this.minreorderperiodunit = vo.getMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getMinReorderPeriodUnit().getBean();
		this.femaleminreorderperiodval = vo.getFemaleMinReorderPeriodVal();
		this.femaleminreorderperiodunit = vo.getFemaleMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getFemaleMinReorderPeriodUnit().getBean();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		if(vo.getAssocInvestigations() != null)
		{
			this.associnvestigations = new ims.vo.RefVoBean[vo.getAssocInvestigations().size()];
			for(int associnvestigations_i = 0; associnvestigations_i < vo.getAssocInvestigations().size(); associnvestigations_i++)
			{
				this.associnvestigations[associnvestigations_i] = new ims.vo.RefVoBean(vo.getAssocInvestigations().get(associnvestigations_i).getBoId(),vo.getAssocInvestigations().get(associnvestigations_i).getBoVersion());
			}
		}
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.InvestShortVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.colour = vo.getColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getColour().getBean();
		this.activestatus = vo.getActiveStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getActiveStatus().getBean();
		this.investigationindex = vo.getInvestigationIndex() == null ? null : (ims.ocrr.vo.beans.InvestigationIndexShortVoBean)vo.getInvestigationIndex().getBean(map);
		this.providerservice = vo.getProviderService() == null ? null : (ims.ocrr.vo.beans.LocSvcProviderSysVoBean)vo.getProviderService().getBean(map);
		this.helptext = vo.getHelpText() == null ? null : vo.getHelpText().getBeanCollection();
		this.isaddon = vo.getIsAddon();
		this.minreorderperiodval = vo.getMinReorderPeriodVal();
		this.minreorderperiodunit = vo.getMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getMinReorderPeriodUnit().getBean();
		this.femaleminreorderperiodval = vo.getFemaleMinReorderPeriodVal();
		this.femaleminreorderperiodunit = vo.getFemaleMinReorderPeriodUnit() == null ? null : (ims.vo.LookupInstanceBean)vo.getFemaleMinReorderPeriodUnit().getBean();
		this.turnaroundmeasure = vo.getTurnaroundMeasure() == null ? null : (ims.vo.LookupInstanceBean)vo.getTurnaroundMeasure().getBean();
		this.expectedturnaround = vo.getExpectedTurnaround();
		this.eventtype = vo.getEventType() == null ? null : (ims.vo.LookupInstanceBean)vo.getEventType().getBean();
		if(vo.getAssocInvestigations() != null)
		{
			this.associnvestigations = new ims.vo.RefVoBean[vo.getAssocInvestigations().size()];
			for(int associnvestigations_i = 0; associnvestigations_i < vo.getAssocInvestigations().size(); associnvestigations_i++)
			{
				this.associnvestigations[associnvestigations_i] = new ims.vo.RefVoBean(vo.getAssocInvestigations().get(associnvestigations_i).getBoId(),vo.getAssocInvestigations().get(associnvestigations_i).getBoVersion());
			}
		}
	}

	public ims.ocrr.vo.InvestShortVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.InvestShortVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.InvestShortVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.InvestShortVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.InvestShortVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.framework.utils.beans.ColorBean getColour()
	{
		return this.colour;
	}
	public void setColour(ims.framework.utils.beans.ColorBean value)
	{
		this.colour = value;
	}
	public ims.vo.LookupInstanceBean getActiveStatus()
	{
		return this.activestatus;
	}
	public void setActiveStatus(ims.vo.LookupInstanceBean value)
	{
		this.activestatus = value;
	}
	public ims.ocrr.vo.beans.InvestigationIndexShortVoBean getInvestigationIndex()
	{
		return this.investigationindex;
	}
	public void setInvestigationIndex(ims.ocrr.vo.beans.InvestigationIndexShortVoBean value)
	{
		this.investigationindex = value;
	}
	public ims.ocrr.vo.beans.LocSvcProviderSysVoBean getProviderService()
	{
		return this.providerservice;
	}
	public void setProviderService(ims.ocrr.vo.beans.LocSvcProviderSysVoBean value)
	{
		this.providerservice = value;
	}
	public ims.core.vo.beans.HelpTextVoBean[] getHelpText()
	{
		return this.helptext;
	}
	public void setHelpText(ims.core.vo.beans.HelpTextVoBean[] value)
	{
		this.helptext = value;
	}
	public Boolean getIsAddon()
	{
		return this.isaddon;
	}
	public void setIsAddon(Boolean value)
	{
		this.isaddon = value;
	}
	public Integer getMinReorderPeriodVal()
	{
		return this.minreorderperiodval;
	}
	public void setMinReorderPeriodVal(Integer value)
	{
		this.minreorderperiodval = value;
	}
	public ims.vo.LookupInstanceBean getMinReorderPeriodUnit()
	{
		return this.minreorderperiodunit;
	}
	public void setMinReorderPeriodUnit(ims.vo.LookupInstanceBean value)
	{
		this.minreorderperiodunit = value;
	}
	public Integer getFemaleMinReorderPeriodVal()
	{
		return this.femaleminreorderperiodval;
	}
	public void setFemaleMinReorderPeriodVal(Integer value)
	{
		this.femaleminreorderperiodval = value;
	}
	public ims.vo.LookupInstanceBean getFemaleMinReorderPeriodUnit()
	{
		return this.femaleminreorderperiodunit;
	}
	public void setFemaleMinReorderPeriodUnit(ims.vo.LookupInstanceBean value)
	{
		this.femaleminreorderperiodunit = value;
	}
	public ims.vo.LookupInstanceBean getTurnaroundMeasure()
	{
		return this.turnaroundmeasure;
	}
	public void setTurnaroundMeasure(ims.vo.LookupInstanceBean value)
	{
		this.turnaroundmeasure = value;
	}
	public Integer getExpectedTurnaround()
	{
		return this.expectedturnaround;
	}
	public void setExpectedTurnaround(Integer value)
	{
		this.expectedturnaround = value;
	}
	public ims.vo.LookupInstanceBean getEventType()
	{
		return this.eventtype;
	}
	public void setEventType(ims.vo.LookupInstanceBean value)
	{
		this.eventtype = value;
	}
	public ims.vo.RefVoBean[] getAssocInvestigations()
	{
		return this.associnvestigations;
	}
	public void setAssocInvestigations(ims.vo.RefVoBean[] value)
	{
		this.associnvestigations = value;
	}

	private Integer id;
	private int version;
	private ims.framework.utils.beans.ColorBean colour;
	private ims.vo.LookupInstanceBean activestatus;
	private ims.ocrr.vo.beans.InvestigationIndexShortVoBean investigationindex;
	private ims.ocrr.vo.beans.LocSvcProviderSysVoBean providerservice;
	private ims.core.vo.beans.HelpTextVoBean[] helptext;
	private Boolean isaddon;
	private Integer minreorderperiodval;
	private ims.vo.LookupInstanceBean minreorderperiodunit;
	private Integer femaleminreorderperiodval;
	private ims.vo.LookupInstanceBean femaleminreorderperiodunit;
	private ims.vo.LookupInstanceBean turnaroundmeasure;
	private Integer expectedturnaround;
	private ims.vo.LookupInstanceBean eventtype;
	private ims.vo.RefVoBean[] associnvestigations;
}
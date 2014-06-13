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

package ims.scheduling.vo.beans;

public class SessionActivityEventVoBean extends ims.vo.ValueObjectBean
{
	public SessionActivityEventVoBean()
	{
	}
	public SessionActivityEventVoBean(ims.scheduling.vo.SessionActivityEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activity = vo.getActivity() == null ? null : new ims.vo.RefVoBean(vo.getActivity().getBoId(), vo.getActivity().getBoVersion());
		this.appointmentstatus = vo.getAppointmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentStatus().getBean();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventLiteVoBean)vo.getEvent().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.scheduling.vo.SessionActivityEventVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.activity = vo.getActivity() == null ? null : new ims.vo.RefVoBean(vo.getActivity().getBoId(), vo.getActivity().getBoVersion());
		this.appointmentstatus = vo.getAppointmentStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getAppointmentStatus().getBean();
		this.event = vo.getEvent() == null ? null : (ims.pathways.vo.beans.EventLiteVoBean)vo.getEvent().getBean(map);
	}

	public ims.scheduling.vo.SessionActivityEventVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.scheduling.vo.SessionActivityEventVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.scheduling.vo.SessionActivityEventVo vo = null;
		if(map != null)
			vo = (ims.scheduling.vo.SessionActivityEventVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.scheduling.vo.SessionActivityEventVo();
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
	public ims.vo.RefVoBean getActivity()
	{
		return this.activity;
	}
	public void setActivity(ims.vo.RefVoBean value)
	{
		this.activity = value;
	}
	public ims.vo.LookupInstanceBean getAppointmentStatus()
	{
		return this.appointmentstatus;
	}
	public void setAppointmentStatus(ims.vo.LookupInstanceBean value)
	{
		this.appointmentstatus = value;
	}
	public ims.pathways.vo.beans.EventLiteVoBean getEvent()
	{
		return this.event;
	}
	public void setEvent(ims.pathways.vo.beans.EventLiteVoBean value)
	{
		this.event = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean activity;
	private ims.vo.LookupInstanceBean appointmentstatus;
	private ims.pathways.vo.beans.EventLiteVoBean event;
}
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

package ims.clinical.vo.beans;

public class LimbCareVoBean extends ims.vo.ValueObjectBean
{
	public LimbCareVoBean()
	{
	}
	public LimbCareVoBean(ims.clinical.vo.LimbCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hadpaddedarmsupportleft = vo.getHadPaddedArmSupportLeft();
		this.hadpaddedarmsupportright = vo.getHadPaddedArmSupportRight();
		this.hadleftarmfoldedacrosspatientschest = vo.getHadLeftArmFoldedAcrossPatientsChest();
		this.hadrightarmfoldedacrosspatientschest1 = vo.getHadRightArmFoldedAcrossPatientsChest1();
		this.hadleftlegdvtprophylaxsis = vo.getHadLeftLegDVTProphylaxsis();
		this.hadrightlegdvtprophylaxsis = vo.getHadRightLegDVTProphylaxsis();
		this.hadleftleggelpad = vo.getHadLeftLegGelPad();
		this.hadrightleggelpad = vo.getHadRightLegGelPad();
		this.hasrightarmsecuredbyside = vo.getHasRightArmSecuredBySide();
		this.hasleftarmsecuredbyside = vo.getHasLeftArmSecuredBySide();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.LimbCareVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.hadpaddedarmsupportleft = vo.getHadPaddedArmSupportLeft();
		this.hadpaddedarmsupportright = vo.getHadPaddedArmSupportRight();
		this.hadleftarmfoldedacrosspatientschest = vo.getHadLeftArmFoldedAcrossPatientsChest();
		this.hadrightarmfoldedacrosspatientschest1 = vo.getHadRightArmFoldedAcrossPatientsChest1();
		this.hadleftlegdvtprophylaxsis = vo.getHadLeftLegDVTProphylaxsis();
		this.hadrightlegdvtprophylaxsis = vo.getHadRightLegDVTProphylaxsis();
		this.hadleftleggelpad = vo.getHadLeftLegGelPad();
		this.hadrightleggelpad = vo.getHadRightLegGelPad();
		this.hasrightarmsecuredbyside = vo.getHasRightArmSecuredBySide();
		this.hasleftarmsecuredbyside = vo.getHasLeftArmSecuredBySide();
	}

	public ims.clinical.vo.LimbCareVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.LimbCareVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.LimbCareVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.LimbCareVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.LimbCareVo();
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
	public Boolean getHadPaddedArmSupportLeft()
	{
		return this.hadpaddedarmsupportleft;
	}
	public void setHadPaddedArmSupportLeft(Boolean value)
	{
		this.hadpaddedarmsupportleft = value;
	}
	public Boolean getHadPaddedArmSupportRight()
	{
		return this.hadpaddedarmsupportright;
	}
	public void setHadPaddedArmSupportRight(Boolean value)
	{
		this.hadpaddedarmsupportright = value;
	}
	public Boolean getHadLeftArmFoldedAcrossPatientsChest()
	{
		return this.hadleftarmfoldedacrosspatientschest;
	}
	public void setHadLeftArmFoldedAcrossPatientsChest(Boolean value)
	{
		this.hadleftarmfoldedacrosspatientschest = value;
	}
	public Boolean getHadRightArmFoldedAcrossPatientsChest1()
	{
		return this.hadrightarmfoldedacrosspatientschest1;
	}
	public void setHadRightArmFoldedAcrossPatientsChest1(Boolean value)
	{
		this.hadrightarmfoldedacrosspatientschest1 = value;
	}
	public Boolean getHadLeftLegDVTProphylaxsis()
	{
		return this.hadleftlegdvtprophylaxsis;
	}
	public void setHadLeftLegDVTProphylaxsis(Boolean value)
	{
		this.hadleftlegdvtprophylaxsis = value;
	}
	public Boolean getHadRightLegDVTProphylaxsis()
	{
		return this.hadrightlegdvtprophylaxsis;
	}
	public void setHadRightLegDVTProphylaxsis(Boolean value)
	{
		this.hadrightlegdvtprophylaxsis = value;
	}
	public Boolean getHadLeftLegGelPad()
	{
		return this.hadleftleggelpad;
	}
	public void setHadLeftLegGelPad(Boolean value)
	{
		this.hadleftleggelpad = value;
	}
	public Boolean getHadRightLegGelPad()
	{
		return this.hadrightleggelpad;
	}
	public void setHadRightLegGelPad(Boolean value)
	{
		this.hadrightleggelpad = value;
	}
	public Boolean getHasRightArmSecuredBySide()
	{
		return this.hasrightarmsecuredbyside;
	}
	public void setHasRightArmSecuredBySide(Boolean value)
	{
		this.hasrightarmsecuredbyside = value;
	}
	public Boolean getHasLeftArmSecuredBySide()
	{
		return this.hasleftarmsecuredbyside;
	}
	public void setHasLeftArmSecuredBySide(Boolean value)
	{
		this.hasleftarmsecuredbyside = value;
	}

	private Integer id;
	private int version;
	private Boolean hadpaddedarmsupportleft;
	private Boolean hadpaddedarmsupportright;
	private Boolean hadleftarmfoldedacrosspatientschest;
	private Boolean hadrightarmfoldedacrosspatientschest1;
	private Boolean hadleftlegdvtprophylaxsis;
	private Boolean hadrightlegdvtprophylaxsis;
	private Boolean hadleftleggelpad;
	private Boolean hadrightleggelpad;
	private Boolean hasrightarmsecuredbyside;
	private Boolean hasleftarmsecuredbyside;
}
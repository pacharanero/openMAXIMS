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

package ims.nursing.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class PainSeverity extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public PainSeverity()
	{
		super();
	}
	public PainSeverity(int id)
	{
		super(id, "", true);
	}
	public PainSeverity(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public PainSeverity(int id, String text, boolean active, PainSeverity parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public PainSeverity(int id, String text, boolean active, PainSeverity parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public PainSeverity(int id, String text, boolean active, PainSeverity parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static PainSeverity buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new PainSeverity(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (PainSeverity)super.getParentInstance();
	}
	public PainSeverity getParent()
	{
		return (PainSeverity)super.getParentInstance();
	}
	public void setParent(PainSeverity parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		PainSeverity[] typedChildren = new PainSeverity[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (PainSeverity)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof PainSeverity)
		{
			super.addChild((PainSeverity)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof PainSeverity)
		{
			super.removeChild((PainSeverity)child);
		}
		return super.getChildInstances().size();
	}
	public Image getExpandedImage()
	{
		return super.getImage();
	}
	public Image getCollapsedImage()
	{
		return super.getImage();
	}
	public static ims.framework.IItemCollection getNegativeInstancesAsIItemCollection()
	{
		PainSeverityCollection result = new PainSeverityCollection();
		result.add(NO_PAIN_AT_ALL);
		result.add(NORMAL_ACTIVITIES);
		result.add(MILD_STINGING);
		result.add(FEW_PROBLEMS);
		result.add(NOT_BAD);
		result.add(QUITE_BAD);
		result.add(CAUSES_DIFICULTIES);
		result.add(VERY_BAD);
		result.add(DISABLING);
		result.add(EXCRUITIATING);
		result.add(NO_CONTROL);
		return result;
	}
	public static PainSeverity[] getNegativeInstances()
	{
		PainSeverity[] instances = new PainSeverity[11];
		instances[0] = NO_PAIN_AT_ALL;
		instances[1] = NORMAL_ACTIVITIES;
		instances[2] = MILD_STINGING;
		instances[3] = FEW_PROBLEMS;
		instances[4] = NOT_BAD;
		instances[5] = QUITE_BAD;
		instances[6] = CAUSES_DIFICULTIES;
		instances[7] = VERY_BAD;
		instances[8] = DISABLING;
		instances[9] = EXCRUITIATING;
		instances[10] = NO_CONTROL;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[11];
		negativeInstances[0] = "NO_PAIN_AT_ALL";
		negativeInstances[1] = "NORMAL_ACTIVITIES";
		negativeInstances[2] = "MILD_STINGING";
		negativeInstances[3] = "FEW_PROBLEMS";
		negativeInstances[4] = "NOT_BAD";
		negativeInstances[5] = "QUITE_BAD";
		negativeInstances[6] = "CAUSES_DIFICULTIES";
		negativeInstances[7] = "VERY_BAD";
		negativeInstances[8] = "DISABLING";
		negativeInstances[9] = "EXCRUITIATING";
		negativeInstances[10] = "NO_CONTROL";
		return negativeInstances;
	}
	public static PainSeverity getNegativeInstance(String name)
	{
		if(name == null)
			return null;
		String[] negativeInstances = getNegativeInstanceNames();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].equals(name))
				return getNegativeInstances()[i];
		}
		return null;
	}
	public static PainSeverity getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		PainSeverity[] negativeInstances = getNegativeInstances();
		for (int i = 0; i < negativeInstances.length; i++)
		{
			if(negativeInstances[i].getID() == id)
				return negativeInstances[i];
		}
		return null;
	}
	public int getTypeId()
	{
		return TYPE_ID;
	}
	public static final int TYPE_ID = 1001023;
	public static final PainSeverity NO_PAIN_AT_ALL = new PainSeverity(-135, "0", true, null, null, Color.Black);
	public static final PainSeverity NORMAL_ACTIVITIES = new PainSeverity(-136, "1", true, null, null, Color.Black);
	public static final PainSeverity MILD_STINGING = new PainSeverity(-137, "2", true, null, null, Color.Black);
	public static final PainSeverity FEW_PROBLEMS = new PainSeverity(-138, "3", true, null, null, Color.Black);
	public static final PainSeverity NOT_BAD = new PainSeverity(-139, "4", true, null, null, Color.Black);
	public static final PainSeverity QUITE_BAD = new PainSeverity(-140, "5", true, null, null, Color.Black);
	public static final PainSeverity CAUSES_DIFICULTIES = new PainSeverity(-141, "6", true, null, null, Color.Black);
	public static final PainSeverity VERY_BAD = new PainSeverity(-142, "7", true, null, null, Color.Black);
	public static final PainSeverity DISABLING = new PainSeverity(-143, "8", true, null, null, Color.Black);
	public static final PainSeverity EXCRUITIATING = new PainSeverity(-144, "9", true, null, null, Color.Black);
	public static final PainSeverity NO_CONTROL = new PainSeverity(-145, "10", true, null, null, Color.Black);
}
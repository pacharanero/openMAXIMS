//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.scheduling.vo.lookups;

import ims.framework.cn.data.TreeNode;
import java.util.ArrayList;
import ims.framework.utils.Image;
import ims.framework.utils.Color;

public class SchProfileType extends ims.vo.LookupInstVo implements TreeNode
{
	private static final long serialVersionUID = 1L;

	public SchProfileType()
	{
		super();
	}
	public SchProfileType(int id)
	{
		super(id, "", true);
	}
	public SchProfileType(int id, String text, boolean active)
	{
		super(id, text, active, null, null, null);
	}
	public SchProfileType(int id, String text, boolean active, SchProfileType parent, Image image)
	{
		super(id, text, active, parent, image);
	}
	public SchProfileType(int id, String text, boolean active, SchProfileType parent, Image image, Color color)
	{
		super(id, text, active, parent, image, color);
	}
	public SchProfileType(int id, String text, boolean active, SchProfileType parent, Image image, Color color, int order)
	{
		super(id, text, active, parent, image, color, order);
	}
	public static SchProfileType buildLookup(ims.vo.LookupInstanceBean bean)
	{
		return new SchProfileType(bean.getId(), bean.getText(), bean.isActive());
	}
	public String toString()
	{
		if(getText() != null)
			return getText();
		return "";
	}
	public TreeNode getParentNode()
	{
		return (SchProfileType)super.getParentInstance();
	}
	public SchProfileType getParent()
	{
		return (SchProfileType)super.getParentInstance();
	}
	public void setParent(SchProfileType parent)
	{
		super.setParentInstance(parent);
	}
	public TreeNode[] getChildren()
	{
		ArrayList children = super.getChildInstances();
		SchProfileType[] typedChildren = new SchProfileType[children.size()];
		for (int i = 0; i < children.size(); i++)
		{
			typedChildren[i] = (SchProfileType)children.get(i);
		}
		return typedChildren;
	}
	public int addChild(TreeNode child)
	{
		if (child instanceof SchProfileType)
		{
			super.addChild((SchProfileType)child);
		}
		return super.getChildInstances().size();
	}
	public int removeChild(TreeNode child)
	{
		if (child instanceof SchProfileType)
		{
			super.removeChild((SchProfileType)child);
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
		SchProfileTypeCollection result = new SchProfileTypeCollection();
		result.add(OUTPATIENT);
		result.add(THEATRE);
		result.add(WARD_ATTENDANCE);
		return result;
	}
	public static SchProfileType[] getNegativeInstances()
	{
		SchProfileType[] instances = new SchProfileType[3];
		instances[0] = OUTPATIENT;
		instances[1] = THEATRE;
		instances[2] = WARD_ATTENDANCE;
		return instances;
	}
	public static String[] getNegativeInstanceNames()
	{
		String[] negativeInstances = new String[3];
		negativeInstances[0] = "OUTPATIENT";
		negativeInstances[1] = "THEATRE";
		negativeInstances[2] = "WARD_ATTENDANCE";
		return negativeInstances;
	}
	public static SchProfileType getNegativeInstance(String name)
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
	public static SchProfileType getNegativeInstance(Integer id)
	{
		if(id == null)
			return null;
		SchProfileType[] negativeInstances = getNegativeInstances();
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
	public static final int TYPE_ID = 1141030;
	public static final SchProfileType OUTPATIENT = new SchProfileType(-3038, "Outpatient", true, null, null, Color.Default);
	public static final SchProfileType THEATRE = new SchProfileType(-3039, "Theatre", true, null, null, Color.Default);
	public static final SchProfileType WARD_ATTENDANCE = new SchProfileType(-3040, "Ward Attendance", true, null, null, Color.Default);
}
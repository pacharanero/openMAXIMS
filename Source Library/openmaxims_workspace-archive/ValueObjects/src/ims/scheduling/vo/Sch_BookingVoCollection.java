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

package ims.scheduling.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import ims.framework.enumerations.SortOrder;

/**
 * Linked to Scheduling.Sch_Booking business object (ID: 1055100006).
 */
public class Sch_BookingVoCollection extends ims.vo.ValueObjectCollection implements ims.vo.ImsCloneable, Iterable<Sch_BookingVo>
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Sch_BookingVo> col = new ArrayList<Sch_BookingVo>();
	public String getBoClassName()
	{
		return "ims.scheduling.domain.objects.Sch_Booking";
	}
	public boolean add(Sch_BookingVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			return this.col.add(value);
		}
		return false;
	}
	public boolean add(int index, Sch_BookingVo value)
	{
		if(value == null)
			return false;
		if(this.col.indexOf(value) < 0)
		{
			this.col.add(index, value);
			return true;
		}
		return false;
	}
	public void clear()
	{
		this.col.clear();
	}
	public void remove(int index)
	{
		this.col.remove(index);
	}
	public int size()
	{
		return this.col.size();
	}
	public int indexOf(Sch_BookingVo instance)
	{
		return col.indexOf(instance);
	}
	public Sch_BookingVo get(int index)
	{
		return this.col.get(index);
	}
	public boolean set(int index, Sch_BookingVo value)
	{
		if(value == null)
			return false;
		this.col.set(index, value);
		return true;
	}
	public void remove(Sch_BookingVo instance)
	{
		if(instance != null)
		{
			int index = indexOf(instance);
			if(index >= 0)
				remove(index);
		}
	}
	public boolean contains(Sch_BookingVo instance)
	{
		return indexOf(instance) >= 0;
	}
	public Object clone()
	{
		Sch_BookingVoCollection clone = new Sch_BookingVoCollection();
		
		for(int x = 0; x < this.col.size(); x++)
		{
			if(this.col.get(x) != null)
				clone.col.add((Sch_BookingVo)this.col.get(x).clone());
			else
				clone.col.add(null);
		}
		
		return clone;
	}
	public boolean isValidated()
	{
		for(int x = 0; x < col.size(); x++)
			if(!this.col.get(x).isValidated())
				return false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(col.size() == 0)
			return null;
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		for(int x = 0; x < col.size(); x++)
		{
			String[] listOfOtherErrors = this.col.get(x).validate();
			if(listOfOtherErrors != null)
			{
				for(int y = 0; y < listOfOtherErrors.length; y++)
				{
					listOfErrors.add(listOfOtherErrors[y]);
				}
			}
		}
		
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
			return null;
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		return result;
	}
	public Sch_BookingVoCollection sort()
	{
		return sort(SortOrder.ASCENDING);
	}
	public Sch_BookingVoCollection sort(boolean caseInsensitive)
	{
		return sort(SortOrder.ASCENDING, caseInsensitive);
	}
	public Sch_BookingVoCollection sort(SortOrder order)
	{
		return sort(new Sch_BookingVoComparator(order));
	}
	public Sch_BookingVoCollection sort(SortOrder order, boolean caseInsensitive)
	{
		return sort(new Sch_BookingVoComparator(order, caseInsensitive));
	}
	@SuppressWarnings("unchecked")
	public Sch_BookingVoCollection sort(Comparator comparator)
	{
		Collections.sort(col, comparator);
		return this;
	}
	public ims.scheduling.vo.Sch_BookingRefVoCollection toRefVoCollection()
	{
		ims.scheduling.vo.Sch_BookingRefVoCollection result = new ims.scheduling.vo.Sch_BookingRefVoCollection();
		for(int x = 0; x < this.col.size(); x++)
		{
			result.add(this.col.get(x));
		}
		return result;
	}
	public Sch_BookingVo[] toArray()
	{
		Sch_BookingVo[] arr = new Sch_BookingVo[col.size()];
		col.toArray(arr);
		return arr;
	}
	public Iterator<Sch_BookingVo> iterator()
	{
		return col.iterator();
	}
	@Override
	protected ArrayList getTypedCollection()
	{
		return col;
	}
	private class Sch_BookingVoComparator implements Comparator
	{
		private int direction = 1;
		private boolean caseInsensitive = true;
		public Sch_BookingVoComparator()
		{
			this(SortOrder.ASCENDING);
		}
		public Sch_BookingVoComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
		}
		public Sch_BookingVoComparator(SortOrder order, boolean caseInsensitive)
		{
			if (order == SortOrder.DESCENDING)
			{
				direction = -1;
			}
			this.caseInsensitive = caseInsensitive;
		}
		public int compare(Object obj1, Object obj2)
		{
			Sch_BookingVo voObj1 = (Sch_BookingVo)obj1;
			Sch_BookingVo voObj2 = (Sch_BookingVo)obj2;
			return direction*(voObj1.compareTo(voObj2, this.caseInsensitive));
		}
		public boolean equals(Object obj)
		{
			return false;
		}
	}
	public ims.scheduling.vo.beans.Sch_BookingVoBean[] getBeanCollection()
	{
		return getBeanCollectionArray();
	}
	public ims.scheduling.vo.beans.Sch_BookingVoBean[] getBeanCollectionArray()
	{
		ims.scheduling.vo.beans.Sch_BookingVoBean[] result = new ims.scheduling.vo.beans.Sch_BookingVoBean[col.size()];
		for(int i = 0; i < col.size(); i++)
		{
			Sch_BookingVo vo = ((Sch_BookingVo)col.get(i));
			result[i] = (ims.scheduling.vo.beans.Sch_BookingVoBean)vo.getBean();
		}
		return result;
	}
	public static Sch_BookingVoCollection buildFromBeanCollection(java.util.Collection beans)
	{
		Sch_BookingVoCollection coll = new Sch_BookingVoCollection();
		if(beans == null)
			return coll;
		java.util.Iterator iter = beans.iterator();
		while (iter.hasNext())
		{
			coll.add(((ims.scheduling.vo.beans.Sch_BookingVoBean)iter.next()).buildVo());
		}
		return coll;
	}
	public static Sch_BookingVoCollection buildFromBeanCollection(ims.scheduling.vo.beans.Sch_BookingVoBean[] beans)
	{
		Sch_BookingVoCollection coll = new Sch_BookingVoCollection();
		if(beans == null)
			return coll;
		for(int x = 0; x < beans.length; x++)
		{
			coll.add(beans[x].buildVo());
		}
		return coll;
	}
}
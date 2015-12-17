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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.domain.impl;

import java.util.List;

import ims.admin.domain.base.impl.BaseDocumentCategoryToFormConfigImpl;
import ims.admin.vo.AppFormForDocumentCategoryConfigVoCollection;
import ims.admin.vo.DocumentCategoryToFormCfgVo;
import ims.admin.vo.DocumentCategoryToFormCfgVoCollection;
import ims.admin.vo.domain.AppFormForDocumentCategoryConfigVoAssembler;
import ims.admin.vo.domain.DocumentCategoryToFormCfgVoAssembler;
import ims.core.configuration.domain.objects.DocumentCategoryToFormCfg;
import ims.core.configuration.vo.DocumentCategoryToFormCfgRefVo;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.exceptions.CodingRuntimeException;

public class DocumentCategoryToFormConfigImpl extends BaseDocumentCategoryToFormConfigImpl
{
	private static final long serialVersionUID = 1L;

	public AppFormForDocumentCategoryConfigVoCollection listForms(String nameFilter, String excludedFormIds) 
	{
		DomainFactory factory = getDomainFactory();
		String hql = " select af from AppForm af where upper(af.name) like :name and af.isComponent = :isComp and af.isAlias = :isAlias " + (excludedFormIds != null ? " and af.id not in (" + excludedFormIds + ") " : "") + " order by upper(af.name) asc";
		String filter = nameFilter.trim().toUpperCase() + "%";
		return AppFormForDocumentCategoryConfigVoAssembler.createAppFormForDocumentCategoryConfigVoCollectionFromAppForm(factory.find(hql, new String[]{"name", "isComp", "isAlias"}, new Object[]{filter, Boolean.FALSE, Boolean.FALSE}));
	}

	public DocumentCategoryToFormCfgVo get(DocumentCategoryToFormCfgRefVo configId) 
	{
		if(configId == null || configId.getID_DocumentCategoryToFormCfg() == null)
			return null;
		
		DocumentCategoryToFormCfg doDocumentCategoryConfig = (DocumentCategoryToFormCfg) getDomainFactory().getDomainObject(DocumentCategoryToFormCfg.class, configId.getID_DocumentCategoryToFormCfg());
		
		return DocumentCategoryToFormCfgVoAssembler.create(doDocumentCategoryConfig);
	}

	public DocumentCategoryToFormCfgVo save(DocumentCategoryToFormCfgVo record)	throws StaleObjectException 
	{
		if(record == null)
			throw new CodingRuntimeException("Cannot save a null DocumentCategoryToFormCfgVo.");
		
		if(!record.isValidated())
			throw new CodingRuntimeException("DocumentCategoryToFormCfgVo is not validated.");
		
		DomainFactory factory = getDomainFactory();
		DocumentCategoryToFormCfg doConfig = DocumentCategoryToFormCfgVoAssembler.extractDocumentCategoryToFormCfg(factory, record);
		
		//WDEV-18905  - start
		if (!record.getID_DocumentCategoryToFormCfgIsNotNull())
		{
			StringBuilder hqlBuilder = new StringBuilder("select dc from DocumentCategoryToFormCfg as dc left join dc.appForm as af where af.id = :formID and (dc.isRIE is null  or dc.isRIE = 0) ");		
			List <?> list = factory.find(hqlBuilder.toString(),"formID", record.getAppForm().getID_AppForm());
			
			if (list != null && list.size() > 0)
				throw new StaleObjectException(doConfig);
		}
		//WDEV-18905  - end
		
		factory.save(doConfig);
		
		return DocumentCategoryToFormCfgVoAssembler.create(doConfig);
	}

	public DocumentCategoryToFormCfgVoCollection listDocumentCategoryToFormConfigs() 
	{
		DomainFactory factory = getDomainFactory();
		//WDEV-18898 - excluding RIE records from list domain call
		String hql = " select dc from DocumentCategoryToFormCfg as dc left join dc.appForm as f where dc.isRIE is null or dc.isRIE = 0 order by f.name asc ";
		
		return DocumentCategoryToFormCfgVoAssembler.createDocumentCategoryToFormCfgVoCollectionFromDocumentCategoryToFormCfg(factory.find(hql));
	}
	//WDEV-18898
	public Boolean isStale(DocumentCategoryToFormCfgRefVo documentCategoryToFormRef)
	{
		if(documentCategoryToFormRef == null)
            return false;

		DomainFactory factory = getDomainFactory();

		List<?> listOfRecords = factory.find("select dc.id from DocumentCategoryToFormCfg as dc where dc.id = :docCfgId and dc.version > :docCfgVer", new String[] {"docCfgId", "docCfgVer"}, new Object[] {documentCategoryToFormRef.getID_DocumentCategoryToFormCfg(), documentCategoryToFormRef.getVersion_DocumentCategoryToFormCfg()});

		if(listOfRecords != null && listOfRecords .size() > 0)
            return true;

		return false;
	}
}
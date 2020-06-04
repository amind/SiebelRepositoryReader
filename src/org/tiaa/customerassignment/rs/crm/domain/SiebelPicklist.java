package org.tiaa.customerassignment.rs.crm.domain;

import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelPicklist extends BaseEntity
{

	private String inactive;
	private String name;
	private String repositoryId;
	private String repositoryName;
	private String searchSpec;
	private String sortSpec;
	private String staticField;
	private String typeField;
	private String typeValue;	
	private String busComp;

	public String getBusComp() {
		return busComp;
	}

	public void setBusComp(String busComp) {
		this.busComp = busComp;
	}

	public String getInactive()
	{
		return inactive;
	}

	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	public String getRepositoryId()
	{
		return repositoryId;
	}

	public void setRepositoryId(String repositoryId)
	{
		this.repositoryId = repositoryId;
	}

	public String getRepositoryName()
	{
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}

	public String getSearchSpec()
	{
		return searchSpec;
	}

	public void setSearchSpec(String searchSpec)
	{
		this.searchSpec = searchSpec;
	}

	public String getSortSpec()
	{
		return sortSpec;
	}

	public void setSortSpec(String sortSpec)
	{
		this.sortSpec = sortSpec;
	}

	public String getStaticField()
	{
		return staticField;
	}

	public void setStaticField(String staticField)
	{
		this.staticField = staticField;
	}

	public String getTypeField()
	{
		return typeField;
	}

	public void setTypeField(String typeField)
	{
		this.typeField = typeField;
	}

	public String getTypeValue()
	{
		return typeValue;
	}

	public void setTypeValue(String typeValue)
	{
		this.typeValue = typeValue;
	}

}
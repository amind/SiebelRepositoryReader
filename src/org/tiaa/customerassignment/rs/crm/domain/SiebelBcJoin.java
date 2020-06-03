package org.tiaa.customerassignment.rs.crm.domain;

import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBcJoin extends BaseEntity
{

	private String aliasName;
	private String inactive;
	private String parentName;
	private String projectName;
	private String repositoryName;
	private String table;

	public String getAliasName()
	{
		return aliasName;
	}

	public void setAliasName(String aliasName)
	{
		this.aliasName = aliasName;
	}

	public String getInactive()
	{
		return inactive;
	}

	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getRepositoryName()
	{
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}

	public String getTable()
	{
		return table;
	}

	public void setTable(String table)
	{
		this.table = table;
	}

}
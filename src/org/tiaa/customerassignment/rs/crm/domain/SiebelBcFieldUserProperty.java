package org.tiaa.customerassignment.rs.crm.domain;

import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBcFieldUserProperty extends BaseEntity
{

	private String gparentName;
	private String name;
	private String inactive;
	private String parentName;
	private String repositoryName;
	private String value;
	private String fieldName;

	public String getGparentName()
	{
		return gparentName;
	}

	public void setGparentName(String gparentName)
	{
		this.gparentName = gparentName;
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

	public String getRepositoryName()
	{
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

}
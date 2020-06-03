package org.tiaa.customerassignment.rs.crm.domain;

import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBcFieldPickMap extends BaseEntity
{

	private String constrain;
	private String field;
	private String inactive;
	private String name;
	private String parentId;
	private String parentName;
	private String picklistField;
	private String repositoryId;
	private String repositoryName;

	public String getConstrain()
	{
		return constrain;
	}

	public void setConstrain(String constrain)
	{
		this.constrain = constrain;
	}

	public String getField()
	{
		return field;
	}

	public void setField(String field)
	{
		this.field = field;
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

	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public String getParentName()
	{
		return parentName;
	}

	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}

	public String getPicklistField()
	{
		return picklistField;
	}

	public void setPicklistField(String picklistField)
	{
		this.picklistField = picklistField;
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

}
package org.tiaa.customerassignment.rs.crm.domain;

import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBcUserProperty extends BaseEntity
{

	private String name;
	private String inactive;
	private String value;
	private String bcName;

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

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getBcName()
	{
		return bcName;
	}

	public void setBcName(String bcName)
	{
		this.bcName = bcName;
	}
}
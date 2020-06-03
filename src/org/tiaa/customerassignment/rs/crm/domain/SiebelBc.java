package org.tiaa.customerassignment.rs.crm.domain;

import java.util.Collection;
import java.util.HashMap;
import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBc extends BaseEntity
{

	private String name;
	private String repositoryName;
	private String noUpdate;
	private String noInsert;
	private String noDelete;

	protected HashMap<String, SiebelBcField> fields;//NOSONAR
	protected HashMap<String, SiebelBcJoin> joins;//NOSONAR
	protected HashMap<String, SiebelBcUserProperty> userProperties;//NOSONAR

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

	public String getRepositoryName()
	{
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName)
	{
		this.repositoryName = repositoryName;
	}

	public String getNoUpdate()
	{
		return noUpdate;
	}

	public void setNoUpdate(String noUpdate)
	{
		this.noUpdate = noUpdate;
	}

	public String getNoInsert()
	{
		return noInsert;
	}

	public void setNoInsert(String noInsert)
	{
		this.noInsert = noInsert;
	}

	public String getNoDelete()
	{
		return noDelete;
	}

	public void setNoDelete(String noDelete)
	{
		this.noDelete = noDelete;
	}

	public Collection<SiebelBcField> getFields()
	{
		return fields == null ? null : fields.values();
	}

	public Collection<SiebelBcJoin> getJoins()
	{
		return joins == null ? null : joins.values();
	}

	public Collection<SiebelBcUserProperty> getUserProperties()
	{
		return userProperties == null ? null : userProperties.values();
	}
	
	public void addField(SiebelBcField field) {
		if (fields == null) {
			fields = new HashMap<String, SiebelBcField>();		
		}
		fields.put(field.getId(), field);		
	}
	
	public void addJoin(SiebelBcJoin join) {
		if (joins == null) {
			joins = new HashMap<String, SiebelBcJoin>();		
		}
		joins.put(join.getId(), join);		
	}
	
	public void addUserProperty(SiebelBcUserProperty userProperty) {
		if (userProperties == null) {
			userProperties = new HashMap<String, SiebelBcUserProperty>();		
		}
		userProperties.put(userProperty.getId(), userProperty);		
	}	
}
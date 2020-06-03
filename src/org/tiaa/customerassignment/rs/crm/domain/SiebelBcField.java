package org.tiaa.customerassignment.rs.crm.domain;

import java.util.Collection;
import java.util.HashMap;
import com.amind.common.domain.BaseEntity;

@SuppressWarnings("serial")
public class SiebelBcField extends BaseEntity
{

	private String calculated;
	private String calculatedValue;
	private String destField;
	private String inactive;
	private String join;
	private String name;
	private String siebelName;
	private String parentId;
	private String parentName;
	private String pickList;
	private String pickListBc;
	private String pickListField;
	private String pickListValue;
	private String readOnly;
	private String repositoryId;
	private String repositoryName;
	private String required;
	private String scale;
	private String type;
	private String length;
	private String validation;
	private boolean lov = false;
	private String searchSpec;
	private String sortSpec;
	private String parentSpec;

	protected HashMap<String, SiebelBcFieldUserProperty> userProperties;//NOSONAR
	protected HashMap<String, SiebelBcFieldPickMap> pickMaps;//NOSONAR

	public String getCalculated()
	{
		return calculated;
	}

	public void setCalculated(String calculated)
	{
		this.calculated = calculated;
	}

	public String getCalculatedValue()
	{
		return calculatedValue;
	}

	public void setCalculatedValue(String calculatedValue)
	{
		this.calculatedValue = calculatedValue;
	}

	public String getDestField()
	{
		return destField;
	}

	public void setDestField(String destField)
	{
		this.destField = destField;
	}

	public String getInactive()
	{
		return inactive;
	}

	public void setInactive(String inactive)
	{
		this.inactive = inactive;
	}

	public String getJoin()
	{
		return join;
	}

	public void setJoin(String join)
	{
		this.join = join;
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

	public String getSiebelName()
	{
		return siebelName;
	}

	public void setSiebelName(String siebelName)
	{
		this.siebelName = siebelName;
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

	public String getPickList()
	{
		return pickList;
	}

	public void setPickList(String pickList)
	{
		this.pickList = pickList;
	}

	public String getPickListBc()
	{
		return pickListBc;
	}

	public void setPickListBc(String pickListBc)
	{
		this.pickListBc = pickListBc;
	}

	public String getPickListField()
	{
		return pickListField;
	}

	public void setPickListField(String pickListField)
	{
		this.pickListField = pickListField;
	}

	public String getPickListValue()
	{
		return pickListValue;
	}

	public void setPickListValue(String pickListValue)
	{
		this.pickListValue = pickListValue;
	}

	public String getReadOnly()
	{
		return readOnly;
	}

	public void setReadOnly(String readOnly)
	{
		this.readOnly = readOnly;
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

	public String getRequired()
	{
		return required;
	}

	public void setRequired(String required)
	{
		this.required = required;
	}

	public String getScale()
	{
		return scale;
	}

	public void setScale(String scale)
	{
		this.scale = scale;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getLength()
	{
		return length;
	}

	public void setLength(String length)
	{
		this.length = length;
	}

	public String getValidation()
	{
		return validation;
	}

	public void setValidation(String validation)
	{
		this.validation = validation;
	}

	public boolean isLov()
	{
		return lov;
	}

	public void setLov(boolean lov)
	{
		this.lov = lov;
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

	public String getParentSpec()
	{
		return parentSpec;
	}

	public void setParentSpec(String parentSpec)
	{
		this.parentSpec = parentSpec;
	}

	public Collection<SiebelBcFieldUserProperty> getUserProperties()
	{
		return userProperties == null ? null : userProperties.values();
	}

	public Collection<SiebelBcFieldPickMap> getPickMaps()
	{
		return pickMaps == null ? null : pickMaps.values();
	}	
	
	public void addUserProperty(SiebelBcFieldUserProperty userProperty) {
		if (userProperties == null) {
			userProperties = new HashMap<String, SiebelBcFieldUserProperty>();		
		}
		userProperties.put(userProperty.getId(), userProperty);		
	}
	
	public void addPickMap(SiebelBcFieldPickMap pickMap) {
		if (pickMaps == null) {
			pickMaps = new HashMap<String, SiebelBcFieldPickMap>();		
		}
		pickMaps.put(pickMap.getId(), pickMap);		
	}		
}
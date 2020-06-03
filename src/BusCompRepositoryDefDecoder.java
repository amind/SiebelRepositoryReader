import org.tiaa.customerassignment.rs.crm.domain.SiebelBc;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcField;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcFieldPickMap;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcFieldUserProperty;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcJoin;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcUserProperty;

public class BusCompRepositoryDefDecoder extends SiebelRepositoryDefDecoder{

	public static SiebelBc getBcDefFromRepositoryClob(String bcName, String rrComplied) {
		BusCompRepositoryDefDecoder decoder= new BusCompRepositoryDefDecoder(bcName, rrComplied);
		decoder.init(rrComplied);
		return decoder.bcDef;
	}
	
	private BusCompRepositoryDefDecoder(String bcName, String rrComplied) {
		super();
		this.bcName = bcName;
	}
	
	private String bcName;	
	private SiebelBc bcDef;

	public void init(String rrCompiled) {
		bcDef = new SiebelBc();
		try {
			processCompiledString(rrCompiled);	
			
			RepDefEntity repDef = this.getRepositoryDefinition();
			
			//set properties
			bcDef.setName(repDef.getAttributes().get(15));
			bcDef.setNoDelete(repDef.getAttributes().get(16));
			bcDef.setNoInsert(repDef.getAttributes().get(17));
			bcDef.setNoUpdate(repDef.getAttributes().get(19));
			
			//set children
			for (RepDefEntity rd : repDef.getChildren()) {
				
				if("Field".equals(rd.getType())) {
					bcDef.addField(createField(rd));	
				}
				else if ("Business Component User Prop".equals(rd.getType())) {
					bcDef.addUserProperty(createUserProperty(rd));					
				}
				else if ("Join".equals(rd.getType())) {
					bcDef.addJoin(createJoin(rd));
				}					
			}
			
		}
		catch (Exception e) {
			throw new RuntimeException ("Failed to decode RR data for Bussiness Component '" +bcName+ "'", e);
		}
	}
	
	SiebelBcField createField(RepDefEntity repDef) {
		SiebelBcField field = new SiebelBcField();
		
		//set properties
		
//		private String calculated;
//		private String calculatedValue;
//		private String destField;
//		private String inactive;
		//there are no RR records for inactive meta data
		field.setInactive("N");
//		private String join;
		field.setJoin(repDef.getAttributes().get(14));
//		private String name;
		field.setName(repDef.getAttributes().get(19));
		field.setId(field.getName());
//		private String siebelName;
		field.setSiebelName(field.getName());
//		private String parentId;
//		private String parentName;
//		private String pickList;
		field.setPickList(repDef.getAttributes().get(22));
//		private String pickListBc;
//		private String pickListField;
//		private String pickListValue;
//		private String readOnly;
		field.setReadOnly(repDef.getAttributes().get(26));
//		private String repositoryId;
//		private String repositoryName;
//		private String required;
		field.setRequired(repDef.getAttributes().get(27));
//		private String scale;
//		private String type;
		field.setType(repDef.getAttributes().get(30));
//		private String length;
		field.setLength(repDef.getAttributes().get(29));
//		private String validation;
//		private boolean lov = false;
//		private String searchSpec;
//		private String sortSpec;
//		private String parentSpec;		
		
		//set children
		for (RepDefEntity rd : repDef.getChildren()) {
			
			if("Field User Prop".equals(rd.getType())) {
				field.addUserProperty(createFieldUserProperty(rd));	
			}
			else if ("Pick Map".equals(rd.getType())) {
				field.addPickMap(createPickMap(rd));
			}				
		}		
		
		return field;
	}
	
	
	SiebelBcJoin createJoin(RepDefEntity repDef) {
		SiebelBcJoin join = new SiebelBcJoin();
		
		//set properties		
		
//		private String aliasName;
		join.setAliasName(repDef.getAttributes().get(0));
		join.setName(join.getAliasName());
		join.setId(join.getAliasName());
//		private String inactive;
		//there are no RR records for inactive meta data
		join.setInactive("N");
//		private String parentName;
//		private String projectName;
//		private String repositoryName;
//		private String table;	
		join.setTable(repDef.getAttributes().get(2));		
		
		return join;
	}
	
	SiebelBcUserProperty createUserProperty(RepDefEntity repDef) {
		SiebelBcUserProperty userProperty = new SiebelBcUserProperty();
		
		//set properties

//		private String name;
		userProperty.setName(repDef.getAttributes().get(0));
		userProperty.setId(userProperty.getName());		
//		private String inactive;
		//there are no RR records for inactive meta data
		userProperty.setInactive("N");
//		private String value;
		userProperty.setValue(repDef.getAttributes().get(1));
//		private String bcName;		
		
		return userProperty;
	}	
	
	
	SiebelBcFieldUserProperty createFieldUserProperty(RepDefEntity repDef) {
		SiebelBcFieldUserProperty userProperty = new SiebelBcFieldUserProperty();		
		
		//set properties
		
//		private String gparentName;
//		private String name;
		userProperty.setName(repDef.getAttributes().get(0));
		userProperty.setId(userProperty.getName());			
//		private String inactive;
		//there are no RR records for inactive meta data
		userProperty.setInactive("N");		
//		private String parentName;
//		private String repositoryName;
//		private String value;
		userProperty.setValue(repDef.getAttributes().get(1));		
//		private String fieldName;		
		
		return userProperty;
	}
	
	SiebelBcFieldPickMap createPickMap(RepDefEntity repDef) {
		SiebelBcFieldPickMap pickMap = new SiebelBcFieldPickMap();		
		
		//set properties
//		private String constrain;
		pickMap.setConstrain(repDef.getAttributes().get(0));
//		private String field;
		pickMap.setField(repDef.getAttributes().get(1));
//		private String inactive;
		//there are no RR records for inactive meta data
		pickMap.setInactive("N");	
//		private String name;
		pickMap.setName(repDef.getAttributes().get(2));
		pickMap.setId(pickMap.getName());		
//		private String parentId;
//		private String parentName;
//		private String picklistField;
		pickMap.setPicklistField(repDef.getAttributes().get(4));
//		private String repositoryId;
//		private String repositoryName;	
		
		return pickMap;
	}		
	
}

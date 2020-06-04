import org.tiaa.customerassignment.rs.crm.domain.SiebelPicklist;

public class PickListRepositoryDefDecoder extends SiebelRepositoryDefDecoder{

	public static SiebelPicklist getDefinitionFromRepositoryClob(String pickListName, String rrComplied) {
		PickListRepositoryDefDecoder decoder= new PickListRepositoryDefDecoder(pickListName, rrComplied);
		decoder.init(rrComplied);
		return decoder.pickListDef;
	}
	
	private PickListRepositoryDefDecoder(String pickListName, String rrComplied) {
		super();
		this.pickListName = pickListName;
	}
	
	private String pickListName;	
	private SiebelPicklist pickListDef;

	public void init(String rrCompiled) {
		pickListDef = new SiebelPicklist();
		try {
			processCompiledString(rrCompiled);	
			
			RepDefEntity repDef = this.getRepositoryDefinition();
			//set properties
			
			//there are no RR records for inactive meta data
			pickListDef.setInactive("N");
			
			pickListDef.setName(repDef.getAttributes().get(3));
			pickListDef.setBusComp(repDef.getAttributes().get(1));
			pickListDef.setSearchSpec(repDef.getAttributes().get(8));
			pickListDef.setSortSpec(repDef.getAttributes().get(9));
			pickListDef.setStaticField(repDef.getAttributes().get(10));
			pickListDef.setTypeField(repDef.getAttributes().get(11));
			pickListDef.setTypeValue(repDef.getAttributes().get(12));
		}
		catch (Exception e) {
			throw new RuntimeException ("Failed to decode RR data for Pick List '" +pickListName+ "'", e);
		}
	}
	
	
}

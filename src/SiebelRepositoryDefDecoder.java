import java.util.ArrayList;
import java.util.List;

public class SiebelRepositoryDefDecoder {
	
	RepDefEntity repositoryDefinition;
	
	//skip 5 chars from the start: @0*0*
	int currentIndex = 5;
	
	protected void processCompiledString(String rrString) {
		repositoryDefinition = recProcessCompiledString(rrString.trim());
	}
	
// Just an example a compiled Siebel repository definition followed when writing comments of the parser code
//	
//	1*1325*18*Business Component
//	3*
//	13*Activity TCSD
//	5*ATTRS
//	182*
//	0*1*N17*CSSBCFINSActivity0*1*Y1*N0*0*1*N1*N0*1*N1*Y0*1*N13*Activity TCSD1*Y1*N1*N1*N1*N0*1*N0*0*0*0*23*[Record Type] = 'Sales'0*10*Row Status0*9*S_EVT_ACT13*Non-Transient6*Action0*0*
	
	private RepDefEntity recProcessCompiledString(String rrString) {

		RepDefEntity rde = new RepDefEntity();
		
		//skip 1*
		currentIndex +=2;					
		int endIndex = rrString.indexOf('*', currentIndex);		
		String value = rrString.substring(currentIndex, endIndex);
		
		rde.setNumChildren(Integer.parseInt(value));	
		
		//1*1325*
		currentIndex = endIndex+1;	
		endIndex = rrString.indexOf('*', currentIndex);		
		value = rrString.substring(currentIndex, endIndex);
		
		//1*1325*18*
		currentIndex = endIndex+1;		
		endIndex = currentIndex + Integer.parseInt(value);
		value = rrString.substring(currentIndex, endIndex);	
		
		rde.setType(rrString.substring(currentIndex, endIndex));		
		
		//1*1325*18*Business Component3*
		currentIndex = endIndex;
		value = rrString.substring(currentIndex, currentIndex +2);
		if("3*".equals(value))
			currentIndex += 2;// skip 3*
		
		endIndex = rrString.indexOf('*', currentIndex);	
		value = rrString.substring(currentIndex, endIndex);
		
		//1*1325*18*Business Component3*13*
		currentIndex = endIndex+1;		
		endIndex = currentIndex + Integer.parseInt(value);
		value = rrString.substring(currentIndex, endIndex);	
		
		rde.setName(rrString.substring(currentIndex, endIndex));		
		
		//1*1325*18*Business Component3*13*Activity TCSD
		currentIndex = endIndex;		
		endIndex = rrString.indexOf('*', currentIndex);	
		value = rrString.substring(currentIndex, endIndex);	
		
		//1*1325*18*Business Component3*13*Activity TCSD5*
		currentIndex = endIndex+1;		
		endIndex = currentIndex + Integer.parseInt(value);
		value = rrString.substring(currentIndex, endIndex);	
		
		if (!"ATTRS".equals(value)) {
			throw new RuntimeException("Unexpected token '" + value + "', 'ATTRS' was expected for object definition: " + rde);
		}
		
		//1*1325*18*Business Component3*13*Activity TCSD5*ATTRS
		currentIndex = endIndex;		
		endIndex = rrString.indexOf('*', currentIndex);	
		value = rrString.substring(currentIndex, endIndex);	
		
		//1*1325*18*Business Component3*13*Activity TCSD5*ATTRS182*
		currentIndex = endIndex+1;		
		endIndex = currentIndex + Integer.parseInt(value);
		value = rrString.substring(currentIndex, endIndex);		
		
		//workaround for extra spaces and tabs in scripts
		//if next is not 1* something is off, do not set attributes and skip to next 1*, unless it is the end
		if((rrString.length() - endIndex) > 2 &&  !"1*".equals(rrString.substring(endIndex, endIndex+2))) {
			endIndex = rrString.indexOf("1*", endIndex);
		}
		else {
			rde.setAttributes(value);
		}
		
		currentIndex = endIndex;
		
		for (int i = 0; i < rde.getNumChildren(); i++) {
			rde.addChild(recProcessCompiledString(rrString), i);
		}
		
		return rde;		
	}
	
	
	public RepDefEntity getRepositoryDefinition() {
		return repositoryDefinition;
	}
	public void setRepositoryDefinition(RepDefEntity repositoryDefinition) {
		this.repositoryDefinition = repositoryDefinition;
	}



	protected class RepDefEntity {
		
		private String name;
		private int numChildren;
		private String type;
		private List<String> attributes = new ArrayList<String>();
		
		private RepDefEntity[] children = new RepDefEntity[0];
		
		public RepDefEntity[]  getChildren() {
			return children;
		}
		public void addChild(RepDefEntity child, int i) {
			if (children.length == 0) {
				children = new RepDefEntity[numChildren];
			}			
			children[i] = child;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNumChildren() {
			return numChildren;
		}
		public void setNumChildren(int numChildren) {
			this.numChildren = numChildren;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public List<String> getAttributes() {
			return attributes;
		}
		public void setAttributes(String rrString) {
			int currentIndex = 0;
			int endIndex = 0;
			String value;
			
			// example used in comments
			//1*N0*7*TODO_CD0*0*0*1*N1*N0*1*Y0*1*N1*Y0*0*1*Y29*User Msg with Error Code Only0*1*N4*Type1*N0*16*Activity Type TC0*0*0*1*N1*N0*2*3010*DTYPE_TEXT1*Y0*0*
			while (currentIndex < rrString.length()) {
				
				endIndex = rrString.indexOf('*', currentIndex);		
				value = rrString.substring(currentIndex, endIndex);
				
				//1*N
				//1*N0*7 - 2nd iter
				currentIndex = endIndex+1;		
				
				//1*N0
				//1*N0*7 - 2nd iter
				endIndex = currentIndex + Integer.parseInt(value);
				
				//N
				// "" - 2nd iter
				attributes.add(rrString.substring(currentIndex, endIndex));
				
				currentIndex = endIndex;
			}

		}
		
		public String toString() {
			return "Name: '" + name + "' Type: '" + type + "' Number Of Children: " + numChildren + " Attributes: " + attributes ;			
		}	
	}

}

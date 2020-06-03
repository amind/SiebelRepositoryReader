# SiebelRepositoryReader
Repository Reader for BC and Pick List definitions from 
S_RR_BUSCOMP.COMPILED_OBJ_DEFN  and  S_RR_PICKLIST.COMPILED_OBJ_DEFN 
to use the data from RR tables for TIAA 

##Changes to carry over to TIAA project

### A. Add these 3 methods to SiebelBc

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
	
### B. Add these 2 methods to SiebelBcField
	
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

### C. Add BusCompRepositoryDefDecoder, PickListRepositoryDefDecoder and SiebelRepositoryDefDecoder to your project

### D. Modify your repository definition loading code to:
1. Load compiled repository definition data from S_RR_BUSCOMP.COMPILED_OBJ_DEFN and S_RR_PICKLIST.COMPILED_OBJ_DEFN instead of no longer existing tables in prod.

Build IO and IC on top of existing BO/BC (Runtime Repository Details / Runtime Repository Buscomp and Runtime Repository Pick List) and then define DOs similar to SiebelBc and SiebelPicklist, but you only need to map 3 fields in each: Name, Repository and Complield Obj Def

2. Use BusCompRepositoryDefDecoder and PickListRepositoryDefDecoder to decode compiled definition into existing DO format like this:

SiebelBc bcDef = 
	BusCompRepositoryDefDecoder.getBcDefFromRepositoryClob("Activity TCSD", rrCompiledDef);
	
SiebelPicklist plDef =
	PickListRepositoryDefDecoder.getPickListDefFromRepositoryClob("Activity TCSD", rrCompiledDef);
	
Where rrCompiledDef is mapped to "Complield Obj Def"; 		
See RepositoryReaderRunner for an example.

## Explanation of Siebel encoding used in OMPILED_OBJ_DEFN CLOB fields

The way this serialization is done is, *N (number) followed by a N long sequence of characters to read, except certain digits mean something else as well.

0* - empty value
1* - start of a property set (it is not a true representation of the siebel property set, but similar)
3* - value tag

SQL> SELECT COMPILED_OBJ_DEFN from SIEBEL.S_RR_BUSCOMP WHERE SIEBEL.S_RR_BUSCOMP.NAME = 'Runtime Repository Buscomp';

@0*0*  - not sure what this is, but they all start with @0*0* 

1*  - new property set
5*  - number of child property sets
18*Business Component - type
3* - value tag
26*Runtime Repository Buscomp - value
5*ATTRS - properties
151* - next 151 chars are property values
 0*1*N10*CSSBusComp0*1*Y1*N0*0*1*N1*N0*1*N1*N0*1*N26*Runtime Repository Buscomp1*N1*N1*N1*N1*N0*1*N0*0*0*0*0*0*0*0*12*S_RR_BUSCOMP13*Non-Transient0*0*0*

1*  - child prop set
0*  - number of grand children
5*Field - type
3* - value tag
0* - value (*0 means empty, as in 0 number of chars after  the *)
5*ATTRS - properties
157*
 1*N0*17*COMPILED_OBJ_DEFN1*N0*0*1*N1*N0*1*N0*1*N1*N0*0*1*N29*User Msg with Error Code Only0*1*N16*Complied Obj Def1*N0*0*0*0*0*1*N1*N0*0*10*DTYPE_CLOB1*Y0*0* 

1*  - child
0* 
5*Field
3*
0*
5*ATTRS
134*
 1*N0*7*LANG_CD1*N0*0*1*N1*N0*1*N0*1*N1*N0*0*1*N29*User Msg with Error Code Only0*1*N4*Lang1*N0*0*0*0*0*1*N1*N0*1*310*DTYPE_TEXT1*Y0*0*

1*  - child
0*
5*Field
3*
0*
5*ATTRS
133*
 1*N0*4*NAME1*N0*0*1*N1*N0*1*N0*1*N1*N0*0*1*N29*User Msg with Error Code Only0*1*N4*Name1*N0*0*0*0*0*1*N1*N0*3*40010*DTYPE_TEXT1*Y0*0*

1* - child
0*
5*Field
3*
0*
5*ATTRS
149*
 1*N0*13*REPOSITORY_ID1*N0*0*1*N1*N0*1*N0*1*N1*N0*0*1*N29*User Msg with Error Code Only0*1*N13*Repository Id1*N0*0*0*0*0*1*N1*N0*2*158*DTYPE_ID1*Y0*0*

1* - child
0*
5*Field
3*
0*
5*ATTRS
143*
  1*N0*11*VERSION_NUM1*N0*0*1*N1*N0*1*N0*1*N1*N0*0*1*N29*User Msg with Error Code Only0*1*N7*Version1*N0*0*0*0*0*1*N*N0*2*2210*DTYPE_TEXT1*Y0*0*                                                   
                                                                                

SQL> spool OFF


Example of a BC field with 9 child pick map fields (from the middle of Action BC )

1*
9*
5*Field
3*
0*
5*ATTRS
190*
 1*N0*12*TARGET_OU_ID0*0*0*1*N1*N0*1*N0*1*N1*N0*0*1*Y29*User Msg with Error Code Only0*1*N10*Account Id1*N0*25*PickList Activity Account0*21*Field: 'Calc Acct Id'0*1*N1*N0*0*8*DTYPE_ID1*Y0*0*

1*
0*
8*Pick Map
3*
0*
5*ATTRS
	71*0*21*Account Currency Code21*Account Currency Code1*N13*Currency Code0*

1*0*8*Pick Map3*0*5*ATTRS37*0*10*Account Id10*Account Id1*N2*Id0*
1*0*8*Pick Map3*0*5*ATTRS55*0*16*Account Location16*Account Location1*N8*Location0*
1*0*8*Pick Map3*0*5*ATTRS43*0*12*Account Name12*Account Name1*N4*Name0*
1*0*8*Pick Map3*0*5*ATTRS69*0*15*Service Country15*Service Country1*N23*Primary Account Country0*
1*0*8*Pick Map3*0*5*ATTRS72*0*19*Service Location Id19*Service Location Id1*N18*Primary Address Id0*
1*0*8*Pick Map3*0*5*ATTRS81*0*19*Service Postal Code19*Service Postal Code1*N27*Primary Account Postal Code0*
1*0*8*Pick Map3*0*5*ATTRS63*0*13*Service State13*Service State1*N21*Primary Account State0*
1*0*8*Pick Map3*0*5*ATTRS90*0*22*Service Street Address22*Service Street Address1*N30*Primary Account Street Address0*

1*  -  next field prop set
0*
5*Field 
…


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.tiaa.customerassignment.rs.crm.domain.SiebelBc;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcField;
import org.tiaa.customerassignment.rs.crm.domain.SiebelPicklist;

public class RepositoryReaderRunner {

	public static void main(String[] args) throws IOException {
		String rrCompiledDef = readRRFile("./RR_Files/BusComp/Activity TCSD.txt");
		SiebelBc bcDef = BusCompRepositoryDefDecoder.getDefinitionFromRepositoryClob("Activity TCSD", rrCompiledDef);
		
		System.out.println("BC Def: Activity TCSD");
		for (SiebelBcField field : bcDef.getFields()) {
			System.out.print("Field: '" + field.getName());
			System.out.print("' Join: '" + field.getJoin());
			System.out.println("' Is RR: " + field.getReadOnly() + field.getRequired());
		}
		
		rrCompiledDef = readRRFile("./RR_Files/PickList/PickList Employee Dest Business Unit TC.txt");
		SiebelPicklist plDef = PickListRepositoryDefDecoder.getDefinitionFromRepositoryClob("PickList Employee Dest Business Unit TC5", rrCompiledDef);

		System.out.println("PickList Employee Dest Business Unit TC5");
		
		System.out.print("Name: '" + plDef.getName());
		System.out.print("' BusComp: '" + plDef.getBusComp());
		System.out.print("' Field: '" + plDef.getTypeField());
		System.out.print("' Value: '" + plDef.getTypeValue());
		System.out.print("' Search Spec: '" + plDef.getSearchSpec());
		System.out.println("' Sort Spec: '" + plDef.getSortSpec() +"'");
		
	}
	
	private static String readRRFile(String path) throws IOException {
		String rr = "";
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream(path);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        rr+= line;
		    }
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		} finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}	
		return rr;
	}

}

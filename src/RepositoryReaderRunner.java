import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.tiaa.customerassignment.rs.crm.domain.SiebelBc;
import org.tiaa.customerassignment.rs.crm.domain.SiebelBcField;

public class RepositoryReaderRunner {

	public static void main(String[] args) throws IOException {
		String rrCompiledDef = readRRFile("./RR_Files/BusComp/Activity TCSD.txt");
		SiebelBc bcDef = BusCompRepositoryDefDecoder.getBcDefFromRepositoryClob("Activity TCSD", rrCompiledDef);
		
		for (SiebelBcField field : bcDef.getFields()) {
			System.out.print("Field: '" + field.getName());
			System.out.println("' Is RR: " + field.getReadOnly() + field.getRequired());
		}
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

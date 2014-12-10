package labo1.alfonso.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlRepository extends RepositoryBase {
	public static String getHtmlAsString(String file) throws IOException {
	    BufferedReader reader = null;
	    StringBuilder stringBuilder;
	    
	    try {
	    	reader = new BufferedReader(new FileReader(file));
		    String line = null;
		    stringBuilder = new StringBuilder();
		    String ls = System.getProperty("line.separator");

		    while( ( line = reader.readLine() ) != null ) {
		        stringBuilder.append( line );
		        stringBuilder.append( ls );
		    }
	    } finally {
	    	//TODO: Reader null
	    	reader.close();
	    }

	    return stringBuilder.toString();
	}
}

package phoneBookMap;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter fw = new FileWriter(Properties.filepapath);
		
		fw.write("writing file");
		fw.close();

	}

}

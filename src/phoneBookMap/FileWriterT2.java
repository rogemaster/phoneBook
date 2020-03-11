package phoneBookMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterT2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter fw = new FileWriter(new File("test2.txt"));
		
		fw.write("writing file2");
		fw.close();

	}

}

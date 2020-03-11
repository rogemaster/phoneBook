package phoneBookMap;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderT2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataInputStream dis = new DataInputStream(new FileInputStream(Properties.filepapath));
		InputStreamReader isr = new InputStreamReader(dis, "utf-8");
		
		System.out.println(dis.readInt());
		
	}

}

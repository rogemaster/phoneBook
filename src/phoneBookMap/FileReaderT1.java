package phoneBookMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader(Properties.filepapath));
		
		while(true) {
			String strarr = br.readLine();
			
			if(strarr == null) break;
			String[] str = strarr.split(",");
			
			System.out.println("이름 : " + str[0]);
			System.out.println("나이 : " + str[1]);
			System.out.println("부서 : " + str[2]);
			System.out.println("전화번호 : " + str[3]);
		}
	}

}

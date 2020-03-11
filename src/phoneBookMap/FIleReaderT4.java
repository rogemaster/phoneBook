package phoneBookMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FIleReaderT4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(Properties.filepapath));
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		while(true) {
			String str = br.readLine();
			
			if(str == null) break;
			
			Employee emp = new Employee(str.split(","));
			empList.add(emp);
		}

		for(int i = 0; i < empList.size(); i++) {
			System.out.println(empList.get(i).toString());
		}
		
		
	}
}

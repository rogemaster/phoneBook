package phoneBookMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FIleReaderT3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(Properties.filepapath));
		
	//	Employee emp = new Employee(br.readLine().split(","));
		
		FIleReaderT3 t3 = new FIleReaderT3();
	//	t3.printEmp(emp);
	}
	
	public void printEmp(Employee emp) {
		System.out.println(emp.toString());
	}
}

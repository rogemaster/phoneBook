package phoneBookMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FIleReaderT5 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(Properties.filepapath));
		
		Map<String, Employee> emplist = new HashMap<String, Employee>();
		
		while(true) {
			String text = br.readLine();
			
			if(text == null) break;
			
			Employee emp = new Employee(text.split(","));
			emplist.put(emp.name, emp);
		}

		System.out.println(emplist.get("김선호"));
		System.out.println(emplist.get("이태식"));
		
		Iterator<String> keys = emplist.keySet().iterator();
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("1번 반복 = Key : %s, value : %s", key, emplist.get(key)));
			System.out.println("1번 변형 = Key : " + key + " / Value : " + emplist.get(key));
		}
		
		for(Entry<String, Employee> elem : emplist.entrySet()) {
			System.out.println(String.format("2번 반복 = Key : %s, value : %s", elem.getKey(), elem.getValue()));
			System.out.println("2-1반복 = " + elem.getKey() + " / " + elem.getValue());
		}
		
		for(String key : emplist.keySet()) {
			System.out.println(String.format("3번 반복 = Key : %s, value : %s", key, emplist.get(key)));
		}
		
		
	}
}

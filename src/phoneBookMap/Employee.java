package phoneBookMap;

public class Employee {
	
	public String name;
	public String age;
	public String department;
	public String phonenumber;
	
	public Employee(String[] emp) {
		super();
		this.name = emp[0];
		this.age = emp[1];
		this.department = emp[2];
		this.phonenumber = emp[3];
	}

	@Override
	public String toString() {
		return "[" + name + ", " + age + ", " + department + ", " + phonenumber + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
}

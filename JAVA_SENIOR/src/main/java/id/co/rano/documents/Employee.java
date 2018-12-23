package id.co.rano.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
	@Id
	protected Long employeeID;
	protected String firstName;
	protected String lastName;
	protected String title;
	protected String workPhone;
	
	public Employee(Long employeeID, String firstName,
			String lastName, String title, String workPhone) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.workPhone = workPhone;
	}

	public Employee() {
		
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName="
				+ firstName + ", lastName=" + lastName + ", title=" + title
				+ ", workPhone=" + workPhone + "]";
	}
	
	
}

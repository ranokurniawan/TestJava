package id.co.rano.entity;

import java.io.Serializable;

public class EmployeesEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1615321916842421080L;
	protected long employeeID;
	protected String firstName;
	protected String lastName;
	protected String title;
	protected String workPhone;
	
	public EmployeesEntity(long employeeID, String firstName,
			String lastName, String title, String workPhone) {
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.workPhone = workPhone;
	}

	public EmployeesEntity() {
		
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
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
	
}

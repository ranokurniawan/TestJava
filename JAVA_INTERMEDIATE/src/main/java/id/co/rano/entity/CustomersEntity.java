package id.co.rano.entity;

import java.io.Serializable;

public class CustomersEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3381767555813751597L;
	protected long customerID;
	protected String companyName;
	protected String firstName;
	protected String lastName;
	protected String billingAddress;
	protected String city;
	protected String stateOrProvince;
	protected String zipCode;
	protected String email;
	protected String companyWebsite;
	protected String phoneNumber;
	protected String faxNumber;
	protected String shipAddress;
	protected String shipCity;
	protected String shipStateOrProvince;
	protected String shipZipCode;
	protected String shipPhoneNumber;
	
	public CustomersEntity(long customerID, String companyName,
			String firstName, String lastName, String billingAddress,
			String city, String stateOrProvince, String zipCode, String email,
			String companyWebsite, String phoneNumber, String faxNumber,
			String shipAddress, String shipCity, String shipStateOrProvince,
			String shipZipCode, String shipPhoneNumber) {
		this.customerID = customerID;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.zipCode = zipCode;
		this.email = email;
		this.companyWebsite = companyWebsite;
		this.phoneNumber = phoneNumber;
		this.faxNumber = faxNumber;
		this.shipAddress = shipAddress;
		this.shipCity = shipCity;
		this.shipStateOrProvince = shipStateOrProvince;
		this.shipZipCode = shipZipCode;
		this.shipPhoneNumber = shipPhoneNumber;
	}
	
	public CustomersEntity() {
		
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipStateOrProvince() {
		return shipStateOrProvince;
	}

	public void setShipStateOrProvince(String shipStateOrProvince) {
		this.shipStateOrProvince = shipStateOrProvince;
	}

	public String getShipZipCode() {
		return shipZipCode;
	}

	public void setShipZipCode(String shipZipCode) {
		this.shipZipCode = shipZipCode;
	}

	public String getShipPhoneNumber() {
		return shipPhoneNumber;
	}

	public void setShipPhoneNumber(String shipPhoneNumber) {
		this.shipPhoneNumber = shipPhoneNumber;
	}	
	
}

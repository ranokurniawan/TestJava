package id.co.rano.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orders{
	/**
	 * 
	 */
	@Id
	protected Long orderID;
	protected Customer customer;
	protected Employee employee;
	protected String orderDate;
	protected String purchaseOrderNumber;
	protected String shipDate;
	protected ShippingMethod shippingMethod;
	protected double freightCharge;
	protected double taxes;
	protected char paymentReceived;
	protected String comment;
	public Orders(Long orderID, Customer customer, Employee employee,
			String orderDate, String purchaseOrderNumber, String shipDate,
			ShippingMethod shippingMethod, double freightCharge, double taxes,
			char paymentReceived, String comment) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.employee = employee;
		this.orderDate = orderDate;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.shipDate = shipDate;
		this.shippingMethod = shippingMethod;
		this.freightCharge = freightCharge;
		this.taxes = taxes;
		this.paymentReceived = paymentReceived;
		this.comment = comment;
	}
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public double getFreightCharge() {
		return freightCharge;
	}
	public void setFreightCharge(double freightCharge) {
		this.freightCharge = freightCharge;
	}
	public double getTaxes() {
		return taxes;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public char getPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(char paymentReceived) {
		this.paymentReceived = paymentReceived;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customer=" + customer
				+ ", employee=" + employee + ", orderDate=" + orderDate
				+ ", purchaseOrderNumber=" + purchaseOrderNumber
				+ ", shipDate=" + shipDate + ", shippingMethod="
				+ shippingMethod + ", freightCharge=" + freightCharge
				+ ", taxes=" + taxes + ", paymentReceived=" + paymentReceived
				+ ", comment=" + comment + "]";
	}
	
	
}

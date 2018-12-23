package id.co.rano.entity;

import java.io.Serializable;

public class OrdersEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3973792543490410652L;
	protected long orderID;
	protected CustomersEntity customersEntity;
	protected EmployeesEntity employeesEntity;
	protected String orderDate;
	protected String purchaseOrderNumber;
	protected String shipDate;
	protected ShippingMethodEntity shippingMethodEntity;
	protected double freightCharge;
	protected double taxes;
	protected char paymentReceived;
	protected String comment;
	
	public OrdersEntity(long orderID, CustomersEntity customersEntity,
			EmployeesEntity employeesEntity, String orderDate,
			String purchaseOrderNumber, String shipDate,
			ShippingMethodEntity shippingMethodEntity, double freightCharge,
			double taxes, char paymentReceived, String comment) {
		this.orderID = orderID;
		this.customersEntity = customersEntity;
		this.employeesEntity = employeesEntity;
		this.orderDate = orderDate;
		this.purchaseOrderNumber = purchaseOrderNumber;
		this.shipDate = shipDate;
		this.shippingMethodEntity = shippingMethodEntity;
		this.freightCharge = freightCharge;
		this.taxes = taxes;
		this.paymentReceived = paymentReceived;
		this.comment = comment;
	}

	public OrdersEntity() {
		
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public CustomersEntity getCustomersEntity() {
		return customersEntity;
	}

	public void setCustomersEntity(CustomersEntity customersEntity) {
		this.customersEntity = customersEntity;
	}

	public EmployeesEntity getEmployeesEntity() {
		return employeesEntity;
	}

	public void setEmployeesEntity(EmployeesEntity employeesEntity) {
		this.employeesEntity = employeesEntity;
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

	public ShippingMethodEntity getShippingMethodEntity() {
		return shippingMethodEntity;
	}

	public void setShippingMethodEntity(ShippingMethodEntity shippingMethodEntity) {
		this.shippingMethodEntity = shippingMethodEntity;
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

}

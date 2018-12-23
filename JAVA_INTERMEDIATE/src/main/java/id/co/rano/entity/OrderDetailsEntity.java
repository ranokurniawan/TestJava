package id.co.rano.entity;

import java.io.Serializable;

public class OrderDetailsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5526755590144275531L;
	protected long orderDetailID;
	protected OrdersEntity ordersEntity;
	protected ProductsEntity productsEntity;
	protected long quantity;
	protected double unitPrice;
	protected double discount;
	
	public OrderDetailsEntity(long orderDetailID, OrdersEntity ordersEntity,
			ProductsEntity productsEntity, long quantity, double unitPrice,
			double discount) {
		this.orderDetailID = orderDetailID;
		this.ordersEntity = ordersEntity;
		this.productsEntity = productsEntity;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	public OrderDetailsEntity() {
		
	}

	public long getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public OrdersEntity getOrdersEntity() {
		return ordersEntity;
	}

	public void setOrdersEntity(OrdersEntity ordersEntity) {
		this.ordersEntity = ordersEntity;
	}

	public ProductsEntity getProductsEntity() {
		return productsEntity;
	}

	public void setProductsEntity(ProductsEntity productsEntity) {
		this.productsEntity = productsEntity;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}

package id.co.rano.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderDetails{
	/**
	 * 
	 */
	@Id
	protected Long orderDetailID;
	protected Orders orders;
	protected Product product;
	protected long quantity;
	protected double unitPrice;
	protected double discount;
	
	public OrderDetails(Long orderDetailID, Orders orders, Product product,
			long quantity, double unitPrice, double discount) {
		this.orderDetailID = orderDetailID;
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	public Long getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(Long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Override
	public String toString() {
		return "OrderDetails [orderDetailID=" + orderDetailID + ", orders="
				+ orders + ", product=" + product + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", discount=" + discount + "]";
	}
	
	

}

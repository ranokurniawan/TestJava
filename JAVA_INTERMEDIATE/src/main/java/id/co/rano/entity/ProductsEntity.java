package id.co.rano.entity;

import java.io.Serializable;

public class ProductsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321553286500319233L;
	protected long productID;
	protected String productName;
	protected double unitPrice;
	protected char inStock;
	
	public ProductsEntity(long productID, String productName, double unitPrice,
			char inStock) {
		this.productID = productID;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}

	public ProductsEntity() {
		
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public char getInStock() {
		return inStock;
	}

	public void setInStock(char inStock) {
		this.inStock = inStock;
	}
	
}

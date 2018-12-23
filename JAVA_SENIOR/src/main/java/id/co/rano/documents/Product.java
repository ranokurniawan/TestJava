package id.co.rano.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	protected Long productID;
	protected String productName;
	protected double unitPrice;
	protected char inStock;
	
	public Product(Long productID, String productName, double unitPrice,
			char inStock) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
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

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName="
				+ productName + ", unitPrice=" + unitPrice + ", inStock="
				+ inStock + "]";
	}
	
	
}

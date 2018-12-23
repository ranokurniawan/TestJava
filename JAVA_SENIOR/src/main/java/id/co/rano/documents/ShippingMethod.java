package id.co.rano.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShippingMethod{
	/**
	 * 
	 */
	@Id
	protected Long shippingMethodID;
	protected String shippingMethod;
	
	public ShippingMethod(Long shippingMethodID, String shippingMethod) {
		this.shippingMethodID = shippingMethodID;
		this.shippingMethod = shippingMethod;
	}

	public ShippingMethod() {
		
	}

	public Long getShippingMethodID() {
		return shippingMethodID;
	}

	public void setShippingMethodID(Long shippingMethodID) {
		this.shippingMethodID = shippingMethodID;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	@Override
	public String toString() {
		return "ShippingMethod [shippingMethodID=" + shippingMethodID
				+ ", shippingMethod=" + shippingMethod + "]";
	}
	
	
}

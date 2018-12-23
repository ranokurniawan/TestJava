package id.co.rano.entity;

import java.io.Serializable;

public class ShippingMethodEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6449499861846986081L;
	protected long shippingMethodID;
	protected String shippingMethod;
	
	public ShippingMethodEntity(long shippingMethodID, String shippingMethod) {
		this.shippingMethodID = shippingMethodID;
		this.shippingMethod = shippingMethod;
	}

	public ShippingMethodEntity() {
		
	}

	public long getShippingMethodID() {
		return shippingMethodID;
	}

	public void setShippingMethodID(long shippingMethodID) {
		this.shippingMethodID = shippingMethodID;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	
}

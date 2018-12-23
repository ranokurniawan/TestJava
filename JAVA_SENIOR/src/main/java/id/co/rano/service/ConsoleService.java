package id.co.rano.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
	@Value("${csv.data.customer:unknown}")
	protected String csvDataCustomer;
	
	public String getCsvDataCustomer() {
		return getCsvDataCustomer(csvDataCustomer);
	}

	public String getCsvDataCustomer(String csvDataCustomer) {
        return csvDataCustomer;
    }
	
	@Value("${csv.data.employee:unknown}")
	protected String csvDataEmployee;
	
	public String getCsvDataEmployee() {
		return getCsvDataEmployee(csvDataEmployee);
	}

	public String getCsvDataEmployee(String csvDataEmployee) {
        return csvDataEmployee;
    }

	@Value("${csv.data.product:unknown}")
	protected String csvDataProduct;
	
	public String getCsvDataProduct() {
		return getCsvDataProduct(csvDataProduct);
	}

	public String getCsvDataProduct(String csvDataProduct) {
        return csvDataProduct;
    }

	@Value("${csv.data.shippingmethod:unknown}")
	protected String csvDataShippingmethod;
	
	public String getCsvDataShippingmethod() {
		return getCsvDataShippingmethod(csvDataShippingmethod);
	}

	public String getCsvDataShippingmethod(String csvDataShippingmethod) {
        return csvDataShippingmethod;
    }

	@Value("${csv.data.order:unknown}")
	protected String csvDataOrder;
	
	public String getCsvDataOrder() {
		return getCsvDataOrder(csvDataOrder);
	}

	public String getCsvDataOrder(String csvDataOrder) {
        return csvDataOrder;
    }

	@Value("${csv.data.orderdetail:unknown}")
	protected String csvDataOrderDetail;
	
	public String getCsvDataOrderDetail() {
		return getCsvDataOrderDetail(csvDataOrderDetail);
	}

	public String getCsvDataOrderDetail(String csvDataOrderDetail) {
        return csvDataOrderDetail;
    }

	@Value("${delimiter.data.customer:unknown}")
	protected String delimiterDataCustomer;
	
	public String getDelimiterDataCustomer() {
		return getDelimiterDataCustomer(delimiterDataCustomer);
	}

	public String getDelimiterDataCustomer(String delimiterDataCustomer) {
        return delimiterDataCustomer;
    }

	@Value("${delimiter.data.employee:unknown}")
	protected String delimiterDataEmployee;
	
	public String getDelimiterDataEmployee() {
		return getDelimiterDataEmployee(delimiterDataEmployee);
	}

	public String getDelimiterDataEmployee(String delimiterDataEmployee) {
        return delimiterDataEmployee;
    }

	@Value("${delimiter.data.product:unknown}")
	protected String delimiterDataProduct;
	
	public String getDelimiterDataProduct() {
		return getDelimiterDataProduct(delimiterDataProduct);
	}

	public String getDelimiterDataProduct(String delimiterDataProduct) {
        return delimiterDataProduct;
    }

	@Value("${delimiter.data.shippingmethod:unknown}")
	protected String delimiterDataShippingmethod;
	
	public String getDelimiterDataShippingmethod() {
		return getDelimiterDataShippingmethod(delimiterDataShippingmethod);
	}

	public String getDelimiterDataShippingmethod(String delimiterDataShippingmethod) {
        return delimiterDataShippingmethod;
    }

	@Value("${delimiter.data.order:unknown}")
	protected String delimiterDataOrder;
	
	public String getDelimiterDataOrder() {
		return getDelimiterDataOrder(delimiterDataOrder);
	}

	public String getDelimiterDataOrder(String delimiterDataOrder) {
        return delimiterDataOrder;
    }

	@Value("${delimiter.data.orderdetail:unknown}")
	protected String delimiterDataOrderDetail;
	
	public String getDelimiterDataOrderDetail() {
		return getDelimiterDataOrderDetail(delimiterDataOrderDetail);
	}

	public String getDelimiterDataOrderDetail(String delimiterDataOrderDetail) {
        return delimiterDataOrderDetail;
    }
	
	@Value("${pilih.run.app:unknown}")
	protected String pilihRunApp;
	
	public String getPilihRunApp() {
		return getPilihRunApp(pilihRunApp);
	}

	public String getPilihRunApp(String pilihRunApp) {
        return pilihRunApp;
    }
	
}

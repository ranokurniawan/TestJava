package id.co.rano.service;

import id.co.rano.entity.OrdersEntity;
import id.co.rano.manager.Utility;









import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	
	@Autowired
	private CustomersService customersService;
	
	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private ShippingMethodService shippingMethodService;
	
	public List<OrdersEntity> getListOrder(List<String> listData, String delimiter){
		List<OrdersEntity> listOrdersEntities = new ArrayList<OrdersEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			if (splitData[3].equals("")) {
				splitData[3] = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			} else {
				String[] splitDate = splitData[3].split("/");
				splitData[3] = splitDate[2].concat("-").concat(splitDate[1]).concat("-").concat(splitDate[0]);
			}
			if (splitData[5].equals("")) {
				splitData[5] = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			} else {
				String[] splitDate = splitData[5].split("/");
				splitData[5] = splitDate[2].concat("-").concat(splitDate[1]).concat("-").concat(splitDate[0]);
			}
			if (splitData[7].equals("")) {
				splitData[7] = "0";
			}
			if (splitData[8].equals("")) {
				splitData[8] = "0";
			}
			try {
				listOrdersEntities.add(new OrdersEntity(Integer.valueOf(splitData[0]), 
						customersService.getCustomer(Integer.valueOf(splitData[1])), 
						employeesService.getEmployee(Integer.valueOf(splitData[2])), 
						splitData[3], 
						splitData[4], 
						splitData[5], 
						shippingMethodService.getShippingMethod(Integer.valueOf(splitData[6])), 
						Double.parseDouble(splitData[7].replace(",", ".")), 
						Double.parseDouble(splitData[8].replace(",", ".")), 
						splitData[9].charAt(0), null));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return listOrdersEntities;
	}
	
	public void saveDataOrder(OrdersEntity ordersEntity) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("INSERT INTO orders VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, ordersEntity.getOrderID());
			preparedStatement.setLong(2, ordersEntity.getCustomersEntity().getCustomerID());
			preparedStatement.setLong(3, ordersEntity.getEmployeesEntity().getEmployeeID());
			preparedStatement.setString(4, ordersEntity.getOrderDate());
			preparedStatement.setString(5, ordersEntity.getPurchaseOrderNumber());
			preparedStatement.setString(6, ordersEntity.getShipDate());
			preparedStatement.setLong(7, ordersEntity.getShippingMethodEntity().getShippingMethodID());
			preparedStatement.setDouble(8, ordersEntity.getFreightCharge());
			preparedStatement.setDouble(9, ordersEntity.getTaxes());
			preparedStatement.setString(10, String.valueOf(ordersEntity.getPaymentReceived()));
			preparedStatement.setString(11, ordersEntity.getComment());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	public OrdersEntity getOrder(long orderID) throws SQLException{
		OrdersEntity ordersEntity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("SELECT * FROM orders WHERE OrderID = ?");
			preparedStatement.setLong(1, orderID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				ordersEntity = new OrdersEntity(resultSet.getLong(1), 
						customersService.getCustomer(resultSet.getLong(2)), 
						employeesService.getEmployee(resultSet.getLong(3)), 
						resultSet.getString(4), resultSet.getString(5), 
						resultSet.getString(6), 
						shippingMethodService.getShippingMethod(resultSet.getLong(7)), 
						resultSet.getDouble(8), resultSet.getDouble(9), resultSet.getString(10).charAt(0), 
						resultSet.getString(11));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			conn.close();
		}
		return ordersEntity;
	}
}

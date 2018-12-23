package id.co.rano.service;

import id.co.rano.entity.CustomersEntity;
import id.co.rano.manager.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomersService {

	public List<CustomersEntity> getListCustomer(List<String> listData, String delimiter){
		List<CustomersEntity> listCustomersEntities = new ArrayList<CustomersEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listCustomersEntities.add(new CustomersEntity(Integer.valueOf(splitData[0]), 
					splitData[1], splitData[2], splitData[3], splitData[4], 
					splitData[5], splitData[6], splitData[7], splitData[8], 
					splitData[9], splitData[10], splitData[11], 
					splitData[12], splitData[13], splitData[14], 
					splitData[15], splitData[16]));
		});
		return listCustomersEntities;
	}
	
	public void saveDataCustomer(CustomersEntity customersEntity) throws SQLException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn
					.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, customersEntity.getCustomerID());
			preparedStatement.setString(2, customersEntity.getCompanyName());
			preparedStatement.setString(3, customersEntity.getFirstName());
			preparedStatement.setString(4, customersEntity.getLastName());
			preparedStatement.setString(5, customersEntity.getBillingAddress());
			preparedStatement.setString(6, customersEntity.getCity());
			preparedStatement.setString(7, customersEntity.getStateOrProvince());
			preparedStatement.setString(8, customersEntity.getZipCode());
			preparedStatement.setString(9, customersEntity.getEmail());
			preparedStatement.setString(10, customersEntity.getCompanyWebsite());
			preparedStatement.setString(11, customersEntity.getPhoneNumber());
			preparedStatement.setString(12, customersEntity.getFaxNumber());
			preparedStatement.setString(13, customersEntity.getShipAddress());
			preparedStatement.setString(14, customersEntity.getShipCity());
			preparedStatement.setString(15, customersEntity.getShipStateOrProvince());
			preparedStatement.setString(16, customersEntity.getShipZipCode());
			preparedStatement.setString(17, customersEntity.getShipPhoneNumber());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	public CustomersEntity getCustomer(long customerID) throws SQLException{
		CustomersEntity customersEntity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("SELECT * FROM customers WHERE CustomerID = ?");
			preparedStatement.setLong(1, customerID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customersEntity = new CustomersEntity(resultSet.getLong(1), resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), 
						resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), 
						resultSet.getString(9), resultSet.getString(10), resultSet.getString(11), 
						resultSet.getString(12), resultSet.getString(13), resultSet.getString(14), 
						resultSet.getString(15), resultSet.getString(16), resultSet.getString(17));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			conn.close();
		}
		return customersEntity;
	}
	
}

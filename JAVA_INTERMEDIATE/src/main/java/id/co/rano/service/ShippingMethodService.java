package id.co.rano.service;

import id.co.rano.entity.ShippingMethodEntity;
import id.co.rano.manager.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService {

	public List<ShippingMethodEntity> getListShippingMehotd(List<String> listData, String delimiter){
		List<ShippingMethodEntity> listShippingMethodEntities = new ArrayList<ShippingMethodEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listShippingMethodEntities.add(new ShippingMethodEntity(Integer.valueOf(splitData[0]),
					splitData[1]));
		});
		return listShippingMethodEntities;
	}
	
	public void saveDataShippingMethod(ShippingMethodEntity shippingMethodEntity) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("INSERT INTO shipping_methods VALUES(?,?)");
			preparedStatement.setLong(1, shippingMethodEntity.getShippingMethodID());
			preparedStatement.setString(2, shippingMethodEntity.getShippingMethod());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	public ShippingMethodEntity getShippingMethod(long shippingMethodID) throws SQLException{
		ShippingMethodEntity shippingMethodEntity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("SELECT * FROM shipping_methods WHERE ShippingMethodID = ?");
			preparedStatement.setLong(1, shippingMethodID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				shippingMethodEntity = new ShippingMethodEntity(resultSet.getLong(1), 
						resultSet.getString(2));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			conn.close();
		}
		return shippingMethodEntity;
	}
}

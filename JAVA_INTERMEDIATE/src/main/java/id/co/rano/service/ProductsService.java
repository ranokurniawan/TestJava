package id.co.rano.service;

import id.co.rano.entity.ProductsEntity;
import id.co.rano.manager.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	public List<ProductsEntity> getListProduct(List<String> listData, String delimiter){
		List<ProductsEntity> listProductsEntities = new ArrayList<ProductsEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listProductsEntities.add(new ProductsEntity(Integer.valueOf(splitData[0]), splitData[1],
					Double.parseDouble(splitData[2].replace(",", ".")), splitData[3].charAt(0)));
		});
		return listProductsEntities;
	}
	
	public void saveDataProduct(ProductsEntity productsEntity) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?)");
			preparedStatement.setLong(1, productsEntity.getProductID());
			preparedStatement.setString(2, productsEntity.getProductName());
			preparedStatement.setDouble(3, productsEntity.getUnitPrice());
			preparedStatement.setString(4, String.valueOf(productsEntity.getInStock()));
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	public ProductsEntity getProduct(long productID) throws SQLException{
		ProductsEntity productsEntity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("SELECT * FROM products WHERE ProductID = ?");
			preparedStatement.setLong(1, productID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				productsEntity = new ProductsEntity(resultSet.getLong(1), 
						resultSet.getString(2), resultSet.getDouble(3), 
						resultSet.getString(4).charAt(0));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			conn.close();
		}
		return productsEntity;
	}
}

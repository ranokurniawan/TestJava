package id.co.rano.service;

import id.co.rano.entity.OrderDetailsEntity;
import id.co.rano.manager.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ProductsService productsService;

	public List<OrderDetailsEntity> getListOrderDetail(List<String> listData, String delimiter){
		List<OrderDetailsEntity> listOrderDetailsEntities = new ArrayList<OrderDetailsEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			try {
				listOrderDetailsEntities.add(new OrderDetailsEntity(Integer.valueOf(splitData[0]), 
						ordersService.getOrder(Integer.valueOf(splitData[1])), 
						productsService.getProduct(Integer.valueOf(splitData[2])), 
						Integer.valueOf(splitData[3]), Double.parseDouble(splitData[4].replace(",", ".")), 
						Double.parseDouble(splitData[5].replace("%", "").replace(",", "."))));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return listOrderDetailsEntities;
	}
	
	public void saveDataOrderDetail(OrderDetailsEntity orderDetailsEntity) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("INSERT INTO order_details VALUES(?,?,?,?,?,?)");
			preparedStatement.setLong(1, orderDetailsEntity.getOrderDetailID());
			preparedStatement.setLong(2, orderDetailsEntity.getOrdersEntity().getOrderID());
			preparedStatement.setLong(3, orderDetailsEntity.getProductsEntity().getProductID());
			preparedStatement.setLong(4, orderDetailsEntity.getQuantity());
			preparedStatement.setDouble(5, orderDetailsEntity.getUnitPrice());
			preparedStatement.setDouble(6, orderDetailsEntity.getDiscount());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
}

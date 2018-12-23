package id.co.rano.service;

import id.co.rano.entity.EmployeesEntity;
import id.co.rano.manager.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
	
	public List<EmployeesEntity> getListEmployee(List<String> listData, String delimiter){
		List<EmployeesEntity> listEmployeesEntities = new ArrayList<EmployeesEntity>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listEmployeesEntities.add(new EmployeesEntity(Integer.valueOf(splitData[0]), splitData[1],
					splitData[2], splitData[3], splitData[4]));
		});
		return listEmployeesEntities;
	}
	
	public void saveDataEmployee(EmployeesEntity employeesEntity) throws SQLException{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("INSERT INTO employees VALUES(?,?,?,?,?)");
			preparedStatement.setLong(1, employeesEntity.getEmployeeID());
			preparedStatement.setString(2, employeesEntity.getFirstName());
			preparedStatement.setString(3, employeesEntity.getLastName());
			preparedStatement.setString(4, employeesEntity.getTitle());
			preparedStatement.setString(5, employeesEntity.getWorkPhone());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}
	}
	
	public EmployeesEntity getEmployee(long employeeID) throws SQLException{
		EmployeesEntity employeesEntity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			conn = Utility.getKoneksi();
			preparedStatement = conn.prepareStatement("SELECT * FROM employees WHERE EmployeeID = ?");
			preparedStatement.setLong(1, employeeID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employeesEntity = new EmployeesEntity(resultSet.getLong(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			resultSet.close();
			preparedStatement.close();
			conn.close();
		}		
		return employeesEntity;
	}
}

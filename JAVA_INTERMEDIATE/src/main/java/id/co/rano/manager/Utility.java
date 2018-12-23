package id.co.rano.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utility {
		
	public static List<String> getListData(String fileName) {
		List<String> listData = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			String line;
			bufferedReader.readLine();
			while((line = bufferedReader.readLine()) != null) {
				if (line.contains("\"")) {
					line = line.concat(bufferedReader.readLine());
					listData.add(line.replaceAll("\"", ""));
				} else {
					listData.add(line);
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listData;
	}
	
	private static Connection conn = null;
	public static Connection getKoneksi()throws SQLException{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjava", "Student", 
					"12345678");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}

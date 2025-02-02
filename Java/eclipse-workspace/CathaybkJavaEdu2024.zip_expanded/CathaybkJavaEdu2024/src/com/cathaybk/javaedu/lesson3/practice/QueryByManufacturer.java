package com.cathaybk.javaedu.lesson3.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryByManufacturer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connUrl = "jdbc:oracle:thin:@//localhost:1521/XE";

		try (Connection conn = DriverManager.getConnection(connUrl, "student", "student123456");
				PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ?");) {
			// 設置查詢的參數值
			pstmt.setString(1, "Toyota");

			// 執行查詢並獲取結果集
			ResultSet rs = pstmt.executeQuery();

			// 創建一個 List 來存儲所有結果
			List<Map<String, Object>> resultList = new ArrayList<>();

			// 遍歷結果集
			while (rs.next()) {
				// 創建一個 Map 來存儲每一行的數據
				Map<String, Object> rowMap = new HashMap<>();
				rowMap.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				rowMap.put("TYPE", rs.getString("TYPE"));
				rowMap.put("MIN_PRICE", rs.getInt("MIN_PRICE"));
				rowMap.put("PRICE", rs.getInt("PRICE"));

				// 將 Map 添加到 List
				resultList.add(rowMap);
			}

			// 打印結果
			for (Map<String, Object> row : resultList) {
				int minPrice = (int) row.get("MIN_PRICE");
				int price = (int) row.get("PRICE");
				int priceDifference = price - minPrice;
				System.out.print("製造商: " + row.get("MANUFACTURER") + " ");
				System.out.print("型號: " + row.get("TYPE") + " ");
				System.out.print("售價: " + row.get("PRICE") + " ");
				System.out.print("底價: " + row.get("MIN_PRICE") + " ");
				System.out.println("售價高於底價" + priceDifference);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

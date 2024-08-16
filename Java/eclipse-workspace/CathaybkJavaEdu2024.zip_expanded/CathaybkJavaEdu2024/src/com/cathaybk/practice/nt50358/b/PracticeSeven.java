package com.cathaybk.practice.nt50358.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import animalprectice_extends.interface_pet;

/**
 * 練習十七
 */
public class PracticeSeven {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	private static final String SELECT_CARS_SQL = "select * from STUDENT.CARS ";// *

	private static final String QUERY_CARS_SQL = "select MANUFACTURER,TYPE,MIN_PRICE,PRICE from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";// *

	private static final String INSERT_CARS_SQL = "insert into STUDENT.CARS ( MANUFACTURER , TYPE , PRICE , MIN_PRICE) values (  ? ,? ,? ,?)";// *

	private static final String UPDATE_CARS_SQL = "UPDATE STUDENT.CARS SET PRICE = ? , MIN_PRICE =? WHERE MANUFACTURER = ? and TYPE = ?";//

	private static final String DELETE_CARS_SQL = "delete from STUDENT.CARS WHERE MANUFACTURER = ? and TYPE = ?";//

	public static void main(String[] args) {

		totalData();
		Scanner methodScanner = new Scanner(System.in);
		System.out.println("請選擇以下指令輸入：select、insert、update、delete");
		String methodChoice = methodScanner.next();
		boolean validChoice = false;
		do {
			switch (methodChoice) {
			case "select":
				queryMethod();
				validChoice = true;
				break;
			case "insert":
				insertMethod();
				validChoice = true;
				break;
			case "update":
				updateMethod();
				validChoice = true;
				break;
			case "delete":
				deleteMethod();
				validChoice = true;
				break;
			default:
				System.out.println("請選擇以下指令輸入：select、insert、update、delete");
				methodChoice = methodScanner.next();
				break;
			}
		} while (!validChoice);
	}

	private static String[] manuTypePrintMethod(Scanner queryScanner) {
		System.out.print("請輸入製造商：");
		String queryManuScan = queryScanner.next();
		System.out.print("請輸入類型：");
		String queryTypeScan = queryScanner.next();
		return new String[] { queryManuScan, queryTypeScan };
	}

	private static String[] ALLPrintMethod(Scanner queryScanner) {
		System.out.print("請輸入製造商：");
		String queryManuScan = queryScanner.next();
		System.out.print("請輸入類型：");
		String queryTypeScan = queryScanner.next();
		System.out.print("請輸入售價：");
		Double insertPriceScan = queryScanner.nextDouble();
		String insertPriceToString = Double.toString(insertPriceScan);
		System.out.print("請輸入底價：");
		Double insertMinPriceScan = queryScanner.nextDouble();
		String insertMinPriceToString = Double.toString(insertMinPriceScan);

		return new String[] { queryManuScan, queryTypeScan, insertPriceToString, insertMinPriceToString };
	}

	private static void totalData() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);) {
			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果
			List<Map<String, String>> carMapList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
				carMap.put("TYPE", rs.getString("TYPE"));
				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carMap.put("PRICE", rs.getString("PRICE"));
				carMapList.add(carMap);
			}

			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : carMapList) {
				BigDecimal price = new BigDecimal(map.get("PRICE")); // map.get("自己儲存的 KEY 值")
				BigDecimal minPrice = new BigDecimal(map.get("MIN_PRICE"));
				sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，售價：")
						.append(price.toPlainString()).append("，底價：").append(minPrice.toPlainString());
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void queryMethod() {// SELECT
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(QUERY_CARS_SQL);
				Scanner queryScanner = new Scanner(System.in);) {
			String[] querySan = manuTypePrintMethod(queryScanner);
			pstmt.setString(1, querySan[0]);
			pstmt.setString(2, querySan[1]);
			ResultSet queryResultSet = pstmt.executeQuery();
			List<Car> carList = new ArrayList<>();
			while (queryResultSet.next()) {
				Car car = new Car(queryResultSet.getString("MANUFACTURER"), queryResultSet.getString("TYPE"),
						queryResultSet.getString("MIN_PRICE"), queryResultSet.getString("PRICE"));
				carList.add(car);

			}
			if (carList.size() == 0) {
				System.out.println("查無此資料");
				return;
			}
			for (Car car : carList) {
				System.out.println(car.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertMethod() {
		try {
			Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				String[] querySan = ALLPrintMethod(queryScanner);
				pstmt.setString(1, querySan[0]);
				pstmt.setString(2, querySan[1]);
				pstmt.setString(3, querySan[2]);
				pstmt.setString(4, querySan[3]);
				pstmt.executeUpdate();
				int returnExecute = pstmt.executeUpdate();
				if (returnExecute == 0) {
					System.out.println("新增失敗");
				} else {
					System.out.println("新增成功");
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("新增失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");

		}

	}

	private static void updateMethod() {
		try {
			Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_CARS_SQL);
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				String[] querySan = ALLPrintMethod(queryScanner);
				pstmt.setString(3, querySan[0]);
				pstmt.setString(4, querySan[1]);
				pstmt.setString(1, querySan[2]);
				pstmt.setString(2, querySan[3]);

				pstmt.executeUpdate();
				int returnExecute = pstmt.executeUpdate();
				if (returnExecute == 0) {
					System.out.println("更新失敗");
				} else {
					System.out.println("更新成功");
				}
				conn.commit();

			} catch (SQLException e) {
				conn.rollback();
				System.out.println("更新失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}

	}

	private static void deleteMethod() {
		try {Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_CARS_SQL);
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				String[] querySan = manuTypePrintMethod(queryScanner);
				pstmt.setString(1, querySan[0]);
				pstmt.setString(2, querySan[1]);
				pstmt.executeUpdate();
				int returnExecute = pstmt.executeUpdate();
				if (returnExecute == 0) {
					System.out.println("刪除失敗");
				} else {
					System.out.println("刪除成功");
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("刪除失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}

	}

}
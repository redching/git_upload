package com.cathaybk.javaedu.lesson3.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Random;

import animalprectice_extends.interface_pet;

public class AdvanceInsertTransaction {
	public static void main(String[] args) {
//		String txt = "Hello Everybody";
//		System.out.println(txt.indexOf("e"));
	
	String[] cars = {"Volvo", "BMW", "Ford"};
	cars[0]= "bbbb";
	for (int i = 0; i < cars.length; i++) {
		
		System.out.println(cars[i]);
	}
	}
}

//	public static final String UPDATE_MEMBER_SQL = "update STUDENT.MEMBER set NAME = ? where ID = ? and PWD = ?";
//
//	public static final String INSERT_CARS_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?, ?, ?, ?)";
//
//	public static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
//
//	public static void main(String[] args) {
//		doInsert();
////		doQuery();
//	}
//
//	public static void doInsert() {
//		int OneCurrectNumber = 0;
//			
//			try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {// 第一筆資料
//				try {
//					Random rand = new Random();
//					int RandomFive = rand.nextInt(100000) + 1;
//					String FormattedNumber = String.format("%05d", RandomFive);
//					conn.setAutoCommit(false);
//					PreparedStatement pstmt = conn.prepareStatement(INSERT_CARS_SQL);
//					pstmt.setString(1, FormattedNumber);
//					pstmt.setString(2, FormattedNumber + 1);
//					pstmt.setInt(3, rand.nextInt(1000) + 1);
//					pstmt.setInt(4, rand.nextInt(1000) + 1);
//					pstmt.executeUpdate();
//					OneCurrectNumber += 1;
//					pstmt.setString(1, FormattedNumber);
//					pstmt.setString(2, FormattedNumber + 2);
//					pstmt.setInt(3, rand.nextInt(1000) + 1);
//					pstmt.setInt(4, rand.nextInt(1000) + 1);
//					pstmt.executeUpdate();
//					OneCurrectNumber += 1;
////					System.out.println(OneCurrectNumber);
////					TotalNumber = OneCurrectNumber + TwoCurrectNumber;
//					if (OneCurrectNumber==2) {
//						conn.commit();
////						ResultSet rs = pstmt.executeQuery();
////						System.out.println(getString("MANUFACTURER"));
//					System.out.println("新增成功");
//					PreparedStatement pstmt1 = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?");
//					ResultSet rs = pstmt1.executeQuery();
//					pstmt1.setString(1, rs.getString("MANUFACTURER"));
//					pstmt1.setString(2, "DEFG");
//
//					// ResultSet物件儲存查詢結果
////					ResultSet rs = pstmt1.executeQuery();
//
//					// 使用StringBuilder做字串串接
//					StringBuilder sb = new StringBuilder();
//					sb.append("查詢結果： ");
//					while (rs.next()) {
//						sb.append("製造商： ").append(rs.getString("MANUFACTURER")).append("，型號：").append(rs.getString("TYPE"))
//								.append("，售價：").append(rs.getString("PRICE")).append("，底價：").append(rs.getString("MIN_PRICE"));
//					}
//					System.out.println(sb.toString());
//					}else {
//						conn.rollback();
//					}
//				} catch (Exception e) {
//
//					try {
//						OneCurrectNumber = 0;
//						conn.rollback();
//					} catch (SQLException sqle) {
////                    sqle.printStackTrace();
//						System.out.println("rollback 失敗，原因：" + sqle.getMessage());
//					}
//				}
//			} catch (SQLException sqle) {
//				sqle.printStackTrace();
//			}
//			
//		
//	}
//
//	private static char[] getString(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	public static void doQuery() {
////
////		try (Connection conn = DriverManager.getConnection(CONN_URL, "student", "student123456");) {
////
////			PreparedStatement pstmt = conn.prepareStatement("select * from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?");
////			pstmt.setString(1, "ABCD");
////			pstmt.setString(2, "DEFG");
////
////			// ResultSet物件儲存查詢結果
////			ResultSet rs = pstmt.executeQuery();
////
////			// 使用StringBuilder做字串串接
////			StringBuilder sb = new StringBuilder();
////			sb.append("查詢結果： ");
////			while (rs.next()) {
////				sb.append("製造商： ").append(rs.getString("MANUFACTURER")).append("，型號：").append(rs.getString("TYPE"))
////						.append("，售價：").append(rs.getString("PRICE")).append("，底價：").append(rs.getString("MIN_PRICE"));
////			}
////			System.out.println(sb.toString());
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
//
//}
		
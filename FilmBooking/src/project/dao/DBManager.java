package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/film_booking?verifyServerCertificate=false&useSSL=true","root","1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt, PreparedStatement pstmt2) {
		try {
			pstmt2.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn,PreparedStatement pstmt,PreparedStatement pstmt2, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			pstmt2.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}public static void close(Connection conn,PreparedStatement pstmt,PreparedStatement pstmt2,PreparedStatement pstmt3, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			pstmt2.close();
			pstmt3.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, ResultSet rs) {
		try {
			rs.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

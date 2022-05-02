package com.genpact.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Service {
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static Connection con = null;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/genpact", "root", "income@tax1998");

			if (con != null) {
				System.out.println("Connected...");
			} else {
				System.out.println("Not Connected...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

	}

	public static String registerUser(String username, String password) {
		String message = "";
		try {
			pstmt = con.prepareStatement("select * from userregister where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			boolean found = rs.next();
			if (found) {
				// System.out.println("EXISTED...");
				message = "EXISTED";
			} else {
				pstmt = con.prepareStatement("insert into userregister values (?,?)");
				pstmt.setString(1, username);
				pstmt.setString(2, password);

				int executeUpdate = pstmt.executeUpdate();
				if (executeUpdate > 0) {
					// System.out.println("REGISTER...");
					message = "REGISTERED";
				} else {
					// System.out.println("ERROR...");
					message = "ERROR";
				}
			}

		} catch (Exception e) {
			// System.out.println("ERROR...");
			message = "ERROR";
			e.printStackTrace();
			// TODO: handle exception
		}
		return message;
	}

	public static String loginUser(String username, String password) {
		String message = "";
		try {
			pstmt = con.prepareStatement("select * from userregister where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			boolean found = rs.next();

			if (found) {
				System.out.println("EXISTED...");
				message = "EXISTED";
			} else {
				System.out.println("NOT EXISTED");
				message = "NOT EXISTED";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

}

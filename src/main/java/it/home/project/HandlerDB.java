package it.home.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class HandlerDB {
	
	private final static Logger log = Logger.getLogger(HandlerDB.class);

	public void viewTable() throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost/walletdb?useSSL=false";

		Statement statement = null; // interface that represent a SQL statement
		String query = "SELECT * FROM walletdb.wallet_profile";
		try (Connection con = DriverManager.getConnection(db_url, "root", "toor")) {
			Class.forName(driver);
			statement = con.createStatement();
			try (ResultSet rs = statement.executeQuery(query)) {
				while (rs.next()) {
					String profileName = rs.getString("profile_name");
					String profileSurname = rs.getString("profile_surname");
					System.out.println(profileName + "\t" + profileSurname);
				}
			}

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		} finally {
			if (statement != null)
				statement.close();
		}
	}

	/**
	 * its only a tools class, used to retrieve the correct id and increment it in
	 * the query.
	 * 
	 * @return int
	 * @throws SQLException
	 */
	public int getLastId() throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost/walletdb?useSSL=false";
		int newestId = 0;
		Statement statement = null; // interface that represent a SQL statement
		String query = "SELECT profile_id FROM walletdb.wallet_profile";
		try (Connection con = DriverManager.getConnection(db_url, "root", "toor")) {
			Class.forName(driver);
			statement = con.createStatement();
			try (ResultSet rs = statement.executeQuery(query)) {
				while (rs.next()) {
					newestId = rs.getInt("profile_id");
				}
			}

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		} finally {
			if (statement != null)
				statement.close();
		}
		return newestId + 1;
	}

	public void insertMethod(String dbName, String dbSurname) throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost/walletdb?useSSL=false";
		PreparedStatement insertUser = null;
		if (dbName != null && dbSurname != null) {

			try (Connection con = DriverManager.getConnection(db_url, "root", "toor")) {

				Class.forName(driver);
				insertUser = con.prepareStatement(
						"INSERT INTO wallet_profile (profile_id, profile_name, profile_surname) VALUES" + "(?,?,?)");
				// this prevent SQL injection
				insertUser.setInt(1, getLastId());
				insertUser.setString(2, dbName);
				insertUser.setString(3, dbSurname);
				insertUser.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				log.error(e.getMessage());
			} finally {
				if (insertUser != null)
					insertUser.close();
			}
		} else
			System.err.println("The input values are null");
	}
	
}

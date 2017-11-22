package it.home.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class LoginHandler {

	private static final Logger log_ = Logger.getLogger(LoginHandler.class.getName());
	private static Scanner in = new Scanner(System.in);

	public static boolean login() throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost/walletdb?useSSL=false";

		ArrayList<String> usernameList = new ArrayList<>();
		ArrayList<String> passwordList = new ArrayList<>();

		String userDB, passDb;
		boolean x = false;
		boolean okPass = false;

		String query = "SELECT * FROM walletdb.wallet_profile";

		try (Connection con = DriverManager.getConnection(db_url, "root", "toor")) {
			Class.forName(driver);
			try (Statement statement = con.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while (resultSet.next()) {
						userDB = resultSet.getString("profile_name");
						usernameList.add(userDB);
					}
					System.out.println("Collecting data... Get " + usernameList.size() + " users name");
					System.out.printf("insert username: ");
					String username = in.nextLine();
					for (String us : usernameList) {
						if (username.equals(us)) {
							System.out.println("username found ==>> " + username + " - " + us);
							okPass = true;
						}
					} // END FOR
				} // END FIRST TRY
			}
		} // END SECOND TRY
		catch (Exception e) {
			log_.info(e.getLocalizedMessage());
		}
		if (okPass) {
			try (Connection con = DriverManager.getConnection(db_url, "root", "toor")) {
				Class.forName(driver);
				try (Statement statement = con.createStatement()) {

					try (ResultSet resultSet = statement.executeQuery(query);) {
						System.out.print("insert password: ");
						String password = in.nextLine();

						while (resultSet.next()) {
							passDb = resultSet.getString("profile_surname");
							passwordList.add(passDb);
						}
						System.out.println("Collecting data... Get " + passwordList.size() + " users password");
						for (String ps : passwordList) {
							if (password.equals(ps)) {
								System.out.println("surname found ==>> " + password + " - " + ps);
								x = true;
							}
						}
						System.out.println("\n==>> You're logged in");
					}
				}
			} catch (Exception e) {
				log_.info(e.getLocalizedMessage());
			}
		} else
			System.err.println("ad password");
		return x;
	}
}

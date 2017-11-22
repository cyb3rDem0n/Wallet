/**
 * @author Giuseppe D'Agostino
 * @author Pasquale Labate
 * 
 * Home wallet handler project. Opens sources.
 * 
 */
package it.home.project;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class WalletApp {
	private static final Logger log = Logger.getLogger(WalletApp.class);

	public static void main(String[] args) {
		HandlerDB db = new HandlerDB();
		try {
			if (LoginHandler.login()) {
				db.insertMethod("Babbo", "Natale");
				System.out
						.println("\n*****************************\n" + " TABLE " + "\n*****************************\n");
				db.viewTable();
			} else {
				System.err.println("Your username/password 're shit, retry");
				WalletApp.main(args);
			}
		} catch (SQLException e) {
			log.error(e.getSQLState());
		}
	} // END MAIN

}

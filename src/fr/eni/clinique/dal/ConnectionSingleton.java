package fr.eni.clinique.dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	static {
            try {
				Class.forName(Settings.getProperty("driverDB"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
    public static Connection getConnect() {
    	Connection connect=null;
    	String url = Settings.getProperty("urldb");
        try {
			connect = DriverManager.getConnection(url, Settings.getProperty("userdb"),Settings.getProperty("passworddb"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connect;
    }


  
}

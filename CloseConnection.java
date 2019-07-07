package hrishabh;

import java.sql.Connection;
import java.sql.SQLException;

public class CloseConnection {
	
	public static void Exit() {
		Connection connection = null;
		try {
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}

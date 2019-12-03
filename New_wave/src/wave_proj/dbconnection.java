package wave_proj;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class dbconnection {

	public static void main(String[] args) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("hi");
			//	String dbURL = "jdbc:sqlserver://192.168.14.15:3306;Localization1.3";
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.14.15;user=sa;password=dbadmin987!;database=Localization1.3");
			if (conn != null) {}
			//Connection conn =DriverManager.getConnection("jdbc:sqlserver://192.168.14.15", "sa", "dbadmin987!,");
			//+ "user=sa;password=dbadmin987!;database=Localization1.3"
			//		String user = "sa";
			//		String pass = "dbadmin987!";
			//		Connection conn = DriverManager.getConnection(dbURL, user, pass);
			conn.createStatement();
			//		ResultSet rs=st.executeQuery("select * from CustomerMaster");
			String query="select * from CustomerMaster";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				String name=rs.getString("CustomerName");
				System.out.println(name);
			}


		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

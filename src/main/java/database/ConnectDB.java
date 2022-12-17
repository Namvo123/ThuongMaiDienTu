package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public Connection getConnect() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=TMDT;user=sa;password=sa";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Kết nối thành công");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//	
//	public static void main(String[] args) {
//		ConnectDB cn = new ConnectDB();
//		cn.getConnect();
//	}
}

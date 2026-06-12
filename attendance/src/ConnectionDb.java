import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private static final String url = "jdbc:mysql://localhost:3306/shre";
    private static final String username = "root";
    private static final String password = "Shree1@";


    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ensures driver is loaded
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found!", e);
        }

        return DriverManager.getConnection(url,username,password);
    }




}

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    static void main() {
        try(Connection con = ConnectionDb.getConnection()){
            System.out.println("connection successful");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

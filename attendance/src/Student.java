import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
    public static void addStudent(String name, int rollNo, String dept) {
        try (Connection con = ConnectionDb.getConnection()){
String query = "insert into students(name , roll_no ,department) values(?,?,?)";
PreparedStatement pre = con.prepareStatement(query);
pre.setString(1,name);
pre.setInt(2,rollNo);
pre.setString(3,dept);
pre.executeUpdate();
            System.out.println("student add successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

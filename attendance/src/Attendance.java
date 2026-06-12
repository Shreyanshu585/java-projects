import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Attendance {
    public static void markAttend(int studentId , String status){
        try(Connection con = ConnectionDb.getConnection()){
            String query = "insert into attendance(student_id,status) values(?,?)";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setInt(1,studentId);
            pre.setString(2,status);
            pre.executeUpdate();
            System.out.println("marked attendance");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

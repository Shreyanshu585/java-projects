
import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration_Login {
    public static Connection con;
    public static Scanner sc = new Scanner(System.in);


    public static void connectionDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "root", "Shree1@");
            System.out.println("connected successfully....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registration() throws SQLException {
        System.out.println("username : ");
        String username = sc.nextLine();
        System.out.println("password : ");
        String password = sc.nextLine();

        try {
            String query = "insert into user(username,password) values(?,?)";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, username);
            pre.setString(2, password);
            pre.executeUpdate();
            System.out.println("registration successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Login() {
        System.out.println("username : ");
        String username = sc.nextLine();
        System.out.println("password : ");
        String password = sc.nextLine();
        try {
            String query = "select * from user where username = ? and password = ?";
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();

            if (rs.next()) {
                System.out.println("login successfully...." + rs.getString("username"));
            } else {
                System.out.println("invalid credential");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    static void main() throws SQLException {
        connectionDB();
        System.out.println(" System ");
        System.out.println("1. register ");
        System.out.println("2. login ");
        System.out.println("3. exit ");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1 -> registration();

            case 2 -> Login();

            case 3 -> {
                System.out.println("good bye");
            return;
            }
            default -> System.out.println("invalid choice ");


        }


    }


}

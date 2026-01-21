package hospitalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class patient {

    static Connection connection;
    private static Scanner scanner;


public patient(Connection connection,Scanner scanner){
    this.connection=connection;
    this.scanner=scanner;
}


public static void addPatient() {
    System.out.println("enter patient name : ");
    String name = scanner.nextLine();
    System.out.println("enter patient age : ");
    int age = scanner.nextInt();
    scanner.nextLine();
    System.out.println("enter patient gender : ");
    String gender = scanner.nextLine();


    try {
        String query = "insert into patient (name ,age,gender) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, gender);
        int affectRows = preparedStatement.executeUpdate();
        if (affectRows > 0) {
            System.out.println("the entry of patient is done !");
        } else {
            System.out.println("entry has been failed !");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

  public static void viewPatients() {
      String query = "select * from patient";

      try {
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          ResultSet result = preparedStatement.executeQuery();
          System.out.println("patients : ");
          System.out.println("+____________+_________________+___________+_______________+");
          System.out.println("| patient id |       name      |    age    |    gender     | ");
          System.out.println("+____________+_________________+___________+_______________+");
          while (result.next()) {
              int id = result.getInt("id");
              String name = result.getString("name");
              int age = result.getInt("age");
              String gender = result.getString("gender");
              System.out.printf("|-%13s|%-18s|%-12s|%-15s|\n",id,name,age,gender);
              System.out.println("+____________+_________________+____________+_______________+");
          }
          } catch (SQLException e){
              e.printStackTrace();

          }

  }


  public static boolean getPatientById(int id) {
      String query = " select * from patient where id = ? ";

      try {
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.setInt(1, id);
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              return true;
          } else {
              return false;
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return false;
  };

}

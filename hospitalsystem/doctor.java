package hospitalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class doctor {

    private static Connection connection;



    public doctor(Connection connection){
        this.connection=connection;

    }


    public static void viewDoctor() {
        String query = "select * from doctor";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            System.out.println("patients : ");
            System.out.println("+____________+_________________+______________________+");
            System.out.println("| doctor id  |       name      |    specialization    | ");
            System.out.println("+____________+_________________+______________________+");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String specialization = result.getString("specialization");

                System.out.printf("|-%13s|%-18s|%-24s|\n",id,name,specialization);
                System.out.println("+_____________+__________________+________________________+");
            }
        } catch (SQLException e){
            e.printStackTrace();

        }

    }


    public static boolean getDoctorById(int id) {
        String query = " select * from doctor where id = ? ";

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
    }

}



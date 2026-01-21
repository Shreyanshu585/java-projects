package hospitalsystem;

import java.sql.*;
import java.util.Scanner;

public class hospitalManagment {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "Shree1@";


    static void main() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            patient p = new patient(connection, scanner);
            doctor d = new doctor(connection);
            while (true) {
                System.out.println("HOSPITAL MANAGMENT SYSTEM ");
                System.out.println("1. Add Patient ");
                System.out.println("2. View Patient ");
                System.out.println("3. Add Doctor ");
                System.out.println("4. Book Appointment ");
                System.out.println("5. Exit ");
                System.out.println("Enter your choice : ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        patient.viewPatients();
                        System.out.println();
                        break;
                    case 3:
                        doctor.viewDoctor();
                        System.out.println();
                        break;
                    case 4:

                        bookAppointment(p, d, connection, scanner);
                        System.out.println();
                        break;
                    case 5:

                        return;
                    default:
                        System.out.println("enter valid choice ! ..");
                        break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void bookAppointment(patient p, doctor d, Connection connection, Scanner scanner) {
        System.out.print("Enter Patient Id: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor Id: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();
        if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)) {
            if (checkDoctorAvailability(doctorId, appointmentDate, connection)) {
                String appointmentQuery = "insert into appointments(patient_id ,doctor_id ,appointment_date) values(?,?,?)";
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(appointmentQuery);
                    preparedStatement.setInt(1, patientId);
                    preparedStatement.setInt(2, doctorId);
                    preparedStatement.setString(3, appointmentDate);
                    int rowAffected = preparedStatement.executeUpdate();
                    if (rowAffected > 0) {
                        System.out.println("Appointment has been successfully book..  ");
                    } else {
                        System.out.println("Appointment not book ");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.println("Either doctor or patient doesn't exist!!!");
            }
        }

    }


    public static boolean checkDoctorAvailability(int doctorId, String appointmentDate, Connection connection) {
        String query = "select count(*) from appointments where doctor_id = ? and appointment_date = ?";
        try {
            PreparedStatement preparedStatement = patient.connection.prepareStatement(query);
            preparedStatement.setInt(1, doctorId);
            preparedStatement.setString(2, appointmentDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    return true;
                } else {
                    return false;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return false;
    }


}

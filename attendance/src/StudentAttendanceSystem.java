
import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentAttendanceSystem {


    static void main() {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();
        Attendance att = new Attendance();

        System.out.println("Student Attendance System");
        System.out.println("1. Add student");
        System.out.println("2. Marked attendance");
        System.out.println("3. Exit");
        System.out.println("enter choice : ");
        int choice = sc.nextInt();
        sc.nextLine();


        switch (choice) {

            case 1 -> {
                System.out.println("enter student name: ");
                String name = sc.nextLine();
                System.out.println("enter student roll number: ");
                int rollNo = sc.nextInt();
                sc.nextLine();

//                String rollStr = sc.nextLine();
//                int rollNo = Integer.parseInt(rollStr);

                System.out.println("enter student department: ");
                String dept = sc.nextLine();
                Student.addStudent(name,rollNo,dept);

            }

            case 2->
            {
                System.out.println("enter student id ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("enter student status ( Present /Absent)");
                String status = sc.nextLine();
                Attendance.markAttend(id,status);

            }

            case 3->{
                System.out.println("Existing...");
                System.exit(0);
            }
        }
    }
}
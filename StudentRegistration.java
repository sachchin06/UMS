package sachchin;

import java.sql.*;
import java.util.Scanner;
public class StudentRegistration {
    String name,uname,pwd;
    int age, select;
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to University Management System\n\n....\nStudent Registration");
        System.out.println("\nPlease Submit the following information,\nName: ");
        name = sc.next();
        System.out.println("Username: ");
        uname = sc.next();
        System.out.println("Password: ");
        pwd = sc.next();
        System.out.println("Age: ");
        age = sc.nextInt();
        System.out.println("Select Course Number from following list");
        System.out.println("[1] SENG 11111 - Introduction to Programming");
        System.out.println("[2] SENG 11112 - Fundamentals of Engineering");
        System.out.println("[3] SENG 11113 - Data Structures and Algorithms");
        select = sc.nextInt();
    }
    public void add(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "root", "Luxan@22"
            );
            Statement st = con.createStatement();
            PreparedStatement sts = con.prepareStatement("INSERT INTO emp (Username, Name, Age, Password) VALUES (?, ?, ?,?)");
            sts.setString(1, uname);
            sts.setString(2, name);
            sts.setInt(3, age);
            sts.setString(4, pwd);
            sts.executeUpdate();

            con.close();

        }catch (Exception e){System.out.println(e);}
    }
    public void Display() {
        System.out.println("You have successfully registered for the followuing course: ");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase", "root", "Esiva@98"
            );
            Statement sta = con.createStatement();
            PreparedStatement sts = con.prepareStatement("INSERT INTO course (username,course) VALUES (?,?)");
            switch(select) {
                case 1:
                    System.out.println("Subject: SENG 11111 - Introduction to Programming");
                    sts.setString(1,uname);
                    sts.setString(2,"SENG 1111 - Introduction to Programming");
                    sts.executeUpdate();
                    break;
                case 2:
                    System.out.println("Subject: SENG 11112 - Fundamentals of Engineering");
                    sts.setString(1,uname);
                    sts.setString(2,"SENG 1112 - Fundamentals of Engineering");
                    sts.executeUpdate();
                    break;

                case 3:
                    System.out.println("Subject: SENG 11113 - Data Structures and Algorithms");
                    sts.setString(1,uname);
                    sts.setString(2,"SENG 1113 - Data Structures and Algorithm");
                    sts.executeUpdate();
                    break;
            }
            con.close();
        }catch(Exception e) {System.out.println(e);}
        System.out.println("Thank You");
    }
}
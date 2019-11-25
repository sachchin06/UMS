package sachchin;

import java.sql.*;
import java.util.Scanner;

public class Student_Login {
    String uname, pwd;
    public void input(){
        System.out.println("Student Login Form\nUsername: ");
        Scanner sc = new Scanner(System.in);
        uname = sc.next();
        System.out.println("Password:");
        pwd = sc.next();
    }
    public void retrieve(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo", "root", "sachchin1998"
            );
            Statement st = con.createStatement();
            ResultSet result =  st.executeQuery("select * from emp where Username = "+uname);
            result.next();
            String Name = result.getString(2);
            System.out.println("Hi "+Name+"You have successfully registered for the following courses");
            ResultSet rs = st.executeQuery("select * from course where username ="+ uname);
            result.next();
            String course = rs.getString(2);
            System.out.println(course);
            con.close();
        }catch(Exception e) {System.out.println(e);}
    }
    public void choice() {
        System.out.println("Please select an option\n1.Exit\n2.Registration");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        switch(select) {
            case 1:
                System.out.println("Bye");
                break;
            case 2:
                StudentRegistration SR = new StudentRegistration();
                SR.input();
                SR.add();
                SR.Display();
                break;
        }
    }

}
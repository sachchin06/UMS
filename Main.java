package sachchin;

import java.sql.*;
import java.util.Scanner;
class main{

    public static void main(String[] args) {

        System.out.println("Welcome to University Management System");
        System.out.println("Select, [1] Sign Up [2] Sign in");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        System.out.println("Please select your registration role [1] leccturer [2] Student");
        int s1 = sc.nextInt();
        StudentRegistration stu = new StudentRegistration();
        Student_Login SL = new Student_Login();
        switch(selection) {
            case 1:
                if(s1 == 2){
                    stu.input();
                    stu.add();
                    stu.Display();
                }
                else if(s1 == 1){
                    System.out.println("System under construction");
                }
                break;
            case 2:
                if(s1==2){
                    SL.input();
                    SL.retrieve();
                    SL.choice();
                }
                else if(s1 == 1){
                    System.out.println("System under construction");
                }
                break;
        }
    }

}
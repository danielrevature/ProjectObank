package org.example.services;

import org.example.dao.UserController;
import org.example.services.CustomerMain;

import java.util.Scanner;

public class UserAccess {
    private static boolean check;
    private static String actype=null;
    private static int curId;
    private static int min;
    private static int max;
    public static boolean found = false;
    public static String empUsername;
    public static int empId;
    public UserAccess(){

    }
    public static void logCredentials(){

        System.out.println("");

        int tries = 3;
        for(tries = 1; tries <=3 ; tries++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your user name");
            String empUserName = scanner.nextLine();
            System.out.println("Please enter your password");
            String password = scanner.nextLine();


            UserController userController = new UserController();

            check = userController.getCredentials(empUserName, password, found);
            if (check == true) {
                System.out.println("Login successful! ");

                tries = 3;
                CustomerMain.cusService();
            }
            else if(tries <3){
                System.out.println("Login failed! Please try again!!");
            }
            else{
                System.out.println("Access denied! Please contact the system administrator!!");
            }
        }
    }

}

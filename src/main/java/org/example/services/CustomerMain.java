package org.example.services;

import java.util.Scanner;

public class CustomerMain {
    public CustomerMain(){

        }
    public static void cusService() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        boolean type = false;
        try {

            System.out.println("Please enter   1 - new customer  2 -  existing customer   3  -  Inquiry   4 -  Quit");
            int choice = scanner.nextInt();
            if(choice == 1) NewRegistration.registerNew();
            if(choice == 2) AccountMaintenance.existingAccount();
            if(choice == 3) Inquiry.Allaccounts();
            if(choice == 4){
                System.out.println("Process aborted by user");
                System.exit(0);;
            }
        }
        catch( IllegalArgumentException ex){
            System.out.println("Please enter appropriate integer.\n" + ex);
        }


    }
}

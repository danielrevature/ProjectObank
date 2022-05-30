package org.example.services;

import java.util.Scanner;

public class CustomerMain {
    public CustomerMain(){

        }
    public static void cusService() throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        boolean type = false;
        try {

            System.out.println("Please enter your choice number\n" +
                    "1 -  new customer\n" +
                    "2 -  existing customer\n" +
                    "3 -  Inquiry\n" +
                    "4 -  Quit");
            int choice = scanner.nextInt();
            if(choice == 1) NewRegistration.registerNew();
            if(choice == 2) AccountMaintenance.existingAccount();
            if(choice == 3) {

                System.out.println("Please select\n" +
                        "1 -  Print all accounts\n" +
                        "2 -  Print by account number\n" +
                        "3 -  print by user id\n" +
                        "4 -  Delete user\n" +
                        "5 -  QUIT");
               int sel = scanner.nextInt();
                switch(sel){
                    case 1:
                        Inquiry.Allaccounts();
                        case 2:
                            Inquiry.getMainAccountByAcc();
                    case 3:
                        Inquiry.getMainAccountById();

                    case 4:
                        Inquiry.deleteUser();
                    case 5:
                        System.out.println("Process aborted by user");
                        System.exit(0);
            }

            }
        }
        catch( IllegalArgumentException ex){
            System.out.println("Please enter appropriate integer.\n" + ex);
        }


    }
}

package controller;

import crud.authorCrud;
import crud.bookCrud;
import utils.scannerUtil;
public class MainController {

    public static void menu(){
        System.out.println();
        System.out.println("|------------------------------|");
        System.out.println("|         MAIN MENU            |");
        System.out.println("|------------------------------|");
        System.out.println("| 1 ➜ Author Management        |");
        System.out.println("| 2 ➜ Book Management          |");
        System.out.println("| 3 ➜ Exit Program             |" );
        System.out.println("|------------------------------|");
        System.out.println();
        System.out.print("Enter Choice ➜  ");
    }
    public static void main(String[] args) {
        System.out.println("|--------------LIBRARY MANAGEMENT SYSTEM---------------║");
        int choice=0;

        while (choice != 3) {
            menu();
            choice = scannerUtil.nextInt();

            switch (choice) {
                case 1:
                    char options;
                    do{
                        System.out.println();
                        System.out.println(" A ➜ Add Author \n B ➜ Delete Author \n C ➜ update Author \n D ➜ Show All Author \n E ➜ Go Back to Main Menu \n F ➜ Exit Program");
                        System.out.print("Enter Choice ➜ ");
                        options = scannerUtil.nextChar();
                        System.out.println();

                        if(options == 'e' || options == 'E'){
                            System.out.println("Returning to Manin Menu...");
                            break;
                        }
                        if(options == 'f'  || options == 'F'){
                            System.out.println("Thank You ! Visit Again.");
                            System.exit(0);
                        }
                        authorCrud.authorCrudfun(options);
                    }while (true);
                    break;
                case 2:
                    char option;
                    do {
                        System.out.println();
                        System.out.println(" A ➜ Add Book \n B ➜ Delete Book \n C ➜ Update Edition or Price \n D ➜ Show All Books \n E ➜ Go Back to Main Menu \n F ➜ Exit Program");
                        System.out.print("Enter Choice ➜ ");
                        option = scannerUtil.nextChar();
                        if(option == 'e' || option == 'E'){
                            System.out.println("Returning to Manin Menu...");
                            break;
                        }
                        if(option == 'f' || option == 'F'){
                            System.out.println("Thank You ! Visit Again.");
                            System.exit(0);
                        }
                        bookCrud.bookCrudfun(option);
                    }while (true);
                    break;

                case 3:
                    System.out.println("Thank You ! Visit Again.");
                    break;
                default:
                    System.out.println("Invalid Input, Please Choice from Options !");
                    break;
            }
        }
    }
}

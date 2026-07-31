package crud;

import Dao.AuthorDao;
import java.util.Scanner;

public class authorCrud {
    public static void authorCrudfun(char option) {
        AuthorDao authorDao = new AuthorDao();
        Scanner sc = new Scanner(System.in);
        switch(option){
            case 'a','A':
                String input1;
                System.out.println("Enter Author Name");
                input1 = sc.nextLine();

                authorDao.addAuthor(input1);
                break;
            case 'b','B':
                String nameEntered;
                System.out.println("Enter Author Name to Delete");
                nameEntered = sc.nextLine();

                authorDao.delAuthor(nameEntered);
                break;

            case 'c','C':
                System.out.println("Enter Previous Author Name: ");
                String prevName = sc.nextLine();

                System.out.println("Enter New Author Name:  ");
                String updatedName = sc.nextLine();

                authorDao.updateAuthor(prevName, updatedName);
                break;

            case 'd','D':
                authorDao.getAllAuthor();
                break;
            default:
                System.out.println("Invalid Input, Please Choose from Options !");
                break;

        }
    }

}

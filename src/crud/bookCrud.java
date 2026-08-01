package crud;

import Dao.BookDao;
import services.BookServices;

public class bookCrud {
    public static void bookCrudfun(char option) {
        BookDao bookDao = new BookDao();
        BookServices bookServices = new BookServices(bookDao);

        switch(option){
            case 'a','A':
                bookServices.addBookServices();
                break;

            case 'b','B':
                bookServices.deleteBookServices();
                break;

            case 'c','C':
                bookServices.updateBookService();
                break;

            case 'd','D':
                bookServices.getAllBooksService();
                break;
            default:
                System.out.println("Invalid Input, Please Choose from Options !");
        }
    }
}

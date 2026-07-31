package services;

import Dao.AuthorDao;
import Dao.BookDao;
import model.Author;
import model.Book;
import java.util.Scanner;

public class BookServices {
    private BookDao bookDao;
    public BookServices(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBookServices(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name:-");
        String name = sc.nextLine();

        System.out.println("Enter Book Edition:-");
        String edition = sc.nextLine();

        System.out.println("Enter Book Price:-");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter book Author Name:-");
        String authorName = sc.nextLine();
        Author author = AuthorDao.getAuthorByName(authorName);

        if(author == null){
            return;
        }

        Book newBook = new Book(name, price, edition, author);
        bookDao.addBook(newBook);
    }

    public void deleteBookServices(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name to Delete: ");
        String bookName = sc.nextLine();
        if(bookName.length()==0){
            return;
        }
        bookDao.deleteBookByName(bookName);

    }

    public void getAllBooksService(){
        bookDao.getAllBook();
    }

    public void updateBookService(){
        double bookPrice;
        String bookEdition,bookName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Book Name to be updated ");
        bookName = sc.nextLine();
        System.out.println("Enter Book Price to be updated ");
        bookPrice = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Book Edition to be updated ");
        bookEdition = sc.nextLine();
        bookDao.updateBookByEditionAndPrice(bookName,bookEdition,bookPrice);
    }

}

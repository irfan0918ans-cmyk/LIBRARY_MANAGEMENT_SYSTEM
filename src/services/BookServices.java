package services;

import Dao.AuthorDao;
import Dao.BookDao;
import model.Author;
import model.Book;
import utils.scannerUtil;

public class BookServices {
    private BookDao bookDao;
    public BookServices(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBookServices(){

        System.out.println("Enter Book Name:-");
        String name = scannerUtil.nextLine();

        System.out.println("Enter Book Edition:-");
        String edition = scannerUtil.nextLine();

        System.out.println("Enter Book Price:-");
        double price = scannerUtil.nextDouble();

        System.out.println("Enter book Author Name:-");
        String authorName = scannerUtil.nextLine();
        Author author = AuthorDao.getAuthorByName(authorName);

        if(author == null){
            return;
        }

        Book newBook = new Book(name, price, edition, author);
        bookDao.addBook(newBook);
    }

    public void deleteBookServices(){

        System.out.println("Enter Book Name to Delete: ");
        String bookName = scannerUtil.nextLine();
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

        System.out.println("Enter Book Name to be updated ");
        bookName = scannerUtil.nextLine();
        System.out.println("Enter Book Price to be updated ");
        bookPrice = scannerUtil.nextDouble();

        System.out.println("Enter Book Edition to be updated ");
        bookEdition = scannerUtil.nextLine();
        bookDao.updateBookByEditionAndPrice(bookName,bookEdition,bookPrice);
    }

}

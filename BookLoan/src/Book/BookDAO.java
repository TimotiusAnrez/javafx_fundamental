package Book;

import java.util.ArrayList;

//inherited interface from DAO to be more specific to Book domain usage
public interface BookDAO extends DAO{
    public boolean addBook(Book book);
    public boolean updateBook(Book book);
    public boolean  deleteBook(Book book);
    
    public Book getBookByID(String ISBN);
    public ArrayList<Book> getAllBooks();
    public Boolean sellBook(String ISBN, int quantity); //we use option in case the book that we want to sell doesn't exist through searching in ISBN
}

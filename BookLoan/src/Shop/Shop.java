package Shop;

import java.util.ArrayList;

import Book.Book;
import Book.BookDAO;

//blue print to use the BookModel
public class Shop {

    private BookDAO bookModel; //dependency injection
    
    public Shop(BookDAO bookModel){
        this.bookModel = bookModel; //injecting dependency to Shop object
    }

    public void addBook(String bookName, String ISBN, int price, int sku){
        Book book = new Book(bookName, ISBN, price, sku);
        bookModel.addBook(book); //abstract interface to use the 
    }

    public Book getBookByID(String ISBN){
        return bookModel.getBookByID(ISBN);
    }

    public ArrayList<Book> getAllBook(){
        return bookModel.getAllBooks();
    }

    public void sellBook(String ISBN, int quantity){
        bookModel.sellBook(ISBN, quantity);
    }
}

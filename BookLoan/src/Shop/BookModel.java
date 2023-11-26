package Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;

import Book.Book;
import Book.BookDAO;

//Tools needed to interact with database, will be injected to Shop
public class BookModel implements BookDAO {

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement sm;

    @Override
    public void setup() throws Exception, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/book", "root", "password");
    }

    @Override
    public void connect() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/book", "root", "password");
    }

    @Override
    public void close() throws Exception {
        connection.close();
        try {
            DriverManager.getConnection("jbdc:mysql://127.0.0.1:3306/book; shutdown=true", "root", "password");
        } catch (Exception e) {

        }
    }

    @Override
    public boolean addBook(Book book) {
        
        try {
            System.out.println("arrive add book" + book.getBookName() + book.getISBN());
            setup();
            connect();
            String sqlStatement = String.format("INSERT INTO Book (ISBN, bookName, price, sku) " +
                    "values (%s, %s, %d, %d)",
                    book.getISBN(), book.getBookName(), book.getPrice(), book.getSku());
            sm = connection.createStatement();
            sm.execute(sqlStatement);
            close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    }

    @Override
    public boolean deleteBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public Book getBookByID(String ISBN) {
        Book bookResult = new Book();

        try {
            setup();
            connect();
            String sqlStatement = String.format("select * from Book where ISBN = %s", ISBN);
            rs = ps.executeQuery(sqlStatement);
            while(rs.next()){
                bookResult = new Book(rs.getString("bookName"), rs.getString("ISBN"), rs.getInt("price"), rs.getInt("sku"));
            }
            close();
        } catch (Exception e) {
            return bookResult;
        }
        return bookResult;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> bookList = new ArrayList<>();

        try {
            setup();
            connect();
            System.out.println("Arrive at getAllBooks");
            String sqlStatement = "select * from Book";
            sm = connection.createStatement();
            rs = sm.executeQuery(sqlStatement);

            while (rs.next()) {
                Book bookItem = new Book(rs.getString("bookName"), rs.getString("ISBN"), rs.getInt("price"), rs.getInt("sku")   );
                bookList.add(bookItem);
            }

            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Boolean sellBook(String ISBN, int quantity) {

        try {

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

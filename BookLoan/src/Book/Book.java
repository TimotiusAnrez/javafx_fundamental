package Book;
import java.util.Objects;

/**
 * @author tim
 * @category POJO
 * @version V1.0.0
 * 
 * Book class is a domain class that will be used by DAO and BookModel
 * Book will be the base data object structure with no other method other than getting data and create object.
 */
public class Book {
    String bookName, ISBN;
    int price, sku;
    

    public Book() {
    }

    public Book(String bookName, String ISBN, int price, int sku) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.price = price;
        this.sku = sku;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSku() {
        return this.sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public Book bookName(String bookName) {
        setBookName(bookName);
        return this;
    }

    public Book ISBN(String ISBN) {
        setISBN(ISBN);
        return this;
    }

    public Book price(int price) {
        setPrice(price);
        return this;
    }

    public Book sku(int sku) {
        setSku(sku);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName) && Objects.equals(ISBN, book.ISBN) && price == book.price && sku == book.sku;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, ISBN, price, sku);
    }

    @Override
    public String toString() {
        return "{" +
            " bookName='" + getBookName() + "'" +
            ", ISBN='" + getISBN() + "'" +
            ", price='" + getPrice() + "'" +
            ", sku='" + getSku() + "'" +
            "}";
    }
    
}

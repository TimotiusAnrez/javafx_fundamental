import java.util.ArrayList;

import Book.Book;
import Book.BookDAO;
import Shop.BookModel;
import Shop.Shop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    private BookDAO buildDAO(){
        return new BookModel(); //exposed interface to be used
    }

    private Shop buildModel(){
        return new Shop(buildDAO()); //inject exposed interface for data access
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        HBox parent = new HBox();
        
        Scene initialScene = new Scene(parent, 1280, 720);
        
        Shop model = buildModel();
        System.out.println("Hello World");
        model.addBook("Catching Fire","ISBN-12801234", 55, 35);
        ArrayList<Book> bookList = model.getAllBook();
        
        for(Book element: bookList){
            
            Text banner = new Text(element.getBookName());
            banner.setX(1280/2);
            banner.setY(720/2);
            parent.getChildren().add(banner);
        }

        stage.setScene(initialScene);
        stage.show();
    }
}

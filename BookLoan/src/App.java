import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        HBox parent = new HBox();
        Text banner = new Text("Hello World");
        
        parent.getChildren().add(banner);
        Scene initialScene = new Scene(parent, 1280, 720);
        
        
        
        stage.setScene(initialScene);
        stage.show();
    }
}

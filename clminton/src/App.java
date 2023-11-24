import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text banner = new Text("Hello World");
        Group parent = new Group();
        parent.getChildren().addAll(banner);
        Scene initialScene = new Scene(parent, 1280, 720);
        stage.setScene(initialScene);

        stage.show();
    }


}

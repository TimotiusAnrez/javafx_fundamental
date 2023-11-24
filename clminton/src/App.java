import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Item;
import view.Table;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Table tableContent = new Table(); //create table object
            tableContent.addData(new Item("SKU001", "Hard Disk 1TB", 200, false)); //add table data
            tableContent.addData(new Item("SKU002", "Keyboard Logitech", 500, true));
            
            TableView<Item> table = tableContent.showTable();//show table

            VBox layout = new VBox();
            //Button
            Button inventory = new Button("Inventory");
            Button tax = new Button("Tax");
            
            HBox buttonBox = new HBox();
            buttonBox.getChildren().addAll(inventory, tax);
            inventory.disableProperty().bind(table.getSelectionModel().selectedItemProperty().isNull());
            tax.disableProperty().bind(
                table.getSelectionModel().selectedItemProperty().isNull().or(
                    Bindings.selectBoolean(table.getSelectionModel().selectedItemProperty(), "tax").not()
                ));

            layout.getChildren().addAll(table, buttonBox);



            Scene content = new Scene(layout);

            stage.setScene(content);
            stage.setTitle("Item Table");
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw e;
        }
    }


}

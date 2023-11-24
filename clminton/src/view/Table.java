package view;

import java.util.*;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

public class Table {

    ArrayList<Item> ItemList = new ArrayList<>();

    public TableView<Item> showTable(){

        //Creating table
        TableView<Item> itemTable = new TableView<>(); //table container

        //Table header definition
        TableColumn<Item, String> skuColumn = new TableColumn<>("SKU"); //TableColumn object has String argument to name the column
        TableColumn<Item, String> nameColumn = new TableColumn<>("Item Name");
        TableColumn<Item, Integer> priceColumn = new TableColumn<>("Price");
        TableColumn<Item, Boolean> taxColumn= new TableColumn<>("Taxable");

        //Add header definition to table
        itemTable.getColumns().addAll(skuColumn, nameColumn, priceColumn, taxColumn); //add all column header to table

        
        //Add data to table
        for(Item element:ItemList){
            itemTable.getItems().add(element);
        }

        //Binding data to header definition
        skuColumn.setCellValueFactory(new PropertyValueFactory<>("sku"));//? set column value to Item property value of inserted as argument
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));;
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));

        return itemTable;
    }

    public void addData(Item itemInput){
        ItemList.add(itemInput);
    }
}

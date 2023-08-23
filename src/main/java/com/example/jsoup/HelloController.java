package com.example.jsoup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HelloController {
    @FXML
    Label label;
    @FXML
    TableView tableView;
    @FXML
    Button button;

    Model model= new Model();
    public void initialize() throws IOException {
        model.poluchenieDannyh("https://www.avito.ru/");
        label.setText(model.generalTitle); //СЮДА ДОБАВИТЬ elFirst??????

        button.setOnAction(a->initTable());
    }

    private void initTable() {
        tableView.getColumns().clear();
        TableColumn<Header, String> aColumn=new TableColumn<>("titleS");
        aColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.getColumns().add(aColumn);
        tableView.setItems(model.observableList);
    }
}
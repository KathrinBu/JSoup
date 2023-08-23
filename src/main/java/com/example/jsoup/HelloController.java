package com.example.jsoup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
        model.poluchenieDannyh("https://www.avito.ru/sankt-peterburg/koshki?cd=1");
        label.setText(model.generalTitle);
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
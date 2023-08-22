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

    static ObservableList<Header> observableList= FXCollections.observableArrayList();
    public void initialize() throws IOException {
        label.setText("title"); //СЮДА ДОБАВИТЬ elFirst??????
        poluchenieDannyh("https://www.avito.ru/");
        button.setOnAction(a->initTable());

    }

    public static void poluchenieDannyh(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element elFirst = doc.selectFirst("title"); //заголовок общий
        Elements el = doc.select("h3"); //список заголовков
        String elGip = doc.select("a").attr("href"); //список гиперссылок в формате ссылок
        for (Element elS:el) {
            String title=elS.text();
            observableList.add(new Header(title));
        }
    }
    private void initTable() {
        tableView.getColumns().clear();
        TableColumn<Header, String> aColumn=new TableColumn<>("titleS");
        aColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.getColumns().add(aColumn);
        tableView.setItems(observableList);
    }
}
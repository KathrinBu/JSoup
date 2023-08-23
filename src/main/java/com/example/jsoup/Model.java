package com.example.jsoup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Model {
    String generalTitle;

    ObservableList<Header> observableList= FXCollections.observableArrayList();

    public void poluchenieDannyh(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element elFirst = doc.selectFirst("title"); //заголовок общий
        generalTitle = elFirst.text();
        Elements el = doc.select("h3"); //список заголовков
        String elGip = doc.select("a").attr("href"); //список гиперссылок в формате ссылок
        for (Element elS:el) {
            String title=elS.text();
            observableList.add(new Header(title));
        }
    }
}

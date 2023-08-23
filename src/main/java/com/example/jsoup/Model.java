package com.example.jsoup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Model {
    String generalTitle;
    String kod;

    ObservableList<Header> observableList= FXCollections.observableArrayList();

    public void poluchenieDannyh(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
//        FileWriter fileWriter=new FileWriter("1.html");
//        fileWriter.write(html);
//        fileWriter.close();
        Element elFirst = doc.selectFirst("title"); //заголовок общий
        generalTitle = elFirst.text();
        Elements items=doc.getElementsByClass("item");
        for (Element item:items) {
           Element e1=item.getElementsByClass("item").select("a").first();
           String str=e1.text();
           if(str.toLowerCase().contains("котенок")){
               observableList.add(new Header(str));
           }
        }
    }
}

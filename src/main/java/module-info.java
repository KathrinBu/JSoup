module com.example.jsoup {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.example.jsoup to javafx.fxml;
    exports com.example.jsoup;
}
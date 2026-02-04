module com.example.atv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.atv2 to javafx.fxml;
    exports com.example.atv2;
}
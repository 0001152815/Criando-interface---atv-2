module com.example.atv2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atv2 to javafx.fxml;
    exports com.example.atv2;
}
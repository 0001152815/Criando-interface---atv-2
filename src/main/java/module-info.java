module com.example.atv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.atv2.controller to javafx.fxml;
    opens com.example.atv2 to javafx.fxml;

    exports com.example.atv2;
}


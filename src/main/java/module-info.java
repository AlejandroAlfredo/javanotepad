module com.javanotepad {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.javanotepad to javafx.fxml;
    opens com.javanotepad.controllers to javafx.fxml;
    opens com.javanotepad.events to javafx.fxml;
    opens com.javanotepad.service to javafx.fxml;
    opens com.javanotepad.util to javafx.fxml;
    exports com.javanotepad;
}

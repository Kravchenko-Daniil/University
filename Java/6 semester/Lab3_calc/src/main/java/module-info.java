module com.example.lab3_calc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab3_calc to javafx.fxml;
    exports com.example.lab3_calc;
    requires exp4j;
}
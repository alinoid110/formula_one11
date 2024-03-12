module com.example.formula_one {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.formula_one to javafx.fxml;
    exports com.example.formula_one;
}
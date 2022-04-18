module wit.comp1050.mastermind {
    requires javafx.controls;
    requires javafx.fxml;


    opens wit.comp1050.mastermind to javafx.fxml;
    exports wit.comp1050.mastermind;
}
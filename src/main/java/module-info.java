module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens is.vidmot to javafx.fxml;
    exports is.vidmot;
}

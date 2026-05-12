module org.example.jnote {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    opens org.example.jnote to javafx.fxml;
    opens org.example.jnote.controllers to javafx.fxml;
    opens org.example.jnote.models to com.fasterxml.jackson.databind;
    exports org.example.jnote;
}
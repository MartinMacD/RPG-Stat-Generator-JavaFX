module com.macdonaldmartin.rpgstatgenjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.macdonaldmartin.rpgstatgenjava to javafx.fxml;
    exports com.macdonaldmartin.rpgstatgenjava;
}
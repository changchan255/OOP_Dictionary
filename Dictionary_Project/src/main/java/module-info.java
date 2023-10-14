module dictionaryapplication.dictionary_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens Controller.dictionary_project to javafx.fxml;
    exports Controller.dictionary_project;
}
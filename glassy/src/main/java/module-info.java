module com.editor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.editor to javafx.fxml;
    exports com.editor;
}

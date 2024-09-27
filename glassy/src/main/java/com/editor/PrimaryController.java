package com.editor;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

 
}

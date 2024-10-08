package com.editor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
       @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem cutMenuItem;

    @FXML
    private MenuItem copyMenuItem;

    @FXML
    private MenuItem pasteMenuItem;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private TextArea textArea;

    @FXML
    private  SecondaryModel secondaryModel;

    @FXML
    private void onRun() {
       Path path = secondaryModel.getPath();
       System.out.println(path);
       ProcessBuilder processBuilder = null;
       if(path.toString().endsWith(".py")) {
        processBuilder = new ProcessBuilder("alacritty", "-e", "bash", "-c", "python3 " + path.toString() + "; read -p 'Press Enter to continue...'");
       }
    //    processBuilder = new ProcessBuilder("alacritty", "-e", "java", path.toString());
       try {
            processBuilder.start();
       } catch (IOException | NullPointerException e) {
            e.printStackTrace();
         }
    }
    
    @FXML
    public void onSave() throws IOException {
        System.out.println("Save");
        System.out.println(secondaryModel.getText());
        secondaryModel.save();
    }

    @FXML
    public void onOpen() {
        System.out.println("Open");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null) {
            System.out.println(file.getAbsolutePath());
            secondaryModel.open(file.toPath());
        }
    }

    @FXML
    public void initialize() {
        secondaryModel = new SecondaryModel();
        textArea.textProperty().bindBidirectional(secondaryModel.textProperty());
    }

}
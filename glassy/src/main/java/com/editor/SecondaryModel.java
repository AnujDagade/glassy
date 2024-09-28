package com.editor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecondaryModel {
    
    private final StringProperty text = new SimpleStringProperty();
    private TextFile textFile;

    public void save() throws IOException {
        try{
            Files.writeString(textFile.getFile(),getText(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Path getPath() {
        return textFile.getFile();
    }

    public void open(Path path) {
        try {
            textFile = new TextFile(path);
            setText(Files.readString(textFile.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public StringProperty textProperty() {
        return text;
    }
}

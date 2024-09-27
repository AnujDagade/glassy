package com.editor;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class TextFile {
    private Path file;
    private List<String> lines;

    protected TextFile(Path path) {
        this.file = path;
    }

    public Path getFile() {
        return file;
    }

    public List<String> getLines() {
        return lines;
    }
}

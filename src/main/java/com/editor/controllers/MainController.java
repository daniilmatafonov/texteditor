package com.editor.controllers;

import com.editor.model.FileActionModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Collections;

public class MainController {

    public MainController(final FileActionModel fileActionModel) {
        this.fileActionModel = fileActionModel;
    }

    private FileActionModel fileActionModel;

    private FileActionModel.TextDocument textFile;

    @FXML
    private TextArea textArea;

    public void newFile(){
        fileActionModel.newFile();
    }

    public void readFile(){
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file !=null){
            textFile = fileActionModel.readFile(file.toPath());
            textArea.clear();
            textFile.data().parallelStream().forEach(textArea::appendText);
        }
    }

    public void saveFile(){
        FileActionModel.TextDocument textDocument = new FileActionModel.TextDocument(textFile.path(), Collections.singletonList(textArea.getText()));
        fileActionModel.saveFile(textDocument);
    }

    public void closeFile(){
        fileActionModel.close();
    }
}

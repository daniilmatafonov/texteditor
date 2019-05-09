package com.editor.controllers;

import com.editor.model.FileActionModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.Arrays;

public class MainController {

    public MainController(final FileActionModel fileActionModel) {
        this.fileActionModel = fileActionModel;
    }

    private FileActionModel fileActionModel;

    private FileActionModel.TextDocument textFile;

    @FXML
    private TextArea textArea;

    public void newFile() {
        clearTextArea();
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(null);
        fileActionModel.newFile(file.toPath());
        textFile = fileActionModel.readFile(file.toPath());
    }

    private void clearTextArea(){
        textArea.clear();
    }

    private void fillTextArea(){
      textFile.data().forEach(s -> textArea.appendText(s + "\n"));
    }

    public void readFile(){
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file !=null){
            clearTextArea();
            textFile = fileActionModel.readFile(file.toPath());
            fillTextArea();
        }
    }

    public void saveFile(){
        if (textArea.getText().isEmpty()){
            textFile.clearData();
        }
        FileActionModel.TextDocument textDocument = new FileActionModel.TextDocument(textFile.path(), Arrays.asList(textArea.getText().split("\n")));
        fileActionModel.saveFile(textDocument);
    }

    public void closeFile(){
        saveFile();
        fileActionModel.close();
    }

    public void about(){
        fileActionModel.about();
    }
}

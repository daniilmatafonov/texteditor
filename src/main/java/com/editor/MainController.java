package com.editor;

import com.editor.model.FileActionModel;
import javafx.scene.control.TextArea;

public class MainController {

    public MainController(final FileActionModel fileActionModel) {
        this.fileActionModel = fileActionModel;
    }

    private FileActionModel fileActionModel;

    private TextArea textArea;

    public void newFile(){
        fileActionModel.newFile();
    }

    public void readFile(){
        fileActionModel.readFile();
    }

    public void saveFile(){
        fileActionModel.saveFile();
    }

    public void closeFile(){
        fileActionModel.close();
    }
}

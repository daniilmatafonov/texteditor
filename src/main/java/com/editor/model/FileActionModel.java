package com.editor.model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileActionModel {

    public void newFile(Path path) {
        if (Files.notExists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TextDocument readFile(Path path){
            try {
                List<String> data = Files.readAllLines(path);
                return new TextDocument(path, data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public void saveFile(TextDocument textDocument){
        if (Files.isWritable(textDocument.path)){
            try {
                Files.write(textDocument.path, textDocument.data, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(TextDocument document){
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Exit from TextEditor without saving ?", ButtonType.OK, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        handleResultCloseConfirmationDialog(alert, document);
    }

    private void handleResultCloseConfirmationDialog(Alert alert, TextDocument document){
        if (alert.getResult() == ButtonType.OK){
            Platform.exit();
        }
        if (alert.getResult() == ButtonType.NO){
            saveFile(document);
            Platform.exit();
        }
        if (alert.getResult() == ButtonType.CANCEL){
            alert.close();
        }
    }

    public static class TextDocument {
        private Path path;

        private List<String> data;

        public TextDocument(Path path, List<String> data) {
            this.path = path;
            this.data = data;
        }

        public Path path() {
            return path;
        }

        public List<String> data() {
            return data;
        }

        public void clearData(){
            data.clear();
        }
    }
}

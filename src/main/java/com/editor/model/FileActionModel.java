package com.editor.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileActionModel {

    public void newFile(){

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
                Files.write(textDocument.path, textDocument.data, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(){
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
    }
}

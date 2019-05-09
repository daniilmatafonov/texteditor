package com.editor.model;

import java.nio.file.Path;
import java.util.List;

public class FileActionModel {

    public void newFile(){

    }

    public void readFile(){

    }

    public void saveFile(){

    }

    public void close(){

    }

    public class TextDocument {
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

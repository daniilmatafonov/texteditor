package com.editor;

import com.editor.model.FileActionModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TextEditorApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        fxmlLoader.setControllerFactory(c -> new MainController(new FileActionModel()));
        stage.setTitle("TextEditor");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
}

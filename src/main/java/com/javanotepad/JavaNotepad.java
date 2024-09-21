package com.javanotepad;

import com.javanotepad.events.WindowsEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaNotepad extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("notepad"));
        stage.setScene(scene);
        stage.setTitle("java notepad - Empty file*");
        stage.setResizable(true);
        //stage.getIcons().add(new Image(""));
        // events
        stage.addEventHandler(WindowsEvent.WINDOWS_EXIT, event -> {
            stage.close();
        });
        //
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(JavaNotepad.class.getResource(fxml + ".fxml"));
        return loader.load();
    }

    public static void run(String[] args) {
        launch(args);
    }
}

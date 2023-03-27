package com.example.lab3_calc;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("CalcUI.fxml");
        loader.setLocation(url);
        Parent layout = loader.load();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();

//        String css = this.getClass().getResource("../stylesheet1.css").toExternalForm();
//        scene.getStylesheets().add(css);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

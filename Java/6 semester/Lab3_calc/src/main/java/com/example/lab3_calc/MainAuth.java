package com.example.lab3_calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainAuth extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("AuthUI.fxml");
        loader.setLocation(url);
        Parent layout = loader.load();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Authorization");
        stage.show();
    }
}

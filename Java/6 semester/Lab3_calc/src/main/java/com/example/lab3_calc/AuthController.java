package com.example.lab3_calc;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthController {

    public TextField input_login;
    public PasswordField input_password;
    public void buttonClick(){
        String login = input_login.getText();
        String password = input_password.getText();
        if (login.equals("Dan") && password.equals("123")){
            ((Stage) input_login.getParent().getScene().getWindow()).close();
        }
    }

}

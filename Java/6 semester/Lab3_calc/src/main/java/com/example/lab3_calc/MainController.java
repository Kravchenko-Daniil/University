package com.example.lab3_calc;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainController {
    public TextField text;

    public void buttonClick(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getTarget();
        text.appendText(button.getText());
    }

    public void buttonClickOperations(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getTarget();
        switch (button.getId()){
            case "btn_div":
                text.appendText("/");
                break;
            case "btn_mul":
                text.appendText("*");
                break;
            case "btn_plus":
                text.appendText("+");
                break;
            case "btn_min":
                text.appendText("-");
                break;
            case "btn_back":
                int lenght = text.getLength();
                if (lenght > 0){
                    text.deleteText(lenght-1, lenght);
                }
                break;
            case "btn_clear":
                text.clear();
                break;
            case "btn_res":
                Expression expression = new ExpressionBuilder(text.getText()).build();
                Double result = expression.evaluate();
                text.setText(result.toString());
                int lenght2 = text.getLength();
                text.deleteText(lenght2-2, lenght2);
                break;
        }
    }
}

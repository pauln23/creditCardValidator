package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {
    @FXML
    private Button btValid, btReset;
    @FXML
    private TextField ccText;
    @FXML
    private Rectangle rect;

    private Long ccNumber;

   public void doLuhn(ActionEvent e){


       System.out.println((ccText.getText()));
        creditCard card = new creditCard(Long.parseLong(ccText.getText()));


        if (card.valid){
            rect.setFill(Color.GREEN);
        }
        else{
            rect.setFill(Color.RED);
        }
    }

    public void reset(ActionEvent e){
        rect.setFill(Color.TRANSPARENT);
    }
}

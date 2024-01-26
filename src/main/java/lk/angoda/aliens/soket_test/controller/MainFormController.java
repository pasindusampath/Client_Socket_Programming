package lk.angoda.aliens.soket_test.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import lk.angoda.aliens.soket_test.service.ClientSide;

import java.io.IOException;

public class MainFormController {
    public VBox mainContainer;
    public TextField txtMsg;
    ClientSide ob ;
    public void initialize() throws IOException {
        ob = new ClientSide();
        new Thread(ob).start();
    }


    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        ob.sendToClient(txtMsg.getText());
    }
}

package lk.angoda.aliens.soket_test.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lk.angoda.aliens.soket_test.dto.TransferData;
import lk.angoda.aliens.soket_test.service.ClientSide;

import java.io.IOException;

public class MainFormController {
    public VBox mainContainer;
    public TextField txtMsg;
    ClientSide ob ;
    public void initialize() throws IOException {
        ob = new ClientSide();
        new Thread(ob).start();

        ob.valueProperty().addListener((observable, oldValue, newValue) -> {
            Label label = new Label(newValue.getMsg());
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.getChildren().add(label);
            mainContainer.getChildren().add(hBox);
        });

    }


    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        ob.sendToClient(new TransferData(txtMsg.getText(),"","ALL","TEXT_MSG"));
    }
}

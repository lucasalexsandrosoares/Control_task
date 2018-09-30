package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.layout.Pane;
import jdbc.AbreTela;


public class ControllerConsultar{

    @FXML
    private Pane HomeConsultar;

    public void handleOnActionCriarTarefa(ActionEvent actionEvent){
        new AbreTela().TelaCriarTarefa();
        HomeConsultar.getScene().getWindow().hide();
    }
}

package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import jdbc.AbreTela;

public class ControllerExcluir {

    @FXML
    private Pane HomeExcluir;

    public void handleOnActionSair(){
        new AbreTela().TelaLogin();
        HomeExcluir.getScene().getWindow().hide();

    }
    public void handleOnActionCriarTarefa(){
        new AbreTela().TelaCriarTarefa();
        HomeExcluir.getScene().getWindow().hide();

    }
    public void handleOnActionConsultar(){
        new AbreTela().TelaConsultar();
        HomeExcluir.getScene().getWindow().hide();

    }
    public void handleOnActionTarefaFinalizada(){
        new AbreTela().TelaTarefaFinalizada();
        HomeExcluir.getScene().getWindow().hide();
      
    }
}

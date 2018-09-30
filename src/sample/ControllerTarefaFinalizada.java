package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import jdbc.AbreTela;

public class ControllerTarefaFinalizada {

    @FXML
    private Pane HomeTarefaFinalizada;

    public void handleOnActionCriarTarefa(){
        new AbreTela().TelaCriarTarefa();
        HomeTarefaFinalizada.getScene().getWindow().hide();
    }
    public void handleOnActionExcluirTarefa(){
        new AbreTela().TelaExcluir();
        HomeTarefaFinalizada.getScene().getWindow().hide();
    }
    public void handleOnActionConsultar(){
        new AbreTela().TelaConsultar();
        HomeTarefaFinalizada.getScene().getWindow().hide();
    }
    public void handleOnActionSair(){
        new AbreTela().TelaLogin();
        HomeTarefaFinalizada.getScene().getWindow().hide();
    }
}

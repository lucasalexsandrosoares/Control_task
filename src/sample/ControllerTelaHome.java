package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import jdbc.AbreTela;



public class ControllerTelaHome {

    @FXML
    private Text HomeOpcoes;

    public void handleOnActionCriarTarefa(ActionEvent actionEvent){
        new AbreTela().TelaCriarTarefa();
        HomeOpcoes.getScene().getWindow().hide();

    }


    public void criarTarefa(){
        new AbreTela().TelaCriarTarefa();
        HomeOpcoes.getScene().getWindow().hide();
    }

    public void handleOnActionConsultarTarefa(){
        new AbreTela().TelaConsultar();
        HomeOpcoes.getScene().getWindow().hide();
    }
}

package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;



import javafx.scene.text.Text;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ControllerTelaHome extends ConnectionFactory {

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
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from tarefa");
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public  void handleOnActionSair(){
        new AbreTela().TelaLogin();
        HomeOpcoes.getScene().getWindow().hide();
    }
    public void handleOnActionExcluir(){
        new AbreTela().TelaExcluir();
        HomeOpcoes.getScene().getWindow().hide();
    }
    public void handleOnActionTarefaFinalizada(){
        new AbreTela().TelaTarefaFinalizada();
        HomeOpcoes.getScene().getWindow().hide();
    }
}

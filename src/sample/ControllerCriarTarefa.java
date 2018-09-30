package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerCriarTarefa extends ConnectionFactory {

    @FXML
    private Button btnCancelar;
    @FXML
    private  Button btnSalvar;
    @FXML
    private TextField tarefa;


    public void handleOnActionCancelar(ActionEvent actionEvent){
        new AbreTela().TelaHome();
        btnCancelar.getScene().getWindow().hide();

    }

    public void handleOnActionSalvar(ActionEvent actionEvent){
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into tarefa (tarefa) value (?)");
            statement.setString(1,tarefa.getText());
            statement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

        new AbreTela().TelaConsultar();
        btnSalvar.getScene().getWindow().hide();

    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;
import jdbc.GeraHash;

import java.sql.SQLException;

public class ControllerRegistrar {
    @FXML
    private Button btnRegistrarVoltarLogin;
    @FXML
    private TextField txRegistrarEmail;
    @FXML
    private TextField txRegistrarNome;
    @FXML
    private PasswordField psRegistrarSenha;
    @FXML
    private Button cadastrar;

    public ControllerRegistrar() {
    }

    public void handleOnActionRegistrarConfirmar(ActionEvent actionEvent){
        new ConnectionFactory().ExecSQLSemRetorno("INSERT INTO user (name, email, password) VALUE ('" + txRegistrarNome.getText() + "','" + txRegistrarEmail.getText() + "','" + GeraHash.gerarHash(psRegistrarSenha.getText()) + "')");

        System.out.println("Usuário " + txRegistrarNome.getText() + " registrado com sucesso.");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Registrado com sucesso.");

        alert.showAndWait();

        cadastrar.getScene().getWindow().hide();
        new AbreTela().TelaLogin();

    }

    public void handleOnActionRegistrarVoltar(ActionEvent actionEvent){
        btnRegistrarVoltarLogin.getScene().getWindow().hide();
        new AbreTela().TelaLogin();
    }
}

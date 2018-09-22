package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;
import jdbc.GeraHash;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerLogin {
    @FXML
    TextField txLoginUsuario;
    @FXML
    PasswordField psLoginSenha;

    public void handleOnActionLoginEntrar(ActionEvent actionEvent){
        try {
            ResultSet rs = new ConnectionFactory().ExecSQLComRetorno("SELECT email FROM user WHERE name = '" + txLoginUsuario.getText() + "' AND password = '" + GeraHash.gerarHash(psLoginSenha.getText()) + "'" );

            while (rs.next()) {
                if (!rs.getString(1).isEmpty()){
                    System.out.println("Você está logado com sucesso. Seu e-mail é o: " + rs.getString(1) + ".");

                    // Abrir tela home //
                    txLoginUsuario.getScene().getWindow().hide();
                    new AbreTela().TelaRegistrar();
                    return;
                    // Abrir tela home //
                }
            }

            System.out.println("Você errou sua senha ou seu nome. Tente novamente!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void onMouseClickedLoginRegistrar(MouseEvent mouseEvent){
        new AbreTela().TelaRegistrar();
        txLoginUsuario.getScene().getWindow().hide();
    }
}


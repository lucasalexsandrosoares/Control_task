package jdbc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AbreTela {
    public static Stage primaryStage;

    public void TelaLogin(){
        // Não alterar //
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ControlTask.fxml"));
            primaryStage.setTitle("ControlTask - Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TelaRegistrar(){
        AbreTela("fxml/ControlRegistrar.fxml","ControlTask - Registre-se");
    }

    public void TelaHome(){
        AbreTela("fxml/ControlHome.fxml","ControlTask - Inicio");
    }

    private void AbreTela(String caminho, String titulo){
        // Não alterar //
        try {
            Parent fx = FXMLLoader.load(getClass().getClassLoader().getResource(caminho));

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(fx));
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.layout.Pane;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;

import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ControllerConsultar implements Initializable {


    @FXML
    private Pane HomeConsultar;

    @FXML
    private TableView<Tarefas> tabela;
    @FXML
    private TableColumn tarefas;

    @FXML
    private final ObservableList<Tarefas> data =
            FXCollections.observableArrayList();



    public void handleOnActionCriarTarefa(ActionEvent actionEvent){
        new AbreTela().TelaCriarTarefa();
        HomeConsultar.getScene().getWindow().hide();
    }

    public void handleOnActionSair(){
        new AbreTela().TelaLogin();
        HomeConsultar.getScene().getWindow().hide();
    }
    public void handleOnActionExcluirTarefa(){
        new AbreTela().TelaExcluir();
        HomeConsultar.getScene().getWindow().hide();
    }
    public void handleOnActionTarefaFinalizada(){
        new AbreTela().TelaTarefaFinalizada();
        HomeConsultar.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Tarefas> listaTarefas = new ArrayList<Tarefas>();
        ConnectionFactory com = new ConnectionFactory();
        ResultSet resultado = com.ExecSQLComRetorno("select tarefa,data,hora from tarefa");

        try {
            while (resultado.next()) {
                Tarefas tarefa = new Tarefas();
                try {
                    tarefa.setTarefa(resultado.getString(1));
                    tarefa.setData(resultado.getString(2));
                    tarefa.setHora(resultado.getString(3));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                listaTarefas.add(tarefa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        data.addAll(listaTarefas);
        tabela.setItems(data);
    }
}

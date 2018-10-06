package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import jdbc.AbreTela;
import jdbc.ConnectionFactory;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import javafx.util.StringConverter;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;



public class ControllerCriarTarefa implements Initializable {

    @FXML
    private Button btnCancelar;
    @FXML
    private  Button btnSalvar;
    @FXML
    private TextField tarefa;
    @FXML
    public DatePicker datePicker;
    @FXML
    private TextField hora;


    public void handleOnActionCancelar(ActionEvent actionEvent){
        new AbreTela().TelaHome();
        btnCancelar.getScene().getWindow().hide();

    }

    public void handleOnActionSalvar(ActionEvent actionEvent){
        new ConnectionFactory().ExecSQLSemRetorno("insert into tarefa(tarefa,data,hora) value('" + tarefa.getText() + "','" + datePicker.getValue() + "','" + hora.getText() +"')");

        new AbreTela().TelaConsultar();
        btnSalvar.getScene().getWindow().hide();
            try{
                //Transforma em java.sql.Date, que permite inserir no Banco de Dados.
                Date dataSql = Date.valueOf(datePicker.getValue());
                System.out.println( dataSql);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                }else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        datePicker.setConverter(converter);
        datePicker.setPromptText("dd/MM/yyyy");
        // configura o valor inicial
        datePicker.setValue(LocalDate.now());
    }

}


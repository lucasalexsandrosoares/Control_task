package sample;


import javafx.beans.property.SimpleStringProperty;


public class Tarefas {

    private SimpleStringProperty tarefa;

    private SimpleStringProperty data;

    private SimpleStringProperty hora;

    public Tarefas(){
        tarefa = new SimpleStringProperty();
        data = new SimpleStringProperty();
        hora = new SimpleStringProperty();
    }

    public String getTarefa(){
        return tarefa.get();
    }

    public void setTarefa(String tarefa){
        this.tarefa.set(tarefa);
    }

    public String getData(){
        return data.get();
    }

    public SimpleStringProperty data(){return data;}

    public void setData(String data){this.data.set(String.valueOf(data));}

    public String getHora(){return hora.get();}

    public void setHora(String hora){this.hora.set(hora);}
}

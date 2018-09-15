package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jdbc.User;

public class UserDAO {

    // Insere um Usuário
    public void insert(User user) {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();
            PreparedStatement p =
                    conn.prepareStatement("insert into user(name,password) values(?, ?) ");
            p.setString(1, user.getName());
            p.setString(2, user.getPassword());

            p.execute();
            p.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //
    // Método para atualizar
    //

    //
    // Método para excluir um Usuário específico pelo Id
    //

    // Exclui todos os registros da Tabela
    public void deleteAll() {
        try {
            // Cria a conexão com o banco de dados
            Connection conn = (new ConnectionFactory()).getConnection();

            Statement stat = conn.createStatement();
            stat.execute("delete from user");
            // Fecha conexão com o banco de dados
            stat.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

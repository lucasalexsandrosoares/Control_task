package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbc.UserDAO;
import jdbc.User;

public class Main {

    public static void main(String[] args) {


        User user = new User();
        user.setName("Idris Elba");
        user.setPassword("Ragnarok");

        UserDAO userDAO = new UserDAO();
        //userDAO.deleteAll();
        userDAO.insert(user);

		/*
		try {
			Connection conn = DriverManager
					.getConnection(stringConexao
							, usuarioBD, senhaBD);
			Statement stat = conn.createStatement();
			stat.execute("delete from user");
			stat.close();

			PreparedStatement p =
					conn.prepareStatement("insert into user(name,password) values(?, ?) ");
			p.setString(1, "Tom");
			p.setString(2, "Senha123");

			p.execute();
			p.close();

			Statement query = conn.createStatement();

			ResultSet result = query.executeQuery("select user_id, name, password from user ");
			// Para cada registro do conjunto de resultado
			while(result.next()) {
				// Pega os valores de cada coluna
				long userId = result.getLong(1);
				String name = result.getString(2);
				String password = result.getString(3);
				System.out.println(userId+" "+name+" "+password);
			}
			result.close();
			query.close();

			//Fecha a conexão de bancos de dados
			conn.close();

		}catch (Exception e) {
			e.printStackTrace();
		}
		*/

    }

}


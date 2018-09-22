package jdbc;
import java.sql.*;

// Fábrica de conexão com o Banco de dados
public class ConnectionFactory {

    private static final  String stringConexao = "jdbc:mysql://localhost:3306/banco_de_dados?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String usuarioBD = "root";
    private static final String senhaBD = "070499";

    // Obtêm uma nova Conexão
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(stringConexao, usuarioBD, senhaBD);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void ExecSQLSemRetorno(String sql){
        try {
            Connection con = getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet ExecSQLComRetorno(String sql){
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            return ps.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}

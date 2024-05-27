
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco ","usuario", "senha");
            ResultSet rsBancoo = conexao.createStatement().executeQuery("SELECT * FROM BANCOO");
            while (rsBancoo.next()){
                System.out.println("Nome: " + rsBancoo.getString("nome"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Drive do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                conexao.close();
            }
        }
    }
}

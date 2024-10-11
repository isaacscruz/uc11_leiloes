
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    // Método para conectar ao banco de dados
    public Connection connectDB() {
        Connection conexao = null;
        String url = "jdbc:mysql://localhost:3306/uc11";  // URL do banco de dados
        String usuario = "root";  // Usuário do banco
        String senha = "is@@Cruz4096";  // Senha do banco

        try {
            // Tentar estabelecer a conexão
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao tentar conectar ao banco de dados.");
            e.printStackTrace();  // Exibe o erro no console para diagnóstico
        }

        return conexao;  // Retorna a conexão estabelecida
    }
}

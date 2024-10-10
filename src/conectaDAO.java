
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:127.0.0.1:3306/uc11";
        String usuario = "root";
        String senha = "is@@Cruz4096";
        
        try {
            // Tentativa de conexão
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            // Se chegar aqui, a conexão foi bem-sucedida
            System.out.println("Conexão estabelecida com sucesso!");
            
        } catch (SQLException e) {
            // Caso haja falha, captura e exibe a exceção
            System.out.println("Falha ao tentar conectar ao banco de dados.");
            e.printStackTrace();
        }
    }
}


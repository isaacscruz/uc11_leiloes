/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {

   Connection conn;
    PreparedStatement prep;
    ResultSet rs;

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos"; // Consulta SQL

        try {
            conn = new conectaDAO().connectDB(); // Conecta ao banco
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            // Itera sobre os resultados e cria objetos ProdutosDTO
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor"));
                produto.setStatus(rs.getString("status"));

                lista.add(produto); // Adiciona o produto na lista
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (prep != null) prep.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }

        return lista; // Retorna a lista de produtos
    }

    void cadastrarProduto(ProdutosDTO produto) {
    String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)"; // Consulta SQL

    try {
        conn = new conectaDAO().connectDB(); // Conecta ao banco
        prep = conn.prepareStatement(sql);
        
        // Define os parâmetros da consulta
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());

        prep.executeUpdate(); // Executa a atualização
        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
    } finally {
        try {
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}


  public void venderProduto(int produtoId) {
    String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?"; // SQL para atualizar o status
    try {
        conn = new conectaDAO().connectDB(); // Conecta ao banco
        prep = conn.prepareStatement(sql);
        prep.setInt(1, produtoId); // Define o ID do produto

        prep.executeUpdate(); // Executa a atualização
        JOptionPane.showMessageDialog(null, "Produto vendido com sucesso.");
    } catch (SQLException e) {
        System.out.println("Erro ao vender produto: " + e.getMessage());
    } finally {
        try {
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}

public ArrayList<ProdutosDTO> listarProdutosVendidos() {
    ArrayList<ProdutosDTO> listaVendidos = new ArrayList<>();
    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";
    
    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();
        
        while (rs.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getInt("valor"));
            produto.setStatus(rs.getString("status"));
            
            listaVendidos.add(produto);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao listar produtos vendidos: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
    
    return listaVendidos;
}
}
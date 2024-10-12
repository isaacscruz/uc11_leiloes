/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marcelo
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaVendas extends JFrame {

    private JTable tabelaProdutosVendidos;
    private JScrollPane scrollPane;

    public TelaVendas() {
        setTitle("Vendas");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tabelaProdutosVendidos = new JTable();
        tabelaProdutosVendidos.setModel(new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0));
        
        scrollPane = new JScrollPane(tabelaProdutosVendidos);
        add(scrollPane, BorderLayout.CENTER);

        carregarTabelaProdutosVendidos(); // Carrega os produtos vendidos
    }

    public void carregarTabelaProdutosVendidos() {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        ArrayList<ProdutosDTO> listaVendidos = produtosDAO.listarProdutosVendidos();
        
        DefaultTableModel model = (DefaultTableModel) tabelaProdutosVendidos.getModel();
        model.setNumRows(0); // Limpa a tabela antes de adicionar
        
        for (ProdutosDTO p : listaVendidos) {
            model.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getValor(),
                p.getStatus()
            });
        }
    }
}

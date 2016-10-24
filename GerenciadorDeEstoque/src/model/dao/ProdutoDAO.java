package model.dao;

import Conexao.ConexaoEstoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author naelio
 */

public class ProdutoDAO {
    
    private Connection con = null;

    public ProdutoDAO() {
        con = ConexaoEstoque.getConnection();
    }
   
    public boolean save(Produto produto){
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Produto (descricao,quantidade,preco,categoria) VALUES (?,?,?,?)";
        
        try {
            
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, produto.getDescricao());  
            stmt.setInt(2, produto.getQuantidade());    
            stmt.setFloat(3, produto.getPreco());       
            stmt.setString(4, produto.getCategoria());
          
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
           return false;
        }finally{
           ConexaoEstoque.closeConnection(con, stmt);
        }
    }    
    
    /* Retorna uma lista com o nome de todos os produtos
    que tem a mesma categoria em comum */  
    public ArrayList<String> ListaDeProdutosMesmaCategoria(String category){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Produto WHERE Categoria = '" + category + "'";
        ArrayList<String> Produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql); // preparo a sql
            rs = stmt.executeQuery();    
            while(rs.next())
                Produtos.add(rs.getString("descricao")); // Estou add cada produto encontrado na list
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro" + ex);
        }finally{
            ConexaoEstoque.closeConnection(con, stmt, rs);
        }        
        return Produtos;
    }
    
    public ResultSet BuscarTodosProdutos(){
       
       PreparedStatement stmt = null;
       ResultSet rs = null;
       String sql = "SELECT * FROM Produto";
       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }   
       return rs;
    }
    
    public ResultSet BuscarPorCategoria(String categoria){
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT *  FROM Produto where Categoria = '" + categoria + "'; ";
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }        
        return rs;
    }
    
}

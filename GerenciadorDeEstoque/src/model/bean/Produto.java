/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

public class Produto {
    
    private int id;
    private String descricao;
    private String categoria;
    private int quantidade;
    private float preco;
   
    
    public Produto(){
        
    }
    
    public Produto(String descricao, int qtd, float preco){
        this.descricao = descricao;
        this.quantidade = qtd;
        this.preco = preco;
        
    }
  
    public int getNome() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}

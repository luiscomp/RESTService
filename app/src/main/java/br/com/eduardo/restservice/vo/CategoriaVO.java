package br.com.eduardo.restservice.vo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by LuisEduardo on 26/04/2017.
 */
public class CategoriaVO {
    @SerializedName("nome")
    private String nome;
    @SerializedName("produtos")
    private ArrayList<ProdutoVO> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ProdutoVO> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<ProdutoVO> produtos) {
        this.produtos = produtos;
    }
}

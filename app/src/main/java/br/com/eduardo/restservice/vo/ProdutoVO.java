package br.com.eduardo.restservice.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LuisEduardo on 26/04/2017.
 */
public class ProdutoVO {
    @SerializedName("nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

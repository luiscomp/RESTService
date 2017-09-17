package br.com.eduardo.restservice.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LuisEduardo on 26/04/2017.
 */
public class UsuarioVO {
    @SerializedName("nome")
    private String nome;
    @SerializedName("login")
    private String login;
    @SerializedName("senha")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

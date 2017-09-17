package br.com.eduardo.restservice.httprequests;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuisEduardo on 26/04/2017.
 */
public class ResultRequest<TypeClass> {
    @SerializedName("codigo")
    private String codigo;
    @SerializedName("mensagem")
    private String mensagem;
    @SerializedName("objetoResposta")
    private TypeClass objetoResposta;
    @SerializedName("listaResposta")
    private ArrayList<TypeClass> listaResposta;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TypeClass getObjetoResposta() {
        return objetoResposta;
    }
    public void setObjetoResposta(TypeClass objetoResposta) {
        this.objetoResposta = objetoResposta;
    }

    public ArrayList<TypeClass> getListaResposta() {
        return listaResposta;
    }
    public void setListaResposta(ArrayList<TypeClass> listaResposta) {
        this.listaResposta = listaResposta;
    }
}

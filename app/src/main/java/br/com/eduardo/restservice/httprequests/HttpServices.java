package br.com.eduardo.restservice.httprequests;

import br.com.eduardo.restservice.vo.CategoriaVO;
import br.com.eduardo.restservice.vo.ProdutoVO;
import br.com.eduardo.restservice.vo.UsuarioVO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by LuisEduardo on 24/04/2017.
 */
public interface HttpServices {

    @POST("Usuario/Cadastrar")
    @Headers({ "Content-Type: application/json;charset=UTF-8", "Accept: application/json"})
    Call<ResultRequest<UsuarioVO>> cadastrarUsuario(@Body UsuarioVO usuario);

    @POST("Categoria/Recuperar")
    @Headers({ "Content-Type: application/json;charset=UTF-8", "Accept: application/json"})
    Call<ResultRequest<CategoriaVO>> recuperarCategoria(@Body CategoriaVO categoria);

    @POST("Produto/Listar")
    @Headers({ "Content-Type: application/json;charset=UTF-8", "Accept: application/json"})
    Call<ResultRequest<ProdutoVO>> recuperarListaProdutos(@Body ProdutoVO produto);
}

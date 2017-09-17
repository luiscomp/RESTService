package br.com.eduardo.restservice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.eduardo.restservice.R;
import br.com.eduardo.restservice.adapters.ProdutoRecycleViewAdapter;
import br.com.eduardo.restservice.httprequests.HttpServices;
import br.com.eduardo.restservice.httprequests.ServiceGenerator;
import br.com.eduardo.restservice.util.Util;
import br.com.eduardo.restservice.vo.CategoriaVO;
import br.com.eduardo.restservice.vo.ProdutoVO;
import br.com.eduardo.restservice.httprequests.ResultRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaActivity extends AppCompatActivity {

    @BindView(R.id.etCategoria) EditText etCategoria;
    @BindView(R.id.rvProdutos) RecyclerView rvProdutos;

    @OnClick(R.id.btnBuscar) void buscar() {
        CategoriaVO categoria = new CategoriaVO();
        categoria.setNome(etCategoria.getText().toString());

        ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
        ProdutoVO produto = null;
        for(int i = 1; i <= 10; i++) {
            produto = new ProdutoVO();
            produto.setNome("Pizza "+i);
            produtos.add(produto);
        }
        categoria.setProdutos(produtos);

        recuperarCategoria(categoria);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        ButterKnife.bind(this);

        Util.ocultarTecladoActivity(CategoriaActivity.this);

        instanciarLista();
        setarLista();

    }

    private void setarLista() {
        ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
        ProdutoVO produto = null;
        for(int i = 1; i <= 10; i++) {
            produto = new ProdutoVO();
            produto.setNome("Pizza "+i);
            produtos.add(produto);
        }

        ((ProdutoRecycleViewAdapter)rvProdutos.getAdapter()).atualizarData(produtos);
    }

    private void instanciarLista() {
        rvProdutos = (RecyclerView) findViewById(R.id.rvProdutos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CategoriaActivity.this, LinearLayoutManager.VERTICAL, false);
        rvProdutos.setLayoutManager(layoutManager);
        rvProdutos.setAdapter(new ProdutoRecycleViewAdapter());
    }

    private void recuperarCategoria(CategoriaVO categoria) {
        Util.exibirProgressDialog(CategoriaActivity.this, "Aguarde...");

        HttpServices services = ServiceGenerator.creativeService(HttpServices.class);
        Call<ResultRequest<CategoriaVO>> call = services.recuperarCategoria(categoria);

        call.enqueue(new Callback<ResultRequest<CategoriaVO>>() {
            @Override
            public void onResponse(Call<ResultRequest<CategoriaVO>> call, Response<ResultRequest<CategoriaVO>> response) {
                if (response.isSuccessful()) {
                    ResultRequest resultado = response.body();

                    setarValores(resultado);

                    Toast.makeText(CategoriaActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CategoriaActivity.this, "Falha", Toast.LENGTH_SHORT).show();
                }
                Util.fecharProgressDialog();
            }

            @Override
            public void onFailure(Call<ResultRequest<CategoriaVO>> call, Throwable t) {
                Util.fecharProgressDialog();
                Toast.makeText(CategoriaActivity.this, "Erro na chamada do servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setarValores(ResultRequest resultado) {
        CategoriaVO categoria = (CategoriaVO) resultado.getObjetoResposta();
        ((ProdutoRecycleViewAdapter)rvProdutos.getAdapter()).atualizarData(categoria.getProdutos());
    }
}

package br.com.eduardo.restservice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.eduardo.restservice.R;
import br.com.eduardo.restservice.adapters.ProdutoRecycleViewAdapter;
import br.com.eduardo.restservice.httprequests.HttpRequests;
import br.com.eduardo.restservice.httprequests.ServiceGenerator;
import br.com.eduardo.restservice.util.Util;
import br.com.eduardo.restservice.vo.ProdutoVO;
import br.com.eduardo.restservice.httprequests.ResultRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutoActivity extends AppCompatActivity {

    @BindView(R.id.rvProdutos) RecyclerView rvProdutos;

    @OnClick(R.id.btnBuscar) void buscar() {
        recuperarListaProdutos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        ButterKnife.bind(this);

        instanciarLista();
    }

    private void instanciarLista() {
        rvProdutos = (RecyclerView) findViewById(R.id.rvProdutos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProdutoActivity.this, LinearLayoutManager.VERTICAL, false);
        rvProdutos.setLayoutManager(layoutManager);
        rvProdutos.setAdapter(new ProdutoRecycleViewAdapter());
    }


    private void recuperarListaProdutos() {
        Util.exibirProgressDialog(ProdutoActivity.this, "Aguarde...");

        HttpRequests services = ServiceGenerator.creativeService(HttpRequests.class);
        Call<ResultRequest<ProdutoVO>> call = services.recuperarListaProdutos();

        call.enqueue(new Callback<ResultRequest<ProdutoVO>>() {
            @Override
            public void onResponse(Call<ResultRequest<ProdutoVO>> call, Response<ResultRequest<ProdutoVO>> response) {
                if (response.isSuccessful()) {
                    ResultRequest resultado = response.body();

                    setarValores(resultado);

                    Toast.makeText(ProdutoActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ProdutoActivity.this, "Falha", Toast.LENGTH_SHORT).show();
                }
                Util.fecharProgressDialog();
            }

            @Override
            public void onFailure(Call<ResultRequest<ProdutoVO>> call, Throwable t) {
                Util.fecharProgressDialog();
                Toast.makeText(ProdutoActivity.this, "Erro na chamada do servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setarValores(ResultRequest resultado) {
        ArrayList<ProdutoVO> listaProdutos = (ArrayList<ProdutoVO>) resultado.getListaResposta();
        ((ProdutoRecycleViewAdapter)rvProdutos.getAdapter()).atualizarData(listaProdutos);
    }
}

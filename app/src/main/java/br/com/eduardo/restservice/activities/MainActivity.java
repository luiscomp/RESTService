package br.com.eduardo.restservice.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.eduardo.restservice.R;
import br.com.eduardo.restservice.util.Util;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.btnRetornarObjeto) void retornarObjeto() {
        Intent intent = new Intent(MainActivity.this, UsuarioActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btnRetornarObjetoComLista) void retornarObjetoComLista() {
        Intent intent = new Intent(MainActivity.this, CategoriaActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btnRetornarLista) void retornarLista() {
        Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Util.ocultarTecladoActivity(MainActivity.this);
    }
}

package br.com.eduardo.restservice.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.eduardo.restservice.R;
import br.com.eduardo.restservice.httprequests.HttpServices;
import br.com.eduardo.restservice.httprequests.ServiceGenerator;
import br.com.eduardo.restservice.util.Util;
import br.com.eduardo.restservice.httprequests.ResultRequest;
import br.com.eduardo.restservice.vo.UsuarioVO;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuarioActivity extends AppCompatActivity {
    @BindView(R.id.etNome) EditText etNome;
    @BindView(R.id.etLogin) EditText etLogin;
    @BindView(R.id.etSenha) EditText etSenha;
    @BindView(R.id.tvCodigo) TextView tvCodigo;
    @BindView(R.id.tvMensagem) TextView tvMensagem;
    @BindView(R.id.tvNome) TextView tvNome;
    @BindView(R.id.tvLogin) TextView tvLogin;
    @BindView(R.id.tvSenha) TextView tvSenha;

    @OnClick(R.id.btnEnviar) void enviar() {
        UsuarioVO usuario = new UsuarioVO();
        usuario.setNome(etNome.getText().toString());
        usuario.setLogin(etLogin.getText().toString());
        usuario.setSenha(etSenha.getText().toString());

        cadastrarUsuario(usuario);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        ButterKnife.bind(this);

        Util.ocultarTecladoActivity(UsuarioActivity.this);
    }

    private void cadastrarUsuario(UsuarioVO usuario) {
        Util.exibirProgressDialog(UsuarioActivity.this, "Aguarde...");

        HttpServices services = ServiceGenerator.creativeService(HttpServices.class);
        Call<ResultRequest<UsuarioVO>> call = services.cadastrarUsuario(usuario);

        call.enqueue(new Callback<ResultRequest<UsuarioVO>>() {
            @Override
            public void onResponse(Call<ResultRequest<UsuarioVO>> call, Response<ResultRequest<UsuarioVO>> response) {
                if (response.isSuccessful()) {
                    ResultRequest resultado = response.body();

                    setarValores(resultado);

                    Toast.makeText(UsuarioActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UsuarioActivity.this, "Falha", Toast.LENGTH_SHORT).show();
                }
                Util.fecharProgressDialog();
            }

            @Override
            public void onFailure(Call<ResultRequest<UsuarioVO>> call, Throwable t) {
                Util.fecharProgressDialog();
                Toast.makeText(UsuarioActivity.this, "Erro na chamada do servidor", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setarValores(ResultRequest resultado) {
        tvCodigo.setText("Código: " + resultado.getCodigo());
        tvMensagem.setText("Resultado: " + resultado.getMensagem());

        UsuarioVO usuario = (UsuarioVO) resultado.getObjetoResposta();
        tvNome.setText("Nome: "+usuario.getNome());
        tvLogin.setText("Login: "+usuario.getLogin());
        tvSenha.setText("Senha: "+usuario.getSenha());
    }
}

package com.ddm.maincrud.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ddm.maincrud.R;
import com.ddm.maincrud.dto.DtoUser;
import com.ddm.maincrud.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroDeUsuarioActivity extends AppCompatActivity {

    private static final String TAG = "CadastroDeUsuarioActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_usuario);
    }

    public void cadastrar(View view) {
        String nome = ((EditText) findViewById(R.id.et_cadastro_usuario_nome)).getText().toString();
        String email = ((EditText) findViewById(R.id.et_cadastro_usuario_email)).getText().toString();
        String senha = ((EditText) findViewById(R.id.et_cadastro_usuario_password)).getText().toString();
        String telefone = ((EditText) findViewById(R.id.et_cadastro_usuario_phone)).getText().toString();

        DtoUser dtoUser = new DtoUser(email, nome, senha, telefone);

        RetrofitService.getServico(this).cadastrarUsuario(dtoUser).enqueue(new Callback<DtoUser>() {
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                Toast.makeText(CadastroDeUsuarioActivity.this, "Usuário cadastrado com ID: " + response.body().getId(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}

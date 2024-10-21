package com.example.clase1410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usuario, password;
    TextView resultado;
    ProgressBar pgB;
    Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.txtUsuario);
        password = findViewById(R.id.txtPassword);
        pgB = findViewById(R.id.progressBar);
        btnValidar = findViewById(R.id.btnEnviar);
        resultado = findViewById(R.id.lblResultado);
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskV().execute(usuario.getText().toString(), password.getText().toString());
            }
        });

    }

    class AsyncTaskV extends android.os.AsyncTask<String, Void, String >{

        @Override
        protected void onPreExecute() {
            pgB.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                Thread.sleep(5000);
                String userValido = "Carlos";
                String passValido = "pancho123";
                String userInput = strings[0];
                String passInput = strings[1];
                if (userInput.equals(userValido) && passInput.equals(passValido)) {
                    resultado.setText("Datos correctos");
                }else {
                    resultado.setText("Usuario/Contraseña incorrecto");
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pgB.setVisibility(View.INVISIBLE);
            btnValidar.setEnabled(true);
        }
    }
}
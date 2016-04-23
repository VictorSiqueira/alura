package com.cadastrocaelum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.cadastrocaelum.dao.AlunoDAO;
import com.cadastrocaelum.utils.helper.FormularioHelper;
import com.cadastrocaelum.utils.pojo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtSite;
    EditText edtEndereco;
    EditText edtTelefone;
    Button btnSalvar;
    RatingBar ratNota;
    FormularioHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        getElementsOfActivity();
        helper = new FormularioHelper(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAlunoFromFormularioActivity();
                AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
                dao.insere(aluno);
                dao.close();
                goToListAlunos();
            }
        });

    }

    private void goToListAlunos() {
        Intent i = new Intent(this,ListaAlunosAcitivty.class);
        startActivity(i);
        finish();
    }


    private void getElementsOfActivity() {
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtSite = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtNome);
        edtTelefone = (EditText)findViewById(R.id.edtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        ratNota = (RatingBar) findViewById(R.id.nota);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

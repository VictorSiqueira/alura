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

        //getElementsOfActivity();
        helper = new FormularioHelper(this);

        //recuperando dados que possam vir da tela de listagem e setando nos EditText
        final Aluno aluno2Update = (Aluno) getIntent().getSerializableExtra("aluno");
        if(aluno2Update != null){
            btnSalvar.setText("Alterar");
            helper.setAluno2UpdateOnFormulario(aluno2Update);
        }

        //Colocando um listener no botao salvar e dando um comportamento
        //diferente para cada ocasiao que pode variar entre salvar e dar update
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAlunoFromFormularioActivity();
                AlunoDAO dao = new AlunoDAO(FormularioActivity.this);
                if(aluno2Update != null){
                    aluno.setId(aluno2Update.getId());
                    dao.update(aluno);
                }else {
                    dao.insere(aluno);
                }
                dao.close();
                goToListAlunos();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * metodo para ir para a lista de Alunos de volta
     * atraves de uma intent
     */
    private void goToListAlunos() {
        Intent i = new Intent(this,ListaAlunosAcitivty.class);
        startActivity(i);
        finish();
    }

    /**
     * metodo para pegar todos os elementos da tela e seta-los nas
     * variaveis corretamente
     */
    private void getElementsOfActivity() {
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtSite = (EditText)findViewById(R.id.edtNome);
        edtEndereco = (EditText)findViewById(R.id.edtNome);
        edtTelefone = (EditText)findViewById(R.id.edtNome);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        ratNota = (RatingBar) findViewById(R.id.nota);
    }
}

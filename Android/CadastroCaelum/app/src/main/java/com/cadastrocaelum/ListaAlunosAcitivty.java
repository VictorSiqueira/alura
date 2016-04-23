package com.cadastrocaelum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.cadastrocaelum.dao.AlunoDAO;
import com.cadastrocaelum.utils.pojo.Aluno;

import java.util.List;

public class ListaAlunosAcitivty extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_acitivty);

        lista = (ListView)findViewById(R.id.lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosAcitivty.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaAlunosAcitivty.this, "Longo: "+ parent.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
                return true;//consome o evento de clique sozinho, não deixa o clique simples ser ativado
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> listaAlunos = dao.getAllAlunos();
        dao.close();
        //new ArrayAdapter<>(Contexto,layout da cedula, Array);
        final ArrayAdapter<Aluno> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listaAlunos); // modelo de cada item da tela
        lista.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meu_menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_novo :
                Intent i = new Intent(this,FormularioActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

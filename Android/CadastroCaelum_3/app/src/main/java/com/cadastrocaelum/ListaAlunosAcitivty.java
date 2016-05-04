package com.cadastrocaelum;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cadastrocaelum.dao.AlunoDAO;
import com.cadastrocaelum.utils.adapter.AlunoAdapter;
import com.cadastrocaelum.utils.asynctask.EnviaContatoTask;
import com.cadastrocaelum.utils.converter.AlunoConverter;
import com.cadastrocaelum.utils.pojo.Aluno;
import com.cadastrocaelum.utils.support.WebClient;

import java.util.List;

public class ListaAlunosAcitivty extends AppCompatActivity {
    ListView lista;
    Aluno aluno;
    List<Aluno> listaAlunos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_acitivty);

        lista = (ListView)findViewById(R.id.lista);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ListaAlunosAcitivty.this, "" + position, Toast.LENGTH_SHORT).show();
                Aluno aluno  = (Aluno)parent.getAdapter().getItem(position);
                gotToFormulario(aluno);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ListaAlunosAcitivty.this, "Longo: " + parent.getAdapter().getItem(position), Toast.LENGTH_SHORT).show();
                aluno = (Aluno)parent.getAdapter().getItem(position);
                return false;//consome o evento de clique sozinho, não deixa o clique simples ser ativado quando é true
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    /**
     * metodo para popular a lista de Alunos conforme os dados que
     * houverem no Banco de dados SQLite, apresentando cada item
     * seguindo o layout de item "simple_list_item_1", que pode ser
     * substituido por um xml personlaizado
     */
    private void carregaLista() {
        AlunoDAO dao = new AlunoDAO(this);
        listaAlunos = dao.getAllAlunos();
        dao.close();
        //new ArrayAdapter<>(Contexto,layout da cedula, Array);
        final AlunoAdapter adapter = new AlunoAdapter(this,listaAlunos); // modelo de cada item da tela
        getLayoutInflater();
        lista.setAdapter(adapter);
    }

    /**
     * Personalização do menu da ActionBar, utilizando um
     * XML para ciar a diagramacao e é disparado pelo inflater
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meu_menu_lista_alunos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Metodo para criar um comportamento para cada item do menu da Action
     * Bar personalizado, buscando a identificação deles declaradas no XML
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_novo :
                gotToFormulario(null);
                break;
            case R.id.menu_enviar_alunos:
                new EnviaContatoTask(this).execute();
                break;
            case R.id.menu_provas:
                Intent i = new Intent(this,ProvasActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * metodo que dispara uma intennt para o formulario quando um item
     * na lista é selecionado
     * @param aluno
     */
    private void gotToFormulario(Aluno aluno){
        Intent i = new Intent(this,FormularioActivity.class);
        if(aluno != null){
            i.putExtra("aluno",aluno);
        }
        startActivity(i);
    }

    /**
     * Metodo para criar um menu quando um item na lista é clicado longamente,
     * onde cada MenuItem é uma opção que irá aparecer, e aqui é setado
     * um listener de clique para ação. Obs.: vale notar que isso pode ser feito
     * com XML tambem
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(Intent.ACTION_CALL);
                /*forma para passar a OS o que vc quer e recebe uma URI
                para setar a URI e ela saber que é um telefone, precisa
                por "tel:" como prefixo*/
                Uri tel = Uri.parse("tel:"+aluno.getTelefone());
                i.setData(tel);
                startActivity(i);
                return false;
            }
        });
        MenuItem enviarSms = menu.add("Enviar SMS");
        MenuItem acharMapa = menu.add("Achar no mapa");
        MenuItem irNoSite = menu.add("Navegar no Site");
        irNoSite.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri web = Uri.parse("http://"+aluno.getSite());
                i.setData(web);
                startActivity(i);
                return false;
            }
        });
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AlunoDAO dao = new AlunoDAO(ListaAlunosAcitivty.this);
                dao.deletar(aluno);
                dao.close();
                carregaLista();
                return false;
            }
        });
        MenuItem enviarEmail = menu.add("Enviar E-mail");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}

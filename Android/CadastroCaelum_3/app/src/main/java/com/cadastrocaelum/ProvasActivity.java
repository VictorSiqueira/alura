package com.cadastrocaelum;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cadastrocaelum.utils.fragments.DetalhesProvaFragments;
import com.cadastrocaelum.utils.fragments.ListaProvasFragments;
import com.cadastrocaelum.utils.pojo.Prova;

public class ProvasActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);
        //getSupport por causa do v$ de suporte que ta sendo usado
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();

        if(verifyOrientarion()){
            tx.replace(R.id.frame_detalhe_provas,new DetalhesProvaFragments());
        }

        //precisa colocar para manipular
        tx.replace(R.id.frame_lista_provas, new ListaProvasFragments());
        tx.commit();//para dar "ok"
    }

    private boolean verifyOrientarion() {
        //xml criado para verificar orientação
        return getResources().getBoolean(R.bool.isLand);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_provas, menu);
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

    //prova que sera usada nos fragments
    public void selecionaProva(Prova provaSelecionada){
        Bundle cabide = new Bundle();
        cabide.putSerializable("prova",provaSelecionada);// equivalente ao putExtras
        DetalhesProvaFragments detalhes = new DetalhesProvaFragments();
        //passo o "cabide"
        detalhes.setArguments(cabide);

        //atualizo o detalhes
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        if(verifyOrientarion()){
            tx.replace(R.id.frame_detalhe_provas,detalhes);
        }
        tx.commit();
    }
}

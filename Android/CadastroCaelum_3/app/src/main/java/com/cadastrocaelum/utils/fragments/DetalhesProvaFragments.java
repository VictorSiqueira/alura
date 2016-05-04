package com.cadastrocaelum.utils.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cadastrocaelum.R;
import com.cadastrocaelum.utils.pojo.Prova;

/**
 * Created by Victor on 03/05/2016.
 */
public class DetalhesProvaFragments extends Fragment {
    private Prova prova;
    private TextView materia;
    private TextView data;
    private ListView topicos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View layout = inflater.inflate(R.layout.prova_detalhe, container, false);

        //pega a prova vindo de outro fragment
        if(getArguments() != null){
            prova = (Prova) getArguments().getSerializable("prova");
        }

        buscaComponentes(layout);
        populaCamposComDadosDaProva();

        return layout;
    }

    //insere dados no
    private void populaCamposComDadosDaProva(){
        if(prova != null){
            this.materia.setText(prova.getMateria());
            this.data.setText(prova.getData());

            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_list_item_1,
                            prova.getTopicos());

            this.topicos.setAdapter(adapter);
        }
    }

    //busca elementos do XML
    private void buscaComponentes(View layout){
        this.materia = (TextView) layout.findViewById(
                R.id.detalhe_prova_materia);
        this.data = (TextView) layout.findViewById(
                R.id.detalhe_prova_data);
        this.topicos = (ListView) layout.findViewById(
                R.id.detalhe_prova_topicos);
    }

}
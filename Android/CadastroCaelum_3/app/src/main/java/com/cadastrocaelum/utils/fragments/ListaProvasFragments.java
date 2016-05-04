package com.cadastrocaelum.utils.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cadastrocaelum.ProvasActivity;
import com.cadastrocaelum.R;
import com.cadastrocaelum.utils.pojo.Prova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Victor on 03/05/2016.
 */
public class ListaProvasFragments extends Fragment {
    @Nullable
    @Override //metodo que serve para vincular um layout a esse fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate(xml, view "pai", false);
        View layout = inflater.inflate(R.layout.fragment_lista_provas, container, false);
        ListView listaProvas =  (ListView)layout.findViewById(R.id.lista_provas);

        Prova prova1 = new Prova("17/03/2016","Matematica");
        prova1.setTopicos(Arrays.asList("Algebra", "Geometria", "calculo"));

        Prova prova2 = new Prova("18/12/2016","Portugues");
        prova1.setTopicos(Arrays.asList("Sintaxe", "Literatura"));

        List<Prova> provas = new ArrayList<>();
        provas.add(prova1);
        provas.add(prova2);

        //pegando a activity que chama o fragment
        ArrayAdapter adapter = new ArrayAdapter<Prova>(getActivity(),android.R.layout.simple_list_item_1, provas);

        listaProvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Prova item = (Prova)adapter.getItemAtPosition(position);
                ProvasActivity provasActivity = (ProvasActivity)getActivity();
            }
        });

        listaProvas.setAdapter(adapter);
        return layout;
    }
}

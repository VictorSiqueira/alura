package com.cadastrocaelum.utils.fragments;

import com.cadastrocaelum.dao.AlunoDAO;
import com.cadastrocaelum.utils.pojo.Aluno;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by Victor on 07/05/2016.
 */
public class MapFragment extends SupportMapFragment {

    @Override
    public void onResume() {
        super.onResume();
        Localizador localizador = new Localizador(getActivity());// para pegar contexto da activity mae
        LatLng local = localizador.getCoordenada("Rua Vergueiro, 3185, Vila Mariana");
        centraliza(local);

        AlunoDAO dao = new AlunoDAO(getActivity());
        List<Aluno> alunos = dao.getAllAlunos();
        for(Aluno aluno : alunos){
            if(aluno.getEndereco()!=null){
                LatLng coordenada = localizador.getCoordenada(aluno.getEndereco());
                if (coordenada != null){
                    MarkerOptions marcador = new MarkerOptions()
                            .position(coordenada)
                            .title(aluno.getNome())
                            .snippet(aluno.getEndereco());//balaozinho
                    getMap().addMarker(marcador);
                }
            }
        }
    }

    public void centraliza (LatLng local){
        GoogleMap map = getMap();
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 17));
    }
}

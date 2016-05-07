package com.cadastrocaelum.utils.fragments;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 07/05/2016.
 */
public class Localizador {

    private Geocoder geocoder;

    public Localizador(Context context) {
        geocoder = new Geocoder(context);
    }

    public LatLng getCoordenada(String s) {
        try {
            List<Address> enderecos = geocoder.getFromLocationName(s,1); //endereco, quantida, organixados por releveancia
            if(!enderecos.isEmpty()){
                Address endereco = enderecos.get(0);
                return new LatLng(endereco.getLatitude(),endereco.getLongitude());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.cadastrocaelum.utils.support;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import com.cadastrocaelum.utils.fragments.MapFragment;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by Victor on 08/05/2016.
 */
public class AtualizadorDeLocalizacao implements LocationListener {
    LocationManager locationManager;
    private GoogleApiClient client;
    private LocationRequest mLocationRequest;
    private MapFragment mapa;

    public AtualizadorDeLocalizacao(Context context, MapFragment mapa) {
        this.mapa = mapa;


        Configurador config = new Configurador(this);
        this.client = new GoogleApiClient.Builder(context)//entra no lugar do LocationClient
                .addApi(LocationServices.API)
                .addConnectionCallbacks(config)
               // .addOnConnectionFailedListener(null)//tratamento para nao existencia do play services
                .build();
        this.client.connect();
    }

    public void inicia(LocationRequest request) {
        LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);
    }

    public void cancela() {
        LocationServices.FusedLocationApi.removeLocationUpdates(client, this);
        this.client.disconnect();
    }

    @Override
    public void onLocationChanged(Location location) {
        LatLng local = new LatLng( location.getLatitude(), location.getLongitude());
        mapa.centraliza(local);
    }
}

package com.cadastrocaelum.utils.support;

import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

/**
 * Created by Victor on 08/05/2016.
 * classe para conexao com o play services, usada na classe AtualizadorDeLocalizacao
 */
public class Configurador implements GoogleApiClient.ConnectionCallbacks {

    private final AtualizadorDeLocalizacao atualizadorDeLocalizacao;

    public Configurador(AtualizadorDeLocalizacao atualizadorDeLocalizacao) {
        this.atualizadorDeLocalizacao = atualizadorDeLocalizacao;
    }

    @Override
    public void onConnected(Bundle bundle) {
        LocationRequest request = LocationRequest.create();
        request.setInterval(2000);//obter posicao por tinvervalo em milis
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);//precisao consumindo gastando mediano a precisao
        request.setSmallestDisplacement(50);
        //obter posicao por diferenca de posicao em metros, esse cara concorre com o interval
        //é bastante usando quando esta andando, e aparece quem disparar primeiro, ele ou Interval

        atualizadorDeLocalizacao.inicia(request);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}

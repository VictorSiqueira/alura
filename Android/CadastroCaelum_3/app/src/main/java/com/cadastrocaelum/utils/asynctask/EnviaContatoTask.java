package com.cadastrocaelum.utils.asynctask;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.cadastrocaelum.dao.AlunoDAO;
import com.cadastrocaelum.utils.converter.AlunoConverter;
import com.cadastrocaelum.utils.pojo.Aluno;
import com.cadastrocaelum.utils.support.WebClient;

import java.util.List;

/**
 * Created by Victor on 01/05/2016.
 */

//AsyncTask<Object,Object,Retorn DoInBackground>
public class EnviaContatoTask extends AsyncTask<Object,Object,String> {
    private  Context ctx;
    private ProgressDialog progess;

    public EnviaContatoTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //ProgressDialog.show(contexto,title,message);
        progess = ProgressDialog.show(ctx,"Aguarde...","Enviando dados dos alunos.");

    }

    @Override
    protected String doInBackground(Object... params) {
        AlunoDAO dao = new AlunoDAO(ctx);
        List<Aluno> alunos = dao.getAllAlunos();
        dao.close();
        String json = new AlunoConverter().toJson(alunos);
        String media = new WebClient("http://www.caelum.com.br/mobile").post(json);
        return media;
    }

    @Override
    //o retorno desse metodo e sempre igual ao retorno do doInBackground
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progess.dismiss();
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
}

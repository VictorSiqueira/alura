package com.cadastrocaelum.utils.converter;

import com.cadastrocaelum.utils.pojo.Aluno;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.List;

/**
 * Created by Victor on 01/05/2016.
 */
public class AlunoConverter {
    public String toJson(List<Aluno> alunos) {
        JSONStringer js = new JSONStringer();
        try {
            js.object().key("list").array();
            js.object().key("aluno").array();

            for(Aluno aluno : alunos){
                js.object();
                js.key("nome").value(aluno.getNome());
                js.key("nota").value(aluno.getNota());
                js.key("endereco").value(aluno.getEndereco());
                js.key("caminhoFoto").value(aluno.getFoto());
                js.key("site").value(aluno.getSite());
                js.key("telefone").value(aluno.getTelefone());
                js.endObject();// toda vez que termoianr de inputar dados de um json precisa fecha-lo
            }

            js.endArray();//array de aluno
            js.endObject();
            js.endArray();//array de list
            js.endObject();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return js.toString();
    }
}

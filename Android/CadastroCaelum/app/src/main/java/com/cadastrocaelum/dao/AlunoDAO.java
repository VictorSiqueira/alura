package com.cadastrocaelum.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cadastrocaelum.utils.pojo.Aluno;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor on 23/04/2016.
 */
public class AlunoDAO extends SQLiteOpenHelper{
    private static final String DATABASE = "NomeDoBanco";
    private static final Integer VERSAO = 1;
    private static final String TABELA = "Alunos";

    public AlunoDAO(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "telefone TEXT, " +
                "endereco TEXT, " +
                "site TEXT, " +
                "nota REAL, " +
                "caminhoFoto TEXT );";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA +";";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Aluno aluno) {
        ContentValues contentValues = new ContentValues(); //faz o mesmo papel que o hibernate
        contentValues.put("nome",aluno.getNome());
        contentValues.put("telefone",aluno.getTelefone());
        contentValues.put("endereco",aluno.getEndereco());
        contentValues.put("site",aluno.getSite());
        contentValues.put("nota",aluno.getNota());
        contentValues.put("caminhoFoto", "--");
        //insert(nome da tabela, valor a ser inserido se alguma linha for nula, contentValues com o que vai ser inserido);
        getWritableDatabase().insert(TABELA, null, contentValues);
    }

    public List<Aluno> getAllAlunos() {
        String sql = "SELECT * FROM "+ TABELA+ ";";
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        List<Aluno> lista = new ArrayList<>();
        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();
            aluno.setId(cursor.getInt(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setFoto(cursor.getString(cursor.getColumnIndex("caminhoFoto")));
            aluno.setNota(cursor.getFloat(cursor.getColumnIndex("nota")));
            lista.add(aluno);
        }
        return lista;
    }

    public void deletar(Aluno aluno) {
        String[] args = {aluno.getId().toString()};
        //delete(TABELA,WHERE,VALORES DO WHERE);
        getWritableDatabase().delete(TABELA,"id=?",args);
    }

    public void update(Aluno aluno) {
        ContentValues contentValues = new ContentValues(); //faz o mesmo papel que o hibernate
        contentValues.put("nome",aluno.getNome());
        contentValues.put("telefone",aluno.getTelefone());
        contentValues.put("endereco",aluno.getEndereco());
        contentValues.put("site",aluno.getSite());
        contentValues.put("nota",aluno.getNota());
        contentValues.put("caminhoFoto", "--");
        //insert(nome da tabela, valores para atualizar ,qual ocorrencia quer atualizar, );
        String[] args = {aluno.getId().toString()};
        getWritableDatabase().update(TABELA, contentValues , "id=?", args);
    }
}

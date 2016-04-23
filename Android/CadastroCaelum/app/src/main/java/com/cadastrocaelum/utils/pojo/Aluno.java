package com.cadastrocaelum.utils.pojo;

/**
 * Created by Victor on 23/04/2016.
 */
public class Aluno {
    private Integer id;
    private String nome;
    private String site;
    private String endereco;
    private String telefone;
    private Float nota;
    private String foto;

    public Aluno() {
    }
    public Aluno(String nome, String site, String endereco, String telefone, Float nota) {
        this.nome = nome;
        this.site = site;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Float getNota() {
        return nota;
    }
    public void setNota(Float nota) {
        this.nota = nota;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return this.id +" - "+ this.nome;
    }
}

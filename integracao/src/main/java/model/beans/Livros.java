package model.beans;

import java.sql.Date;

public class Livros {

    private int id;
    private String titulo;
    private String autor;
    private int unidades;
    private Date data_publicacao;

    public Livros() {
    }

    public Livros(int id, String titulo, String autor, int unidades, Date data_publicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.unidades = unidades;
        this.data_publicacao = data_publicacao;
    }



    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getUnidades() {
        return unidades;
    }

    public Date getData_publicacao() {
        return data_publicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setData_publicacao(Date data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
    
    

    
}

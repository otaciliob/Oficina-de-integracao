package model.beans;

public class Livros {

    private int id;
    private String titulo;
    private String autor;
    private int unidades;
    private int data_publicacao;

    public Livros() {
    }

    public Livros(int id, String titulo, String autor, int unidades, int data_publicacao) {
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

    public int getData_publicacao() {
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

    public void setData_publicacao(int data_publicacao) {
        this.data_publicacao = data_publicacao;
    }
    
    

    
}

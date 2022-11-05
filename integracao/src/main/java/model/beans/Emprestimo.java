package model.beans;

import java.sql.Date;

public class Emprestimo {
    
    private String livro_id;
    private int leitor_rg;
    private Date data_devolucao;

    public Emprestimo() {
    }

    public Emprestimo(String livro_id, int leitor_rg, Date data_devolucao) {
        this.livro_id = livro_id;
        this.leitor_rg = leitor_rg;
        this.data_devolucao = data_devolucao;
    }

    public String getLivro_id() {
        return livro_id;
    }

    public int getLeitor_rg() {
        return leitor_rg;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setLivro_id(String livro_id) {
        this.livro_id = livro_id;
    }

    public void setLeitor_rg(int leitor_rg) {
        this.leitor_rg = leitor_rg;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
    
    
}

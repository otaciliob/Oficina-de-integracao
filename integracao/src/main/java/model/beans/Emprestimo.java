package model.beans;

import java.sql.Date;

public class Emprestimo {
    
    private int livro_id;
    private int leitor_rg;
    private Date data_devolucao;

    public Emprestimo() {
    }

    public Emprestimo(int livro_id, int leitor_rg, Date data_devolucao) {
        this.livro_id = livro_id;
        this.leitor_rg = leitor_rg;
        this.data_devolucao = data_devolucao;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public int getLeitor_rg() {
        return leitor_rg;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public void setLeitor_rg(int leitor_rg) {
        this.leitor_rg = leitor_rg;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
    
    
}

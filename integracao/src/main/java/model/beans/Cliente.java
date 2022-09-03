package model.beans;

public class Cliente {
    
    private String rg;
    private String nome;
    private String email;

    public Cliente() {
    }

    public Cliente(String rg, String nome, String email) {
        this.rg = rg;
        this.nome = nome;
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

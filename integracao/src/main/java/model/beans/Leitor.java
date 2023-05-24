package model.beans;

import control.Validator;

public class Leitor {
    
    private int rg;
    private String nome;
    private String email;

    public Leitor() {
    }

    public Leitor(int rg, String nome, String email) {
        this.rg = rg;
        this.nome = nome;
        this.email = email;
    }

    public int getRg() {
        return rg;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean validateRG(int rg){
        return Validator.validateRG(String.valueOf(rg));
    }
    
    
}

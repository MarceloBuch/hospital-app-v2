package com.example.hospital;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String nome;
    private String CPF;
    private String fone;
    private String numCon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNumCon() {
        return numCon;
    }

    public void setNumCon(String numCon) {
        this.numCon = numCon;
    }
}


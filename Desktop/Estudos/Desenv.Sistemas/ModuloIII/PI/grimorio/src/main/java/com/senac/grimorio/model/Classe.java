/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.grimorio.model;

public class Classe {
    private int idClasse;
    private String nomeClasse;
    private String descricaoClasse;

    public Classe() {
    }
    
    public Classe(int idClasse, String nomeClasse, String descricaoClasse) {
        this.idClasse = idClasse;
        this.nomeClasse = nomeClasse;
        this.descricaoClasse = descricaoClasse;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getDescricaoClasse() {
        return descricaoClasse;
    }

    public void setDescricaoClasse(String descricaoClasse) {
        this.descricaoClasse = descricaoClasse;
    }
    
}

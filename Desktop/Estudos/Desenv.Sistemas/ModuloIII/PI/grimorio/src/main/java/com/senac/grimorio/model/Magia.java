/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.grimorio.model;

public class Magia {
    private int idMagia;
    private String nomeMagia;
    private String nivel;
    private int idClasse;
    private String tipo;
    private String descricao;
    private String tempConjuarcao;
    private String alcance;
    private String componentes;
    private String duracao;
    private int idDado;

    public Magia() {
    }
    
    public Magia(int idMagia, String nomeMagia, String nivel, int idClasse, String tipo, String descricao, String tempConjuarcao, String alcance, String componentes, String duracao, int idDado) {
        this.idMagia = idMagia;
        this.nomeMagia = nomeMagia;
        this.nivel = nivel;
        this.idClasse = idClasse;
        this.tipo = tipo;
        this.descricao = descricao;
        this.tempConjuarcao = tempConjuarcao;
        this.alcance = alcance;
        this.componentes = componentes;
        this.duracao = duracao;
        this.idDado = idDado;
    }

    public int getIdMagia() {
        return idMagia;
    }

    public void setIdMagia(int idMagia) {
        this.idMagia = idMagia;
    }

    public String getNomeMagia() {
        return nomeMagia;
    }

    public void setNomeMagia(String nomeMagia) {
        this.nomeMagia = nomeMagia;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempConjuarcao() {
        return tempConjuarcao;
    }

    public void setTempConjuarcao(String tempConjuarcao) {
        this.tempConjuarcao = tempConjuarcao;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getIdDado() {
        return idDado;
    }

    public void setIdDado(int idDado) {
        this.idDado = idDado;
    } 
}

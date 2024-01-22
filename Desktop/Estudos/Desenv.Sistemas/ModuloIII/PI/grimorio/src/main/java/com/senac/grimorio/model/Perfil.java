/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.grimorio.model;

public class Perfil{
    protected int idPerfil;
    protected String nomePerfil;
    protected int idClasse;
    protected int idRaca;
    protected int nivelPersonagem;
    protected int idUsuario;
    protected int idConta;
    protected String caminhoImagem;

    public Perfil() {
    }

    public Perfil(int idPerfil, String nomePerfil, int idClasse, int idRaca, int nivelPersonagem, int idUsuario, int idConta, String caminhoImagem) {
        this.idPerfil = idPerfil;
        this.nomePerfil = nomePerfil;
        this.idClasse = idClasse;
        this.idRaca = idRaca;
        this.nivelPersonagem = nivelPersonagem;
        this.idUsuario = idUsuario;
        this.idConta = idConta;
        this.caminhoImagem = caminhoImagem;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

    public int getNivelPersonagem() {
        return nivelPersonagem;
    }

    public void setNivelPersonagem(int nivelPersonagem) {
        this.nivelPersonagem = nivelPersonagem;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }      
}

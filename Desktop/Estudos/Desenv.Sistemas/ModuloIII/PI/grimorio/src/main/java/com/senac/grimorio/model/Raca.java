/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.grimorio.model;

public class Raca {
    private int idRaca;
    private String nomeRaca;
    private String descricaoRaca;

    public Raca() {
    }

    public Raca(int idRaca, String nomeRaca, String descricaoRaca) {
        this.idRaca = idRaca;
        this.nomeRaca = nomeRaca;
        this.descricaoRaca = descricaoRaca;
    }

    public int getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(int idRaca) {
        this.idRaca = idRaca;
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    public String getDescricaoRaca() {
        return descricaoRaca;
    }

    public void setDescricaoRaca(String descricaoRaca) {
        this.descricaoRaca = descricaoRaca;
    }
}

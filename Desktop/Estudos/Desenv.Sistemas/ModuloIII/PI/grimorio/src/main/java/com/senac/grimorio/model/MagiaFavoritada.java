package com.senac.grimorio.model;

public class MagiaFavoritada{
    private int idMagiaFavoritada;
    private int idMagia;
    private final int slotMax = 6;
    private int slotAtual;
    private int idPerfil;
    private int idUsuario;

    public MagiaFavoritada() {
    }

    public MagiaFavoritada(int idMagiaFavoritada, int idMagia, int slotAtual, int idPerfil, int idUsuario) {
        this.idMagiaFavoritada = idMagiaFavoritada;
        this.idMagia = idMagia;
        this.slotAtual = slotAtual;
        this.idPerfil = idPerfil;
        this.idUsuario = idUsuario;
    }

    public int getIdMagiaFavoritada() {
        return idMagiaFavoritada;
    }

    public void setIdMagiaFavoritada(int idMagiaFavoritada) {
        this.idMagiaFavoritada = idMagiaFavoritada;
    }

    public int getIdMagia() {
        return idMagia;
    }

    public void setIdMagia(int idMagia) {
        this.idMagia = idMagia;
    }

    public int getSlotAtual() {
        return slotAtual;
    }

    public void setSlotAtual(int slotAtual) {
        this.slotAtual = slotAtual;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean adicionaSlot(int slot) {
        if (slot <= 0 || slotAtual + slot > slotMax) {
            return false; // Não é possível adicionar mais slots
        }
        slotAtual += slot;
        return true; // Slots adicionados com sucesso
    }

    public boolean removeSlot(int slot) {
        if (slot <= 0 || slotAtual - slot < 0) {
            return false; // Não é possível remover mais slots
        }
        slotAtual -= slot;
        return true; // Slots removidos com sucesso
    }
}

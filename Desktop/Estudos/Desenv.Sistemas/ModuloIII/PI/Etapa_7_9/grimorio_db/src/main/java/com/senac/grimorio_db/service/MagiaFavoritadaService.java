package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.MagiaFavoritada;
import com.senac.grimorio_db.repository.MagiaFavoritadaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class MagiaFavoritadaService {
   @Autowired 
   MagiaFavoritadaRepository magiaFavoritadaRepository;  //chama repositorio 
    
    //CRUD
    
    public List<MagiaFavoritada> listarTodos(){
        return magiaFavoritadaRepository.findAll();
    }
    
    public MagiaFavoritada buscarPorId(Integer id){
        return magiaFavoritadaRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        MagiaFavoritada encontrado = buscarPorId(id);
        magiaFavoritadaRepository.deleteById(encontrado.getIdMagiaFavoritada());
    }
    
    public MagiaFavoritada criar(MagiaFavoritada magiaFavoritada){
        magiaFavoritada.setIdMagiaFavoritada(null);
        magiaFavoritadaRepository.save(magiaFavoritada);
        return magiaFavoritada;
    }
    
    public MagiaFavoritada atualizar(Integer id, MagiaFavoritada enviado){
        MagiaFavoritada encontrado = buscarPorId(id);
        encontrado.setMagia(enviado.getMagia());
        encontrado.setSlotAtual(enviado.getSlotAtual());
        encontrado.setPerfil(enviado.getPerfil());
        encontrado.setUsuario(enviado.getUsuario());
        magiaFavoritadaRepository.save(encontrado);
        return encontrado;
    }
    
    public void excluirPorIdPerfil(Integer idPerfil) {
        magiaFavoritadaRepository.findByPerfil_IdPerfil(idPerfil);
        
    }
    
    public List<MagiaFavoritada> buscarMagiasFavoritadasPorPerfil(Integer idPerfil) {
        return magiaFavoritadaRepository.findByPerfil_IdPerfil(idPerfil);
    }
}
    
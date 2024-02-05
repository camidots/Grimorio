package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Magia;
import com.senac.grimorio_db.repository.MagiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class MagiaService {
   @Autowired 
   MagiaRepository magiaRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Magia> listarTodos(){
        return magiaRepository.findAll();
    }
    
    public Magia buscarPorId(Integer id){
        return magiaRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Magia encontrado = buscarPorId(id);
        magiaRepository.deleteById(encontrado.getIdMagia());
    }
    
    public Magia criar(Magia magia){
        magia.setIdMagia(null);
        magiaRepository.save(magia);
        return magia;
    }
    
    public Magia atualizar(Integer id, Magia enviado){
        Magia encontrado = buscarPorId(id);
        encontrado.setNomeMagia(enviado.getNomeMagia());
        encontrado.setNivel(enviado.getNivel());
        encontrado.setTipo(enviado.getTipo());
        encontrado.setTempConjuracao(enviado.getTempConjuracao());
        encontrado.setAlcance(enviado.getAlcance());
        encontrado.setComponentes(enviado.getComponentes());
        encontrado.setDuracao(enviado.getDuracao());
        encontrado.setDescricao(enviado.getDescricao());
        magiaRepository.save(encontrado);
        return encontrado;
    }
}
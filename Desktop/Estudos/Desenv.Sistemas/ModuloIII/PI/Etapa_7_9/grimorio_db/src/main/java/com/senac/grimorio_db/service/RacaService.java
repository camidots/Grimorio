package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Raca;
import com.senac.grimorio_db.repository.RacaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class RacaService {
   @Autowired 
   RacaRepository racaRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Raca> listarTodos(){
        return racaRepository.findAll();
    }
    
    public Raca buscarPorId(Integer id){
        return racaRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Raca encontrado = buscarPorId(id);
        racaRepository.deleteById(encontrado.getIdRaca());
    }
    
    public Raca criar(Raca raca){
        raca.setIdRaca(null);
        racaRepository.save(raca);
        return raca;
    }
    
    public Raca atualizar(Integer id, Raca enviado){
        Raca encontrado = buscarPorId(id);
        encontrado.setNomeRaca(enviado.getNomeRaca());
        encontrado.setDescricaoRaca(enviado.getDescricaoRaca());
        racaRepository.save(encontrado);
        return encontrado;
    }
}
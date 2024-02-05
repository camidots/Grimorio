package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Perfil;
import com.senac.grimorio_db.repository.PerfilRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class PerfilService {
   @Autowired 
   PerfilRepository perfilRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Perfil> listarTodos(){
        return perfilRepository.findAll();
    }
    
    public Perfil buscarPorId(Integer id){
        return perfilRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Perfil encontrado = buscarPorId(id);
        perfilRepository.deleteById(encontrado.getIdPerfil());
    }
    
    public Perfil criar(Perfil perfil){
        perfil.setIdPerfil(null);
        perfilRepository.save(perfil);
        return perfil;
    }
    
    public Perfil atualizar(Integer id, Perfil enviado){
        Perfil encontrado = buscarPorId(id);
        encontrado.setNomePerfil(enviado.getNomePerfil());
        encontrado.setClasse(enviado.getClasse());
        encontrado.setIdPerfil(enviado.getIdPerfil());
        encontrado.setRaca(enviado.getRaca());
        encontrado.setUsuario(enviado.getUsuario());
        encontrado.setConta(enviado.getConta());
        encontrado.setNivelPersonagem(enviado.getNivelPersonagem());
        encontrado.setCaminhoImagem(enviado.getCaminhoImagem());   
        perfilRepository.save(encontrado);
        return encontrado;
    }
}

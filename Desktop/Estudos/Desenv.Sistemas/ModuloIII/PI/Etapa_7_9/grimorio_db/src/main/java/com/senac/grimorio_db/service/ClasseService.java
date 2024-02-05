package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Classe;
import com.senac.grimorio_db.repository.ClasseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class ClasseService {
   @Autowired 
   ClasseRepository classeRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Classe> listarTodos(){
        return classeRepository.findAll();
    }
    
    public Classe buscarPorId(Integer id){
        return classeRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Classe encontrado = buscarPorId(id);
        classeRepository.deleteById(encontrado.getIdClasse());
    }
    
    public Classe criar(Classe classe){
        classe.setIdClasse(null);
        classeRepository.save(classe);
        return classe;
    }
    
    public Classe atualizar(Integer id, Classe enviado){
        Classe encontrado = buscarPorId(id);
        encontrado.setNomeClasse(enviado.getNomeClasse());
        encontrado.setDescricaoClasse(enviado.getDescricaoClasse());
        classeRepository.save(encontrado);
        return encontrado;
    }
}

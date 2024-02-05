package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Conta;
import com.senac.grimorio_db.repository.ContaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class ContaService {
   @Autowired 
   ContaRepository contaRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Conta> listarTodos(){
        return contaRepository.findAll();
    }
    
    public Conta buscarPorId(Integer id){
        return contaRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Conta encontrado = buscarPorId(id);
        contaRepository.deleteById(encontrado.getIdConta());
    }
    
    public Conta criar(Conta conta){
        conta.setIdConta(null);
        contaRepository.save(conta);
        return conta;
    }
    
    public Conta atualizar(Integer id, Conta enviado){
        Conta encontrado = buscarPorId(id);
        encontrado.setNomeConta(enviado.getNomeConta());
        contaRepository.save(encontrado);
        return encontrado;
    }
}

package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.Conta;
import com.senac.grimorio_db.service.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //tipo controller
@RequestMapping("/api/conta") //chama a view
public class ContaAPIController {
    
   @Autowired
   ContaService contaService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Conta>> listar(Model model){
       List<Conta> listagem = contaService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Conta> pesquisar(@PathVariable Integer id){
        Conta encontrado = contaService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Conta> criar(@RequestBody Conta conta){
       var novo = contaService.criar(conta);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Conta> atualizar(@PathVariable Integer id, @RequestBody Conta conta){
       var editado = contaService.atualizar(id, conta);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          contaService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }    
}
package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.Raca;
import com.senac.grimorio_db.service.RacaService;
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
@RequestMapping("/api/raca") //chama a view
public class RacaAPIController {
    
   @Autowired
   RacaService racaService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Raca>> listar(Model model){
       List<Raca> listagem = racaService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Raca> pesquisar(@PathVariable Integer id){
        Raca encontrado = racaService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Raca> criar(@RequestBody Raca raca){
       var novo = racaService.criar(raca);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Raca> atualizar(@PathVariable Integer id, @RequestBody Raca raca){
       var editado = racaService.atualizar(id, raca);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          racaService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }    
}
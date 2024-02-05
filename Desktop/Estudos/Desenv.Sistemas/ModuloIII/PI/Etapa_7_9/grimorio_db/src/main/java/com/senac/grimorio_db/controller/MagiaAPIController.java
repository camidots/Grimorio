package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.Magia;
import com.senac.grimorio_db.service.MagiaService;
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
@RequestMapping("/api/magia") //chama a view
public class MagiaAPIController {
    
   @Autowired
   MagiaService magiaService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Magia>> listar(Model model){
       List<Magia> listagem = magiaService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Magia> pesquisar(@PathVariable Integer id){
        Magia encontrado = magiaService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Magia> criar(@RequestBody Magia magia){
       var novo = magiaService.criar(magia);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Magia> atualizar(@PathVariable Integer id, @RequestBody Magia magia){
       var editado = magiaService.atualizar(id, magia);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          magiaService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }    
}
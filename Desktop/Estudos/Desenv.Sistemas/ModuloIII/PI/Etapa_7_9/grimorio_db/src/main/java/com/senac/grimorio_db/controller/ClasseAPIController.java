package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.Classe;
import com.senac.grimorio_db.service.ClasseService;
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
@RequestMapping("/api/classe") //chama a view
public class ClasseAPIController {
    
   @Autowired
   ClasseService classeService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Classe>> listar(Model model){
       List<Classe> listagem = classeService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Classe> pesquisar(@PathVariable Integer id){
        Classe encontrado = classeService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Classe> criar(@RequestBody Classe classe){
       var novo = classeService.criar(classe);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Classe> atualizar(@PathVariable Integer id, @RequestBody Classe classe){
       var editado = classeService.atualizar(id, classe);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          classeService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }    
}

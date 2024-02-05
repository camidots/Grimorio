package com.senac.grimorio_db.controller;


import com.senac.grimorio_db.model.Perfil;
import com.senac.grimorio_db.service.PerfilService;
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
@RequestMapping("/api/pefil") //chama a view
public class PerfilAPIController {
    
   @Autowired
   PerfilService perfilService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Perfil>> listar(Model model){
       List<Perfil> listagem = perfilService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Perfil> pesquisar(@PathVariable Integer id){
        Perfil encontrado = perfilService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Perfil> criar(@RequestBody Perfil pefil){
       var novo = perfilService.criar(pefil);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
     
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Perfil> atualizar(@PathVariable Integer id, @RequestBody Perfil pefil){
       var editado = perfilService.atualizar(id, pefil);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          perfilService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }  
      
      
}

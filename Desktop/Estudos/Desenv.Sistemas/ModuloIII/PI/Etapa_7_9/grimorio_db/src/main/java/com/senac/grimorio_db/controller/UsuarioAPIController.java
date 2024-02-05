package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.Usuario;
import com.senac.grimorio_db.service.UsuarioService;
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
@RequestMapping("/api/usuario") //chama a view
public class UsuarioAPIController {
    
   @Autowired
   UsuarioService usuarioService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<Usuario>> listar(Model model){
       List<Usuario> listagem = usuarioService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<Usuario> pesquisar(@PathVariable Integer id){
        Usuario encontrado = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
       var novo = usuarioService.criar(usuario);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
       var editado = usuarioService.atualizar(id, usuario);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          usuarioService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    }    
}
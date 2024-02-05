package com.senac.grimorio_db.controller;

import com.senac.grimorio_db.model.MagiaFavoritada;
import com.senac.grimorio_db.service.MagiaFavoritadaService;
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
@RequestMapping("/api/magiaFavoritada") //chama a view
public class MagiaFavoritadaAPIController {
    
   @Autowired
   MagiaFavoritadaService magiaFavoritadaService; //chama service
   
   //CRUD
   @GetMapping("/listar") // Caminho para listar filmes (retorno JSON)  
   public ResponseEntity<List<MagiaFavoritada>> listar(Model model){
       List<MagiaFavoritada> listagem = magiaFavoritadaService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   }  
   
    @GetMapping("/detalhes/{id}")  //read
    public ResponseEntity<MagiaFavoritada> pesquisar(@PathVariable Integer id){
        MagiaFavoritada encontrado = magiaFavoritadaService.buscarPorId(id);
        return new ResponseEntity<>(encontrado, HttpStatus.OK);
    }
  
   @PostMapping("/criar") // Caminho para criar filme (retorno JSON)
   public ResponseEntity<MagiaFavoritada> criar(@RequestBody MagiaFavoritada magiaFavoritada){
       var novo = magiaFavoritadaService.criar(magiaFavoritada);
       return new ResponseEntity<>(novo, HttpStatus.CREATED);
   }
   
    @PutMapping("/atualizar/{id}") //update
   public ResponseEntity<MagiaFavoritada> atualizar(@PathVariable Integer id, @RequestBody MagiaFavoritada magiaFavoritada){
       var editado = magiaFavoritadaService.atualizar(id, magiaFavoritada);
       return new ResponseEntity<>(editado, HttpStatus.OK);
   } 
   
    @DeleteMapping("/excluirPerfil/{id}") 
    public ResponseEntity<Void> excluirPerfil(@PathVariable Integer idPerfil) {
        magiaFavoritadaService.excluirPorIdPerfil(idPerfil); 
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}") //delet
      public ResponseEntity<Void> excluir(@PathVariable Integer id){
          magiaFavoritadaService.excluir(id);
          return new ResponseEntity<>(HttpStatus.OK);
    } 
      
    @GetMapping("/detalhesPerfil/{id}") 
    public ResponseEntity<List<MagiaFavoritada>> buscarMagiasFavoritadasPorPerfil(@PathVariable Integer idPerfil) {
        List<MagiaFavoritada> magiasFavoritadas = magiaFavoritadaService.buscarMagiasFavoritadasPorPerfil(idPerfil);
        return new ResponseEntity<>(magiasFavoritadas, HttpStatus.OK);
    }

    
}
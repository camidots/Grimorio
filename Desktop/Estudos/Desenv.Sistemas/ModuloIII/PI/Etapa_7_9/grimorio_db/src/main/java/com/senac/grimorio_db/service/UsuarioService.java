package com.senac.grimorio_db.service;

import com.senac.grimorio_db.model.Usuario;
import com.senac.grimorio_db.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //serviço
public class UsuarioService {
   @Autowired 
   UsuarioRepository usuarioRepository;  //chama repositorio 
    
    //CRUD
    
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
    
    public Usuario buscarPorId(Integer id){
        return usuarioRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Usuario encontrado = buscarPorId(id);
        usuarioRepository.deleteById(encontrado.getIdUsuario());
    }
    
    public Usuario criar(Usuario usuario){
        usuario.setIdUsuario(null);
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    public Usuario atualizar(Integer id, Usuario enviado){
        Usuario encontrado = buscarPorId(id);
        encontrado.setNomeUsuario(enviado.getNomeUsuario());
        encontrado.setEmail(enviado.getEmail());
        encontrado.setSenha(enviado.getSenha());
        encontrado.setConta(enviado.getConta());
        usuarioRepository.save(encontrado);
        return encontrado;
    }
}
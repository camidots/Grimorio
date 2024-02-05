package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> { //classe para representar e tipo da chave primaria
    
    List<Usuario> findByConta_IdConta(Integer idConta); //METODOS CRUD PERSONALIZADOS
    
}

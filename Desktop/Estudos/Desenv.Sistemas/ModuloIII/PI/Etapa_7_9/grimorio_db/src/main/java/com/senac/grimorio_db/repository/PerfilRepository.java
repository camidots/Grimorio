package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Perfil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository <Perfil, Integer> { //classe para representar e tipo da chave primaria
    
    List<Perfil> findByClasse_IdClasse(Integer idClasse); //METODOS CRUD PERSONALIZADOS
    List<Perfil> findByRaca_IdRaca(Integer idRaca);
    List<Perfil> findByUsuario_IdUsuario(Integer idUsuario);
    List<Perfil> findByConta_IdConta(Integer idConta);  
}


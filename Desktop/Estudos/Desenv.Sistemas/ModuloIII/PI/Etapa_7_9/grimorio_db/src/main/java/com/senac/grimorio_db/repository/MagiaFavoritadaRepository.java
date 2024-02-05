package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.MagiaFavoritada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagiaFavoritadaRepository extends JpaRepository <MagiaFavoritada, Integer> { //classe para representar e tipo da chave primaria
    
    List<MagiaFavoritada> findByMagia_IdMagia(Integer idMagia); //METODOS CRUD PERSONALIZADOS
    List<MagiaFavoritada> findByPerfil_IdPerfil(Integer idPerfil); //METODOS CRUD PERSONALIZADOS
    List<MagiaFavoritada> findByUsuario_IdUsuario(Integer idUsuario); //METODOS CRUD PERSONALIZADOS
    
}


package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository <Raca, Integer> { //classe para representar e tipo da chave primaria
    
}

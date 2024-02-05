package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Magia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagiaRepository extends JpaRepository<Magia, Integer> { //classe para representar e tipo da chave primaria
     
}

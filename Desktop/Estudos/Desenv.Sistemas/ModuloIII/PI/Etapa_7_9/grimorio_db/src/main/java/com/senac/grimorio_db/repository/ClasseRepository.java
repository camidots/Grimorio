package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> { //classe para representar e tipo da chave primaria
     
}

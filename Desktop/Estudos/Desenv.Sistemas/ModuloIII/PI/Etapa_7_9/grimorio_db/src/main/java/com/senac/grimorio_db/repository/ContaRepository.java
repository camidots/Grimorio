package com.senac.grimorio_db.repository;

import com.senac.grimorio_db.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Integer> { //classe para representar e tipo da chave primaria

}

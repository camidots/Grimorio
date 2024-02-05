package com.senac.grimorio_db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "conta") //tabela

public class Conta {
             
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //pk
    private Integer idConta;
    
    private String nomeConta;
}
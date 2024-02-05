package com.senac.grimorio_db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario") //tabela

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //pk
    private Integer idUsuario;
    
    private String nomeUsuario;
    
    private String email;
    
    private String senha;
    
    @OneToOne
    @JoinColumn(name="id_conta") //fk
    private Conta conta;
}
 
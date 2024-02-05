package com.senac.grimorio_db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil") //tabela

public class Perfil{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //pk
    private Integer idPerfil;
    
    private String nomePerfil;
    
    @ManyToOne
    @JoinColumn(name="id_classe") //fk
    private Classe classe;
    
    @ManyToOne
    @JoinColumn(name="id_raca") //fk
    private Raca raca;
    
    @ManyToOne
    @JoinColumn(name="id_usuario") //fk
    private Usuario usuario; 
    
    @ManyToOne
    @JoinColumn(name="id_conta") //fk
    private Conta conta;
    
    private Integer nivelPersonagem;
    
    private String caminhoImagem;
}

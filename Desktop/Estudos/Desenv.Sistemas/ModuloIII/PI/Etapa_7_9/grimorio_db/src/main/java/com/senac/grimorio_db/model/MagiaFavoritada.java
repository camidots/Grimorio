package com.senac.grimorio_db.model;

import jakarta.persistence.CascadeType;
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
@Table(name = "magias_ficha") //tabela

public class MagiaFavoritada{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //pk
    private Integer idMagiaFavoritada;
    
    @ManyToOne
    @JoinColumn(name="id_magia") //fk
    private Magia magia;
    
    private final Integer slotMax = 6;
    
    private Integer slotAtual;
    
    @ManyToOne
    @JoinColumn(name="id_perfil") //fk
    private Perfil perfil;
    
    @ManyToOne
    @JoinColumn(name="id_usuario") //fk
    private Usuario usuario;   
}

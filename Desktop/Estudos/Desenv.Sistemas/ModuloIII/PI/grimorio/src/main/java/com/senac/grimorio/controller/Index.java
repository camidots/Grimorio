/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.grimorio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
@GetMapping("/index")
    public String index() {
        return "index"; 
    } 
    
@GetMapping("/cadastroPerfil")
public String perfil() {
        return "cadastroPerfil"; 
    }
    
@GetMapping("/login")
public String login() {
        return "login";
    }
}


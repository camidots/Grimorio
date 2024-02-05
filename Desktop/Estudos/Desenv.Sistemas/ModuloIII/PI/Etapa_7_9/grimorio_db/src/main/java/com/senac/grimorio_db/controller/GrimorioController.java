package com.senac.grimorio_db.controller;

import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import com.senac.grimorio_db.model.Classe;
import com.senac.grimorio_db.model.Magia;
import com.senac.grimorio_db.model.Perfil;
import com.senac.grimorio_db.model.Raca;
import com.senac.grimorio_db.service.ClasseService;
import com.senac.grimorio_db.service.ContaService;
import com.senac.grimorio_db.service.MagiaFavoritadaService;
import com.senac.grimorio_db.service.MagiaService;
import com.senac.grimorio_db.service.PerfilService;
import com.senac.grimorio_db.service.RacaService;
import com.senac.grimorio_db.service.UsuarioService;
import static jakarta.persistence.GenerationType.UUID;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GrimorioController {

    @Autowired
    ClasseService classeService;
    
    @Autowired
    ContaService contaService;    
    
    @Autowired
    MagiaService magiaService;
    
    @Autowired
    MagiaFavoritadaService magiaFavoritadaeService;  
    
    @Autowired
    PerfilService perfilService;
    
    @Autowired
    RacaService racaService;  
    
    @Autowired
    UsuarioService usuarioService; 
    
    private static final Logger logger = LoggerFactory.getLogger(GrimorioController.class);

    @GetMapping("/index")
    public String index(Model model) {
        
        return "index"; 
    }
    
@GetMapping("/cadastroPerfil")
    public String showPerfilPage(Model model) {
        
        List<Raca> racas = racaService.listarTodos();
        List<Classe> classes = classeService.listarTodos();

        model.addAttribute("racas", racas);
        model.addAttribute("classes", classes);
        return "cadastroPerfil"; 
    }

@GetMapping("/login")
    public String login() {
            return "login";
    }
    
    @GetMapping("/edicaoPerfil/{id}")
    public String editarPerfil(@PathVariable Integer id, Model model) {
        List<Raca> racas = racaService.listarTodos();
        List<Classe> classes = classeService.listarTodos();
        Perfil perfil = perfilService.buscarPorId(id);

        model.addAttribute("racas", racas);
        model.addAttribute("classes", classes);
        model.addAttribute("perfil", perfil);
        
        return "edicaoPerfil";
    }
}

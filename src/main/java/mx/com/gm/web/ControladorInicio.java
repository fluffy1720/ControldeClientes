package mx.com.gm.web;

import mx.com.gm.domain.Persona;
//import mx.com.gm.domain.Persona;
//import mx.com.gm.dao.iPersonaDao;
import mx.com.gm.servicio.iPersonaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import java.util.Arrays;
//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    //@Value("${index.saludo}")
    @Autowired //inyectar interface de tipo Dao
    private iPersonaService personaService;
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
}

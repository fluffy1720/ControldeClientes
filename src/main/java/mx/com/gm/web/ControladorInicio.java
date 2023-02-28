package mx.com.gm.web;

import mx.com.gm.domain.Persona;
//import mx.com.gm.domain.Persona;
//import mx.com.gm.dao.iPersonaDao;
import mx.com.gm.servicio.iPersonaService;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}

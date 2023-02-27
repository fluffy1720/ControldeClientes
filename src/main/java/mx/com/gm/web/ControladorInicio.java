package mx.com.gm.web;

import mx.com.gm.domain.Persona;
import mx.com.gm.dao.iPersonaDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Arrays;
//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    //@Value("${index.saludo}")
    @Autowired //inyectar interface de tipo Dao
    private iPersonaDao personaDao;
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaDao.findAll();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }
}

package mx.com.gm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import mx.com.gm.domain.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    @GetMapping("/")
    public String inicio(Model model){
        var mensaje="Hola Mundo con Thymeleaf";

        var persona = new Persona();
        var persona2 = new Persona();
        var persona3 = new Persona();

        persona.setNombre("Ivan");
        persona.setApellido("Larios");
        persona.setEmail("larios@gmail.com");
        persona.setTelefono("5630192627");

        persona2.setNombre("Edgar");
        persona2.setApellido("Cano");
        persona2.setEmail("cano@gmail.com");
        persona2.setTelefono("5630192633");

        persona3.setNombre("Ramses");
        persona3.setApellido("Ramos");
        persona3.setEmail("ramos@gmail.com");
        persona3.setTelefono("5630342633");

        //var <Persona> personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona);
        var personas = Arrays.asList(persona, persona2, persona3);
        //var personas = new ArrayList();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }
}

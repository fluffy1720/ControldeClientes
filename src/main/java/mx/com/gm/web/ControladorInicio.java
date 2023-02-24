package mx.com.gm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysql.jdbc.Driver;

import java.util.Arrays;
//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import mx.com.gm.domain.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    //@Value("${index.saludo}")
    @GetMapping("/")
    public String inicio(Model model){
        log.info("ejecutando el controlador Spring MVC");
        //model.addAttribute("personas", personas);
        return "index";
    }
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PreguntaVF;


@Controller
@RequestMapping("/test")
public class TestController {
    @Value("Página de tests")
    private String titulo;
    
    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("titulo", titulo);
        return "test/menu";
    }
    @GetMapping("/pregunta-dummy")
    public String getPreguntaDummy(Model model) {
        model.addAttribute("titulo", titulo);
        return "test/pregunta-dummy";
    }

    @GetMapping("/pregunta-tipo01-test")
    public String getPreguntaTipo01(Model model) {
        PreguntaVF preguntaTest = new PreguntaVF("Es verdadero que 2 + 2 son 4", true);
        model.addAttribute("pregunta", preguntaTest);
        model.addAttribute("titulo", titulo);
        return "test/pregunta-tipo01";
    }

    @PostMapping("/pregunta-tipo01-test")
    public String procesarFormulario(@RequestParam(name = "respuesta") String respuesta, Model model) {
        PreguntaVF preguntaTest = new PreguntaVF("Es verdadero que 2 + 2 son 4", true);
        model.addAttribute("acertada", preguntaTest.isRespuesta() == ("verdadero".equals(respuesta) ? true: false));
        model.addAttribute("pregunta", preguntaTest);
        model.addAttribute("titulo", titulo);
        return "test/pregunta-solucion"; // Reemplaza con la página a la que quieres redirigir después de procesar el formulario
    }


    

}

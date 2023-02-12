package com.factura.app.factura.controller;



import com.factura.app.factura.models.Entity.Respuesta;
import com.factura.app.factura.models.Entity.Tema;
import com.factura.app.factura.models.service.temaService.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;


@RequestMapping("/tema")
@Controller
public class temaController {

    @Autowired
    private ITemaService temaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de temas");
        model.addAttribute("tema", temaService.findAll());
        return "tema/listarTema";
    }
    @GetMapping("/form") // recibe la informacion u cambio
    public String crear(Map<String, Object> model) // Map <String,Object> model

    {

        // instanciando la clase cliente o entidad cliente
        Tema tema = new Tema();

        // model put para mostrar cliente
        model.put("tema", tema);

        model.put("titulo", "formulario Temas");

        return "tema/formTema";

    }
    @RequestMapping(value = "/form", method = RequestMethod.POST) // guarda la
    // informacion en el mismo /form
    // ..post...toma los datos y depues los guarda
    public String guardar(@Valid Tema tema, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Tema Error");
            return "tema/formTema";

        }
        temaService.save(tema);
        return "redirect:/tema/listar";

    }

    @GetMapping("/form/{id}") // al usar el pathVatiable se debe poner el dato
    // extra en la url
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Tema tema = null;

        if (id > 0) {

            tema = temaService.findone(id);
        } else {

            return "redirect:/tema/listar"; // redirigir a listar
        }

        // model put para mostrar cliente
        model.put("tema", tema);

        model.put("titulo", "Editar Tema");

        return "tema/formTema";
    }



    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) { // @PathVariable se usa para
        // mandar informacion por URL

        if (id > 0) {

            temaService.delete(id);

        }

        return "redirect:/tema/listar";
    }
}

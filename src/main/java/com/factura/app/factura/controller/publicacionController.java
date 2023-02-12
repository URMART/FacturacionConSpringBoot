package com.factura.app.factura.controller;

import java.util.Map;

import javax.validation.Valid;

import com.factura.app.factura.models.service.temaService.ITemaService;
import com.factura.app.factura.models.service.usersService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.factura.app.factura.models.Entity.Publicacion;
import com.factura.app.factura.models.service.publicService.IPublicService;

@RequestMapping("/publicacion")
@Controller
public class publicacionController {

    @Autowired
    private IPublicService publicacionService;
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private ITemaService temaService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de publicaciones");
        model.addAttribute("publicaciones", publicacionService.findAll());
        return "publicaciones/listarPublicacion";
    }

    @GetMapping("/form") // recibe la informacion u cambio
    public String crear(Map<String, Object> model) // Map <String,Object> model se usa para mandar la informacion al
                                                   // thymeleaf es un tipo model.addAttribute
    {

        // instanciando la clase cliente o entidad cliente
        Publicacion publicacion = new Publicacion();
        // model put para mostrar cliente
        model.put("publicacion", publicacion);

        model.put("titulo", "formulario Publicaciones");
        model.put("usuarios", usuarioService.findAll());
        model.put("tema", temaService.findAll());

        return "publicaciones/formPublicaciones";

    }

    // guardar user
    // PostMapping("/form")
    @RequestMapping(value = "/form", method = RequestMethod.POST) // guarda la informacion en el mismo /form
                                                                  // ..post...toma los datos y depues los guarda
    public String guardar(@Valid Publicacion publicacion, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Publicacion Error");
            return "publicaciones/formPublicaciones";

        }
        publicacionService.save(publicacion);
        return "redirect:/publicacion/listar";

    }

    @GetMapping("/form/{id}") // al usar el pathVatiable se debe poner el dato extra en la url
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Publicacion publicacion = null;

        if (id > 0) {

            publicacion = publicacionService.findone(id);
        } else {

            return "redirect:/publicacion/listar"; // redirigir a listar
        }

        // model put para mostrar cliente
        model.put("publicacion", publicacion);

        model.put("titulo", "Editar publicacion");

        return "/publicaciones/formPublicaciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) { // @PathVariable se usa para mandar informacion por URL

        if (id > 0) {

            publicacionService.delete(id);

        }

        return "redirect:/publicacion/listar";
    }

}

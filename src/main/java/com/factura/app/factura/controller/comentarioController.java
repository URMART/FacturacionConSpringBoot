
package com.factura.app.factura.controller;

import java.util.Map;

import javax.validation.Valid;

import com.factura.app.factura.models.service.publicService.IPublicService;
import com.factura.app.factura.models.service.usersService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.factura.app.factura.models.Entity.Comentario;
import com.factura.app.factura.models.service.comentarioService.IComentarioService;

@RequestMapping("/comentario")
@Controller
public class comentarioController {

    @Autowired
    private IComentarioService comentarioService;
    @Autowired
    private IPublicService publicacionService;
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de comentarios");
        model.addAttribute("comentario", comentarioService.findAll());
        return "comentario/listarComentario";
    }

    @GetMapping("/form") // recibe la informacion u cambio
    public String crear(Map<String, Object> model) // Map <String,Object> model se usa para mandar la informacion al
                                                   // thymeleaf es un tipo model.addAttribute
    {

        // instanciando la clase cliente o entidad cliente
        Comentario comentario = new Comentario();

        // model put para mostrar cliente
        model.put("comentario", comentario);
        model.put("publicacion", publicacionService.findAll());
        model.put("usuario", usuarioService.findAll());

        model.put("titulo", "formulario Cometarios");

        return "comentario/formComentario";

    }

    // guardar user
    // PostMapping("/form")
    @RequestMapping(value = "/form", method = RequestMethod.POST) // guarda la informacion en el mismo /form
                                                                  // ..post...toma los datos y depues los guarda
    public String guardar(@Valid Comentario comentario, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Comentario Error");
            return "comentario/listarComentario";

        }
        comentarioService.save(comentario);
        return "redirect:/comentario/listar";

    }

    @GetMapping("/form/{id}") // al usar el pathVatiable se debe poner el dato extra en la url
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Comentario comentario = null;

        if (id > 0) {

            comentario = comentarioService.findone(id);
        } else {

            return "redirect:/comentario/listar"; // redirigir a listar
        }

        // model put para mostrar cliente
        model.put("comentario", comentario);

        model.put("titulo", "Editar Comentarios");

        return "/comentario/formComentario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) { // @PathVariable se usa para mandar informacion por URL

        if (id > 0) {

            comentarioService.delete(id);

        }

        return "redirect:/comentario/listar";
    }

}

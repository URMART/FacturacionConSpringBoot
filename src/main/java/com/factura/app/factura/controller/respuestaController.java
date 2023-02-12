
package com.factura.app.factura.controller;

import java.util.Map;

import javax.validation.Valid;

import com.factura.app.factura.models.service.comentarioService.IComentarioService;
import com.factura.app.factura.models.service.usersService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.factura.app.factura.models.Entity.Respuesta;
import com.factura.app.factura.models.service.respuestaService.IRespuestaService;

@RequestMapping("/respuesta")
@Controller
public class respuestaController {

    @Autowired
    private IRespuestaService respuestaService;

    @Autowired
    private IComentarioService comentarioService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de respuestas");
        model.addAttribute("respuesta", respuestaService.findAll());
        return "respuesta/listarRespuesta";
    }

    @GetMapping("/form") // recibe la informacion u cambio
    public String crear(Map<String, Object> model) // Map <String,Object> model
    // se usa para mandar la informacion al
    // thymeleaf es un tipo model.addAttribute
    {

        // instanciando la clase cliente o entidad cliente
        Respuesta respuesta = new Respuesta();

        // model put para mostrar cliente
        model.put("respuesta", respuesta);
        model.put("comentario", comentarioService.findAll());
        model.put("usuario", usuarioService.findAll());


        model.put("titulo", "formulario Respuestas");

        return "respuesta/formRespuesta";

    }

    // guardar user
    // PostMapping("/form")
    @RequestMapping(value = "/form", method = RequestMethod.POST) // guarda la
    // informacion en el mismo /form
    // ..post...toma los datos y depues los guarda
    public String guardar(@Valid Respuesta respuesta, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Respuesta Error");
            return "respuesta/formRespuesta";

        }
        respuestaService.save(respuesta);
        return "redirect:/respuesta/listar";

    }

    @GetMapping("/form/{id}") // al usar el pathVatiable se debe poner el dato
    // extra en la url
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Respuesta respuesta = null;

        if (id > 0) {

            respuesta = respuestaService.findone(id);
        } else {

            return "redirect:/respuesta/listar"; // redirigir a listar
        }

        // model put para mostrar cliente
        model.put("respuesta", respuesta);

        model.put("titulo", "Editar Respuesta");

        return "respuesta/formRespuesta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) { // @PathVariable se usa para
        // mandar informacion por URL

        if (id > 0) {

            respuestaService.delete(id);

        }

        return "redirect:/respuesta/listar";
    }

}

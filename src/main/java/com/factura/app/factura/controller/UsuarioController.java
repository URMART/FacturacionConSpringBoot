package com.factura.app.factura.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.factura.app.factura.models.Entity.Usuario;
import com.factura.app.factura.models.service.usersService.IUsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());
        return "users/listarUsuarios";
    }

    @GetMapping("/listarPublicaciones")
    public String listarPublicaciones(Model model) {

        model.addAttribute("titulo", "Listado de publicaciones Usuarios");
        model.addAttribute("usuarios", usuarioService.findAll());
        return "users/listarUsuarios";
    }


    @GetMapping("/form") // recibe la informacion u cambio
    public String crear(Map<String, Object> model) // Map <String,Object> model se usa para mandar la informacion al
                                                   // thymeleaf es un tipo model.addAttribute
    {

        // instanciando la clase cliente o entidad cliente
        Usuario usuario = new Usuario();

        // model put para mostrar cliente
        model.put("usuario", usuario);

        model.put("titulo", "formulario usuario");

        return "users/formUsuario";

    }

    // guardar user
    // PostMapping("/form")
    @RequestMapping(value = "/form", method = RequestMethod.POST) // guarda la informacion en el mismo /form// ..post...toma los datos y depues los guarda
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario de Usuarios Error");
            return "users/formUsuario";

        }
        usuarioService.save(usuario);
        return "redirect:/listar";

    }

    @GetMapping("/form/{id}") // al usar el pathVatiable se debe poner el dato extra en la url
    public String editar(@PathVariable Long id, Map<String, Object> model) {

        Usuario usuario = null;

        if (id > 0) {

            usuario = usuarioService.findone(id);
        } else {

            return "redirect:/listar"; // redirigir a listar
        }

        // model put para mostrar cliente
        model.put("usuario", usuario);

        model.put("titulo", "Editar usuario");

        return "users/formUsuario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) { // @PathVariable se usa para mandar informacion por URL

        if (id > 0) {

            usuarioService.delete(id);

        }

        return "redirect:/listar";
    }

//zona de login--------------------------------------------->>>>>




    @GetMapping("/login")
    public  String login(Model model){

        model.addAttribute("titulo", "Login");

        return "users/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  String login(@RequestParam("password") String password, @RequestParam("usuario") String usuario){
        List<Usuario> usuarios= usuarioService.findAll(usuario,password);
        if (usuarios.size()>0){
            return "redirect:/listar";
        }
        return "redirect:/login";
    }



}

package com.factura.app.factura.models.service.usersService;

import java.util.List;

import com.factura.app.factura.models.Entity.Usuario;

public interface IUsuarioService {

    public List<Usuario> findAll();

    public List<Usuario> findAll(String username,String password);
    public void save(Usuario usuario);

    public Usuario findone(Long id);

    public void delete(Long id);
}

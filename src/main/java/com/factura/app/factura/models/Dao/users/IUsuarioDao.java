package com.factura.app.factura.models.Dao.users;

import java.util.List;

import com.factura.app.factura.models.Entity.Usuario;

public interface IUsuarioDao {

    public List<Usuario> findAll();
    public List<Usuario> findAll(String username,String password);
    public void save(Usuario usuario);

    public Usuario findone(Long id);

    public void delete(Long id);




}

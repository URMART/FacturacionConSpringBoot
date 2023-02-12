package com.factura.app.factura.models.Dao.publicacion;

import java.util.List;

import com.factura.app.factura.models.Entity.Publicacion;

public interface IPublicacionDao {

    public List<Publicacion> findAll();
    public void save(Publicacion publicacion);

    public Publicacion findone(Long id);

    public void delete(Long id);


}

package com.factura.app.factura.models.service.publicService;

import java.util.List;

import com.factura.app.factura.models.Entity.Publicacion;

public interface IPublicService {

    public List<Publicacion> findAll();
    
    public void save(Publicacion publicacion);

    public Publicacion findone(Long id);

    public void delete(Long id);

}

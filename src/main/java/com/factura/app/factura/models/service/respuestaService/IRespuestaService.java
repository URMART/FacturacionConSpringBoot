package com.factura.app.factura.models.service.respuestaService;

import java.util.List;

import com.factura.app.factura.models.Entity.Respuesta;

public interface IRespuestaService {

    public List<Respuesta> findAll();

    public void save(Respuesta respuesta);

    public Respuesta findone(Long id);

    public void delete(Long id);

}

package com.factura.app.factura.models.Dao.respuesta;

import java.util.List;

import com.factura.app.factura.models.Entity.Respuesta;

public interface IRespuestaDao {

    public List<Respuesta> findAll();

    public void save(Respuesta respuesta);

    public Respuesta findone(Long id);

    public void delete(Long id);

}

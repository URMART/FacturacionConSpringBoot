package com.factura.app.factura.models.service.temaService;

import com.factura.app.factura.models.Entity.Tema;

import java.util.List;

public interface ITemaService {
    public List<Tema> findAll();

    public void save(Tema tema);

    public Tema findone(Long id);

    public void delete(Long id);
}

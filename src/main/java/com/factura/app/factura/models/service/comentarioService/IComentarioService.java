package com.factura.app.factura.models.service.comentarioService;

import java.util.List;

import com.factura.app.factura.models.Entity.Comentario;

public interface IComentarioService {

    public List<Comentario> findAll();

    public void save(Comentario comentario);

    public Comentario findone(Long id);

    public void delete(Long id);

}

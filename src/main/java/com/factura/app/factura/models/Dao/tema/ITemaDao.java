package com.factura.app.factura.models.Dao.tema;


import com.factura.app.factura.models.Entity.Tema;

import java.util.List;

public interface ITemaDao {

    public List<Tema> findAll();

    public void save(Tema tema);

    public Tema findone(Long id);

    public void delete(Long id);
}

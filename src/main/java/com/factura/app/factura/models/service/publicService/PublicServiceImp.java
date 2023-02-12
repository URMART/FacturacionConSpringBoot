package com.factura.app.factura.models.service.publicService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Dao.publicacion.IPublicacionDao;
import com.factura.app.factura.models.Entity.Publicacion;

@Service
public class PublicServiceImp implements IPublicService {
    @Autowired //
    private IPublicacionDao publicacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Publicacion> findAll() {
        return publicacionDao.findAll();
    }
    @Override
    @Transactional
    public void save(Publicacion publicacion) {
        // TODO Auto-generated method stub
        publicacionDao.save(publicacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Publicacion findone(Long id) { // controlador service - service con dao y dao con datos

        // TODO Auto-generated method stub
        return publicacionDao.findone(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub

        publicacionDao.delete(id);
    }

}


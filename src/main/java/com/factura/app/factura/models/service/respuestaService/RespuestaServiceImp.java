package com.factura.app.factura.models.service.respuestaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Dao.respuesta.IRespuestaDao;
import com.factura.app.factura.models.Entity.Respuesta;

@Service
public class RespuestaServiceImp implements IRespuestaService {
    @Autowired //
    private IRespuestaDao respuestaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return respuestaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Respuesta respuesta) {
        // TODO Auto-generated method stub
        respuestaDao.save(respuesta);
    }

    @Override
    @Transactional(readOnly = true)
    public Respuesta findone(Long id) {
        // TODO Auto-generated method stub
        return respuestaDao.findone(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        respuestaDao.delete(id);
    }

}

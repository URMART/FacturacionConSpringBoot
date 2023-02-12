package com.factura.app.factura.models.service.comentarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Dao.comentario.IComentarioDao;
import com.factura.app.factura.models.Entity.Comentario;

@Service
public class ComentarioServiceImp implements IComentarioService {
    @Autowired //
    private IComentarioDao comentarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Comentario> findAll() {
        return comentarioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Comentario comentario) {
        // TODO Auto-generated method stub
        comentarioDao.save(comentario);
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario findone(Long id) { // controlador service - service con dao y dao con datos

        // TODO Auto-generated method stub
        return comentarioDao.findone(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub

        comentarioDao.delete(id);
    }

}

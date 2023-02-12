package com.factura.app.factura.models.service.temaService;


import com.factura.app.factura.models.Dao.tema.ITemaDao;
import com.factura.app.factura.models.Entity.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TemaServiceImp implements  ITemaService {
    @Autowired //
    private ITemaDao temaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tema> findAll() {
        return temaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Tema tema) {
        // TODO Auto-generated method stub
        temaDao.save(tema);
    }

    @Override
    @Transactional(readOnly = true)
    public Tema findone(Long id) {
        // TODO Auto-generated method stub
        return temaDao.findone(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        temaDao.delete(id);
    }
}

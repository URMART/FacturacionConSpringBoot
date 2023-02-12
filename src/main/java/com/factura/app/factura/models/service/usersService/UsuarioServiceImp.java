package com.factura.app.factura.models.service.usersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Dao.users.IUsuarioDao;
import com.factura.app.factura.models.Entity.Usuario;
@ComponentScan({"com.delivery.request"})
@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired //
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll(String username,String password) {
        return usuarioDao.findAll(username,password);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        // TODO Auto-generated method stub
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findone(Long id) { // controlador service - service con dao y dao con datos

        // TODO Auto-generated method stub
        return usuarioDao.findone(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub

        usuarioDao.delete(id);
    }

}

package com.factura.app.factura.models.Dao.users;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Entity.Usuario;

@Repository("UsuarioDaoJPA")
public class UsuarioDaoImp implements IUsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return em.createQuery("from Usuario").getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll(String username,String password) {
        System.out.println("mire aca ------------------------------------------------------>");
        System.out.println(em.createQuery("from Usuario  where Usuario ='"+username+"'and Contrasena='"+password+"'").getResultList());
        return em.createQuery("from Usuario  where Usuario ='"+username+"'and Contrasena='"+password+"'").getResultList();
    }

    // Save
    @Override
    @Transactional
    public void save(Usuario usuario) {

        if (usuario.getId() != null && usuario.getId() > 0) {

            em.merge(usuario);

        } else { 

            // guardar los client
            em.persist(usuario);
        }

    }

    @Transactional(readOnly = true) // solo lectura al reaalizar la consulta
    @Override
    public Usuario findone(Long id) {

        return em.find(Usuario.class, id);// retornando la entidad con el em, la Clase y el id a consultar
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Usuario usuario = findone(id);
        em.remove(usuario);
    }

}

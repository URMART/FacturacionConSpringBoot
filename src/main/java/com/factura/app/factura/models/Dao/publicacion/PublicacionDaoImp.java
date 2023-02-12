package com.factura.app.factura.models.Dao.publicacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Entity.Publicacion;

@Repository("PublicacionDaoJPA")
public class PublicacionDaoImp implements IPublicacionDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Publicacion> findAll() {
        return em.createQuery("from Publicacion").getResultList();
    }

    // Save
    @Override
    @Transactional
    public void save(Publicacion publicacion) {

        if (publicacion.getId() != null && publicacion.getId() > 0) {

            em.merge(publicacion);

        } else {

            // guardar los client
            em.persist(publicacion);
        }

    }

    @Transactional(readOnly = true) // solo lectura al reaalizar la consulta
    @Override
    public Publicacion findone(Long id) {

        return em.find(Publicacion.class, id);// retornando la entidad con el em, la Clase y el id a consultar
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Publicacion publicacion = findone(id);
        em.remove(publicacion);
    }
}

package com.factura.app.factura.models.Dao.respuesta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Entity.Respuesta;

@Repository("RespuestaDaoJPA")
public class RespuestaDaoImp implements IRespuestaDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Respuesta> findAll() {
        return em.createQuery("from Respuesta").getResultList();
    }

    // Save
    @Override
    @Transactional
    public void save(Respuesta respuesta) {

        if (respuesta.getId() != null && respuesta.getId() > 0) {

            em.merge(respuesta);

        } else {

            // guardar los client
            em.persist(respuesta);
        }

    }

    @Transactional(readOnly = true) // solo lectura al reaalizar la consulta
    @Override
    public Respuesta findone(Long id) {

        return em.find(Respuesta.class, id);// retornando la entidad con el em, la Clase y el id a consultar
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Respuesta respuesta = findone(id);
        em.remove(respuesta);
    }
}

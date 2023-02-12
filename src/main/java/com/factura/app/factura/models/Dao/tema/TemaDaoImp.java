package com.factura.app.factura.models.Dao.tema;


import com.factura.app.factura.models.Entity.Respuesta;
import com.factura.app.factura.models.Entity.Tema;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("TemaDaoJPA")
public class TemaDaoImp implements  ITemaDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Tema> findAll() {
        return em.createQuery("from Tema").getResultList();
    }

    // Save
    @Override
    @Transactional
    public void save(Tema tema) {

        if (tema.getId() != null && tema.getId() > 0) {

            em.merge(tema);

        } else {

            // guardar los client
            em.persist(tema);
        }

    }

    @Transactional(readOnly = true) // solo lectura al reaalizar la consulta
    @Override
    public Tema findone(Long id) {

        return em.find(Tema.class, id);// retornando la entidad con el em, la Clase y el id a consultar
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Tema tema = findone(id);
        em.remove(tema);
    }
}

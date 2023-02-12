package com.factura.app.factura.models.Dao.comentario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.factura.app.factura.models.Entity.Comentario;

@Repository("ComentarioDaoJPA")
public class ComentarioDaoImp implements IComentarioDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Comentario> findAll() {
        return em.createQuery("from Comentario").getResultList();
    }

    // Save
    @Override
    @Transactional
    public void save(Comentario comentario) {

        if (comentario.getId() != null && comentario.getId() > 0) {

            em.merge(comentario);

        } else {

            // guardar los client
            em.persist(comentario);
        }

    }

    @Transactional(readOnly = true) // solo lectura al reaalizar la consulta
    @Override
    public Comentario findone(Long id) {

        return em.find(Comentario.class, id);// retornando la entidad con el em, la Clase y el id a consultar
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Comentario comentario = findone(id);
        em.remove(comentario);
    }
}

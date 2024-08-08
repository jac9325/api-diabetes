package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class UsuarioRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;

    public Usuario getUserById(Long id) {
        String hql = "SELECT u FROM Usuario u WHERE u.id_usuario =: id";
        Query query = entityManager.createQuery(hql, Usuario.class)
                .setParameter("id", id);
        
        Usuario user = (Usuario) query.getSingleResult();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> getUsuariosHabilitados() {
        String hql = "SELECT u FROM Usuario u WHERE u.estado = 1";
        Query query = entityManager.createQuery(hql, Usuario.class);
        List<Usuario> users = query.getResultList();
        return users;
    }
}

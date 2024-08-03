/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioTratamiento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class UsuarioTratamientoRepositoryHb {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    //Get  Agencia By Id
    public UsuarioTratamiento getUsuarioTratamientoById(Long id) {
        String hql = "SELECT p FROM UsuarioTratamiento p WHERE p.id_usuario_tratamiento = :id";
        Query query = entityManager.createQuery(hql, UsuarioTratamiento.class)
                .setParameter("id", id);
        //query.setParameter("precio", ); aqui entran los poarametros
        UsuarioTratamiento inst = (UsuarioTratamiento) query.getSingleResult();
        return inst;
    }
    
}

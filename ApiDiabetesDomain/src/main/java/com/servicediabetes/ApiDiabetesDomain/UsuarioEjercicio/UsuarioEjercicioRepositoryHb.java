/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioEjercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class UsuarioEjercicioRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;
    
    //Get  Agencia By Id
    public UsuarioEjercicio getUsuarioEjercicioById(Long id) {
        String hql = "SELECT p FROM UsuarioEjercicio p WHERE p.id_tratamiento_ejercicio = :id";
        Query query = entityManager.createQuery(hql, UsuarioEjercicio.class)
                .setParameter("id", id);
        //query.setParameter("precio", ); aqui entran los poarametros
        UsuarioEjercicio inst = (UsuarioEjercicio) query.getSingleResult();
        return inst;
    }
}

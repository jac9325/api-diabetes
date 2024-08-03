/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class EjercicioRepositoryHb {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Ejercicio getEjercicioById(Long id){
        String hql = "SELECT p FROM Ejercicio p WHERE p.id_ejercicio =: id and p.estado = 1";
        Query query = entityManager.createQuery(hql, Ejercicio.class)
                        .setParameter("id", id);
        Ejercicio inst = (Ejercicio) query.getSingleResult();
        return inst;
    }

    public List<Ejercicio> getListAllEjercicio(){
        String hql = "SELECT p FROM Ejercicio p WHERE p.estado = 1";
        Query query = entityManager.createQuery(hql, Ejercicio.class);
        List<Ejercicio> list = query.getResultList();
        return list;
    }
    
}

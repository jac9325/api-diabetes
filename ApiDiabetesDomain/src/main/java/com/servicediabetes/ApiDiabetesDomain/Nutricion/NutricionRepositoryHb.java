/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

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
public class NutricionRepositoryHb {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Nutricion getNutricionById(Long id){
        String hql = "SELECT p FROM Nutricion p WHERE p.id_nutricion =: id and p.estado = 1";
        Query query = entityManager.createQuery(hql, Nutricion.class)
                        .setParameter("id", id);
        Nutricion inst = (Nutricion) query.getSingleResult();
        return inst;
    }

    public List<Nutricion> getListAllNutricion(){
        String hql = "SELECT p FROM Nutricion p WHERE p.estado = 1";
        Query query = entityManager.createQuery(hql, Nutricion.class);
        List<Nutricion> list = query.getResultList();
        return list;
    }
    
}

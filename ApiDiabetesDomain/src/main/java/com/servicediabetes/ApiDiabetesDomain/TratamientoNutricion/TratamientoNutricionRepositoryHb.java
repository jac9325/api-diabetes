/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class TratamientoNutricionRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;
    
    //Get  Agencia By Id
    public TratamientoNutricion getTratamientoNutricionById(Long id) {
        String hql = "SELECT p FROM TratamientoNutricion p WHERE p.id_tratamiento_nutricion = :id";
        Query query = entityManager.createQuery(hql, TratamientoNutricion.class)
                .setParameter("id", id);
        //query.setParameter("precio", ); aqui entran los poarametros
        TratamientoNutricion inst = (TratamientoNutricion) query.getSingleResult();
        return inst;
    }
    
}

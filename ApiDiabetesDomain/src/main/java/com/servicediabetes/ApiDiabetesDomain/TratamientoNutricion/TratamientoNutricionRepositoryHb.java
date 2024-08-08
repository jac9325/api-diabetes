/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

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

    @SuppressWarnings("unchecked")
    public List<TratamientoNutricion> getAllTratamientoNutricionHabilitadosByIdTratamiento(Long id){
        String hql = "SELECT t FROM TratamientoNutricion t WHERE t.tratamiento.id_tratamiento = :id AND t.estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoNutricion.class)
                .setParameter("id", id);
        return query.getResultList();
    }
    
    public List<TratamientoNutricion> getAllTratamientoNutricionHabilitados(){
        String hql = "SELECT t FROM TratamientoNutricion t WHERE t.estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoNutricion.class);
        return query.getResultList();
    }
}

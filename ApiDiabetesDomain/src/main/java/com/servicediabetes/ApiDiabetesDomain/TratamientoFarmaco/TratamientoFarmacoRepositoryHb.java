/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

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
public class TratamientoFarmacoRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;
    
    //Get  Agencia By Id
    public TratamientoFarmaco getTratamientoFarmacoById(Long id) {
        String hql = "SELECT p FROM TratamientoFarmaco p WHERE p.id_tratamiento_farmaco = :id";
        Query query = entityManager.createQuery(hql, TratamientoFarmaco.class)
                .setParameter("id", id);
        //query.setParameter("precio", ); aqui entran los poarametros
        TratamientoFarmaco inst = (TratamientoFarmaco) query.getSingleResult();
        return inst;
    }

    @SuppressWarnings("unchecked")
    public List<TratamientoFarmaco> getAllTratamientoFarmacoHabilitadosByIdTratamiento(Long id){
        String hql = "SELECT t FROM TratamientoFarmaco t WHERE t.tratamiento.id_tratamiento = :id and t.estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoFarmaco.class)
                .setParameter("id", id);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<TratamientoFarmaco> getAllTratamientoFarmacoHabilitados(){
        String hql = "SELECT t FROM TratamientoFarmaco t WHERE t.estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoFarmaco.class);
        return query.getResultList();
    }
}

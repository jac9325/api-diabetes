/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoEjercicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Tratamiento
 */
@Repository
public class TratamientoEjercicioRepositoryHb {
    @PersistenceContext
    private EntityManager entityManager;
    
    //Get  Agencia By Id
    public TratamientoEjercicio getTratamientoEjercicioById(Long id) {
        String hql = "SELECT p FROM TratamientoEjercicio p WHERE p.id_tratamiento_ejercicio = :id";
        Query query = entityManager.createQuery(hql, TratamientoEjercicio.class)
                .setParameter("id", id);
        //query.setParameter("precio", ); aqui entran los poarametros
        TratamientoEjercicio inst = (TratamientoEjercicio) query.getSingleResult();
        return inst;
    }

    public List<TratamientoEjercicio> getAllTratamientoEjercicioHabilitadoByIdTratamiento(Long id){
        String hql = "SELECT u FROM TratamientoEjercicio u WHERE u.tratamiento.id_tratamiento = :id and estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoEjercicio.class)
                .setParameter("id", id);
        return query.getResultList();
    }

    public List<TratamientoEjercicio> getAllTratamientoEjercicioHabilitados(){
        String hql = "SELECT u FROM TratamientoEjercicio u WHERE u.estado = 1";
        Query query = entityManager.createQuery(hql, TratamientoEjercicio.class);
        return query.getResultList();
    }
}

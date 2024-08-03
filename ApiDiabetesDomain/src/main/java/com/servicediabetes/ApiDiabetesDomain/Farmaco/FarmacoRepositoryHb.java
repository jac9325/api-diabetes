/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

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
public class FarmacoRepositoryHb {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Farmaco getFarmacoById(Long id){
        String hql = "SELECT p FROM Farmaco p WHERE p.id_farmaco =: id and p.estado = 1";
        Query query = entityManager.createQuery(hql, Farmaco.class)
                        .setParameter("id", id);
        Farmaco inst = (Farmaco) query.getSingleResult();
        return inst;
    }

    public List<Farmaco> getListAllFarmaco(){
        String hql = "SELECT p FROM Farmaco p WHERE p.estado = 1";
        Query query = entityManager.createQuery(hql, Farmaco.class);
        List<Farmaco> list = query.getResultList();
        return list;
    }
    
}

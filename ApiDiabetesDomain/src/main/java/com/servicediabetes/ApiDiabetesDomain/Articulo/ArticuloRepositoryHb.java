/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

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
public class ArticuloRepositoryHb {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Articulo> getListAllArticulo(){
        String hql = "SELECT a FROM Articulo a WHERE a.estado = 1";
        Query query = entityManager.createQuery(hql, Articulo.class);
        List<Articulo> list = query.getResultList();
        return list;
    }
}

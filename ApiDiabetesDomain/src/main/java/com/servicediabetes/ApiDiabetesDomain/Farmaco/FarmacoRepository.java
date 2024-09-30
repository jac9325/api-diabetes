/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface FarmacoRepository extends JpaRepository< Farmaco, Long>{
    @Query(value = "SELECT f.* FROM farmaco f " + 
                   "JOIN tratamientoFarmaco tf ON f.id_farmaco = tf.id_farmaco " +
                   "WHERE tf.id_tratamiento = ?1 and tf.estado = 1", nativeQuery = true)
    Optional<List<Farmaco>> getFarmacosByIdTratamiento(Long id_tratamiento);
}

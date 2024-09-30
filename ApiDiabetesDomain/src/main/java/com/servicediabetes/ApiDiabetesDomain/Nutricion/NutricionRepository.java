/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface NutricionRepository extends JpaRepository<   Nutricion, Long> {
    @Query(value = "SELECT n.* FROM nutricion n " + 
                   "JOIN tratamientoNutricion tn ON n.id_nutricion = tn.id_nutricion " +
                   "JOIN tratamiento t ON t.id_tratamiento = tn.id_tratamiento " +
                   "JOIN usuarioTratamiento ut ON ut.id_tratamiento = t.id_tratamiento " +
                   "WHERE ut.id_usuario = ?1", nativeQuery = true)
    Optional<List<Nutricion>> getListNutricionByIdUsuario(Long id_usuario);

    @Query(value = "SELECT n.* FROM nutricion n " + 
                   "JOIN tratamientoNutricion tn ON n.id_nutricion = tn.id_nutricion " +
                   "WHERE tn.id_tratamiento = ?1 and tn.estado = 1", nativeQuery = true)
    Optional<List<Nutricion>> getListNutricionByIdTratamiento(Long id_tratamiento);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Usuario
 */
public interface EjercicioRepository extends JpaRepository<  Ejercicio, Long> {
    @Query(value = "SELECT e.* FROM ejercicio e " + 
                   "JOIN tratamientoEjercicio te ON e.id_ejercicio = te.id_ejercicio " +
                   "JOIN tratamiento t ON t.id_tratamiento = te.id_tratamiento " +
                   "JOIN usuarioTratamiento ut ON ut.id_tratamiento = t.id_tratamiento " +
                   "WHERE ut.id_usuario = ?1", nativeQuery = true)
    Optional<List<Ejercicio>> getEjerciciosByIdUsuario(Long id_usuario);

    @Query(value = "SELECT e.* FROM ejercicio e " + 
                   "JOIN tratamientoEjercicio te ON e.id_ejercicio = te.id_ejercicio " +
                   "WHERE te.id_tratamiento = ?1 and te.estado = 1", nativeQuery = true)
    Optional<List<Ejercicio>> getEjerciciosByIdTratamiento(Long id_tratamiento);
}
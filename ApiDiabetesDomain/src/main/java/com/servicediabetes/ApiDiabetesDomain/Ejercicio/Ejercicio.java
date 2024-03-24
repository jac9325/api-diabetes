/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacs9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ejercicio")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ejercicio")
    private long id_ejercicio;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "dificultad", nullable = false)
    private String dificultad;

    @Column(name = "tipo_ejercicio", nullable = false)
    private String tipo_ejercicio;

    @Column(name = "duracion", nullable = false)
    private String duracion;
    
    @Column(name = "intensidad", nullable = false)
    private String intensidad;

    @Column(name = "nivel_dificultad", nullable = false)
    private String nivel_dificultad;

    @Column(name = "beneficios", nullable = false)
    private String beneficios;

    @Column(name = "precauciones", nullable = false)
    private String precauciones;

    @Column(name = "frecuencia", nullable = false)
    private String frecuencia;
    
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class EjercicioDtos {
    private Long id_ejercicio;
    private String nombre;
    private String descripcion;
    private String dificultad;
    private String tipo_ejercicio;
    private String duracion;
    private String intensidad;
    private String nivel_dificultad;
    private String beneficios;
    private String precauciones;
    private String frecuencia;
    private Integer estado;
}

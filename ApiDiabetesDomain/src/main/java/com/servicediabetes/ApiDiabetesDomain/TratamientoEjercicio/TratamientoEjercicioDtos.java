/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoEjercicio;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class TratamientoEjercicioDtos {
    private Long id_tratamiento_ejercicio;
    private Long id_tratamiento;
    private Long id_ejercicio;
    private Integer estado;
}

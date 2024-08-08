/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class TratamientoFarmacoDtos {  
    private Long id_tratamiento_farmaco;
    private Long id_tratamiento;
    private Long id_farmaco;
    private Integer estado;
}

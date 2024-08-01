/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class TratamientoFarmacoUtils {
    public TratamientoFarmacoDtos convertToDTO(TratamientoFarmaco tratamiento){
        TratamientoFarmacoDtos current = new TratamientoFarmacoDtos();
        current.setId_tratamiento_farmaco(tratamiento.getId_tratamiento_farmaco());
        current.setId_tratamiento(tratamiento.getTratamiento().getId_tratamiento());
        current.setId_farmaco(tratamiento.getFarmaco().getId_farmaco());
        return current;
    }
}

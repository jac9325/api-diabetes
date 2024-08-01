/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class TratamientoNutricionUtils {
    
    public TratamientoNutricionDtos convertToDTO(TratamientoNutricion tratamiento){
        TratamientoNutricionDtos current = new TratamientoNutricionDtos();
        current.setId_tratamiento_nutricion(tratamiento.getId_tratamiento_nutricion());
        current.setId_tratamiento(tratamiento.getTratamiento().getId_tratamiento());
        current.setId_nutricion(tratamiento.getNutricion().getId_nutricion());
        return current;
    }
}

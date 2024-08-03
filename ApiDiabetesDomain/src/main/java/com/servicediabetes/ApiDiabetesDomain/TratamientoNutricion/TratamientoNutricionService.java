/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

/**
 *
 * @author Usuario
 */
public interface TratamientoNutricionService {
    
    TratamientoNutricionDtos createTratamientoNutricion(TratamientoNutricion Request);
    TratamientoNutricionDtos getTratamientoNutricionById(long Id);
    
}

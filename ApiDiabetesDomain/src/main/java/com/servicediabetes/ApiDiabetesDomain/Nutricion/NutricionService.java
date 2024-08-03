/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface NutricionService {
    
    NutricionDtos getNutricionById(Long id);
    List<NutricionDtos> getAllNutricion();
    
}

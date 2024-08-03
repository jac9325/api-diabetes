/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
@Service
public class TratamientoNutricionServiceImpl implements  TratamientoNutricionService {
    
    private final TratamientoNutricionUtils tratamientoNutricionUtils;
    private final TratamientoNutricionRepositoryHb tratamientoNutricionRepositoryHb;
    private final TratamientoNutricionRepository tratamientoNutricionRepository;
   
    
    @Transactional
    @Override
    public TratamientoNutricionDtos createTratamientoNutricion(TratamientoNutricion Request) {
        try {
           TratamientoNutricion tratamiento = tratamientoNutricionRepository.save(Request);
           
           TratamientoNutricionDtos response = tratamientoNutricionUtils.convertToDTO(tratamiento);
            return response;          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    @Override
    public TratamientoNutricionDtos getTratamientoNutricionById(long Id) {
        try {
            TratamientoNutricion tratamiento = tratamientoNutricionRepositoryHb.getTratamientoNutricionById(Id);
                if (tratamiento == null){
                    return null;
                }else{
                    //Preparo el Dto response
                    TratamientoNutricionDtos response = tratamientoNutricionUtils.convertToDTO(tratamiento);
                    return response;
                }          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}

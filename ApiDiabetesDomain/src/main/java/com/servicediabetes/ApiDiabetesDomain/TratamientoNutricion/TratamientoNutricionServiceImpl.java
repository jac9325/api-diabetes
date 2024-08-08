/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import lombok.AllArgsConstructor;

import java.util.List;

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
    public TratamientoNutricionDtos getTratamientoNutricionById(Long Id) {
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

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoNutricionDtos> getAllTratamientoNutricionHabilitadosByIdTratamiento(Long id) {
        try {
            List<TratamientoNutricion> currentListTratamientoNutricion = tratamientoNutricionRepositoryHb.getAllTratamientoNutricionHabilitadosByIdTratamiento(id);
            if (currentListTratamientoNutricion == null || currentListTratamientoNutricion.isEmpty()) {
                return null;
            } else {
                List<TratamientoNutricionDtos> currentTratamientoNutricionDtos = tratamientoNutricionUtils.convertToDtoList(currentListTratamientoNutricion);
                return currentTratamientoNutricionDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<TratamientoNutricionDtos> getAllTratamientoNutricionHabilitados() {
        try {
            List<TratamientoNutricion> currentListTratamientoNutricion = tratamientoNutricionRepositoryHb.getAllTratamientoNutricionHabilitados();
            if (currentListTratamientoNutricion == null || currentListTratamientoNutricion.isEmpty()) {
                return null;
            } else {
                List<TratamientoNutricionDtos> currentListTratamientoNutricionDtos = tratamientoNutricionUtils.convertToDtoList(currentListTratamientoNutricion);
                return currentListTratamientoNutricionDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

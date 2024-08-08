/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

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
public class TratamientoFarmacoServiceImpl implements TratamientoFarmacoService  {
    private final TratamientoFarmacoUtils tratamientoFarmacoUtils;
    private final TratamientoFarmacoRepositoryHb tratamientoFarmacoRepositoryHb;
    private final TratamientoFarmacoRepository tratamientoFarmacoRepository;
   
    
    @Transactional
    @Override
    public TratamientoFarmacoDtos createTratamientoFarmaco(TratamientoFarmaco Request) {
        try {
           TratamientoFarmaco tratamiento = tratamientoFarmacoRepository.save(Request);
           
          TratamientoFarmacoDtos response = tratamientoFarmacoUtils.convertToDTO(tratamiento);
            return response;          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    @Override
    public TratamientoFarmacoDtos getTratamientoFarmacoById(Long Id) {
        try {
            TratamientoFarmaco tratamiento = tratamientoFarmacoRepositoryHb.getTratamientoFarmacoById(Id);
                if (tratamiento == null){
                    return null;
                }else{
                    //Preparo el Dto response
                    TratamientoFarmacoDtos response = tratamientoFarmacoUtils.convertToDTO(tratamiento);
                    return response;
                }          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoFarmacoDtos> getAllTratamientoFarmacoHabilitadosByIdTratamiento(Long id) {
        try {
            List<TratamientoFarmaco> currentTratamientoFarmaco = tratamientoFarmacoRepositoryHb.getAllTratamientoFarmacoHabilitadosByIdTratamiento(id);
            if (currentTratamientoFarmaco == null || currentTratamientoFarmaco.isEmpty()){
                return null;
            } else {
                List<TratamientoFarmacoDtos> currentTratamientoFarmacoDtos = tratamientoFarmacoUtils.convertToDtoList(currentTratamientoFarmaco);
                return currentTratamientoFarmacoDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoFarmacoDtos> getAllTratamientoFarmacoHabilitados() {
        try {
            List<TratamientoFarmaco> currentListTratamientoFarmacos = tratamientoFarmacoRepositoryHb.getAllTratamientoFarmacoHabilitados();
            if (currentListTratamientoFarmacos == null || currentListTratamientoFarmacos.isEmpty()) {
                return null;
            } else {
                List<TratamientoFarmacoDtos> currentListTratamientoFarmacosDtos = tratamientoFarmacoUtils.convertToDtoList(currentListTratamientoFarmacos);
                return currentListTratamientoFarmacosDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

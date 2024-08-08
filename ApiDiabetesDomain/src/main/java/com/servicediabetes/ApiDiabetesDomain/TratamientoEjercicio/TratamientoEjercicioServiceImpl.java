/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoEjercicio;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Tratamiento
 */
@AllArgsConstructor
@Service
public class TratamientoEjercicioServiceImpl implements TratamientoEjercicioService{
    private final TratamientoEjercicioUtils TratamientoEjercicioUtils;
    private final TratamientoEjercicioRepositoryHb TratamientoEjercicioRepositoryHb;
    private final TratamientoEjercicioRepository TratamientoEjercicioRepository;
   
    
    @Transactional
    @Override
    public TratamientoEjercicioDtos createTratamientoEjercicio(TratamientoEjercicio Request) {
        try {
           TratamientoEjercicio userEjer = TratamientoEjercicioRepository.save(Request);
           
           TratamientoEjercicioDtos response = TratamientoEjercicioUtils.convertToDTO(userEjer);
            return response;          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    @Override
    public TratamientoEjercicioDtos getTratamientoEjercicioById(long Id) {
        try {
            TratamientoEjercicio userEjer = TratamientoEjercicioRepositoryHb.getTratamientoEjercicioById(Id);
                if (userEjer == null){
                    return null;
                }else{
                    //Preparo el Dto response
                    TratamientoEjercicioDtos response = TratamientoEjercicioUtils.convertToDTO(userEjer);
                    return response;
                }          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoEjercicioDtos> getAllTratamientoEjercicioHabilitadoByIdTratamiento(Long id) {
        try {
            List<TratamientoEjercicio> currentListTratamientoEjercicio = TratamientoEjercicioRepositoryHb.getAllTratamientoEjercicioHabilitadoByIdTratamiento(id);
            if (currentListTratamientoEjercicio == null || currentListTratamientoEjercicio.isEmpty()){
                return null;
            } else {
                List<TratamientoEjercicioDtos> currentListTratamientoEjercicioDtos = TratamientoEjercicioUtils.convertToDtoList(currentListTratamientoEjercicio);
                return currentListTratamientoEjercicioDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }   

    @Transactional(readOnly = true)
    @Override
    public List<TratamientoEjercicioDtos> getAllTratamientoEjercicioHabilitados() {
        try {
            List<TratamientoEjercicio> currentListTratamientoEjercicio  = TratamientoEjercicioRepositoryHb.getAllTratamientoEjercicioHabilitados();
            if (currentListTratamientoEjercicio == null || currentListTratamientoEjercicio.isEmpty()){
                return null;
            } else {
                List<TratamientoEjercicioDtos> currentListTratamientoEjercicioDtos = TratamientoEjercicioUtils.convertToDtoList(currentListTratamientoEjercicio);
                return currentListTratamientoEjercicioDtos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

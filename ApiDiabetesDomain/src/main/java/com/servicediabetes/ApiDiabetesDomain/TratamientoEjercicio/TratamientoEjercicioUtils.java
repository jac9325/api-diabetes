/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoEjercicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class TratamientoEjercicioUtils {
    public TratamientoEjercicioDtos convertToDTO(TratamientoEjercicio user){
        TratamientoEjercicioDtos current = new TratamientoEjercicioDtos();
        current.setId_tratamiento_ejercicio(user.getId_tratamiento_ejercicio());
        current.setId_ejercicio(user.getEjercicio().getId_ejercicio());
        current.setId_tratamiento(user.getTratamiento().getId_tratamiento());
        current.setEstado(user.getEstado());
        return current;
    }
    
    public  List<TratamientoEjercicioDtos> convertToDtoList(List<TratamientoEjercicio> listTratamientoEjercicio) {
        return listTratamientoEjercicio.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

import java.util.List;
import java.util.stream.Collectors;

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
        current.setEstado(tratamiento.getEstado());
        return current;
    }

    public  List<TratamientoFarmacoDtos> convertToDtoList(List<TratamientoFarmaco> listTratamientoFarmaco) {
        return listTratamientoFarmaco.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class FarmacoUtils {
    public FarmacoDtos convertToDTO( Farmaco farmaco){
        FarmacoDtos current= new FarmacoDtos();
        current.setId_farmaco(farmaco.getId_farmaco());
        current.setDosis(farmaco.getDosis());
        current.setFrecuencia(farmaco.getFrecuencia());
        current.setNombre(farmaco.getNombre());
        current.setPresentacion(farmaco.getPresentacion());
        current.setComposicion_quimica(farmaco.getComposicion_quimica());
        current.setTipo(farmaco.getTipo());
        current.setContraindicaciones(farmaco.getContraindicaciones());
        current.setIndicaciones(farmaco.getIndicaciones());
        current.setTimepoInicio(farmaco.getTimepoinicio());
        current.setEfectosSecundarios(farmaco.getEfectossecundarios());
        current.setEstado(farmaco.getEstado());
        return current;
    }

    public  List<FarmacoDtos> convertToDtoList(List<Farmaco> farmacoList) {
        return farmacoList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Farmaco convertToEntity(Farmaco farmaco){
        Farmaco current= new Farmaco();
        current.setId_farmaco(farmaco.getId_farmaco());
        current.setDosis(farmaco.getDosis());
        current.setFrecuencia(farmaco.getFrecuencia());
        current.setNombre(farmaco.getNombre());
        current.setPresentacion(farmaco.getPresentacion());
        current.setComposicion_quimica(farmaco.getComposicion_quimica());
        current.setTipo(farmaco.getTipo());
        current.setContraindicaciones(farmaco.getContraindicaciones());
        current.setIndicaciones(farmaco.getIndicaciones());
        current.setTimepoinicio(farmaco.getTimepoinicio());
        current.setEfectossecundarios(farmaco.getEfectossecundarios());
        current.setEstado(farmaco.getEstado());
        return current;
    }
    
}

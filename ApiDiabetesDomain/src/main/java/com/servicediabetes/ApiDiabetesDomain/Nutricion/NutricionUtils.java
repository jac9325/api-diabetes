/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class NutricionUtils {
    public NutricionDtos convertToDTO( Nutricion nutricion){
        NutricionDtos current= new NutricionDtos();
        current.setId_nutricion(nutricion.getId_nutricion());
        current.setTipo_comida(nutricion.getTipo_comida());
        current.setFecha(nutricion.getFecha());
        current.setDescripcion(nutricion.getDescripcion());
        current.setCantidad(nutricion.getCantidad());
        current.setCalorias(nutricion.getCalorias());
        current.setCarbohidratos(nutricion.getCarbohidratos());
        current.setProteinas(nutricion.getProteinas());
        current.setGrasas(nutricion.getGrasas());
        current.setFibra(nutricion.getFibra());
        current.setAzucares(nutricion.getAzucares());
        current.setSodio(nutricion.getSodio());
        current.setNotas_adicionales(nutricion.getNotas_adicionales());
        current.setEstado(nutricion.getEstado());
        
        return current;
  
    }

    public  List<NutricionDtos> convertToDtoList(List<Nutricion> nutricionList) {
        return  nutricionList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Nutricion convertToEntity(Nutricion nutricion){
         Nutricion current= new Nutricion();
        current.setId_nutricion(nutricion.getId_nutricion());
        current.setTipo_comida(nutricion.getTipo_comida());
        current.setFecha(nutricion.getFecha());
        current.setDescripcion(nutricion.getDescripcion());
        current.setCantidad(nutricion.getCantidad());
        current.setCalorias(nutricion.getCalorias());
        current.setCarbohidratos(nutricion.getCarbohidratos());
        current.setProteinas(nutricion.getProteinas());
        current.setGrasas(nutricion.getGrasas());
        current.setFibra(nutricion.getFibra());
        current.setAzucares(nutricion.getAzucares());
        current.setSodio(nutricion.getSodio());
        current.setNotas_adicionales(nutricion.getNotas_adicionales());
        current.setEstado(nutricion.getEstado());
        
        return current;

    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class EjercicioUtils {
    public EjercicioDtos convertToDTO( Ejercicio ejercicio){
        EjercicioDtos current= new EjercicioDtos();
        
        current.setId_ejercicio(ejercicio.getId_ejercicio());
        current.setNombre(ejercicio.getNombre());
        current.setDescripcion(ejercicio.getDescripcion());
        current.setDificultad(ejercicio.getDificultad());
        current.setTipo_ejercicio(ejercicio.getTipo_ejercicio());
        current.setDuracion(ejercicio.getDuracion());
        current.setIntensidad(ejercicio.getIntensidad());
        current.setNivel_dificultad(ejercicio.getNivel_dificultad());
        current.setBeneficios(ejercicio.getBeneficios());
        current.setDescripcion(ejercicio.getDescripcion());
        current.setPrecauciones(ejercicio.getPrecauciones());
        current.setFrecuencia(ejercicio.getFrecuencia());
        current.setEstado(ejercicio.getEstado());
        return current;
  
    }

    public  List<EjercicioDtos> convertToDtoList(List<Ejercicio> ejercicioList) {
        return  ejercicioList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Ejercicio convertToEntity(EjercicioDtos ejercicio){
        Ejercicio current= new Ejercicio();
        current.setNombre(ejercicio.getNombre());
        current.setDescripcion(ejercicio.getDescripcion());
        current.setDificultad(ejercicio.getDificultad());
        current.setTipo_ejercicio(ejercicio.getTipo_ejercicio());
        current.setDuracion(ejercicio.getDuracion());
        current.setIntensidad(ejercicio.getIntensidad());
        current.setNivel_dificultad(ejercicio.getNivel_dificultad());
        current.setBeneficios(ejercicio.getBeneficios());
        current.setDescripcion(ejercicio.getDescripcion());
        current.setPrecauciones(ejercicio.getPrecauciones());
        current.setFrecuencia(ejercicio.getFrecuencia());
        current.setEstado(ejercicio.getEstado());
        return current;
    }
    
}

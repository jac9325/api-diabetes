/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoEjercicio;

import java.util.List;

/**
 *
 * @author Tratamiento
 */
public interface TratamientoEjercicioService {
    TratamientoEjercicioDtos createTratamientoEjercicio(TratamientoEjercicio Request);
    TratamientoEjercicioDtos getTratamientoEjercicioById(long Id);
    List<TratamientoEjercicioDtos> getAllTratamientoEjercicioHabilitadoByIdTratamiento(Long id);  
    List<TratamientoEjercicioDtos> getAllTratamientoEjercicioHabilitados(); 
}

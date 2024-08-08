package com.servicediabetes.ApiDiabetesDomain.Tratamiento;


import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;
import java.util.List;
public interface TratamientoService {
    TratamientoDtos createTratamiento(TratamientoDtos request);
    TratamientoDtos getTratamientoById(Long id);
    List<TratamientoDtos> getAllTratamiento();
    Boolean deleteTratamiento(Long id);
    TratamientoDtos updateTratamiento(Long id, TratamientoDtos request);    
    List<TratamientoDtos> getAllTratamientosHabilitados();
    TratamientoDtos getTratamientoHabilitadoByIdUsuario(Long id);
}



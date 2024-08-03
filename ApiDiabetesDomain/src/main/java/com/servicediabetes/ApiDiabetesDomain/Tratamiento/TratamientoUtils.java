package com.servicediabetes.ApiDiabetesDomain.Tratamiento;

import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.ETipoTratamiento;
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;



@Component
public class TratamientoUtils {

    public TratamientoDtos convertToDto(Tratamiento tratamiento) {
        TratamientoDtos dto = new TratamientoDtos();
        dto.setId_tratamiento(tratamiento.getId_tratamiento());
        dto.setTipo_tratamiento(tratamiento.getTipo_tratamiento());
        dto.setFecha_inicio(tratamiento.getFecha_inicio());
        dto.setFecha_fin(tratamiento.getFecha_fin());
        dto.setInstrucciones_generales(tratamiento.getInstrucciones_generales());
        dto.setInstrucciones_especiales(tratamiento.getInstrucciones_especiales());
        dto.setEfectos_secundarios(tratamiento.getEfectos_secundarios());
        dto.setNotas(tratamiento.getNotas());
        dto.setObservaciones(tratamiento.getObservaciones());
        dto.setEstado(tratamiento.getEstado());
        return dto;
    }

    public List<TratamientoDtos> convertToDtoList(List<Tratamiento> listTratamiento) {
        return listTratamiento.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Tratamiento convertToEntity(TratamientoDtos tratamientoDto) {
        Tratamiento entity = new Tratamiento();
        entity.setId_tratamiento(tratamientoDto.getId_tratamiento());
        entity.setTipo_tratamiento((ETipoTratamiento) tratamientoDto.getTipo_tratamiento());
        entity.setFecha_inicio(tratamientoDto.getFecha_inicio());
        entity.setFecha_fin(tratamientoDto.getFecha_fin());
        entity.setInstrucciones_generales(tratamientoDto.getInstrucciones_generales());
        entity.setInstrucciones_especiales(tratamientoDto.getInstrucciones_especiales());
        entity.setEfectos_secundarios(tratamientoDto.getEfectos_secundarios());
        entity.setNotas(tratamientoDto.getNotas());
        entity.setObservaciones(tratamientoDto.getObservaciones());
        entity.setEstado(tratamientoDto.getEstado());
        return entity;
    }
    
    // Agrega aquí tus nuevos métodos o realiza las modificaciones necesarias
}

package com.servicediabetes.ApiDiabetesDomain.DTO;

import java.util.List;

import com.servicediabetes.ApiDiabetesDomain.Ejercicio.EjercicioDtos;
import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoDtos;
import com.servicediabetes.ApiDiabetesDomain.Nutricion.NutricionDtos;
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosGenericos {
    List<TratamientoDtos> tratamiento;
    List<FarmacoDtos> farmaco;
    List<EjercicioDtos> ejercicio;
    List<NutricionDtos> nutricion;
}

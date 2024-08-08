package com.servicediabetes.ApiDiabetesDomain.DTO;

import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosGenericosPaciente {
    DatosGenericos datosGenericos;
    TratamientoDtos tratamiento;
}

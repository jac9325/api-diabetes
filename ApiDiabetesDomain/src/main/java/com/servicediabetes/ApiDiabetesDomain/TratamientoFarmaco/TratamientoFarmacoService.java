/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoFarmaco;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface TratamientoFarmacoService {
    TratamientoFarmacoDtos createTratamientoFarmaco(TratamientoFarmaco Request);
    TratamientoFarmacoDtos getTratamientoFarmacoById(Long Id);
    List<TratamientoFarmacoDtos> getAllTratamientoFarmacoHabilitadosByIdTratamiento(Long id);
    List<TratamientoFarmacoDtos> getAllTratamientoFarmacoHabilitados();
}

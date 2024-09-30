/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface FarmacoService {
    List<FarmacoDtos> getAllFarmaco();
    FarmacoDtos getFarmacoById(Long id);
    List<FarmacoDtos> getFarmacosByIdTratamiento(Long id);
}

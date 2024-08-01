/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface EjercicioService {
    EjercicioDtos getEjercicioById(Long id);
    List<EjercicioDtos> getAllEjercicio();
    EjercicioDtos createEjercicio(EjercicioDtos request);
    Boolean deleteEjercicio(Long id);
    EjercicioDtos updateEjercicio(Long id, EjercicioDtos request);
}

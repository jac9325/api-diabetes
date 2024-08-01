/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioEjercicio;

import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class UsuarioEjercicioUtils {
    public UsuarioEjercicioDtos convertToDTO(UsuarioEjercicio user){
        UsuarioEjercicioDtos current = new UsuarioEjercicioDtos();
        current.setId_tratamiento_ejercicio(user.getId_tratamiento_ejercicio());
        current.setId_ejercicio(user.getEjercicio().getId_ejercicio());
        current.setId_tratamiento(user.getTratamiento().getId_tratamiento());
        return current;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioTratamiento;

/**
 *
 * @author Usuario
 */
public interface UsuarioTratamientoService {
    UsuarioTratamientoDtos createUsuarioTratamiento(UsuarioTratamiento Request);
    UsuarioTratamientoDtos getUsuarioTratamientoById(long Id);
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioTratamiento;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
@Service
public class UsuarioTratamientoServiceImpl implements UsuarioTratamientoService {
    
    private final UsuarioTratamientoUtils usuarioTratamientoUtils;
    private final UsuarioTratamientoRepositoryHb usuarioTratamientoRepositoryHb;
    private final UsuarioTratamientoRepository usuarioTratamientoRepository;
   
    
    @Transactional
    @Override
    public UsuarioTratamientoDtos createUsuarioTratamiento(UsuarioTratamiento Request) {
        try {
           UsuarioTratamiento tratamiento = usuarioTratamientoRepository.save(Request);
           
           UsuarioTratamientoDtos response = usuarioTratamientoUtils.convertToDTO(tratamiento);
            return response;          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    @Override
    public UsuarioTratamientoDtos getUsuarioTratamientoById(long Id) {
        try {
            UsuarioTratamiento tratamiento = usuarioTratamientoRepositoryHb.getUsuarioTratamientoById(Id);
                if (tratamiento == null){
                    return null;
                }else{
                    //Preparo el Dto response
                    UsuarioTratamientoDtos response = usuarioTratamientoUtils.convertToDTO(tratamiento);
                    return response;
                }          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}

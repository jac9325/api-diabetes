/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioEjercicio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@AllArgsConstructor
@Service
public class UsuarioEjercicioServiceImpl implements UsuarioEjercicioService{
    private final UsuarioEjercicioUtils usuarioEjercicioUtils;
    private final UsuarioEjercicioRepositoryHb usuarioEjercicioRepositoryHb;
    private final UsuarioEjercicioRepository usuarioEjercicioRepository;
   
    
    @Transactional
    @Override
    public UsuarioEjercicioDtos createUsuarioEjercicio(UsuarioEjercicio Request) {
        try {
           UsuarioEjercicio userEjer = usuarioEjercicioRepository.save(Request);
           
           UsuarioEjercicioDtos response = usuarioEjercicioUtils.convertToDTO(userEjer);
            return response;          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    @Override
    public UsuarioEjercicioDtos getUsuarioEjercicioById(long Id) {
        try {
            UsuarioEjercicio userEjer = usuarioEjercicioRepositoryHb.getUsuarioEjercicioById(Id);
                if (userEjer == null){
                    return null;
                }else{
                    //Preparo el Dto response
                    UsuarioEjercicioDtos response = usuarioEjercicioUtils.convertToDTO(userEjer);
                    return response;
                }          
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}

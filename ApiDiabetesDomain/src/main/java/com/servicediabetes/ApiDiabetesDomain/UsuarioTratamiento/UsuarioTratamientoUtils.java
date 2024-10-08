/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioTratamiento;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class UsuarioTratamientoUtils {
    public UsuarioTratamientoDtos convertToDTO(UsuarioTratamiento user){
        UsuarioTratamientoDtos current = new UsuarioTratamientoDtos();
        current.setId_usuario_tratamiento(user.getId_usuario_tratamiento());
        current.setId_tratamiento(user.getTratamiento().getId_tratamiento());
        current.setId_usuario(user.getUsuario().getId_usuario());
        current.setEstado(user.getEstado());
        return current;
    }

    public  List<UsuarioTratamientoDtos> convertToDtoList(List<UsuarioTratamiento> listUsuarioTratamiento) {
        return listUsuarioTratamiento.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioTratamiento;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class UsuarioTratamientoDtos {
    private Long id_usuario_tratamiento;
    private Long id_tratamiento;
    private Long id_usuario;
    private Integer estado;
}

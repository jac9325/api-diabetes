package com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class UsuarioRequest {

    private String nombre_apellido;
    private String correo;
    private Integer edad;
    private String contrasena;
    private Date fecha_nacimiento;
}
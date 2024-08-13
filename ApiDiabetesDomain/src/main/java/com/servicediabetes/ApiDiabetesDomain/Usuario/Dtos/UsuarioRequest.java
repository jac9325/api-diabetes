package com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre_apellido;
    private String numero;
    private String correo;
    private Integer edad;
    private String contrasena;
    private Date fecha_nacimiento;
    private Date inicio_diabetes;
    private Date fecha_registro_app;
    private BigDecimal altura;
    private BigDecimal peso;
    private String alergias;
    private Integer estado;
    private String foto_usuario;
    private Boolean es_primera_vez;
}
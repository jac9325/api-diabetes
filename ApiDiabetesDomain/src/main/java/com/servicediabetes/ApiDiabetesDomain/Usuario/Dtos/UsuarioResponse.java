package com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class UsuarioResponse {
    private long id_usuario;

    private String nombre_apellido;

    private String numero;

    private String correo;

    private Integer edad;

    private String contrasena;

    private Date fecha_nacimiento;
    
    private Date fecha_registro_app;

    private BigDecimal altura;

    private BigDecimal peso;
    
    private String alergias;

    private int estado;

    private String foto_usuario;

    private Long id_rol_usuario;
}

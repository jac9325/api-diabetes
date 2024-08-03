<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.math.BigDecimal;
import java.util.Date;

import com.servicediabetes.ApiDiabetesDomain.RolUsuario.RolUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacs9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private long id_usuario;

    @Column(name = "nombre_apellido", nullable = false)
    private String nombre_apellido;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;
    
    @Column(name = "fecha_registro_app", nullable = false)
    private Date fecha_registro_app;

    @Column(name = "altura", nullable = false)
    private BigDecimal altura;

    @Column(name = "peso", nullable = false)
    private BigDecimal peso;
    
    @Column(name = "alergias", nullable = false)
    private String alergias;

    @Column(name = "estado")
    private int estado;
    
    @Column(name = "foto_usuario", nullable = false)
    private String foto_usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_rol_usuario", nullable = false)
    private RolUsuario rolUsuario;

}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.math.BigDecimal;
import java.util.Date;

import com.servicediabetes.ApiDiabetesDomain.RolUsuario.RolUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacs9
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "nombre_apellido", nullable = false)
    private String nombre_apellido;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;
    
    @Column(name = "fecha_registro_app")
    private Date fecha_registro_app;

    @Column(name = "altura")
    private BigDecimal altura;

    @Column(name = "peso")
    private BigDecimal peso;
    
    @Column(name = "alergias")
    private String alergias;

    @Column(name = "estado", nullable = false)
    private Integer estado;
    
    @Column(name = "foto_usuario")
    private String foto_usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_rol_usuario", nullable = false)
    private RolUsuario rolUsuario;

}
>>>>>>> master

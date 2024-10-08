/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacs9
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "farmaco")
public class Farmaco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_farmaco")
    private Long id_farmaco;

    @Column(name = "dosis", nullable = false)
    private String dosis;

    @Column(name = "frecuencia", nullable = false)
    private String frecuencia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "presentacion", nullable = false)
    private String presentacion;

    @Column(name = "composicion_quimica", nullable = false)
    private String composicion_quimica;
    
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "contraindicaciones", nullable = false)
    private String contraindicaciones;

    @Column(name = "indicaciones", nullable = false)
    private String indicaciones;

    @Column(name = "tiempoinicio", nullable = false)
    private Date timepoinicio;

    @Column(name = "efectossecundarios", nullable = false)
    private String efectossecundarios;
    
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

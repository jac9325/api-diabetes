/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Medicion;

import java.math.BigDecimal;
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
@Table(name = "mediciones")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mediciones")
    private long id_mediciones;

    @Column(name = "tipo_medicion", nullable = false)
    private String tipo_medicion;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "valor_numerico", nullable = false)
    private BigDecimal valor_numerico;

    @Column(name = "unidad_medida", nullable = false)
    private String unidad_medida;

    @Column(name = "paramtetro_medicion", nullable = false)
    private String paramtetro_medicion;

    @Column(name = "observaciones", nullable = false)
    private String observaciones;
    
    @Column(name = "diagnostico", nullable = false)
    private String diagnostico;
    
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

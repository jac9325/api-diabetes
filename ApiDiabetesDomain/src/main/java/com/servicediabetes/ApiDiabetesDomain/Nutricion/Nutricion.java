/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

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
@Table(name = "nutricion")
public class Nutricion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nutricion")
    private long id_nutricion;

    @Column(name = "tipo_comida", nullable = false)
    private String tipo_comida;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private BigDecimal cantidad;

    @Column(name = "calorias", nullable = false)
    private BigDecimal calorias;

    @Column(name = "carbohidratos", nullable = false)
    private BigDecimal carbohidratos;

    @Column(name = "proteinas", nullable = false)
    private BigDecimal proteinas;

    @Column(name = "grasas", nullable = false)
    private BigDecimal grasas;

    @Column(name = "fibra", nullable = false)
    private BigDecimal fibra;

    @Column(name = "azucares", nullable = false)
    private BigDecimal azucares;

    @Column(name = "sodio", nullable = false)
    private BigDecimal sodio;

    @Column(name = "notas_adicionales", nullable = false)
    private String notas_adicionales;
    
    @Column(name = "estado")
    private int estado;
}

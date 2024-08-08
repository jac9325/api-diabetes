/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class NutricionDtos {
    private Long id_nutricion;
    private String tipo_comida;
    private Date fecha;
    private String descripcion;
    private BigDecimal cantidad;
    private BigDecimal calorias;
    private BigDecimal carbohidratos;
    private BigDecimal proteinas;
    private BigDecimal grasas;
    private BigDecimal fibra;
    private BigDecimal azucares;
    private BigDecimal sodio;
    private String notas_adicionales;
    private int estado;
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class FarmacoDtos {
    private Long id_farmaco;
    private String dosis;
    private String frecuencia;
    private String nombre;
    private String presentacion;
    private String composicion_quimica;
    private String tipo;
    private String contraindicaciones;
    private String indicaciones;
    private Date tiempoinicio;
    private String efectossecundarios;
    private Integer estado;
    
}

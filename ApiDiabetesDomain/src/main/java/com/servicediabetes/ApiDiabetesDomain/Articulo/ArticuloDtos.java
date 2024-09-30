/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class ArticuloDtos {
    private long id_articulo;
    private String titulo;
    private String contenido;
    private Date fecha_publicacion;
    private String autor;
    private String etiquetas;
    private String imagen;
    private String enlace;
    private Integer estado;
}

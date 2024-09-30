/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

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
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_articulo")
    private long id_articulo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "fecha_publicacion", nullable = false)
    private Date fecha_publicacion;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "etiquetas", nullable = false)
    private String etiquetas;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Column(name = "enlace", nullable = false)
    private String enlace;
    
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

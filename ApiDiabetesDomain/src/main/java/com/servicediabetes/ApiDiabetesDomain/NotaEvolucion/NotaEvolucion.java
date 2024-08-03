/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.NotaEvolucion;

import java.util.Date;

import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Tratamiento;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notasevolucion")
public class NotaEvolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nota_evolucion")
    private long id_nota_evolucion;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name="id_tratamiento")
    private Tratamiento tratamiento;
    
    @Column(name = "estado", nullable = false)
    private Integer estado;
}

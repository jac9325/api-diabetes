/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import com.servicediabetes.ApiDiabetesDomain.Nutricion.Nutricion;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tratamientonutricion")
public class TratamientoNutricion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tratamiento_nutricion")
    private long id_tratamiento_nutricion;

    @ManyToOne
    @JoinColumn(name="id_tratamiento")
    private Tratamiento tratamiento;

    @ManyToOne
    @JoinColumn(name="id_nutricion")
    private Nutricion nutricion;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.UsuarioMedicion;

import java.math.BigDecimal;
import java.util.Date;

import com.servicediabetes.ApiDiabetesDomain.Medicion.Medicion;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Usuario;

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
@Table(name = "usuariomediciones")
public class UsuarioMedicion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario_mediciones")
    private long id_usuario_mediciones;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_mediciones")
    private Medicion medicion;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "fecha")
    private Date fecha;
}

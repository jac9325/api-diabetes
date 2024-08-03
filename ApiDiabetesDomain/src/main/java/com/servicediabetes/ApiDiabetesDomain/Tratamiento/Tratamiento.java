<<<<<<< HEAD
package com.servicediabetes.ApiDiabetesDomain.Tratamiento;

import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.ETipoTratamiento;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tratamiento")
    private Long id_tratamiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tratamiento", nullable = false)
    private ETipoTratamiento tipo_tratamiento;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fecha_fin;

    @Column(name = "instrucciones_generales", nullable = false)
    private String instrucciones_generales;

    @Column(name = "instrucciones_especiales", nullable = false)
    private String instrucciones_especiales;

    @Column(name = "efectos_secundarios", nullable = false)
    private String efectos_secundarios;

    @Column(name = "notas", nullable = false)
    private String notas;

    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @Column(name = "estado")
    private Integer estado;

    
}

package com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos;


//import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
//import javax.persistence.Enumerated;

/* 
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.ETipoTratamiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoDtos {
    private Long id_tratamiento;
    //@Enumerated(EnumType.String)
    private ETipoTratamiento tipo_tratamiento;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String instrucciones_generales;
    private String instrucciones_especiales;
    private String efectos_secundarios;
    private String notas;
    private String observaciones;
    private Integer estado;
}
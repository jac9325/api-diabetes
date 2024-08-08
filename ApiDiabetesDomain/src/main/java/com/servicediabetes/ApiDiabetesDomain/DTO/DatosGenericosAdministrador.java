package com.servicediabetes.ApiDiabetesDomain.DTO;

import java.util.List;

import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosGenericosAdministrador {
    DatosGenericos datosGenericos;
    List<UsuarioResponse> usuario;
}
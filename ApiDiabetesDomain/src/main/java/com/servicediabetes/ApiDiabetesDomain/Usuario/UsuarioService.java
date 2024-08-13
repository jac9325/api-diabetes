package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.util.List;

import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosAdministrador;
import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosPaciente;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse registerUser(UsuarioRequest userRequest);
    UsuarioResponse getUserById(Long id);
    List<UsuarioResponse> getAllUsers();
    UsuarioResponse updateUser(Long id, UsuarioRequest userRequest);
    Boolean deleteUser(Long id);
    //Path getURL();
    DatosGenericosPaciente getAllDatosPaciente(Long id);
    DatosGenericosAdministrador getAllDatosAdministrador(Long id);
}
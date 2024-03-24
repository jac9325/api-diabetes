package com.servicediabetes.ApiDiabetesDomain.Usuario;

import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse registerUser(UsuarioRequest userRequest);
}
package com.servicediabetes.ApiDiabetesDomain.Usuario.Helpers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.servicediabetes.ApiDiabetesDomain.RolUsuario.RolUsuario;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Usuario;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

@Component
public class CastUser {

    public Usuario castUsuarioRequestToUsuario(UsuarioRequest usuarioRequest) {

        Usuario usuario = new Usuario();
        usuario.setNombre_apellido(usuarioRequest.getNombre_apellido());
        usuario.setNumero(usuarioRequest.getNumero());
        usuario.setCorreo(usuarioRequest.getCorreo());
        usuario.setEdad(usuarioRequest.getEdad());
        usuario.setContrasena(usuarioRequest.getContrasena());
        usuario.setFecha_nacimiento(usuarioRequest.getFecha_nacimiento()); 
        usuario.setFecha_registro_app(new Date());
        usuario.setInicio_diabetes(usuarioRequest.getInicio_diabetes());
        usuario.setAltura(usuarioRequest.getAltura());
        usuario.setPeso(usuarioRequest.getAltura());
        usuario.setAlergias(usuarioRequest.getAlergias());
        usuario.setEstado(1);
        usuario.setFoto_usuario(usuarioRequest.getFoto_usuario());      
        usuario.setEs_primera_vez(true);
        RolUsuario currentRole = new RolUsuario();
        currentRole.setId_rol_usuario(1);
        usuario.setRolUsuario(currentRole);

        return usuario;
    }

    public UsuarioResponse castUsuarioResponse(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setId_usuario(usuario.getId_usuario());
        usuarioResponse.setNombre_apellido(usuario.getNombre_apellido());
        usuarioResponse.setNumero(usuario.getNumero());
        usuarioResponse.setCorreo(usuario.getCorreo());
        usuarioResponse.setEdad(usuario.getEdad());
        usuarioResponse.setFecha_nacimiento(usuario.getFecha_nacimiento());
        usuarioResponse.setInicio_diabetes(usuario.getInicio_diabetes());
        usuarioResponse.setFecha_registro_app(usuario.getFecha_registro_app());
        usuarioResponse.setAltura(usuario.getAltura());
        usuarioResponse.setPeso(usuario.getPeso());
        usuarioResponse.setAlergias(usuario.getAlergias());
        usuarioResponse.setEstado(usuario.getEstado());
        usuarioResponse.setFoto_usuario(usuario.getFoto_usuario());
        usuarioResponse.setId_rol_usuario(usuario.getRolUsuario().getId_rol_usuario());
        usuarioResponse.setEs_primera_vez(usuario.getEs_primera_vez());
        return usuarioResponse;
    }

    public List<UsuarioResponse> castListUserResponse(List<Usuario> listUsers){
        return listUsers.stream()
                .map(this::castUsuarioResponse)
                .collect(Collectors.toList());
    }
}

package com.servicediabetes.ApiDiabetesDomain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Helpers.CastUser;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final CastUser castUser;

    @Autowired
    public UsuarioServiceImpl(CastUser castUser) {
        this.castUser = castUser;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public UsuarioResponse registerUser(UsuarioRequest userRequest){

        try {
            if (userRequest == null) {
                return null;
            }
            Usuario currentUsuario = castUser.castUsuarioRequestToUsuario(userRequest);
            currentUsuario = usuarioRepository.save(currentUsuario);
            UsuarioResponse currentUserResponse = castUser.castUsuarioResponse(currentUsuario);

            return currentUserResponse;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}

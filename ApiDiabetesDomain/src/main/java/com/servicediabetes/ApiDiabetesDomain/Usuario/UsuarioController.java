package com.servicediabetes.ApiDiabetesDomain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    // Obejtos Globales Necesarios
    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();

    @PostMapping("/")
    public ResponseEntity<?> regsiter(@RequestBody UsuarioRequest request) {
        try {
            UsuarioResponse result = usuarioService.registerUser(request);
            if (result == null) {
                return response.error(codes.error(), messages.error(), null);
            }
            return response.success(codes.created(), messages.created(), result, null);

        } catch (Exception e) {

            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

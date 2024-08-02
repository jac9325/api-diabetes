package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericos;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id) {
        try {
            UsuarioResponse user = usuarioService.getUserById(id);

            if (user == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), user, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UsuarioResponse> listUser = usuarioService.getAllUsers();
            if (listUser.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listUser, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser( @RequestBody UsuarioRequest Request, @PathVariable(value = "id") Long id) {
        try {
            UsuarioResponse user = usuarioService.updateUser(id, Request);
            if (user == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), user, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        try {
            Boolean result = usuarioService.deleteUser(id);
            if (result == false) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), null, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    // @GetMapping("/path")
    // public Path getMethodName() {
    //     return usuarioService.getURL();
    // }

    @GetMapping("/getAllFarmacoEjercicioNutricion")
    public ResponseEntity<?> getAllFarmacoEjercicioNutricion() {
        try {
            DatosGenericos allFarmacoEjercicioNutricion = usuarioService.getAllFarmacoEjercicioNutricion();
            if (allFarmacoEjercicioNutricion == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), allFarmacoEjercicioNutricion, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
    
}

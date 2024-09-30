/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/nutricion")
public class NutricionController {
    @Autowired
    private NutricionService nutricionService;

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();
    
    @GetMapping("/getNutricionById/{id}")
    public ResponseEntity<?> getNutricionById(@PathVariable(value = "id") Long id) {
        try {
            NutricionDtos nutricion = nutricionService.getNutricionById(id);
            if (nutricion == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), nutricion, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    } 
    
    @GetMapping("/getAllNutricion")
    public ResponseEntity<?> getAllNutricion() {
        try {
            List<NutricionDtos > listNutricion = nutricionService.getAllNutricion();
            if (listNutricion.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listNutricion, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
    
    @GetMapping("/getListNutricionByIdUsuario/{idUsuario}")
    public ResponseEntity<?> getListNutricionByIdUsuario(@PathVariable(value = "idUsuario") Long idUsuario) {
        try {
            List<NutricionDtos> listNutricion = nutricionService.getListNutricionByIdUsuario(idUsuario);
            if (listNutricion.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listNutricion, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getListNutricionByIdTratamiento/{idTratamiento}")
    public ResponseEntity<?> getListNutricionByIdTratamiento(@PathVariable(value = "idTratamiento") Long idTratamiento) {
        try {
            List<NutricionDtos> listNutricion = nutricionService.getListNutricionByIdTratamiento(idTratamiento);
            if (listNutricion.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listNutricion, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

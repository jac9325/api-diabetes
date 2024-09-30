/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
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

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/ejercicio")
public class EjercicioController {
    
    @Autowired
    private EjercicioService ejercicioService;

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();
    
    @GetMapping("/getEjercicioById/{id}")
    public ResponseEntity<?> getEjercicioById(@PathVariable(value = "id") Long id) {
        try {
            EjercicioDtos ejercicio = ejercicioService.getEjercicioById(id);
            if (ejercicio == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), ejercicio, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    } 
    
    @GetMapping("/getAllEjercicio")
    public ResponseEntity<?> getAllEjercicio() {
        try {
            List<EjercicioDtos > listEjercicio = ejercicioService.getAllEjercicio();
            if (listEjercicio.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listEjercicio, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
    @PostMapping("/createEjercicio")
    public ResponseEntity<?> createEjercicio(@RequestBody EjercicioDtos request) {
        try {
            EjercicioDtos current = ejercicioService.createEjercicio(request);
            return response.success(codes.created(), messages.created(), current, null); 
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
    
    @DeleteMapping("/deleteEjercicio/{id}")
    public ResponseEntity<?> deleteEjercicio(@PathVariable(value = "id") Long id) {
        try {
            Boolean current = ejercicioService.deleteEjercicio(id);
            if (current == false)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), null, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @PutMapping("/updateEjercicio/{id}")
    public ResponseEntity<?> updateEjercicio(@PathVariable(value = "id") Long id, @RequestBody EjercicioDtos request) {
        try {
            EjercicioDtos current = ejercicioService.updateEjercicio(id, request);
            if (current == null)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), current, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getEjerciciosByIdUsuario/{idUsuario}")
    public ResponseEntity<?> getEjerciciosByIdUsuario(@PathVariable(value = "idUsuario") Long idUsuario) {
        try {
            List<EjercicioDtos> listEjercicio = ejercicioService.getEjerciciosByIdUsuario(idUsuario);
            if (listEjercicio.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listEjercicio, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getEjerciciosByIdTratamiento/{idTratamiento}")
    public ResponseEntity<?> getEjerciciosByIdTratamiento(@PathVariable(value = "idTratamiento") Long idTratamiento) {
        try {
            List<EjercicioDtos> listEjercicio = ejercicioService.getEjerciciosByIdTratamiento(idTratamiento);
            if (listEjercicio.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listEjercicio, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

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
@RequestMapping("api/v1/farmaco")
public class FarmacoController {
    
    @Autowired
    private FarmacoService farmacoService;

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();
    
    @GetMapping("/getFarmacoById/{id}")
    public ResponseEntity<?> getFarmacoById(@PathVariable(value = "id") Long id) {
        try {
            FarmacoDtos farmaco = farmacoService.getFarmacoById(id);
            if (farmaco == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), farmaco, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    } 
    
    @GetMapping("/getAllFarmaco")
    public ResponseEntity<?> getAllFarmaco() {
        try {
            List<FarmacoDtos > listFarmaco = farmacoService.getAllFarmaco();
            if (listFarmaco.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listFarmaco, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
    
    @GetMapping("/getFarmacosByIdTratamiento/{idTratamiento}")
    public ResponseEntity<?> getFarmacosByIdTratamiento(@PathVariable(value = "idTratamiento") Long idTratamiento) {
        try {
            List<FarmacoDtos> listFarmaco = farmacoService.getFarmacosByIdTratamiento(idTratamiento);
            if (listFarmaco.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listFarmaco, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.TratamientoNutricion;

import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoService;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/TratamientoNutricion")
public class TratamientoNutricionController {
    
    //--Repositorios y Servicios Inicializados
    @Autowired
    private TratamientoNutricionService tratamientoNutricionService;
    

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();
    
    //Metodos de Procesamiento
    @PostMapping("/createTratamientoNutricion")
    public ResponseEntity<?> createTratamientoNutricion(@RequestBody TratamientoNutricion Request) {
        try {
            TratamientoNutricionDtos tratamiento = tratamientoNutricionService.createTratamientoNutricion(Request);
            return response.success(codes.created(), messages.created(), tratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
       
    @GetMapping("/getTratamientoNutricionById/{id}")
    public ResponseEntity<?> getTratamientoNutricionById(@PathVariable(value = "id") Long id) {
        try {
            TratamientoNutricionDtos tratamiento = tratamientoNutricionService.getTratamientoNutricionById(id);
            if (tratamiento == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), tratamiento, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }     
    
    
    
}

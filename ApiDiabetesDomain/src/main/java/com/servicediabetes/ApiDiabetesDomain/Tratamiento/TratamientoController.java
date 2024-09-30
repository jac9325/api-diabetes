package com.servicediabetes.ApiDiabetesDomain.Tratamiento;


import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
import org.springframework.web.bind.annotation.*;


import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
// @RequestMapping("api/v1/tratamiento")
@RequestMapping("/tratamiento")
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();

    @PostMapping("/createTratamiento")
    public ResponseEntity<?> createTratamiento(@RequestBody TratamientoDtos request) {
        try {
            TratamientoDtos tratamiento = tratamientoService.createTratamiento(request);
            return response.success(codes.created(), messages.created(), tratamiento, null); 
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getTratamientoById/{id}")
    public ResponseEntity<?> getTratamientoById(@PathVariable(value = "id") Long id) {
        try {
            TratamientoDtos tratamiento = tratamientoService.getTratamientoById(id);
            if (tratamiento == null)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), tratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getAllTratamiento")
    public ResponseEntity<?> getAllTratamiento() {
        try {
            List<TratamientoDtos> listTratamiento = tratamientoService.getAllTratamiento();
            if (listTratamiento.isEmpty())
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), listTratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(),messages.error() + e.getMessage(), null);
        }
    }

    @DeleteMapping("/deleteTratamiento/{id}")
    public ResponseEntity<?> deleteTratamiento(@PathVariable(value = "id") Long id) {
        try {
            Boolean result = tratamientoService.deleteTratamiento(id);
            if (result == false)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), null, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @PutMapping("/updateTratamiento/{id}")
    public ResponseEntity<?> updateTratamiento(@PathVariable(value = "id") Long id, @RequestBody TratamientoDtos request) {
        try {
            TratamientoDtos tratamiento = tratamientoService.updateTratamiento(id, request);
            if (tratamiento == null)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), tratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    // POR DEFINIR

    // Aquí puedes agregar tus nuevos métodos

    @GetMapping("/getAllTratamientosHabilitados")
    public ResponseEntity<?> getAllTratamientosHabilitados() {
        try {
            List<TratamientoDtos> listTratamiento = tratamientoService.getAllTratamientosHabilitados();
            if (listTratamiento.isEmpty())
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), listTratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(),messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getTratamientoHabilitadoByIdUsuario/{id}")
    public ResponseEntity<?> getTratamientoHabilitadoByIdUsuario(@PathVariable(value = "id") Long id) {
        try {
            TratamientoDtos tratamiento = tratamientoService.getTratamientoHabilitadoByIdUsuario(id);
            if (tratamiento == null)
                return response.error(codes.notFound(), messages.notFound(), null);
            else
                return response.ok(codes.ok(), messages.ok(), tratamiento, null);
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

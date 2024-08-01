/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Ejercicio;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class EjercicioServiceImpl implements EjercicioService{
    
    private final EjercicioUtils ejercicioUtils;
    private final EjercicioRepository ejercicioRepository;
    private final EjercicioRepositoryHb ejercicioRepositoryHb;
    
    public EjercicioServiceImpl(EjercicioUtils ejercicioUtils, EjercicioRepository ejercicioRepository, EjercicioRepositoryHb ejercicioRepositoryHb) {
        this.ejercicioUtils = ejercicioUtils;
        this.ejercicioRepository = ejercicioRepository;
        this.ejercicioRepositoryHb = ejercicioRepositoryHb;
    }

    @Transactional(readOnly = true)
    @Override
    public EjercicioDtos getEjercicioById(Long id){
        try{
            Ejercicio currentFarmaco = ejercicioRepositoryHb.getEjercicioById(id);
            if (currentFarmaco == null){
                return null;
            } else {
                
                EjercicioDtos response = ejercicioUtils.convertToDTO(currentFarmaco);

                return response;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    @Transactional(readOnly = true)
    @Override
    public List<EjercicioDtos> getAllEjercicio() {
        try {
            List<Ejercicio> listResult = ejercicioRepositoryHb.getListAllEjercicio();
            if (listResult.isEmpty()) {
                return null;
            } else {
                
                List<EjercicioDtos> response = ejercicioUtils.convertToDtoList(listResult);
                
                return response;
            }
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());

        }
    }
    
    @Transactional
    @Override
    public EjercicioDtos createEjercicio(EjercicioDtos request) {
        try {
            Ejercicio ejercicio = ejercicioUtils.convertToEntity(request);
            ejercicio = ejercicioRepository.save(ejercicio);
            EjercicioDtos cajaCierreDtos = ejercicioUtils.convertToDTO(ejercicio);
            return cajaCierreDtos;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Transactional
    @Override
    public Boolean deleteEjercicio(Long id) {
        try {
            Ejercicio ejercicio = ejercicioRepositoryHb.getEjercicioById(id);
            if (ejercicio == null)
                return false;
            else {
                ejercicioRepository.delete(ejercicio);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    @Transactional
    @Override
    public EjercicioDtos updateEjercicio(Long id, EjercicioDtos request) {
        try {
            Ejercicio ejercicio = ejercicioRepositoryHb.getEjercicioById(id);
            if (ejercicio == null)
                return null;
            else {
                
                ejercicio.setNombre(request.getNombre());
                ejercicio.setDescripcion(request.getDescripcion());
                ejercicio.setDificultad(request.getDificultad());
                ejercicio.setTipo_ejercicio(request.getTipo_ejercicio());
                ejercicio.setDuracion(request.getDuracion());
                ejercicio.setIntensidad(request.getIntensidad());
                ejercicio.setNivel_dificultad(request.getNivel_dificultad());
                ejercicio.setBeneficios(request.getBeneficios());
                ejercicio.setPrecauciones(request.getPrecauciones());
                ejercicio.setFrecuencia(request.getFrecuencia());
                
                ejercicio = ejercicioRepository.save(ejercicio);
                EjercicioDtos ejercicioDtos = ejercicioUtils.convertToDTO(ejercicio);
                return ejercicioDtos;
            }

                
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Nutricion;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class NutricionServiceImpl implements NutricionService {
    
     private final NutricionUtils nutricionUtils;
    private final NutricionRepository nutricionRepository;
    private final NutricionRepositoryHb nutricionRepositoryHb;
    
    public NutricionServiceImpl(NutricionUtils nutricionUtils, NutricionRepository nutricionRepository, NutricionRepositoryHb nutricionRepositoryHb) {
        this.nutricionUtils = nutricionUtils;
        this.nutricionRepository = nutricionRepository;
        this.nutricionRepositoryHb = nutricionRepositoryHb;
    }

    @Transactional(readOnly = true)
    @Override
    public NutricionDtos getNutricionById(Long id){
        try{
            Nutricion currentFarmaco = nutricionRepositoryHb.getNutricionById(id);
            if (currentFarmaco == null){
                return null;
            } else {
                
                NutricionDtos response = nutricionUtils.convertToDTO(currentFarmaco);

                return response;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    @Transactional(readOnly = true)
    @Override
    public List<NutricionDtos> getAllNutricion() {
        try {
            List<Nutricion> listResult = nutricionRepositoryHb.getListAllNutricion();
            if (listResult.isEmpty()) {
                return null;
            } else {
                
                List<NutricionDtos> response = nutricionUtils.convertToDtoList(listResult);
                
                return response;
            }
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());

        }
    }
    
}

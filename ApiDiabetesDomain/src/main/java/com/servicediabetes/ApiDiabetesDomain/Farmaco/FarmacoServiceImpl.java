/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Farmaco;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
public class FarmacoServiceImpl implements FarmacoService{
    
    private final FarmacoUtils farmacoUtils;
    private final FarmacoRepositoryHb farmacoRepositoryHb;
    
    public FarmacoServiceImpl(FarmacoUtils farmacoUtils, FarmacoRepositoryHb farmacoRepositoryHb) {
        this.farmacoUtils = farmacoUtils;
        this.farmacoRepositoryHb = farmacoRepositoryHb;
    }

    @Transactional(readOnly = true)
    @Override
    public FarmacoDtos getFarmacoById(Long id){
        try{
            Farmaco currentFarmaco = farmacoRepositoryHb.getFarmacoById(id);
            if (currentFarmaco == null){
                return null;
            } else {
                
                FarmacoDtos response = farmacoUtils.convertToDTO(currentFarmaco);

                return response;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    @Transactional(readOnly = true)
    @Override
    public List<FarmacoDtos> getAllFarmaco() {
        try {
            List<Farmaco> listResult = farmacoRepositoryHb.getListAllFarmaco();
            if (listResult.isEmpty()) {
                return null;
            } else {
                
                List<FarmacoDtos> response = farmacoUtils.convertToDtoList(listResult);
                
                return response;
            }
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());

        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

/**
 *
 * @author Usuario
 */
@Service
@AllArgsConstructor
public class ArticuloServiceImpl implements ArticuloService{
    
    private final ArticuloUtils articuloUtils;
    private final ArticuloRepositoryHb articuloRepositoryHb;
    
    @Transactional(readOnly = true)
    @Override
    public List<ArticuloDtos> getAllArticulo() {
        try {
            List<Articulo> listResult = articuloRepositoryHb.getListAllArticulo();
            if (listResult.isEmpty()) {
                return null;
            } else {
                List<ArticuloDtos> response = articuloUtils.convertToDtoList(listResult);
                return response;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

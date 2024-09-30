/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author Usuario
 */
@Component
public class ArticuloUtils {
    public ArticuloDtos convertToDTO( Articulo articulo){
        ArticuloDtos current= new ArticuloDtos();
        
        current.setId_articulo(articulo.getId_articulo());
        current.setTitulo(articulo.getTitulo());
        current.setContenido(articulo.getContenido());
        current.setFecha_publicacion(articulo.getFecha_publicacion());
        current.setAutor(articulo.getAutor());
        current.setEtiquetas(articulo.getEtiquetas());
        current.setImagen(articulo.getImagen());
        current.setEnlace(articulo.getEnlace());
        current.setEstado(articulo.getEstado());
        return current;  
    }

    public  List<ArticuloDtos> convertToDtoList(List<Articulo> articuloList) {
        return  articuloList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Articulo convertToEntity(ArticuloDtos articuloDtos){
        Articulo current= new Articulo();
        current.setId_articulo(articuloDtos.getId_articulo());
        current.setTitulo(articuloDtos.getTitulo());
        current.setContenido(articuloDtos.getContenido());
        current.setFecha_publicacion(articuloDtos.getFecha_publicacion());
        current.setAutor(articuloDtos.getAutor());
        current.setEtiquetas(articuloDtos.getEtiquetas());
        current.setImagen(articuloDtos.getImagen());
        current.setEnlace(articuloDtos.getEnlace());
        current.setEstado(articuloDtos.getEstado());
        return current;
    }
    
}

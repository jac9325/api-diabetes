/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Articulo;

import com.servicediabetes.ApiDiabetesDomain.ArticleImage.ArticleImageService;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Usuario
 */

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/articulo")
public class ArticuloController {
    
    @Autowired
    private final ArticuloService articuloService;
    private final ArticleImageService articleImageService;
    private final HttpServletRequest requestHtttp;

    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();
    
    @GetMapping("/getAllArticulo")
    public ResponseEntity<?> getAllArticulo() {
        try {
            List<ArticuloDtos > listArticulo = articuloService.getAllArticulo();
            if (listArticulo.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listArticulo, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/goImage/{name}")
	public ResponseEntity<Resource> goImage(@PathVariable(value = "name") String filename) throws IOException {
		try {
			Resource image = articleImageService.load(filename);
            String contentType = Files.probeContentType(image.getFile().toPath());
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType)
				.body(image);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        return null;
	}

    @GetMapping("/getUrlImage/{filename}")
    public ResponseEntity<?> getUrlImage(@PathVariable(value = "filename") String filename) {
        try {
            String urlImage = articleImageService.getUrlImage(filename);

            if (urlImage == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), urlImage, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    } 
    
    @GetMapping("/UrlImage/{filename}")
    public ResponseEntity<?> UrlImage(@PathVariable(value = "filename") String filename) {
        try {
            String urlImage = articleImageService.getUrlImage(filename);
            String host = requestHtttp.getRequestURL().toString().replace(requestHtttp.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                            .fromHttpUrl(host)
                            .path("/api/v1/articulo/goImage/")
                            .path(filename)
                            .toUriString();
            if (urlImage == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), url, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    } 

    @DeleteMapping("/deleteImagen/{filename}")
    public ResponseEntity<?> deleteImagen(@PathVariable(value = "filename") String filename) {
        try {
            Boolean result = articleImageService.delete(filename);
            if (result == false) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), null, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }
}

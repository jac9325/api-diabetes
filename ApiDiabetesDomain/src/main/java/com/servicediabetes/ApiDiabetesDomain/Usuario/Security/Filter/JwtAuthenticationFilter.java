/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Usuario.Security.Filter;

import static com.servicediabetes.ApiDiabetesDomain.Usuario.Security.TokenJwtConfig.*;

import java.util.HashMap;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;  
    public JwtAuthenticationFilter( AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Usuario usuario = null;
        String correo = null;
        String contrasena = null;
        
        try {
            usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            correo = usuario.getCorreo();
            contrasena = usuario.getContrasena();
        } catch (StreamReadException e) {
            e.printStackTrace();
        }catch (DatabindException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(correo, contrasena);
        return authenticationManager.authenticate(authenticationToken);
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String username = user.getUsername();
        Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
        Claims claims = Jwts.claims()
            .add("authorities", new ObjectMapper().writeValueAsString(roles))
            .add("correo", username)
            .build();

         String token = Jwts.builder()
            .subject(username)
            .claims(claims)
            .expiration(new Date(System.currentTimeMillis()+3600000))
            .issuedAt(new Date())
            .signWith(SECRET_KEY)
            .compact();
            response.addHeader("Authorization", "Bearer" + token);
            Map<String, Object> body = new HashMap<>();
            body.put("token", token);
            body.put("correo", username);
            body.put("authorities", roles);
            body.put("message", String.format("Hola %s has iniciado correctamente", username));
            body.put("status", 200);

            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setContentType(CONTENT_TYPE);
            response.setStatus(200);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> body = new HashMap<>();
        body.put("message", "Error en la autenticación usuario o contrasena incorrectos");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType(CONTENT_TYPE);
    } 
}

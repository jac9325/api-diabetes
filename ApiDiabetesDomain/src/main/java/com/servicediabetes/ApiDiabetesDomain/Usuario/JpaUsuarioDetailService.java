/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.util.Collections;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Edward
 */
@Service
public class JpaUsuarioDetailService implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
            Optional<Usuario> userOptional = usuarioRepository.findByEmail(correo);
            if (userOptional.isEmpty()) {
                throw new UsernameNotFoundException(String.format( "No se ha encontrado el Usuario %s", correo));
            } 
            Usuario user =  userOptional.orElseThrow();

            GrantedAuthority authority = new SimpleGrantedAuthority(user.getRolUsuario().getNombre());

            return new User(user.getCorreo(), 
            user.getContrasena(),
            true,
            true,
            true, 
            true, 
            Collections.singletonList(authority));
    }
}

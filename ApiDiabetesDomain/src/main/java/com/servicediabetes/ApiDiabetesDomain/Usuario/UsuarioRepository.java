package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query(value ="SELECT * FROM usuario where correo = ?1 and estado = 1", nativeQuery = true)
    Optional<Usuario> findByEmail(String correo);
}

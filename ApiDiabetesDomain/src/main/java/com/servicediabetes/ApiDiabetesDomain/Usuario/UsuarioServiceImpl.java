<<<<<<< HEAD
package com.servicediabetes.ApiDiabetesDomain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Helpers.CastUser;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final CastUser castUser;

    @Autowired
    public UsuarioServiceImpl(CastUser castUser) {
        this.castUser = castUser;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public UsuarioResponse registerUser(UsuarioRequest userRequest){

        try {
            if (userRequest == null) {
                return null;
            }
            Usuario currentUsuario = castUser.castUsuarioRequestToUsuario(userRequest);
            currentUsuario = usuarioRepository.save(currentUsuario);
            UsuarioResponse currentUserResponse = castUser.castUsuarioResponse(currentUsuario);

            return currentUserResponse;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
}
=======
package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericos;
import com.servicediabetes.ApiDiabetesDomain.Ejercicio.EjercicioDtos;
import com.servicediabetes.ApiDiabetesDomain.Ejercicio.EjercicioService;
import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoDtos;
import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoService;
import com.servicediabetes.ApiDiabetesDomain.Nutricion.NutricionDtos;
import com.servicediabetes.ApiDiabetesDomain.Nutricion.NutricionService;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Config.UsuarioConfigSecurity;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Helpers.CastUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final CastUser castUser;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioRepositoryHb userRepositoryHb;
    private final FarmacoService farmacoService;
    private final EjercicioService ejercicioService;
    private final NutricionService nutricionService;

    private final static String UPLOADS_FOLDER = "uploads/images";

    @Transactional
    @Override
    public UsuarioResponse registerUser(UsuarioRequest userRequest){

        try {
            if (userRequest == null) {
                return null;
            }
            Usuario currentUsuario = castUser.castUsuarioRequestToUsuario(userRequest);
            String passwordEncode = UsuarioConfigSecurity.encode(currentUsuario.getContrasena());
            currentUsuario.setContrasena(passwordEncode);
            currentUsuario = usuarioRepository.save(currentUsuario);
            UsuarioResponse currentUserResponse = castUser.castUsuarioResponse(currentUsuario);

            return currentUserResponse;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly=true)
    @Override
    public UsuarioResponse getUserById(Long id) {
        try {
            Usuario user = userRepositoryHb.getUserById(id);
            UsuarioResponse currentUsuarioResponse = castUser.castUsuarioResponse(user);
            if(currentUsuarioResponse == null){
                return null;
            }else{
                // Preparar el DTO Response
                return currentUsuarioResponse;
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly=true)
    @Override
    public List<UsuarioResponse> getAllUsers() {
        try {
            List<Usuario> listUser = usuarioRepository.findAll();
            List<UsuarioResponse> currentListUsuarioResponse = castUser.castListUserResponse(listUser);
            if(currentListUsuarioResponse.isEmpty()){
                return null;
            }
            else{
                return currentListUsuarioResponse;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public UsuarioResponse updateUser(Long id, UsuarioRequest userRequest){
        try {
            //primeramente se buscar Usuario mediante el id
            Usuario user = userRepositoryHb.getUserById(id);
            if (user == null) {
                return null;
            } else {
                //-- se arma el objeto con los nuevos valores
                user.setNombre_apellido(userRequest.getNombre_apellido() != null ? userRequest.getNombre_apellido() : user.getNombre_apellido());
                user.setNumero(userRequest.getNumero() != null ? userRequest.getNumero() : user.getNumero());
                user.setCorreo(userRequest.getCorreo() != null ? userRequest.getCorreo() : user.getCorreo());
                user.setEdad(userRequest.getEdad() != null ? userRequest.getEdad() : user.getEdad());
                if (userRequest.getContrasena() != null) {
                    String passwordEncode = UsuarioConfigSecurity.encode(userRequest.getContrasena());
                    user.setContrasena(passwordEncode);
                } else{
                    user.setContrasena(user.getContrasena());
                }
                user.setFecha_nacimiento(userRequest.getFecha_nacimiento() != null ? userRequest.getFecha_nacimiento() : user.getFecha_nacimiento());
                user.setAltura(userRequest.getAltura() != null ? userRequest.getAltura() : user.getAltura());
                user.setPeso(userRequest.getPeso() != null ? userRequest.getPeso() : user.getPeso());
                user.setAlergias(userRequest.getAlergias() != null ? userRequest.getAlergias() : user.getAlergias());
                user.setFoto_usuario(userRequest.getFoto_usuario() != null ? userRequest.getFoto_usuario() : user.getAlergias());

                // Se guarda la Institucion Medica con los nuevos valores               
                //Preparo el Dto response
                user = usuarioRepository.save(user);
                UsuarioResponse currentUsuarioResponse = castUser.castUsuarioResponse(user);
                return currentUsuarioResponse;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Boolean deleteUser(Long id) {
        try {
            Usuario user = userRepositoryHb.getUserById(id);
            if (user == null) {
                return false;
            } else {
                usuarioRepository.delete(user);
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public Path getURL(){
        return Paths.get(UPLOADS_FOLDER);
    }

    @Transactional
    @Override
    public DatosGenericos getAllFarmacoEjercicioNutricion(){
        try {
            List<FarmacoDtos> currentFarmaco = farmacoService.getAllFarmaco();
            List<EjercicioDtos> currentEjercicio = ejercicioService.getAllEjercicio();
            List<NutricionDtos> currentNutricion = nutricionService.getAllNutricion();

            DatosGenericos currentDatosGenericos = new DatosGenericos();
            currentDatosGenericos.setFarmaco(currentFarmaco);
            currentDatosGenericos.setEjercicio(currentEjercicio);
            currentDatosGenericos.setNutricion(currentNutricion);

            return currentDatosGenericos;  

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
>>>>>>> master

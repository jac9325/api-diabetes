package com.servicediabetes.ApiDiabetesDomain.Usuario;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericos;
import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosAdministrador;
import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosPaciente;
import com.servicediabetes.ApiDiabetesDomain.Ejercicio.EjercicioDtos;
import com.servicediabetes.ApiDiabetesDomain.Ejercicio.EjercicioService;
import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoDtos;
import com.servicediabetes.ApiDiabetesDomain.Farmaco.FarmacoService;
import com.servicediabetes.ApiDiabetesDomain.Nutricion.NutricionDtos;
import com.servicediabetes.ApiDiabetesDomain.Nutricion.NutricionService;
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.TratamientoService;
import com.servicediabetes.ApiDiabetesDomain.Tratamiento.Dtos.TratamientoDtos;
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
    private final UsuarioRepositoryHb usuarioRepositoryHb;
    private final FarmacoService farmacoService;
    private final EjercicioService ejercicioService;
    private final NutricionService nutricionService;
    private final TratamientoService tratamientoService;

    @Transactional
    @Override
    public UsuarioResponse registerUser(UsuarioRequest userRequest){

        try {
            if (userRequest == null || userRequest.getContrasena() == null || userRequest.getCorreo() == null) {
                return null;
            }
            Usuario currentUsuario = castUser.castUsuarioRequestToUsuario(userRequest);
            String passwordEncode = UsuarioConfigSecurity.encode(currentUsuario.getContrasena());
            currentUsuario.setContrasena(passwordEncode);

            currentUsuario.setNombre_apellido(currentUsuario.getNombre_apellido() != null ? currentUsuario.getNombre_apellido() : "Sin Asignar");
            currentUsuario.setNumero(currentUsuario.getNumero() != null ? currentUsuario.getNumero() : "000000000");
            currentUsuario.setCorreo(currentUsuario.getCorreo() != null ? currentUsuario.getCorreo() : "Sin Asignar");
            currentUsuario.setEdad(currentUsuario.getEdad() != null ? currentUsuario.getEdad() : 00);
            currentUsuario.setFecha_nacimiento(new Date());
            currentUsuario.setInicio_diabetes(currentUsuario.getInicio_diabetes() != null ? currentUsuario.getInicio_diabetes() : new Date());
            currentUsuario.setAltura(currentUsuario.getAltura() != null ? currentUsuario.getAltura() : BigDecimal.ZERO);
            currentUsuario.setPeso(currentUsuario.getPeso() != null? currentUsuario.getPeso() : BigDecimal.ZERO);
            currentUsuario.setAlergias(currentUsuario.getAlergias() != null? currentUsuario.getAlergias() : "Sin Asignar");
            currentUsuario.setFoto_usuario(currentUsuario.getFoto_usuario() != null ? currentUsuario.getFoto_usuario() : "default_image.png");
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
            Usuario user = usuarioRepositoryHb.getUserById(id);
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
            Usuario user = usuarioRepositoryHb.getUserById(id);
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
                user.setInicio_diabetes(userRequest.getInicio_diabetes() != null ? userRequest.getInicio_diabetes() : user.getInicio_diabetes());
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
            Usuario user = usuarioRepositoryHb.getUserById(id);
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

    // @Transactional
    // @Override
    // public Path getURL(){
    //     return Paths.get(UPLOADS_FOLDER);
    // }

    @Transactional
    @Override
    public DatosGenericosPaciente getAllDatosPaciente(Long id){
        try {
            if (id <= 0)
                return null;

            Usuario currentUsuario = usuarioRepositoryHb.getUserById(id);

            if (currentUsuario == null || (!currentUsuario.getRolUsuario().getNombre().equals("ROL_PACIENTE")))
                return null;

                List<TratamientoDtos> currentTratamientos = tratamientoService.getAllTratamiento();
                List<FarmacoDtos> currentFarmaco = farmacoService.getAllFarmaco();
                List<EjercicioDtos> currentEjercicio = ejercicioService.getAllEjercicio();
                List<NutricionDtos> currentNutricion = nutricionService.getAllNutricion();
    
                DatosGenericos currentDatosGenericos = new DatosGenericos();
                currentDatosGenericos.setTratamiento(currentTratamientos);
                currentDatosGenericos.setFarmaco(currentFarmaco);
                currentDatosGenericos.setEjercicio(currentEjercicio);
                currentDatosGenericos.setNutricion(currentNutricion);
            
            // Obtengo el tratamiento por Usuario, luego convierto a Dto
            TratamientoDtos currentTratamiento = tratamientoService.getTratamientoHabilitadoByIdUsuario(id);
            
            if (currentTratamiento == null) {
                DatosGenericosPaciente currentDatosGenericosPaciente = new DatosGenericosPaciente();
                currentDatosGenericosPaciente.setDatosGenericos(currentDatosGenericos);
                return currentDatosGenericosPaciente;
            } else {                
                DatosGenericosPaciente currentDatosGenericosPaciente = new DatosGenericosPaciente();
                currentDatosGenericosPaciente.setDatosGenericos(currentDatosGenericos);
                currentDatosGenericosPaciente.setTratamiento(currentTratamiento);
                return currentDatosGenericosPaciente;
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public DatosGenericosAdministrador getAllDatosAdministrador(Long id) {
        try {
            if (id <= 0)
                return null;

            Usuario currentUsuario = usuarioRepositoryHb.getUserById(id);

            if (currentUsuario == null || (!currentUsuario.getRolUsuario().getNombre().equals("ROL_ADMIN")))
                return null;
            
                List<TratamientoDtos> currentTratamientos = tratamientoService.getAllTratamiento();
                List<FarmacoDtos> currentFarmaco = farmacoService.getAllFarmaco();
                List<EjercicioDtos> currentEjercicio = ejercicioService.getAllEjercicio();
                List<NutricionDtos> currentNutricion = nutricionService.getAllNutricion();
    
                DatosGenericos currentDatosGenericos = new DatosGenericos();
                currentDatosGenericos.setTratamiento(currentTratamientos);
                currentDatosGenericos.setFarmaco(currentFarmaco);
                currentDatosGenericos.setEjercicio(currentEjercicio);
                currentDatosGenericos.setNutricion(currentNutricion);
            
            // Obtengo la lista de Usuarios Response, luego convierto la lista en dtos
            List<UsuarioResponse> currentListUsuario = castUser.castListUserResponse(usuarioRepositoryHb.getUsuariosHabilitados());
            if (currentListUsuario == null)
                return null;
            
            DatosGenericosAdministrador currentDatosGenericosAdministrador = new DatosGenericosAdministrador();
            currentDatosGenericosAdministrador.setDatosGenericos(currentDatosGenericos);
            currentDatosGenericosAdministrador.setUsuario(currentListUsuario);

            return currentDatosGenericosAdministrador;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional(readOnly=true)
    @Override
    public UsuarioResponse getUserByEmail(String email) {
        try {
            Usuario user = usuarioRepositoryHb.getUserByEmail(email);
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
}
package com.servicediabetes.ApiDiabetesDomain.Usuario;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosAdministrador;
import com.servicediabetes.ApiDiabetesDomain.DTO.DatosGenericosPaciente;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Codes;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.Messages;
import com.servicediabetes.ApiDiabetesDomain.Middlewares.ResponseUtils;
import com.servicediabetes.ApiDiabetesDomain.ProfileImage.ProfileImageService;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioRequest;
import com.servicediabetes.ApiDiabetesDomain.Usuario.Dtos.UsuarioResponse;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;
    private final ProfileImageService profileImageService;
    private final HttpServletRequest requestHtttp;
    // Obejtos Globales Necesarios
    Codes codes = new Codes();
    Messages messages = new Messages();
    ResponseUtils response = new ResponseUtils();

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody UsuarioRequest request) {
        try {
            UsuarioResponse result = usuarioService.registerUser(request);
            if (result == null) {
                return response.error(codes.error(), messages.error(), null);
            }
            return response.success(codes.created(), messages.created(), result, null);

        } catch (Exception e) {

            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id) {
        try {
            UsuarioResponse user = usuarioService.getUserById(id);

            if (user == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), user, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UsuarioResponse> listUser = usuarioService.getAllUsers();
            if (listUser.isEmpty()) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), listUser, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser( @RequestBody UsuarioRequest Request, @PathVariable(value = "id") Long id) {
        try {
            UsuarioResponse user = usuarioService.updateUser(id, Request);
            if (user == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), user, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        try {
            Boolean result = usuarioService.deleteUser(id);
            if (result == false) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), null, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getAllDatosPaciente/{id}")
    public ResponseEntity<?> getAllDatosPaciente(@PathVariable(value = "id") Long id) {
        try {
            DatosGenericosPaciente allDatosPaciente = usuarioService.getAllDatosPaciente(id);
            if (allDatosPaciente == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), allDatosPaciente, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getAllDatosAdministrador/{id}")
    public ResponseEntity<?> getAllDatosAdministrador(@PathVariable(value = "id") Long id) {
        try {
            DatosGenericosAdministrador allDatosAdministrador = usuarioService.getAllDatosAdministrador(id);
            if (allDatosAdministrador == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), allDatosAdministrador, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable(value = "email") String email) {
        try {
            UsuarioResponse user = usuarioService.getUserByEmail(email);

            if (user == null) {
                return response.error(codes.notFound(), messages.notFound(), null);
            } else {
                return response.ok(codes.ok(), messages.ok(), user, null);
            }
        } catch (Exception e) {
            return response.error(codes.error(), messages.error() + e.getMessage(), null);
        }
    }

    @GetMapping("/goImage/{name}")
	public ResponseEntity<Resource> goImage(@PathVariable(value = "name") String filename) throws IOException {
		try {
			Resource image = profileImageService.load(filename);
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
            String urlImage = profileImageService.getUrlImage(filename);

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
            String urlImage = profileImageService.getUrlImage(filename);
            String host = requestHtttp.getRequestURL().toString().replace(requestHtttp.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                            .fromHttpUrl(host)
                            .path("/api/usuario/goImage/")
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
            Boolean result = profileImageService.delete(filename);
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

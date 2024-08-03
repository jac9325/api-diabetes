package com.appdiabetes.ApiDomain.Usuario;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private long id_usuario;

    @NotBlank
    @Column(name = "usuario_access", nullable = false)
    private String usuario_access;

    @Column(name = "estado")
    private int estado;

    @NotBlank
    @Column(name = "password_access", nullable = false)
    private String password_access;

    @Column(name = "correo_confirmado")
    private int correo_confirmado;

    @Column(name = "numero", nullable = true)
    private String numero;

    @Column(name = "correo", unique = true, nullable = true)
    private String correo;

    @Column(name = "numero_confirmado")
    private int numero_confirmado;

    @Column(name = "estado_confirmacion")
    private int estado_confirmacion;

    @Column(name = "codigo_verificacion_correo")
    private String codigo_verificacion_correo;

    @Column(name = "codigo_verificacion_numero")
    private String codigo_verificacion_numero;

    @Column(name = "codigo_pais")
    private String codigo_pais;

    @Column(name = "fecha_expiracion_token")
    private Date fecha_expiracion_token;

    @Column(name ="es_interno")
    private Integer es_interno;
    
}

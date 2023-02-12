package com.factura.app.factura.models.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotEmpty // validacion solo se utiliza con string cuando sea campo requrido
    @Column(name = "nombre")
    private String Nombre;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "apellido")
    private String Apellido;

    @Getter
    @Setter
    @NotNull // validacion
    @Column(name = "celular")
    private long Celular;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "usuario")
    private String Usuario;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "contrasena")
    private String Password;

    @OneToMany(mappedBy = "usuario")
    private List<Publicacion> publicacion;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentario;


    @OneToMany(mappedBy = "usuario")
    private List<Respuesta> respuesta;

}

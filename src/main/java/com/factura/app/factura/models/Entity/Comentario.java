package com.factura.app.factura.models.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotNull
    @Column(name = "id_Usuario")
    private Long IdUsuario;

    @Getter
    @Setter
    @NotNull
    @Column(name = "id_publicacion")
    private Long IdPublicacion;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "respuesta")
    private String Respuesta;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_usuario",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Usuario usuario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_publicacion",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Publicacion publicacion;

    @OneToMany(mappedBy = "comentario")
    private List<Respuesta> respuesta;



}
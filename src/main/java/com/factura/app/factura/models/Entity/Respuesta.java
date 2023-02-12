package com.factura.app.factura.models.Entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "respuesta")
public class Respuesta implements Serializable {

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
    @Column(name = "id_usuario")
    private Long IdUsuario;

    @Getter
    @Setter
    @NotNull
    @Column(name = "id_comentario")
    private Long IdComentario;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "respuesta_comentario")
    private String RespuestaComentario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_comentario",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Comentario comentario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_usuario",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Usuario usuario;
}
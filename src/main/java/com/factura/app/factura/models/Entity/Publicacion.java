package com.factura.app.factura.models.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {

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
    @Column(name = "id_tema")
    private Long IdTema;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "asunto")
    private String Asunto;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_usuario",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Usuario usuario;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="id_tema",insertable = false,updatable = false)//no permite crear clientes desde esta relacion, debe ser desde la entidas propia
    private  Tema tema;

    @OneToMany(mappedBy = "publicacion")
    private List<Comentario> comentario;


}
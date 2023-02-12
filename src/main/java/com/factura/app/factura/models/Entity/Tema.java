package com.factura.app.factura.models.Entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tema")
public class Tema implements  Serializable {

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
    @Column(name = "nombre_tema")
    private String NombreTema;

    @Getter
    @Setter
    @NotEmpty // validacion
    @Column(name = "descripcion_tema")
    private String DescripcionTema;

    @OneToMany(mappedBy = "tema")
    private List<Publicacion> publicacion;





}

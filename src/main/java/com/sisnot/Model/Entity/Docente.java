package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_docente", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "apellido_paterno", length = 100)
    private String apellidoPaterno;

    @Size(max = 100)
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;

    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "dni")
    private Integer dni;

    @Size(max = 100)
    @Column(name = "direccion", length = 100)
    private String direccion;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "celular")
    private Integer celuar;

    @Size(max = 30)
    @Column(name = "estado", length = 30)
    private String estado;

    @OneToMany(mappedBy = "docente",  cascade = CascadeType.ALL)
    private List<CursoDocente> cursoDocentes;

    @OneToMany(mappedBy = "docente",  cascade = CascadeType.ALL)
    private List<DocenteAlumno> docenteAlumnos;

}
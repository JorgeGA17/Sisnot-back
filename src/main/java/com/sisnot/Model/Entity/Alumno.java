package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_alumno", nullable = false)
    private Long codAlumno;

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
    private Integer celular;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Size(max = 20)
    @Column(name = "estado", length = 20)
    private String estado;

    @OneToMany(mappedBy = "codAlumno")
    private Set<Curso> cursos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codAlumnoFK",  cascade = CascadeType.ALL)
    private Set<DocenteAlumno> docenteAlumnos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codAlumno",  cascade = CascadeType.ALL)
    private Set<Nota> notas = new LinkedHashSet<>();

}
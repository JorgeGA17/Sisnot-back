package com.sisnot.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.util.LinkedHashSet;
import java.util.List;
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
    private List<Curso> cursos ;

    //@OneToMany(mappedBy = "alumno",  cascade = CascadeType.ALL)
   //private List<DocenteAlumno> docenteAlumnos;

    @OneToMany(mappedBy = "codAlumno",  cascade = CascadeType.ALL)
    private List<Nota> notas;

}
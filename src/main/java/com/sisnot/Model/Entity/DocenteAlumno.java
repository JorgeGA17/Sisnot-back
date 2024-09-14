package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "docente_alumno")
@IdClass(DocenteAlumnoPK.class)
public class DocenteAlumno {
    @Id
    private Alumno alumno;
    @Id
    private Docente docente;

    @Column (name="added_Date", nullable=false)
    private LocalDateTime addedDate;



}

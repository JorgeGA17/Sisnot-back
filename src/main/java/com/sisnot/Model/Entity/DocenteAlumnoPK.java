package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class DocenteAlumnoPK implements Serializable  {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_alumno", referencedColumnName = "cod_alumno",foreignKey = @ForeignKey(name = "fk_docalum_cod_alumno"))
    private Alumno codAlumnoFK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_docente", referencedColumnName = "cod_docente",foreignKey = @ForeignKey(name = "fk_docalum_cod_docente"))
    private Docente codDocenteFK;
}

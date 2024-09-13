package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CursoDocentePK implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_docente", referencedColumnName = "cod_docente",foreignKey = @ForeignKey(name = "fk_curdocente_cod_docente"))
    private Docente codDocenteFK;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_curso", referencedColumnName = "cod_curso",foreignKey = @ForeignKey(name = "fk_curdocente_cod_curso"))
    private Curso codCursoFK;

}

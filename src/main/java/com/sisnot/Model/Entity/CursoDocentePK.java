package com.sisnot.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CursoDocentePK implements Serializable {

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_docente",
            foreignKey = @ForeignKey(name = "fk_curdocente_cod_docente"))

    private Docente docente;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_curso",
            foreignKey = @ForeignKey(name = "fk_curdocente_cod_curso"))

    private Curso curso;

}

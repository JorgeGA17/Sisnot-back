package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "docente_alumno")
public class DocenteAlumno {
    @Id
    @Column(name = "cod_docente_alumno", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_alumno", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_docalum_cod_alumno"))
    private Alumno codAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_docente", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_docalum_cod_docente"))
    private Docente codDocente;

}

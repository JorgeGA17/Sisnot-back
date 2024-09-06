package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "curso_docente")
public class CursoDocente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_curso_docente", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_docente", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_curdocente_cod_docente"))
    private Docente codDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_curso", referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_curdocente_cod_curso"))
    private Curso codCurso;

}
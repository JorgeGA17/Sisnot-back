package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "cod_curso", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "nom_curso", length = 100)
    private String nomCurso;

    @Size(max = 30)
    @Column(name = "ciclo", length = 30)
    private String ciclo;

    @Size(max = 30)
    @Column(name = "credito", length = 30)
    private String credito;

    @Size(max = 30)
    @Column(name = "estado", length = 30)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_alumno", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_curso_cod_alumno"))
    private Alumno codAlumno;

    @OneToMany(mappedBy = "codCurso")
    private Set<CursoDocente> cursoDocentes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "codCurso")
    private Set<Nota> notas = new LinkedHashSet<>();

}
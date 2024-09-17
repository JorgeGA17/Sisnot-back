package com.sisnot.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetTime;

@Data
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "componente1_nota")
    private Double componente1Nota;

    @Column(name = "componente2_nota")
    private Double componente2Nota;

    @Column(name = "nota_parcial")
    private Double notaParcial;

    @Column(name = "componente3_nota")
    private Double componente3Nota;

    @Column(name = "componente4_nota")
    private Double componente4Nota;

    @Column(name = "nota_final")
    private Double notaFinal;

    @Column(name = "fecha_registro")
    private OffsetTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "cod_alumno", referencedColumnName = "cod_alumno" ,
            foreignKey = @ForeignKey(name = "fk_nota_cod_alumno"))

    private Alumno codAlumno;

    @ManyToOne
    @JoinColumn(name = "cod_curso", referencedColumnName = "cod_curso" ,
            foreignKey = @ForeignKey(name = "fk_nota_cod_curso"))

    private Curso codCurso;

}
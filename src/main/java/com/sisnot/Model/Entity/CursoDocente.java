package com.sisnot.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "curso_docente")
@IdClass(CursoDocentePK.class)
public class CursoDocente {
    @Id
    private long codCursoFK;
    @Id
    private long codDocenteFK;

    @Column (name="added_Date", nullable=false)
    private LocalDateTime addedDate;

}
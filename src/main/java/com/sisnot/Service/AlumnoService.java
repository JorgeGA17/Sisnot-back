package com.sisnot.Service;

import com.sisnot.Model.Entity.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlumnoService {
    List<Alumno> getAlL();
    Page<Alumno> paginate(Pageable pageable);
    Alumno findById(Long CodAlumno);
    Alumno create(Alumno alumno);
    Alumno update(Long codAlumno, Alumno updateAlumno);
    void delete(Long codAlumno);

}

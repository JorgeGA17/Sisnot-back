package com.sisnot.Service.impl;

import com.sisnot.Model.Entity.Alumno;
import com.sisnot.Repository.AlumnoRepository;
import com.sisnot.Service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;


    @Transactional(readOnly = true)
    @Override
    public List<Alumno> getAlL() {
        return alumnoRepository.findAll();
    }



    @Transactional
    @Override
    public Page<Alumno> paginate(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Alumno findById(Long CodAlumno) {
        return alumnoRepository.findById(CodAlumno)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
    }

    @Transactional
    @Override
    public Alumno create(Alumno alumno) {
        alumno.setFechaIngreso(LocalDateTime.now());
        return alumnoRepository.save(alumno);
    }

    @Transactional
    @Override
    public Alumno update(Long codAlumno, Alumno updateAlumno) {
        Alumno alumnoFromDb = findById(codAlumno);
        alumnoFromDb.setNombre(updateAlumno.getNombre());
        alumnoFromDb.setCelular(updateAlumno.getCelular());
        alumnoFromDb.setEmail(updateAlumno.getEmail());
        alumnoFromDb.setApellidoMaterno(updateAlumno.getApellidoMaterno());
        alumnoFromDb.setApellidoPaterno(updateAlumno.getApellidoPaterno());
        alumnoFromDb.setDireccion(updateAlumno.getDireccion());
        alumnoFromDb.setEstado(updateAlumno.getEstado());
        alumnoFromDb.setDni(updateAlumno.getDni());
        alumnoFromDb.setFechaIngreso(LocalDateTime.now());

        return alumnoRepository.save(alumnoFromDb);
    }

    @Transactional
    @Override
    public void delete(Long codAlumno) {
        Alumno alumno=findById(codAlumno);
        alumnoRepository.delete(alumno);
    }
}

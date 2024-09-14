package com.sisnot.Controller;

import com.sisnot.Model.Entity.Alumno;
import com.sisnot.Service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity <List<Alumno>> getAllAlumnos(){
        List<Alumno> alumnos = alumnoService.getAlL();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity <Page<Alumno>> paginateAlumnos(
            @PageableDefault(size= 5, sort= "name") Pageable pageable) {
        Page<Alumno> alumnos = alumnoService.paginate(pageable);
        return new ResponseEntity<Page<Alumno>>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{codAlumno}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long codAlumno) {
            Alumno alumno = alumnoService.findById(codAlumno);
            return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
        Alumno newAlumno = alumnoService.create(alumno);
        return new ResponseEntity<>(newAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{codAlumno}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long codAlumno,
                                               @RequestBody Alumno alumno){
        Alumno updateAlumno = alumnoService.update(codAlumno, alumno);
        return new ResponseEntity<>(updateAlumno, HttpStatus.OK);
    }

    @DeleteMapping("/{codAlumno}")
    public ResponseEntity<Alumno> deleteAlumno(@PathVariable Long codAlumno){
        alumnoService.delete(codAlumno);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }








}

package jdch.foro.foroAlura.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jdch.foro.foroAlura.domain.curso.CursoService;
import jdch.foro.foroAlura.domain.curso.DatosRegistroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class  CursoController {
    @Autowired
    CursoService cursoService;
    @PostMapping
    @Transactional
    public ResponseEntity nuevoCurso(@RequestBody @Valid DatosRegistroCurso datos){
        System.out.println(datos);
        var datosCursoNuevo = cursoService.crearCurso(datos);

        return ResponseEntity.ok(datosCursoNuevo);
    }
}

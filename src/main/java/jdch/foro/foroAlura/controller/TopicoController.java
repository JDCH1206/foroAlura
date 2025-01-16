package jdch.foro.foroAlura.controller;

import jakarta.validation.Valid;
import jdch.foro.foroAlura.domain.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity nuevoCurso(@RequestBody @Valid DatosCrearTopico datos){
        System.out.println(datos);
        var datosTopicoNuevo = topicoService.crearTopico(datos);
        return ResponseEntity.ok(datosTopicoNuevo);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarTopico (@RequestBody @Valid  DatosEditarTopico datos, @PathVariable Long id){
        System.out.println(datos);
        var datosTopicoNuevo = topicoService.editarTopico(datos, id);
        return ResponseEntity.ok(datosTopicoNuevo);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity mostrarTopico ( @PathVariable Long id){
        var datosTopico = topicoService.mostrarTopico(id);
        return ResponseEntity.ok(datosTopico);
    }

    @GetMapping
    @Transactional
    public ResponseEntity <Page<DatosRespuestaTopico>> mostrarListadoTopicos(@PageableDefault(size = 10,
            sort ="fechaDeCreacionTopico",direction = Sort.Direction.DESC) Pageable paginacion){
        var listadoTopicos = topicoService.mostrarListadoTopicos(paginacion);
        return ResponseEntity.ok(listadoTopicos);
    }
    @DeleteMapping("/borrar/{id}")
    @Transactional
    public ResponseEntity eliminarMedicoBaseDeDatos(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }

}

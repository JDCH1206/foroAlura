package jdch.foro.foroAlura.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jdch.foro.foroAlura.domain.respuesta.DatosCrearRespuesta;
import jdch.foro.foroAlura.domain.respuesta.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;
    @PostMapping
    @Transactional
    public ResponseEntity nuevaRespuesta(@RequestBody @Valid DatosCrearRespuesta datos){
        System.out.println(datos);
        var datosRespuestaConsultaNueva = respuestaService.crearRespuesta(datos);

        return ResponseEntity.ok(datosRespuestaConsultaNueva);
    }
}

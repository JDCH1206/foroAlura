package jdch.foro.foroAlura.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;
    public DatosRespuestaCurso crearCurso (DatosRegistroCurso datos){
        Optional<Curso> cursoExiste = cursoRepository.findByNombreCursoContainsIgnoreCase(datos.nombreCurso());
        if (cursoExiste.isPresent()) {
            throw new RuntimeException("El curso ya existe en la base de datos: " + cursoExiste.get().getNombreCurso());
        }
        var curso = new Curso(datos);
        cursoRepository.save(curso);
        return new DatosRespuestaCurso(curso);

        /*var topico = topicoRepository.findById(datos.topicoRespuestaId()).get();
        var autor = usuarioRepository.findById(datos.autorRespuestaId()).get();
        var respuesta = new Respuesta(datos,topico,autor);
        respuestaRepository.save(respuesta);
        return new DatosRespuestaRespuesta(respuesta);*/
    }
}

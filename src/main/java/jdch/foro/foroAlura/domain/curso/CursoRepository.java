package jdch.foro.foroAlura.domain.curso;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Boolean existsByNombreCurso(String cursoNombre);

    Optional<Curso> findByNombreCursoContainsIgnoreCase(@NotBlank String s);
}

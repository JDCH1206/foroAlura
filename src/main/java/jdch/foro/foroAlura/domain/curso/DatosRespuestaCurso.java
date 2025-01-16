package jdch.foro.foroAlura.domain.curso;

public record DatosRespuestaCurso(
        Long idCurso,
        String NombreCurso,
        CategoriaCurso categoriaCurso
) {
    public DatosRespuestaCurso(Curso curso) {
        this(curso.getId(), curso.getNombreCurso(), curso.getCategoriaCurso());
    }
}

package jdch.foro.foroAlura.domain.curso;

import jakarta.persistence.*;
import jdch.foro.foroAlura.domain.respuesta.Respuesta;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table (name = "cursos")
@EqualsAndHashCode(of="id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCurso;
    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoriaCurso;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombreCurso = datosRegistroCurso.nombreCurso();
        this.categoriaCurso = datosRegistroCurso.categoriaCurso();
    }
    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public CategoriaCurso getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(CategoriaCurso categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }
}

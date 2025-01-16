package jdch.foro.foroAlura.domain.topico;

import jakarta.persistence.*;
import jdch.foro.foroAlura.domain.curso.Curso;
import jdch.foro.foroAlura.domain.respuesta.Respuesta;
import jdch.foro.foroAlura.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "topicos")
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "fechadecreaciontopico")
    private LocalDateTime fechaDeCreacionTopico;
    @Column(name = "fechaultimaediciontopico")
    private LocalDateTime fechaUltimaEdicionTopico;
    @Enumerated(EnumType.STRING)
    @Column(name = "statustopico")
    private Estado statusTopico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Usuario idAutor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso idCurso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico() {
    }

    public Topico(DatosCrearTopico datosCrearTopico, Usuario autorT, Curso cursoT) {
        this.titulo = datosCrearTopico.tituloTopico();
        this.mensaje = datosCrearTopico.mensajeTopico();
        this.fechaDeCreacionTopico = LocalDateTime.now();
        this.fechaUltimaEdicionTopico = LocalDateTime.now();
        this.statusTopico = Estado.ABIERTO;
        this.idAutor = autorT;
        this.idCurso = cursoT;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaDeCreacionTopico() {
        return fechaDeCreacionTopico;
    }

    public void setFechaDeCreacionTopico(LocalDateTime fechaDeCreacionTopico) {
        this.fechaDeCreacionTopico = fechaDeCreacionTopico;
    }

    public Estado getStatusTopico() {
        return statusTopico;
    }

    public void setStatusTopico(Estado statusTopico) {
        this.statusTopico = statusTopico;
    }

    public Usuario getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Usuario idAutor) {
        this.idAutor = idAutor;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public LocalDateTime getFechaUltimaEdicionTopico() {
        return fechaUltimaEdicionTopico;
    }

    public void setFechaUltimaEdicionTopico(LocalDateTime fechaUltimaEdicionTopico) {
        this.fechaUltimaEdicionTopico = fechaUltimaEdicionTopico;
    }
}

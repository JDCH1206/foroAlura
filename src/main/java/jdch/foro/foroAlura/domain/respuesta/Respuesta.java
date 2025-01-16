package jdch.foro.foroAlura.domain.respuesta;

import jakarta.persistence.*;
import jdch.foro.foroAlura.domain.topico.Topico;
import jdch.foro.foroAlura.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mensajerespuesta")
    private String mensajeRespuesta;
    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;
    @Column(name = "fechacreacionrespuesta")
    private LocalDateTime fechaCreacionRespuesta;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario autorRespuesta;
    @Column(name = "fechaultimaedicion")
    private LocalDateTime fechaUltimaEdicion;

    private Boolean solucion = false;

    public Respuesta() {
    }

    public Respuesta(DatosCrearRespuesta parametro, Topico topicoRespuesta, Usuario autorRespuesta) {
        this.mensajeRespuesta = parametro.mensajeRespuesta();
        this.topico = topicoRespuesta;
        this.autorRespuesta = autorRespuesta;
        this.fechaCreacionRespuesta = LocalDateTime.now(); // Establece la fecha de creación actual
        this.fechaUltimaEdicion = LocalDateTime.now();
        this.solucion = false; // Valor por defecto
    }
    public Long getId() {
        return id;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public Usuario getAutorRespuesta() {
        return autorRespuesta;
    }

    public Topico getTopico() {
        return topico;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public void setAutorRespuesta(Usuario autorRespuesta) {
        this.autorRespuesta = autorRespuesta;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public void setSolucion(Boolean solucion) {
        this.solucion = solucion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacionRespuesta() {
        return fechaCreacionRespuesta;
    }

    public void setFechaCreacionRespuesta(LocalDateTime fechaCreacionRespuesta) {
        this.fechaCreacionRespuesta = fechaCreacionRespuesta;
    }

    public LocalDateTime getFechaUltimaEdicion() {
        return fechaUltimaEdicion;
    }

    public void setFechaUltimaEdicion(LocalDateTime fechaUltimaEdicion) {
        this.fechaUltimaEdicion = fechaUltimaEdicion;
    }
}

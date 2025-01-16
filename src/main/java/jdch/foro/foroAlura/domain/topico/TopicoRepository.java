package jdch.foro.foroAlura.domain.topico;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("""
            
            select t from Topico t
            where t.titulo = :titulo
            and t.mensaje = :mensaje
            
            """)

    Optional<Topico> topicoYMensajeRepetido(@NotNull String titulo, @NotNull String mensaje);
    @Query("""
            
            select t from Topico t
            order by fechaDeCreacionTopico desc
            
            """)
    Page<DatosRespuestaTopico> listadoTopicos(Pageable pageable);
}

package jdch.foro.foroAlura.controller;

import jakarta.validation.Valid;
import jdch.foro.foroAlura.domain.usuario.UsuarioRepository;
import jdch.foro.foroAlura.domain.usuario.DatosCrearUsuario;
import jdch.foro.foroAlura.domain.usuario.DatosRespuestaUsuario;
import jdch.foro.foroAlura.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class CrearUsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosCrearUsuario parametro,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        Usuario user = usuarioRepository.save(new Usuario(parametro));
        DatosRespuestaUsuario datosResouestaUsuario = new DatosRespuestaUsuario(user.getid(),user.getLogin(),user.getemail()
                );
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(user.getid()).toUri();
        return ResponseEntity.created(url).body(datosResouestaUsuario);

    }
}

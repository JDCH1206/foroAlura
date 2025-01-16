package jdch.foro.foroAlura.controller;

import jakarta.validation.Valid;
import jdch.foro.foroAlura.domain.usuario.DatosAutenticacionUsuario;
import jdch.foro.foroAlura.domain.usuario.Usuario;
import jdch.foro.foroAlura.infra.security.DatosJWTToken;
import jdch.foro.foroAlura.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        var authTtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
                datosAutenticacionUsuario.contrasena());
        System.out.println(datosAutenticacionUsuario.login());
        System.out.println(datosAutenticacionUsuario.contrasena());
        var usuarioAutenticado = manager.authenticate(authTtoken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}

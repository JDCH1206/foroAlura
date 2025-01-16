package jdch.foro.foroAlura.domain.perfil;

import jakarta.persistence.*;
import jdch.foro.foroAlura.domain.usuario.Usuario;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "perfiles")
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING) // Almacena el valor del enum como cadena en la base de datos
    @Column(nullable = false, unique = true)
    private Rol rol;

    // Relación inversa muchos a muchos con Usuario
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Long getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    // Métodos auxiliares
    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.getPerfiles().add(this);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
        usuario.getPerfiles().remove(this);
    }
}

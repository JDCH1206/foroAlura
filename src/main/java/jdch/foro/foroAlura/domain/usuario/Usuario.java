package jdch.foro.foroAlura.domain.usuario;

import jakarta.persistence.*;
import jdch.foro.foroAlura.domain.perfil.Perfil;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name= "usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String contrasena;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private List<Perfil> perfiles = new ArrayList<>();

    public Usuario() {
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public Usuario(DatosCrearUsuario parametro) {

        this.login = parametro.usuario();
        this.email = parametro.email();
        this.contrasena = parametro.contrasena();
        /*this.perfiles = parametro.rol()*/

    }
    // Métodos auxiliares para manejar perfiles
    public void agregarPerfil(Perfil perfil) {
        this.perfiles.add(perfil);
        perfil.getUsuarios().add(this); // Sincroniza la relación inversa
    }

    public void removerPerfil(Perfil perfil) {
        this.perfiles.remove(perfil);
        perfil.getUsuarios().remove(this); // Sincroniza la relación inversa
    }


    public Long getid() {
        return id;
    }

    public String getemail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }*/

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles.stream()
                .map(perfil -> new SimpleGrantedAuthority("ROLE_" + perfil.getRol().name()))
                .toList();
    }

}

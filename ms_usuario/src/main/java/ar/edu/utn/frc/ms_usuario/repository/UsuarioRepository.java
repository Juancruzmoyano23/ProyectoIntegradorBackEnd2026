package ar.edu.utn.frc.ms_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frc.ms_usuario.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByEmail(String email);
}
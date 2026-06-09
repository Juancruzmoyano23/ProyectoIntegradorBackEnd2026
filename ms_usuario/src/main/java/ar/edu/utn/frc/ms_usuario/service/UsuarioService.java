package ar.edu.utn.frc.ms_usuario.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ar.edu.utn.frc.ms_usuario.dto.UsuarioRequest;
import ar.edu.utn.frc.ms_usuario.dto.UsuarioResponse;
import ar.edu.utn.frc.ms_usuario.entity.Usuario;
import ar.edu.utn.frc.ms_usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse crearUsuario(UsuarioRequest request) {
        Usuario usuario = Usuario.builder()
                .nombreUsuario(request.getNombreUsuario())
                .email(request.getEmail())
                .rol(Usuario.Rol.USUARIO)
                .build();

        Usuario guardado = usuarioRepository.save(usuario);
        return mapearRespuesta(guardado);
    }

    public UsuarioResponse obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return mapearRespuesta(usuario);
    }

    public List<UsuarioResponse> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapearRespuesta)
                .collect(Collectors.toList());
    }

    private UsuarioResponse mapearRespuesta(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombreUsuario(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }
}

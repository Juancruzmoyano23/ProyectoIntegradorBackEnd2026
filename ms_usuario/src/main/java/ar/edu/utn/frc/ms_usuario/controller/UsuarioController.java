package ar.edu.utn.frc.ms_usuario.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.edu.utn.frc.ms_usuario.dto.UsuarioRequest;
import ar.edu.utn.frc.ms_usuario.dto.UsuarioResponse;
import ar.edu.utn.frc.ms_usuario.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> crearUsuario(@Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuarioPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> obtenerTodos() {
        return ResponseEntity.ok(usuarioService.obtenerTodosLosUsuarios());
    }
}

package ar.edu.utn.frc.ms_usuario.dto;

import lombok.Data;
import ar.edu.utn.frc.ms_usuario.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nombreUsuario;
    private String email;
    private Usuario.Rol rol;
}
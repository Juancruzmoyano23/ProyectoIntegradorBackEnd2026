package ar.edu.utn.frc.ms_acciones.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccionResponse {
    private String simbolo;
    private String nombre;
    private Double precioActual;
    private String moneda;
}
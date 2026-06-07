package ar.edu.utn.frc.ms_acciones.controller;

import ar.edu.utn.frc.ms_acciones.dto.AccionResponse;
import ar.edu.utn.frc.ms_acciones.service.AccionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acciones")
@RequiredArgsConstructor
public class AccionesController {

    private final AccionesService accionesService;

    @GetMapping("/{simbolo}")
    public ResponseEntity<AccionResponse> obtenerCotizacion(@PathVariable String simbolo) {
        return ResponseEntity.ok(accionesService.obtenerCotizacion(simbolo));
    }
}
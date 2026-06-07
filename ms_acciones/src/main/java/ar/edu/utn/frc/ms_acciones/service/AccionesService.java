package ar.edu.utn.frc.ms_acciones.service;

import ar.edu.utn.frc.ms_acciones.dto.AccionResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AccionesService {

    private final RestTemplate restTemplate;

    public AccionesService() {
        this.restTemplate = new RestTemplate();
    }

    public AccionResponse obtenerCotizacion(String simbolo) {
        String url = "https://query1.finance.yahoo.com/v8/finance/chart/" + simbolo;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0");
            headers.set("Accept", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> respuesta = restTemplate.exchange(
                url, HttpMethod.GET, entity, Map.class
            );

            Map chart = (Map) respuesta.getBody().get("chart");
            List result = (List) chart.get("result");
            Map datos = (Map) result.get(0);
            Map meta = (Map) datos.get("meta");

            String nombre = (String) meta.get("shortName");
            Double precio = ((Number) meta.get("regularMarketPrice")).doubleValue();
            String moneda = (String) meta.get("currency");

            return new AccionResponse(simbolo.toUpperCase(), nombre, precio, moneda);

        } catch (Exception e) {
            throw new RuntimeException("No se pudo obtener la cotización para: " + simbolo);
        }
    }
}
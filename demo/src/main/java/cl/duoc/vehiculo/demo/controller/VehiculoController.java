package cl.duoc.vehiculo.demo.controller;

import cl.duoc.vehiculo.demo.dto.*;
import cl.duoc.vehiculo.demo.service.VehiculoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService service;

    @PostMapping("/agregar")
    public ResponseEntity<ApiResponse<VehiculoDTO>> agregar(@Valid @RequestBody VehiculoCreateDTO dto) {
        return ResponseEntity.ok(new ApiResponse<>(201, "Vehículo agregado", service.agregar(dto)));
    }

    @GetMapping("/stock")
    public ResponseEntity<ApiResponse<List<VehiculoDTO>>> listar() {
        return ResponseEntity.ok(new ApiResponse<>(200, "Listado de stock", service.listar()));
    }

    @PutMapping("/{id}/vender")
    public ResponseEntity<ApiResponse<VehiculoDTO>> vender(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Vendido", service.vender(id)));
    }

    @PutMapping("/{id}/abastecer")
    public ResponseEntity<ApiResponse<VehiculoDTO>> abastecer(@PathVariable Long id, @RequestParam int cantidad) {
        return ResponseEntity.ok(new ApiResponse<>(200, "Stock aumentado", service.abastecer(id, cantidad)));
    }
}
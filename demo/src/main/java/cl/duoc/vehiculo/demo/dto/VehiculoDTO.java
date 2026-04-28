package cl.duoc.vehiculo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Integer stock;
}
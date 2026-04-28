package cl.duoc.vehiculo.demo.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class VehiculoCreateDTO {
    @NotBlank(message = "La marca no puede estar vacía")
    @Pattern(regexp = "^(BMW|Audi|Mercedes)$", message = "Solo se permite BMW, Audi o Mercedes")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;
}
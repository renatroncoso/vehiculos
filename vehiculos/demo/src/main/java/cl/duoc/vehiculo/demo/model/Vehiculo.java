package cl.duoc.vehiculo.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = " La marca no puede estar vacia")
    @Pattern(regexp = "^(BMW|Audi|Mercedes)$", message = "Solo se permite BMW, Audi o Mercedes")
        private String marca;
    @NotBlank( message = "El modelo es obligatorio")
        private String modelo;
    @Min(value = 0 , message =  "El Stock no puede ser negativo")
        private Integer stock;

}



package cl.duoc.vehiculo.demo.service;

import cl.duoc.vehiculo.demo.dto.*;
import cl.duoc.vehiculo.demo.model.Vehiculo;
import cl.duoc.vehiculo.demo.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository repository;

    public VehiculoDTO agregar(VehiculoCreateDTO dto) {
        Vehiculo v = repository.save(new Vehiculo(null, dto.getMarca(), dto.getModelo(), dto.getStock()));
        return new VehiculoDTO(v.getId(), v.getMarca(), v.getModelo(), v.getStock());
    }

    public List<VehiculoDTO> listar() {
        return repository.findAll().stream()
                .map(v -> new VehiculoDTO(v.getId(), v.getMarca(), v.getModelo(), v.getStock())).toList();
    }

    public VehiculoDTO vender(Long id) {
        Vehiculo v = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe"));
        if (v.getStock() <= 0) throw new RuntimeException("Sin stock");
        v.setStock(v.getStock() - 1);
        repository.save(v);
        return new VehiculoDTO(v.getId(), v.getMarca(), v.getModelo(), v.getStock());
    }

    public VehiculoDTO abastecer(Long id, int cant) {
        Vehiculo v = repository.findById(id).orElseThrow(() -> new RuntimeException("No existe"));
        v.setStock(v.getStock() + cant);
        repository.save(v);
        return new VehiculoDTO(v.getId(), v.getMarca(), v.getModelo(), v.getStock());
    }
}
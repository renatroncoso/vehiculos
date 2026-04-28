package cl.duoc.vehiculo.demo.repository;

import cl.duoc.vehiculo.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}

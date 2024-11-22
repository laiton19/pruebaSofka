package co.com.pruebasofka.repository;

import co.com.pruebasofka.entity.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    List<Movimiento> findByIdCuenta(Long idCuenta);

    List<Movimiento> findByFecha(Date fecha);

    List<Movimiento> findByTipoMovimiento(String tipoMovimiento);

}

package co.com.pruebasofka.repository;

import co.com.pruebasofka.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    Cuenta findByNumeroCuenta(String numeroCuenta);
    List<Cuenta> findByIdCliente(Long idCliente);

}

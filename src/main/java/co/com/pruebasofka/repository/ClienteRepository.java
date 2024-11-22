package co.com.pruebasofka.repository;

import co.com.pruebasofka.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByIdPersona(Long idPersona);
}

package co.com.pruebasofka.repository;

import co.com.pruebasofka.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRespository extends JpaRepository<Persona, Integer> {

    Persona findByIdentificacion(String numeroIdentificacion);
}

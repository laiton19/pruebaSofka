package co.com.pruebasofka.controller;

import co.com.pruebasofka.entity.Persona;
import co.com.pruebasofka.repository.PersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaRespository personaRespository;

    @GetMapping
    private List<Persona> listarPersonas() {
        return personaRespository.findAll();
    }

    @PostMapping
    private Persona crearPersona(@RequestBody Persona persona) {
        return personaRespository.save(persona);
    }
    @PutMapping("/{id}")
    private Persona editarPersona(@PathVariable long id, @RequestBody Persona persona) {
        persona.setId(id);
        return personaRespository.save(persona);
    }
}

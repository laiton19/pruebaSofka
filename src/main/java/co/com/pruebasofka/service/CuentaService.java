package co.com.pruebasofka.service;

import co.com.pruebasofka.entity.Cliente;
import co.com.pruebasofka.entity.Cuenta;
import co.com.pruebasofka.entity.Persona;
import co.com.pruebasofka.repository.ClienteRepository;
import co.com.pruebasofka.repository.CuentaRepository;
import co.com.pruebasofka.repository.PersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PersonaRespository personaRespository;

    public Cuenta crearCuenta(String numeroIdentificacion, Cuenta cuenta){
        try{
            Persona persona = personaRespository.findByIdentificacion(numeroIdentificacion);
            Cliente cliente = clienteRepository.findByIdPersona(persona.getId());
            Cuenta cuentaGuardar = new Cuenta();
            cuentaGuardar.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaGuardar.setEstado(cuenta.isEstado());
            cuentaGuardar.setTipo(cuenta.getTipo());
            cuentaGuardar.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaGuardar.setIdCliente(cliente.getId());

            cuentaRepository.save(cuentaGuardar);

            return cuentaGuardar;

        } catch (RuntimeException e) {
            return null;
        }
    }
}

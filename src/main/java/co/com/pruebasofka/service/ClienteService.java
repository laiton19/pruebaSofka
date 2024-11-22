package co.com.pruebasofka.service;

import co.com.pruebasofka.entity.Cliente;
import co.com.pruebasofka.entity.Cuenta;
import co.com.pruebasofka.entity.CuentasCliente;
import co.com.pruebasofka.entity.Persona;
import co.com.pruebasofka.repository.ClienteRepository;
import co.com.pruebasofka.repository.CuentaRepository;
import co.com.pruebasofka.repository.PersonaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private PersonaRespository personaRespository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    public Cliente crearCliente(String numeroIdentificacion, Cliente cliente) {
        try{
            Persona persona = personaRespository.findByIdentificacion(numeroIdentificacion);
            Cliente clienteGuardar = new Cliente();
            clienteGuardar.setContrasenia(cliente.getContrasenia());
            clienteGuardar.setEstado(cliente.isEstado());
            clienteGuardar.setIdPersona(persona.getId());

            clienteRepository.save(clienteGuardar);

            return clienteGuardar;

        } catch (RuntimeException e) {
            return null;
        }
    }

    public CuentasCliente cuentasClientes(String numeroIdentificacion) {
        try{
            Persona persona = personaRespository.findByIdentificacion(numeroIdentificacion);
            System.out.println("********" + persona);
            List<Cuenta> cuentas = cuentaRepository.findByIdCliente(persona.getId());
            System.out.println("********" + cuentas);
            CuentasCliente cuentasCliente = new CuentasCliente(persona,cuentas);

            return cuentasCliente;

        } catch (RuntimeException e) {
            return null;
        }

    }
}

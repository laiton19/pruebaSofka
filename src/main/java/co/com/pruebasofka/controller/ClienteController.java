package co.com.pruebasofka.controller;

import co.com.pruebasofka.entity.Cliente;
import co.com.pruebasofka.entity.CuentasCliente;
import co.com.pruebasofka.repository.ClienteRepository;
import co.com.pruebasofka.repository.CuentaRepository;
import co.com.pruebasofka.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listaClientes() {

        return clienteRepository.findAll();
    }

    @GetMapping("/cuentasCliente")
    public CuentasCliente cuentasCliente(@RequestParam String numeroIdentificacion) {
        return clienteService.cuentasClientes(numeroIdentificacion);
    }


    @PostMapping
    public Cliente crearCliente(@RequestParam String numeroIdentificacion,@RequestBody Cliente cliente) {
        return clienteService.crearCliente(numeroIdentificacion, cliente);
    }
    @PutMapping("/{id}")
    public Cliente editarCliente(@PathVariable Long id,@RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
}

package co.com.pruebasofka.controller;

import co.com.pruebasofka.entity.Cuenta;
import co.com.pruebasofka.repository.CuentaRepository;
import co.com.pruebasofka.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private CuentaService cuentaService;
    @GetMapping
    private List<Cuenta> cuentas(){
        return cuentaRepository.findAll();
    }
    @PostMapping
    private Cuenta createCuenta(@RequestParam String numeroIdentificacion,@RequestBody Cuenta cuenta){

        return cuentaService.crearCuenta(numeroIdentificacion,cuenta);
    }
}

package co.com.pruebasofka.controller;

import co.com.pruebasofka.entity.Movimiento;
import co.com.pruebasofka.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> listar(@RequestParam String numeroCuenta) {
        return movimientoService.ConsultaMovimientoPorCuenta(numeroCuenta);
    }
    @PostMapping("/registrar")
    private Movimiento registrar(@RequestParam String numeroCuenta, @RequestParam String tipoMovimiento, @RequestParam Double valor){
        return movimientoService.registroMovimiento(numeroCuenta, tipoMovimiento, valor);
    }
}

package co.com.pruebasofka.service;

import co.com.pruebasofka.entity.Cuenta;
import co.com.pruebasofka.entity.Movimiento;
import co.com.pruebasofka.repository.CuentaRepository;
import co.com.pruebasofka.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;


    public Movimiento registroMovimiento(String numeroCuenta, String tipoMovimiento,Double valor){
        try{
            Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
            Double saldo = cuenta.getSaldoInicial();
            Movimiento movimiento = new Movimiento();

            if(tipoMovimiento.equals("Retiro")){
                saldo -= valor;
            } else if (tipoMovimiento.equals("Deposito")) {
                saldo += valor;
            }

            movimiento.setFecha(new java.util.Date());
            movimiento.setTipoMovimiento(tipoMovimiento);
            movimiento.setValor(valor);
            movimiento.setSaldo(saldo);
            movimiento.setIdCuenta(cuenta.getId());

            movimientoRepository.save(movimiento);
            return movimiento;
        } catch (RuntimeException e) {
            return null;
        }

    }

    public List<Movimiento> ConsultaMovimientoPorCuenta(String numeroCuenta){
        try{
            Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta);
            return movimientoRepository.findByIdCuenta(cuenta.getId());
        } catch (RuntimeException e) {
            return null;
        }

    }
}

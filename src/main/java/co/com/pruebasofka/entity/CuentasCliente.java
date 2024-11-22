package co.com.pruebasofka.entity;

import java.util.List;

public class CuentasCliente <Cliente, Cuenta>{

    private Cliente cliente;
    private List<Cuenta> cuentas;

    public CuentasCliente(Cliente cliente, List<Cuenta> cuentas) {
        this.cliente = cliente;
        this.cuentas = cuentas;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}

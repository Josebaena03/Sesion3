package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {

    @Test
    void alCrearUnaCuentaConSaldoInicial_ElSaldoEsCorrecto() {
        Cuenta cuenta = new Cuenta("12345", 50.0);
        assertEquals(50.0, cuenta.getSaldo());
    }
}
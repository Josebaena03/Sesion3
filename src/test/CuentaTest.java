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
    
    @Test
    void alIngresarDinero_ElSaldoDebeAumentar() {
        Cuenta cuenta = new Cuenta("12345", 50.0);
        cuenta.ingresar(100.0);
        assertEquals(150.0, cuenta.getSaldo());
    }
    @Test
    void alRetirarDinero_ElSaldoDebeDisminuir() {
        Cuenta cuenta = new Cuenta("12345", 100.0);
        cuenta.retirar(30.0);
        assertEquals(70.0, cuenta.getSaldo());
    }
    
    @Test
    void alRetirarDinero_SuperandoElLimiteDeDescubierto_DebeLanzarExcepcion() {
        Cuenta cuenta = new Cuenta("12345", 100.0);
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(600.01);
        });
    }
    
    @Test
    void testCasoCompletoDeRegresion_Test0014() {
        // ---- INICIALIZACIÓN ----
        Cuenta cuenta12345 = new Cuenta("12345", 50.0);
        Cuenta cuenta67890 = new Cuenta("67890", 0.0);

        // ---- INSTRUCCIONES ----
        // 1. Reintegro de 200€ de la cuenta 12345 (Saldo: -150€)
        cuenta12345.retirar(200.0);
        // 2. Reintegro de 350€ de la cuenta 67890 (Saldo: -350€)
        cuenta67890.retirar(350.0);
        // 3. Ingreso de 100€ en la cuenta 12345 (Saldo: -50€)
        cuenta12345.ingresar(100.0);
        
        // 4. Error esperado: Reintegro de 200€ en cuenta 67890 (Saldo -350 - 200 = -550, supera el límite)
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta67890.retirar(200.0);
        });

        // 5. Reintegro de 150€ de la cuenta 67890 (Saldo: -500€)
        cuenta67890.retirar(150.0);
        // 6. Reintegro de 200€ de la cuenta 12345 (Saldo: -250€)
        cuenta12345.retirar(200.0);
        // 7. Ingreso de 50€ en la cuenta 67890 (Saldo: -450€)
        cuenta67890.ingresar(50.0);

        // 8. Error esperado: Reintegro de 100€ en cuenta 67890 (Saldo -450 - 100 = -550, supera el límite)
        assertThrows(IllegalArgumentException.class, () -> {
            cuenta67890.retirar(100.0);
        });

        // ---- RESULTADOS ESPERADOS ----
        assertEquals(-250.0, cuenta12345.getSaldo(), "El saldo final de la cuenta 12345 no es el esperado.");
        assertEquals(-450.0, cuenta67890.getSaldo(), "El saldo final de la cuenta 67890 no es el esperado.");
    }
    
}
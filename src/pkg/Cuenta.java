package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numero;
    private List<Movimiento> movimientos;

    public Cuenta(String numero, double saldoInicial) {
        this.numero = numero;
        this.movimientos = new ArrayList<>();
        if (saldoInicial > 0) {
            this.movimientos.add(new Movimiento(saldoInicial, TipoSignoMovimiento.H));
        }
    }

    public double getSaldo() {
        double saldoCalculado = 0.0;
        for (Movimiento m : this.movimientos) {
            if (m.getSigno() == TipoSignoMovimiento.H) {
                saldoCalculado += m.getImporte();
            } else {
                saldoCalculado -= m.getImporte();
            }
        }
        return saldoCalculado;
    }
    
    public void ingresar(double cantidad) {
        this.movimientos.add(new Movimiento(cantidad, TipoSignoMovimiento.H));
    }
    public void retirar(double cantidad) {
        final double LIMITE_DESCUBIERTO = -500.0;  
        if ((getSaldo() - cantidad) >= LIMITE_DESCUBIERTO) {
            this.movimientos.add(new Movimiento(cantidad, TipoSignoMovimiento.D));
        } else {     
            throw new IllegalArgumentException("Fondos insuficientes. Se supera el límite de descubierto.");
        }
    }
}
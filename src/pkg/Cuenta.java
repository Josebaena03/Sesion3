package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numero;
    private List<Movimiento> movimientos;

    public Cuenta(String numero, double saldoInicial) {
        this.numero = numero;
        this.movimientos = new ArrayList<>();
        // El saldo inicial se registra como el primer movimiento
        if (saldoInicial > 0) {
            this.movimientos.add(new Movimiento(saldoInicial, "H"));
        }
    }

    public double getSaldo() {
        double saldoCalculado = 0.0;
        for (Movimiento m : this.movimientos) {
            if (m.getSigno().equals("H")) {
                saldoCalculado += m.getImporte();
            } else {
                saldoCalculado -= m.getImporte();
            }
        }
        return saldoCalculado;
    }
}
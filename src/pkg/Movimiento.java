package pkg;

public class Movimiento {
    private double importe;
    private String signo; // "H" (Haber, ingreso) o "D" (Debe, reintegro)

    public Movimiento(double importe, String signo) {
        this.importe = importe;
        this.signo = signo;
    }

    public double getImporte() {
        return importe;
    }

    public String getSigno() {
        return signo;
    }
}
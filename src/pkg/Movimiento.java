package pkg;

public class Movimiento {
    private double importe;
    private TipoSignoMovimiento signo;

    public Movimiento(double importe, TipoSignoMovimiento signo) {
        this.importe = importe;
        this.signo = signo;
    }

    public double getImporte() {
        return importe;
    }

    public TipoSignoMovimiento getSigno() {
        return signo;
    }
}
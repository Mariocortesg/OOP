public class Banco {
    private double saldo;

    public Banco() {
        this.saldo = 0.0;
    }

    // Getter para saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para saldo con validación (opcional, pero mejor controlar modificaciones)
    private void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    // Método para depositar que usa el setter
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            setSaldo(getSaldo() + cantidad);
        }
    }

    // Método para retirar que usa el setter
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            return true;
        }
        return false;
    }
}



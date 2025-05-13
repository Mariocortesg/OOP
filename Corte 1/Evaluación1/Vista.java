import javax.swing.*;
import java.awt.event.*;

public class Vista extends JFrame {
    private Banco banco;
    private JLabel saldoLabel;
    private JTextField cantidadField;

    public Vista(Banco banco) {
        this.banco = banco;
        inicializarComponentes();
    }

    // Getters y setters para los atributos privados

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public JLabel getSaldoLabel() {
        return saldoLabel;
    }

    public void setSaldoLabel(JLabel saldoLabel) {
        this.saldoLabel = saldoLabel;
    }

    public JTextField getCantidadField() {
        return cantidadField;
    }

    public void setCantidadField(JTextField cantidadField) {
        this.cantidadField = cantidadField;
    }

    private void inicializarComponentes() {
        setTitle("Cajero Automático");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        saldoLabel = new JLabel("Saldo disponible: $0.0");
        saldoLabel.setBounds(30, 20, 250, 30);
        add(saldoLabel);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(30, 60, 80, 25);
        add(cantidadLabel);

        cantidadField = new JTextField();
        cantidadField.setBounds(110, 60, 100, 25);
        add(cantidadField);

        JButton depositarBtn = new JButton("Depositar");
        depositarBtn.setBounds(30, 100, 100, 30);
        add(depositarBtn);

        JButton retirarBtn = new JButton("Retirar");
        retirarBtn.setBounds(140, 100, 100, 30);
        add(retirarBtn);

        JButton saldoBtn = new JButton("Mostrar Saldo");
        saldoBtn.setBounds(250, 100, 120, 30);
        add(saldoBtn);

        depositarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = obtenerCantidad();
                if (cantidad > 0) {
                    getBanco().depositar(cantidad);
                    actualizarSaldo();
                } else {
                    mostrarMensaje("Ingrese una cantidad válida.");
                }
            }
        });

        retirarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double cantidad = obtenerCantidad();
                if (cantidad > 0) {
                    if (getBanco().retirar(cantidad)) {
                        actualizarSaldo();
                    } else {
                        mostrarMensaje("Fondos insuficientes.");
                    }
                } else {
                    mostrarMensaje("Ingrese una cantidad válida.");
                }
            }
        });

        saldoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarSaldo();
            }
        });
    }

    private double obtenerCantidad() {
        try {
            return Double.parseDouble(getCantidadField().getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void actualizarSaldo() {
        getSaldoLabel().setText("Saldo disponible: $" + getBanco().getSaldo());
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}

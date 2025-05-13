public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Vista vista = new Vista(banco);
        vista.setVisible(true);
    }
}

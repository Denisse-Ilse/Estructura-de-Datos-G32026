package mx.edu.uttt.menu;

import javax.swing.JOptionPane;

public class Menus {

    public static void main(String[] args) {
        String opcion;
        do {
            opcion = leer(menu.menuPrincipal());
            switch (opcion) {
                case "1":
                    menuArreglos();
                    break;
                case "2":
                case "3":
                case "4":
                case "5":
                    JOptionPane.showMessageDialog(null, "Este tema aún está en construcción.");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Hasta luego.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (!opcion.equals("0"));
    }

    private static void menuArreglos() {
        String opcion;
        do {
            opcion = leer(menu.menuArreglos());
            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Vectores: aún no conectado a este menú.");
                    break;
                case "2":
                    menuMatrices();
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (!opcion.equals("0"));
    }

    private static void menuMatrices() {
        String opcion;
        do {
            opcion = leer(menu.menuMatices());
            switch (opcion) {
                case "1":
                    Ejer1.main(null);   // Reserva de asientos
                    break;
                case "2":
                    main2.main(null);   // Acumulado de ventas
                    break;
                case "3":
                case "4":
                    main3.main(null);   // Matriz identidad + suma de diagonal principal
                    break;
                case "5":
                    main4.main(null);   // Transposición
                    break;
                case "6":
                    main5.main(null);   // Rotación 90°
                    break;
                case "0":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (!opcion.equals("0"));
    }

    // Si el usuario cancela o cierra el cuadro, se interpreta como "0" (regresar/salir)
    private static String leer(String entrada) {
        return entrada == null ? "0" : entrada.trim();
    }
}

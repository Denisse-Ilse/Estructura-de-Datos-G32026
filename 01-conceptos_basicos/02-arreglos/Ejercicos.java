//Ejercicio 1: Sistema de reserva de asientos.
package mx.edu.uttt.matrices;
import javax.swing.JOptionPane;
public class Ejercicio1 {

    private int[][] asientos;

    public Ejercicio1(int filas, int columnas) {
        asientos = new int[filas][columnas];
    }

    public void reservaAsiento(int fila, int columna) {
        if (fila < 0 || fila >= asientos.length ||
                columna < 0 || columna >= asientos[0].length) {
            System.out.println("Coordenadas fuera de rango. Filas válidas: 0-"
                    + (asientos.length - 1) + ", columnas válidas: 0-"
                    + (asientos[0].length - 1));
            return;
        }

        if (asientos[fila][columna] == 0) {
            asientos[fila][columna] = 1;
            System.out.println("Asiento [" + fila + "][" + columna + "] reservado con éxito.");
        } else {
            System.out.println("El asiento [" + fila + "][" + columna + "] ya está ocupado.");
        }
    }

    public void mostrarSala() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }
}
package mx.edu.uttt.menu;
import javax.swing.JOptionPane;
import mx.edu.uttt.matrices.Ejercicio1;

public class main1 {
    public static void main(String[] args) {
        // 1. Pedir las dimensiones de la sala
        int filas = leerEntero("¿Cuántas filas tiene la sala?");
        int columnas = leerEntero("¿Cuántas columnas (asientos por fila) tiene?");

        if (filas <= 0 || columnas <= 0) {
            System.out.println("Las dimensiones deben ser mayores a 0.");
            return;
        }

        Ejercicio1 sala = new Ejercicio1(filas, columnas);

        int opcion;
        do {
            String menu = "SISTEMA DE RESERVA DE ASIENTOS\n\n"
                    + "1. Reservar un asiento\n"
                    + "2. Ver mapa de la sala\n"
                    + "3. Salir\n\n"
                    + "Elige una opción:";
            opcion = leerEntero(menu);

            switch (opcion) {
                case 1:
                    int fila = leerEntero("Número de fila (0 a " + (filas - 1) + "):");
                    int columna = leerEntero("Número de columna (0 a " + (columnas - 1) + "):");
                    sala.reservaAsiento(fila, columna);
                    break;
                case 2:
                    System.out.println("\nMapa de la sala (0 = libre, 1 = ocupado):");
                    sala.mostrarSala();
                    break;
                case 3:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }


    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);

            if (entrada == null) {
                return 3;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero.");
            }
        }
    }

}

//Ejercico 2 : Acumulado de ventas por sucursal en mes(m*n)
package mx.edu.uttt.matrices;
import javax.swing.JOptionPane;

public class RegistroVentas {

    private int[][] ventas;

    public RegistroVentas(int sucursal, int meses) {
        ventas = new int[sucursal][meses];
    }

    public void registrarVenta(int sucursal, int meses, int monto) {

        if (sucursal < 0 || sucursal >= ventas.length ){
            System.out.println("Surcursal fuera de rango");
            return;
        }


        if (meses<0 || meses>= ventas[0].length ){
            System.out.println("Mes fuera de rango.");
            return;
        }

        if (monto<0) {
            System.out.println("El monto no puede ser negativo.");
            return;
        }
        ventas[sucursal][meses]=monto;
        System.out.println("Venta registrada correctamente");


    }

    public int[] totalPorSucursal() {
        int[] totales = new int[ventas.length];

        for (int i = 0; i < ventas.length; i++) {
            int suma = 0;
            for (int j = 0; j < ventas[i].length; j++) {
                suma += ventas[i][j];
            }
            totales[i] = suma;
        }
        return totales;
    }


    public int[] totalPorMes() {
        // TODO: igual, pero el for externo recorre j y el interno i
        int[] totales = new int[ventas[0].length];

        for (int j = 0; j < ventas[0].length; j++) {
            int suma = 0;
            for (int i = 0; i < ventas.length; i++) {
                suma += ventas[i][j];
            }
            totales[j] = suma;
        }
        return totales;
    }


    public String generarReporte() {
        int[] porSucursal = totalPorSucursal();
        int[] porMes = totalPorMes();
        StringBuilder sb = new StringBuilder();


        sb.append(String.format("%-12s", "Sucursal"));
        for (int j = 0; j < ventas[0].length; j++) {
            sb.append(String.format("%10s", "Mes " + (j + 1)));
        }
        sb.append(String.format("%12s", "TOTAL")).append("\n");


        for (int i = 0; i < ventas.length; i++) {
            sb.append(String.format("%-12s", "Sucursal " + (i + 1)));
            for (int j = 0; j < ventas[i].length; j++) {
                sb.append(String.format("%10d", ventas[i][j]));
            }
            sb.append(String.format("%12d", porSucursal[i])).append("\n");
        }


        sb.append(String.format("%-12s", "TOTAL MES"));
        int granTotal = 0;
        for (int j = 0; j < porMes.length; j++) {
            sb.append(String.format("%10d", porMes[j]));
            granTotal += porMes[j];
        }
        sb.append(String.format("%12d", granTotal)).append("\n");

        return sb.toString();
    }


}

package mx.edu.uttt.menu;
import  mx.edu.uttt.matrices.RegistroVentas;
import javax.swing.JOptionPane;
public class main2 {
    public static void main(String[] args) {
        int m = leerEntero("¿Cuántas sucursales hay?");
        int n = leerEntero("¿Cuántos meses se registran?");

        if (m <= 0 || n <= 0) {
            System.out.println("Operación cancelada: las dimensiones deben ser mayores a 0.");
            return;
        }

        RegistroVentas registro = new RegistroVentas(m, n);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int monto = leerEntero("Ventas de la Sucursal " + (i + 1)
                        + " en el Mes " + (j + 1) + ":");
                if (monto < 0) {
                    System.out.println("Captura cancelada o monto inválido.");
                    return;
                }
                registro.registrarVenta(i, j, monto);
            }
        }

        System.out.println("\n===== REPORTE DE VENTAS =====");
        System.out.println(registro.generarReporte());
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return -1;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero.");
            }
        }
    }
}

//Ejercicio 3: Diagnostico de Matriz identidad y diagonal principal (n*n).
package mx.edu.uttt.matrices;

public class Ejercicio3 {
    private int[][] datos;

    public Ejercicio3(int filas, int columnas) {
        datos = new int[filas][columnas];
    }

    public void setValor(int i, int j, int valor) {
        if (i < 0 || i >= datos.length || j < 0 || j >= datos[0].length) {
            System.out.println("Posición fuera de rango.");
            return;
        }
        datos[i][j] = valor;
    }


    public boolean esCuadrada() {
        return datos.length == datos[0].length;
    }


    public boolean esIdentidad() {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                if (i == j && datos[i][j] != 1) {
                    return false;
                }
                if (i != j && datos[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public int sumaDiagonal() {
        int suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma += datos[i][i];
        }
        return suma;
    }

    public void mostrar() {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                System.out.print(datos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
package mx.edu.uttt.menu;

import mx.edu.uttt.matrices.Ejercicio3;
import javax.swing.JOptionPane;

public class main3 {
    public static void main(String[] args) {
        Integer filas = leerEntero("¿Cuántas filas tiene la matriz?");
        Integer columnas = leerEntero("¿Cuántas columnas tiene la matriz?");

        if (filas == null || columnas == null || filas <= 0 || columnas <= 0) {
            System.out.println("Operación cancelada: dimensiones inválidas.");
            return;
        }

        Ejercicio3 m = new Ejercicio3(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Integer valor = leerEntero("Elemento [" + i + "][" + j + "]:");
                if (valor == null) {
                    System.out.println("Captura cancelada.");
                    return;
                }
                m.setValor(i, j, valor);
            }
        }

        System.out.println("\nMatriz ingresada:");
        m.mostrar();


        if (!m.esCuadrada()) {
            System.out.println("\nADVERTENCIA: la matriz de " + filas + "x" + columnas
                    + " no es cuadrada. Operación cancelada.");
            return;
        }

        if (m.esIdentidad()) {
            System.out.println("\nLa matriz SÍ es una matriz identidad.");
        } else {
            System.out.println("\nLa matriz NO es una matriz identidad.");
        }


        System.out.println("Suma de la diagonal principal: " + m.sumaDiagonal());
    }


    private static Integer leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return null;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero.");
            }
        }
    }
}

//Ejercicio 4: Transpocicion dinamica de matriz(M x N->N x N)
package mx.edu.uttt.matrices;

public class Ejercicio4 {
    private int[][] datos;

    public Ejercicio4(int filas, int columnas) {
        datos = new int[filas][columnas];
    }

    public int getFilas() {
        return datos.length;
    }

    public int getColumnas() {
        return datos[0].length;
    }

    public void setValor(int i, int j, int valor) {
        if (i < 0 || i >= datos.length || j < 0 || j >= datos[0].length) {
            System.out.println("Posición fuera de rango.");
            return;
        }
        datos[i][j] = valor;
    }

    public Ejercicio4 obtenerTranspuesta() {
        Ejercicio4 transpuesta = new Ejercicio4(getColumnas(), getFilas());   // se invierten

        for (int i = 0; i < getFilas(); i++) {
            for (int j = 0; j < getColumnas(); j++) {
                transpuesta.datos[j][i] = this.datos[i][j];
            }
        }
        return transpuesta;
    }

    public void mostrar() {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                System.out.print(datos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
package mx.edu.uttt.menu;
import javax.swing.JOptionPane;
import mx.edu.uttt.matrices.Ejercicio4;

public class main4 {
    public static void main(String[] args) {
        Integer filas = leerEntero("¿Cuántas filas tiene la matriz?");
        Integer columnas = leerEntero("¿Cuántas columnas tiene la matriz?");

        if (filas == null || columnas == null || filas <= 0 || columnas <= 0) {
            System.out.println("Operación cancelada: dimensiones inválidas.");
            return;
        }

        Ejercicio4 original = new Ejercicio4(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Integer valor = leerEntero("Elemento [" + i + "][" + j + "]:");
                if (valor == null) {
                    System.out.println("Captura cancelada.");
                    return;
                }
                original.setValor(i, j, valor);
            }
        }

        System.out.println("\nMatriz original (" + filas + "x" + columnas + "):");
        original.mostrar();

        Ejercicio4 t = original.obtenerTranspuesta();
        System.out.println("\nMatriz transpuesta (" + t.getFilas() + "x" + t.getColumnas() + "):");
        t.mostrar();
    }

    private static Integer leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return null;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero.");
            }
        }
    }
}


//Ejercicio 5: Rotacin de la matriz a 90° en sentido orario, N x N.
package mx.edu.uttt.matrices;

public class Ejercicio5 {
    private int[][] datos;

    public Ejercicio5(int filas, int columnas) {
        datos = new int[filas][columnas];
    }

    public void setValor(int i, int j, int valor) {
        if (i < 0 || i >= datos.length || j < 0 || j >= datos[0].length) {
            System.out.println("Posición fuera de rango.");
            return;
        }
        datos[i][j] = valor;
    }

    public boolean esCuadrada() {
        return datos.length == datos[0].length;
    }
    public Ejercicio5 rotarHorario() {
        if (!esCuadrada()) {
            System.out.println("ADVERTENCIA: solo se puede rotar una matriz cuadrada.");
            return null;
        }

        int n = datos.length;
        Ejercicio5 rotada = new Ejercicio5(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotada.datos[j][n - 1 - i] = this.datos[i][j];
            }
        }
        return rotada;
    }

    public void mostrar() {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                System.out.print(datos[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
package mx.edu.uttt.menu;

import mx.edu.uttt.matrices.Ejercicio5;
import javax.swing.JOptionPane;

public class main5 {
    public static void main(String[] args) {
        Integer filas = leerEntero("¿Cuántas filas tiene la matriz?");
        Integer columnas = leerEntero("¿Cuántas columnas tiene la matriz?");

        if (filas == null || columnas == null || filas <= 0 || columnas <= 0) {
            System.out.println("Operación cancelada: dimensiones inválidas.");
            return;
        }

        Ejercicio5 m = new Ejercicio5(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Integer valor = leerEntero("Elemento [" + i + "][" + j + "]:");
                if (valor == null) {
                    System.out.println("Captura cancelada.");
                    return;
                }
                m.setValor(i, j, valor);
            }
        }

        System.out.println("\nMatriz original:");
        m.mostrar();

        Ejercicio5 rotada = m.rotarHorario();
        if (rotada == null) {
            System.out.println("Operación cancelada.");
            return;
        }

        System.out.println("\nMatriz rotada 90° a la derecha:");
        rotada.mostrar();
    }

    private static Integer leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return null;
            }
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero.");
            }
        }
    }
}

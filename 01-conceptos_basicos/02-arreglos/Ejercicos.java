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

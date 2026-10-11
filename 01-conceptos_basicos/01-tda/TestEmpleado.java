package mx.edu.uttt.tda;

import javax.swing.*;

public class TestEmpleado {
    private static Empleado empl;
    public static void main() {
        iniciar();
    }

    public static void iniciar() {
        String numeroNomina=solicitarTexto("Numero nomina ");
        String nombre =solicitarTexto("Nombre completo");
        empl=new Empleado(numeroNomina,nombre, "Masculino",34000.56,true);


    }

    public static String solicitarTexto(String valor){
        return JOptionPane.showInputDialog("Introduce el texto "+ valor);
    }

    public static void imprimir (){
        String salida ="Datos del Empleado: "+ empl.toString()+"Numero de objetos creados"+
                Empleado.getContarObjetos;
        JOptionPane.showMessageDialog(null,salida);
    }


}

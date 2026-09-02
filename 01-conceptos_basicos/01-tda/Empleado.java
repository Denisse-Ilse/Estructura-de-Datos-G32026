package mx.edu.uttt.tda;

public class Empleado {
    //variable de instancias
    private String numeroNomina;
    private String sexo;
    private double sueldo;
    private boolean activo;
    private static int contarObjetos;
    private static String nombre;

    //cinstructor sobrecargado
    public Empleado() {
    }

    public Empleado(String numeroNomina, String sexo, double sueldo, boolean activo,String nombre) {
        this.numeroNomina = numeroNomina;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.activo = activo;
        this.nombre =nombre;
    }

    public String getNumeroNomina() {
        return numeroNomina;
    }

    public void setNumeroNomina(String numeroNomina) {
        this.numeroNomina = numeroNomina;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getContarObjetos(){
        return Empleado.contarObjetos;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Empleado.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numeroNomina='" + numeroNomina + '\'' +
                ", sexo='" + sexo + '\'' +
                ", sueldo=" + sueldo +
                ", activo=" + (activo?"Activo":"Inactivo") +
                '}';
    }
}

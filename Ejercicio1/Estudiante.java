package Ejercicio1;

public class Estudiante {
    private String nombre;
    private float promedio;
    private String codigo;

    public Estudiante(String nombre, float promedio, String codigo) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public float getPromedio() {
        return promedio;
    }
    public String getCodigo() {
        return codigo;
    }
    

}

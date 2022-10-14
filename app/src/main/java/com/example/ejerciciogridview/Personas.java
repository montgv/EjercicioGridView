package com.example.ejerciciogridview;

//Definimos la clase Personas
public class Personas {
    //Declaramos los diferentes atributos que tiene esta clase
    private String nombre;
    private String apellidos;
    private String sexo;
    private String ciclo;

    //Declaramos un constructor personas con los diferentes atributos
    public Personas(String nombre, String apellidos, String sexo, String ciclo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciclo = ciclo;
    }

    //Declaramos los getter y los setter de los diferentes atributos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
}

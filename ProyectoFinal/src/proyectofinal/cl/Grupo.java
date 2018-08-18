package proyectofinal.cl;

import java.util.ArrayList;

public class Grupo {

    private int codigo;
    private String nombre;
    private ArrayList<Equipo> equipos;
    private int mundial;

    public Grupo() {
    }

    public Grupo(int codigo, String nombre, ArrayList<Equipo> equipos, int mundial) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.equipos = equipos;
        this.mundial = mundial;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public int getMundial() {
        return mundial;
    }

    public void setMundial(int mundial) {
        this.mundial = mundial;
    }

    @Override
    public String toString() {
        return "Grupo{" + "codigo=" + codigo + ", nombre=" + nombre + ", equipos=" + equipos + ", mundial=" + mundial + '}';
    }

}

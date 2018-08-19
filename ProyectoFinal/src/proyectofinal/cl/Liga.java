package proyectofinal.cl;

import java.time.LocalDate;
import java.util.ArrayList;

public class Liga {

    private int id;
    private String nombre;
    private ArrayList<Usuario> participantes;
    private LocalDate fechaCreacion;
    private Mundial mundial;
    private Boolean estado;
    private String tipo;

    public Liga() {
    }

    public Liga(int id, String nombre, ArrayList<Usuario> participantes, LocalDate fechaCreacion, Mundial mundial, Boolean estado, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.participantes = participantes;
        this.fechaCreacion = fechaCreacion;
        this.mundial = mundial;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Liga(int id, String nombre, LocalDate fechaCreacion, Mundial mundial, Boolean estado, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.mundial = mundial;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Liga(int id, String nombre, LocalDate fechaCreacion, Boolean estado, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Mundial getMundial() {
        return mundial;
    }

    public int getIdMundial() {
        return mundial.getId();
    }

    public void setMundial(Mundial mundial) {
        this.mundial = mundial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Liga{" + "id=" + id + ", nombre=" + nombre + ", participantes=" + participantes + ", fechaCreacion=" + fechaCreacion + ", mundial=" + mundial + ", estado=" + estado + ", tipo=" + tipo + '}';
    }

    public String toStringList() {
        return id + "," + nombre + "," + fechaCreacion + "," + mundial.getId() + "," + estado + "," + tipo;
    }
}

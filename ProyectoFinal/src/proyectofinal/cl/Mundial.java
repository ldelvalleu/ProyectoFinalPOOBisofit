package proyectofinal.cl;

import java.util.ArrayList;

public class Mundial {

    private int id;
    private int anno;
    private String paisOrganizador;
    private Boolean estado;
    private ArrayList<Grupo> grupos;

    public Mundial() {
    }

    public Mundial(int id, int anno, String paisOrganizador, Boolean estado, ArrayList<Grupo> grupos) {
        this.id = id;
        this.anno = anno;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
        this.grupos = grupos;
    }

    public Mundial(int id, int anno, String paisOrganizador, Boolean estado) {
        this.id = id;
        this.anno = anno;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }

    public void setPaisOrganizador(String paisOrganizador) {
        this.paisOrganizador = paisOrganizador;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "Mundial{" + "id=" + id + ", anno=" + anno + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + ", grupos=" + grupos + '}';
    }
    
     public String toStringList() {
        return id + "," + anno + "," + paisOrganizador + "," + estado;
    }
}

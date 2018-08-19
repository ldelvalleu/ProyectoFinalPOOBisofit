package proyectofinal.cl;

import java.util.ArrayList;

public class Cronograma {

    private String partido1;
    private String partido2;
    private String partido3;
    private String partido4;
    private String partido5;
    private String partido6;
    private int codigoGrupo;

    public Cronograma() {
    }

    public Cronograma(ArrayList<Equipo> equipos) {
        partido1 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo();

        partido2 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo();

        partido3 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();

        partido4 = equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo()
                + "," + equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo();

        partido5 = equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();

        partido6 = equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();
    }

    public String getPartido1() {
        return partido1;
    }

    public String getPartido2() {
        return partido2;
    }

    public String getPartido3() {
        return partido3;
    }

    public String getPartido4() {
        return partido4;
    }

    public String getPartido5() {
        return partido5;
    }

    public String getPartido6() {
        return partido6;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    @Override
    public String toString() {
        return partido1 + ":" + partido2 + ":" + partido3 + ":" + partido4 + ":" + partido5 + ":" + partido6;
    }
    
}

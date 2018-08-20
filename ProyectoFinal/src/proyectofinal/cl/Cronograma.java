package proyectofinal.cl;

import java.util.ArrayList;
import java.util.Random;

public class Cronograma {

    private String partido1;
    private String partido2;
    private String partido3;
    private String partido4;
    private String partido5;
    private String partido6;
    private int codigoGrupo;
    private String resultado1;
    private String resultado2;
    private String resultado3;
    private String resultado4;
    private String resultado5;
    private String resultado6;

    public Cronograma() {
    }

    public Cronograma(ArrayList<Equipo> equipos) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        int r1 = rand1.nextInt((5 - 0) + 1) + 0;
        int r2 = rand2.nextInt((5 - 0) + 1) + 0;

        partido1 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo();
        resultado1 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado1 = resultado1 + "," + equipos.get(0).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(1).getNombrePais();
        }
        if (r1 < r2) {
            resultado1 = resultado1 + "," + equipos.get(1).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(1).getNombrePais();
        }
        if (r1 == r2) {
            resultado1 = resultado1 + "," + "Empate"
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(1).getNombrePais();
        }

        rand1 = new Random();
        rand2 = new Random();
        r1 = rand1.nextInt((5 - 0) + 1) + 0;
        r2 = rand2.nextInt((5 - 0) + 1) + 0;
        partido2 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo();
        resultado2 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado2 = resultado2 + "," + equipos.get(0).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }
        if (r1 < r2) {
            resultado2 = resultado2 + "," + equipos.get(2).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }
        if (r1 == r2) {
            resultado2 = resultado2 + "," + "Empate"
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }

        rand1 = new Random();
        rand2 = new Random();
        r1 = rand1.nextInt((5 - 0) + 1) + 0;
        r2 = rand2.nextInt((5 - 0) + 1) + 0;
        partido3 = equipos.get(0).getNombrePais()
                + "," + equipos.get(0).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();
        resultado3 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado3 = resultado3 + "," + equipos.get(0).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 < r2) {
            resultado3 = resultado3 + "," + equipos.get(3).getCodigo()
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 == r2) {
            resultado3 = resultado3 + "," + "Empate"
                    + "," + equipos.get(0).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }

        rand1 = new Random();
        rand2 = new Random();
        r1 = rand1.nextInt((5 - 0) + 1) + 0;
        r2 = rand2.nextInt((5 - 0) + 1) + 0;
        partido4 = equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo()
                + "," + equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo();
        resultado4 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado4 = resultado4 + "," + equipos.get(1).getCodigo()
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }
        if (r1 < r2) {
            resultado4 = resultado4 + "," + equipos.get(2).getCodigo()
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }
        if (r1 == r2) {
            resultado4 = resultado4 + "," + "Empate"
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(2).getNombrePais();
        }

        rand1 = new Random();
        rand2 = new Random();
        r1 = rand1.nextInt((5 - 0) + 1) + 0;
        r2 = rand2.nextInt((5 - 0) + 1) + 0;
        partido5 = equipos.get(1).getNombrePais()
                + "," + equipos.get(1).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();
        resultado5 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado5 = resultado5 + "," + equipos.get(1).getCodigo()
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 < r2) {
            resultado5 = resultado5 + "," + equipos.get(3).getCodigo()
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 == r2) {
            resultado5 = resultado5 + "," + "Empate"
                    + "," + equipos.get(1).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }

        rand1 = new Random();
        rand2 = new Random();
        r1 = rand1.nextInt((5 - 0) + 1) + 0;
        r2 = rand2.nextInt((5 - 0) + 1) + 0;
        partido6 = equipos.get(2).getNombrePais()
                + "," + equipos.get(2).getCodigo()
                + "," + equipos.get(3).getNombrePais()
                + "," + equipos.get(3).getCodigo();
        resultado6 = "" + r1 + "," + r2;
        if (r1 > r2) {
            resultado6 = resultado6 + "," + equipos.get(2).getCodigo()
                    + "," + equipos.get(2).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 < r2) {
            resultado6 = resultado6 + "," + equipos.get(3).getCodigo()
                    + "," + equipos.get(2).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
        if (r1 == r2) {
            resultado6 = resultado6 + "," + "Empate"
                    + "," + equipos.get(2).getNombrePais()
                    + "," + equipos.get(3).getNombrePais();
        }
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

    public String getResultado1() {
        return resultado1;
    }

    public String getResultado2() {
        return resultado2;
    }

    public String getResultado3() {
        return resultado3;
    }

    public String getResultado4() {
        return resultado4;
    }

    public String getResultado5() {
        return resultado5;
    }

    public String getResultado6() {
        return resultado6;
    }

    public String getResultado(int numRes) {
        String resp = "";
        switch (numRes) {
            case 1:
                resp = resultado1;
                break;
            case 2:
                resp = resultado2;
                break;
            case 3:
                resp = resultado3;
                break;
            case 4:
                resp = resultado4;
                break;
            case 5:
                resp = resultado5;
                break;
            case 6:
                resp = resultado6;
                break;
        }
        return resp;
    }

    @Override
    public String toString() {
        return partido1 + ":" + partido2 + ":" + partido3 + ":" + partido4 + ":" + partido5 + ":" + partido6;
    }

}

package proyectofinalui.gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import proyectofinal.cl.Liga;
import proyectofinal.dao.DaoLiga;

public class GestorLiga {

    public ArrayList<Object> registrarLiga(String nombre, LocalDate fechaCreacion, int mundial, Boolean estado, String tipo) throws Exception {
        int cont = 0;
        ArrayList<Object> resp = new ArrayList<>();
        int id = listarLigas().size() + 1;

        for (Liga ligaTemp : listarLigasIn()) {
            if (ligaTemp.getId() == id) {
                cont++;
            }
        }
        if (cont == 0) {
            Liga miLiga = new Liga(id, nombre, fechaCreacion, (new GestorMundial().buscarMundialIn(mundial)), estado, tipo);
            new DaoLiga().registrarLiga(miLiga);
            resp.add(true);
            resp.add(id);
        }
        return resp;
    }

    public void actualizarLiga(int id, String nombre, LocalDate fechaCreacion, int mundial, Boolean estado, String tipo) throws Exception {
        Liga miLiga = new Liga(id, nombre, fechaCreacion, (new GestorMundial().buscarMundialIn(mundial)), estado, tipo);
        new DaoLiga().actualizarLiga(miLiga);
    }

    public void borrarLiga(int id) throws Exception {
        new DaoLiga().borrarLiga(id);
    }

    public String buscarLiga(int id) throws Exception {
        Liga miLiga = new DaoLiga().buscarLiga(id);
        String resp = miLiga.toString();
        return resp;
    }

    public Liga buscarLigaTipo(String tipo) throws Exception {
        return new DaoLiga().buscarLigaTipo(tipo);

    }

    public Liga buscarLigaIn(int id) throws Exception {
        return new DaoLiga().buscarLiga(id);
    }

    public ArrayList<String> listarLigas() throws Exception {
        ArrayList<String> ligaesString = new ArrayList<>();
        for (Liga miLiga : (new DaoLiga()).listarLigas()) {
            ligaesString.add(miLiga.toStringList());
        }
        return ligaesString;
    }

    public ArrayList<Liga> listarLigasIn() throws Exception {
        ArrayList<Liga> ligaestemp = new ArrayList<>();
        for (Liga miLiga : (new DaoLiga()).listarLigas()) {
            ligaestemp.add(miLiga);
        }
        return ligaestemp;
    }

    public ArrayList<String> listarLigasUsr() throws Exception {
        ArrayList<String> ligaesString = new ArrayList<>();
        for (Liga miLiga : (new DaoLiga()).listarLigas()) {
            ligaesString.add(miLiga.toStringList());
        }
        return ligaesString;
    }
}

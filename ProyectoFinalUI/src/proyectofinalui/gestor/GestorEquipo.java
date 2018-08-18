package proyectofinalui.gestor;

import java.util.ArrayList;
import proyectofinal.cl.Equipo;
import proyectofinal.dao.DaoEquipo;

public class GestorEquipo {

    public GestorEquipo() {
    }

    public Boolean registrarEquipo(int codigo, String nombrePais, int rankingFifa, String bandera) throws Exception {
        int cont = 0;
        Boolean resp = false;
        for (Equipo equipoTemp : listarEquiposIn()) {
            if (equipoTemp.getCodigo() == codigo) {
                cont++;
            }
        }
        if (cont == 0) {
            Equipo miEquipo = new Equipo(codigo, nombrePais, rankingFifa, bandera, 0);
            new DaoEquipo().registrarEquipo(miEquipo);
            resp = true;
        }
        return resp;
    }

    public void actualizarEquipo(int codigo, String nombrePais, int rankingFifa, String bandera) throws Exception {
        Equipo miEquipo = new Equipo(codigo, nombrePais, rankingFifa, bandera, 0);
        new DaoEquipo().actualizarEquipo(miEquipo);
    }

    public void borrarEquipo(int codigo) throws Exception {
        new DaoEquipo().borrarEquipo(codigo);
    }

    public String buscarEquipo(int codigo) throws Exception {
        Equipo miEquipo = new DaoEquipo().buscarEquipo(codigo);
        String resp = miEquipo.toString();
        return resp;
    }

    public ArrayList<String> listarEquipos() throws Exception {
        ArrayList<String> equiposString = new ArrayList<>();
        for (Equipo miEquipo : (new DaoEquipo()).listarEquipos()) {
            equiposString.add(miEquipo.toString());
        }
        return equiposString;
    }

    public ArrayList<Equipo> listarEquiposIn() throws Exception {
        ArrayList<Equipo> equipostemp = new ArrayList<>();
        for (Equipo miEquipo : (new DaoEquipo()).listarEquipos()) {
            equipostemp.add(miEquipo);
        }
        return equipostemp;
    }
}

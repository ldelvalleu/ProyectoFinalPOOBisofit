package proyectofinalui.gestor;

import java.util.ArrayList;
import proyectofinal.cl.Grupo;
import proyectofinal.dao.DaoGrupo;

public class GestorGrupo {
    public Boolean registrarGrupo(int codigo, String nombre, int mundial) throws Exception, NumberFormatException {
        int cont = 0;
        Boolean resp = false;
        for (Grupo grupoTemp : listarGruposIn()) {
            if (grupoTemp.getCodigo() == codigo) {
                cont++;
            }
        }
        if (cont == 0) {
            Grupo miGrupo = new Grupo(codigo, nombre, mundial);
            new DaoGrupo().registrarGrupo(miGrupo);
            resp = true;
        }
        return resp;
    }

    public void actualizarGrupo(int codigo, String nombre, int mundial) throws Exception, NumberFormatException {
        Grupo miGrupo = new Grupo(codigo, nombre, mundial);
        new DaoGrupo().actualizarGrupo(miGrupo);
    }

    public void borrarGrupo(int codigo) throws Exception {
        new DaoGrupo().borrarGrupo(codigo);
    }

    public String buscarGrupo(int codigo) throws Exception {
        Grupo miGrupo = new DaoGrupo().buscarGrupo(codigo);
        String resp = miGrupo.toString();
        return resp;
    }

    public Grupo buscarGrupoIn(int codigo) throws Exception {
        return new DaoGrupo().buscarGrupo(codigo);
    }

    public ArrayList<String> listarGrupos() throws Exception {
        ArrayList<String> gruposString = new ArrayList<>();
        for (Grupo miGrupo : (new DaoGrupo()).listarGrupos()) {
            gruposString.add(miGrupo.toStringList());
        }
        return gruposString;
    }

    public ArrayList<Grupo> listarGruposIn() throws Exception {
        ArrayList<Grupo> grupostemp = new ArrayList<>();
        for (Grupo miGrupo : (new DaoGrupo()).listarGrupos()) {
            grupostemp.add(miGrupo);
        }
        return grupostemp;
    }
}

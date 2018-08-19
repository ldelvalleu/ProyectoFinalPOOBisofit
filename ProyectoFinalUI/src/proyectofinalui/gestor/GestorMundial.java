package proyectofinalui.gestor;

import java.util.ArrayList;
import proyectofinal.cl.Grupo;
import proyectofinal.cl.Mundial;
import proyectofinal.dao.DaoGrupo;
import proyectofinal.dao.DaoMundial;

public class GestorMundial {

    public Boolean registrarMundial(int anno, String paisOrganizador, Boolean estado) throws Exception {
        int cont = 0;
        Boolean resp = false;
        int id = listarMundiales().size();

        for (Mundial mundialTemp : listarMundialesIn()) {
            if (mundialTemp.getId() == id) {
                cont++;
            }
        }
        if (cont == 0) {
            Mundial miMundial = new Mundial(id, anno, paisOrganizador, estado);
            new DaoMundial().registrarMundial(miMundial);
            resp = true;
        }
        return resp;
    }

    public void actualizarMundial(int id, int anno, String paisOrganizador, Boolean estado) throws Exception {
        Mundial miMundial = new Mundial(id, anno, paisOrganizador, estado);
        new DaoMundial().actualizarMundial(miMundial);
    }

    public void borrarMundial(int id) throws Exception {
        new DaoMundial().borrarMundial(id);
    }

    public String buscarMundial(int id) throws Exception {
        Mundial miMundial = new DaoMundial().buscarMundial(id);
        String resp = miMundial.toString();
        return resp;
    }

    public Mundial buscarMundialIn(int id) throws Exception {
        return new DaoMundial().buscarMundial(id);
    }

    public ArrayList<String> listarMundiales() throws Exception {
        ArrayList<String> mundialesString = new ArrayList<>();
        for (Mundial miMundial : (new DaoMundial()).listarMundiales()) {
            mundialesString.add(miMundial.toStringList());
        }
        return mundialesString;
    }

    public ArrayList<Mundial> listarMundialesIn() throws Exception {
        ArrayList<Mundial> mundialestemp = new ArrayList<>();
        for (Mundial miMundial : (new DaoMundial()).listarMundiales()) {
            mundialestemp.add(miMundial);
        }
        return mundialestemp;
    }
}

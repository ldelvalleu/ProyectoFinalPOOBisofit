package proyectofinal.dao;

import accesobd.Conector;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectofinal.cl.Grupo;
import proyectofinal.cl.Mundial;

public class DaoMundial {

    public ArrayList<Mundial> listarMundiales() throws SQLException, Exception {
        ArrayList<Mundial> mundiales = new ArrayList<>();
        Mundial mundial = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL("{call listWorldCups()}", true);
        while (rs.next()) {
            ArrayList<Grupo> gruposTemp = new ArrayList<>();
            for (Grupo miGrupo : new DaoGrupo().listarGrupos()) {
                if (miGrupo.getMundial() == rs.getInt("id")) {
                    gruposTemp.add(miGrupo);
                }
            }
            mundial = new Mundial(rs.getInt("id"), rs.getInt("anno"), rs.getString("paisorganizador"), rs.getBoolean("estado"), gruposTemp);
            mundiales.add(mundial);

        }
        rs.close();
        return mundiales;
    }

    public void registrarMundial(Mundial miMundial) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miMundial.getId());
        data.add(miMundial.getAnno());
        data.add(miMundial.getPaisOrganizador());
        data.add(miMundial.getEstado());

        new Conector().getConector().ejecutarSQL(data, "{call insertWorldCup(?,?,?,?)}");
    }

    public Mundial buscarMundial(int id) throws java.sql.SQLException, Exception {
        Mundial miMundial = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL(id, "{call searchWorldCup(?)}", true);
        if (rs.next()) {
            ArrayList<Grupo> gruposTemp = new ArrayList<>();
            for (Grupo miGrupo : new DaoGrupo().listarGrupos()) {
                if (miGrupo.getMundial() == rs.getInt("id")) {
                    gruposTemp.add(miGrupo);
                }
            }
            miMundial = new Mundial(rs.getInt("id"), rs.getInt("anno"), rs.getString("paisOrganizador"), rs.getBoolean("estado"), gruposTemp);
        }
        rs.close();
        return miMundial;
    }

    public void actualizarMundial(Mundial miMundial) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        ArrayList<Object> data = new ArrayList<>();
        data.add(miMundial.getId());
        data.add(miMundial.getAnno());
        data.add(miMundial.getPaisOrganizador());
        data.add(miMundial.getEstado());

        new Conector().getConector().ejecutarSQL(data, "{call updateWorldCup(?,?,?,?)}");
    }

    public void borrarMundial(int id) throws java.sql.SQLException, Exception {
        new Conector().getConector().ejecutarSQL(id, "{call deleteWorldCup(?)}");
    }

    private Object DaoGrupo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

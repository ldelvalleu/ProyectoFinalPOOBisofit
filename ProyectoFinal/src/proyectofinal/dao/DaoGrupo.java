package proyectofinal.dao;

import accesobd.Conector;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectofinal.cl.Equipo;
import proyectofinal.cl.Grupo;

public class DaoGrupo {

    public ArrayList<Grupo> listarGrupos() throws SQLException, Exception {
        ArrayList<Grupo> grupos = new ArrayList<>();
        Grupo grupo = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL("{call listGroups()}", true);
        while (rs.next()) {
            ArrayList<Equipo> equiposTemp = new ArrayList<>();
            for (Equipo miEquipo : new DaoEquipo().listarEquipos()) {
                if (rs.getInt("codigo") == miEquipo.getGrupo()) {
                    equiposTemp.add(miEquipo);
                }
            }
            grupo = new Grupo(rs.getInt("codigo"), rs.getString("nombre"), equiposTemp, rs.getInt("idmundial"));
            grupos.add(grupo);
        }
        rs.close();
        return grupos;
    }

    public void registrarGrupo(Grupo miGrupo) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miGrupo.getCodigo());
        data.add(miGrupo.getNombre());
        data.add(miGrupo.getMundial());

        new Conector().getConector().ejecutarSQL(data, "{call insertGroup(?,?,?)}");
    }

    public Grupo buscarGrupo(int id) throws java.sql.SQLException, Exception {
        Grupo miGrupo = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL(id, "{call searchGroup(?)}", true);
        if (rs.next()) {
            ArrayList<Equipo> equiposTemp = new ArrayList<>();
            for (Equipo miEquipo : new DaoEquipo().listarEquipos()) {
                if (rs.getInt("codigo") == miEquipo.getGrupo()) {
                    equiposTemp.add(miEquipo);
                }
            }
            miGrupo = new Grupo(rs.getInt("codigo"), rs.getString("nombre"), equiposTemp, rs.getInt("idmundial"));
        }
        rs.close();
        return miGrupo;
    }

    public void actualizarGrupo(Grupo miGrupo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        ArrayList<Object> data = new ArrayList<>();
        data.add(miGrupo.getCodigo());
        data.add(miGrupo.getNombre());
        data.add(miGrupo.getMundial());

        new Conector().getConector().ejecutarSQL(data, "{call updateGroup(?,?,?)}");
    }

    public void borrarGrupo(int codigo) throws java.sql.SQLException, Exception {
        new Conector().getConector().ejecutarSQL(codigo, "{call deleteGroup(?)}");
    }
}

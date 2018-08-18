package proyectofinal.dao;

import accesobd.Conector;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectofinal.cl.Equipo;

public class DaoEquipo {

    public ArrayList<Equipo> listarEquipos() throws SQLException, Exception {
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo equipo = null;
        java.sql.ResultSet rs;

        rs = new Conector().getConector().ejecutarSQL("{call listTeams()}", true);
        while (rs.next()) {
            equipo = new Equipo(rs.getInt("codigo"), rs.getString("nombrePais"), rs.getInt("rankingFifa"),
                    rs.getString("bandera"),
                    rs.getInt("grupo"));
            equipos.add(equipo);
        }
        rs.close();
        return equipos;
    }

    public void registrarEquipo(Equipo miEquipo) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miEquipo.getCodigo());
        data.add(miEquipo.getNombrePais());
        data.add(miEquipo.getRankingFifa());
        data.add(miEquipo.getBandera());
        data.add(miEquipo.getGrupo());

        new Conector().getConector().ejecutarSQL(data, "{call insertTeam(?,?,?,?,?)}");
    }

    public Equipo buscarEquipo(int id) throws java.sql.SQLException, Exception {
        Equipo miEquipo = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL(id, "{call searchTeam(?)}", true);
        if (rs.next()) {
            miEquipo = new Equipo(rs.getInt("codigo"), rs.getString("nombrePais"), rs.getInt("rankingFifa"),
                    rs.getString("bandera"),
                    rs.getInt("grupo"));
        }
        rs.close();
        return miEquipo;
    }

    public void actualizarEquipo(Equipo miEquipo) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        ArrayList<Object> data = new ArrayList<>();
        data.add(miEquipo.getCodigo());
        data.add(miEquipo.getNombrePais());
        data.add(miEquipo.getRankingFifa());
        data.add(miEquipo.getBandera());
        data.add(miEquipo.getGrupo());
        new Conector().getConector().ejecutarSQL(data, "{call updateTeam(?,?,?,?,?)}");
    }

    public void borrarEquipo(int codigo) throws java.sql.SQLException, Exception {
        new Conector().getConector().ejecutarSQL(codigo, "{call deleteTeam(?)}");
    }
}

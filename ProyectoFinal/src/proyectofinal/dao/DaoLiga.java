package proyectofinal.dao;

import accesobd.Conector;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import proyectofinal.cl.Liga;
import proyectofinal.cl.Usuario;

public class DaoLiga {

    public ArrayList<Liga> listarLigas() throws SQLException, Exception {
        ArrayList<Liga> ligas = new ArrayList<>();
        Liga liga = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL("{call listLeagues()}", true);
        while (rs.next()) {
            ArrayList<Usuario> usuariosTemp = new ArrayList<>();
            for (Usuario tmpUsuario : new DaoUsuario().listarUsuarios()) {
                if (tmpUsuario.getLigaPublica() == rs.getInt("id") || tmpUsuario.getLigaPrivada() == rs.getInt("id")) {
                    usuariosTemp.add(tmpUsuario);
                }
            }
            liga = new Liga(rs.getInt("id"), rs.getString("nombre"), usuariosTemp, (rs.getDate("fechacreacion").toLocalDate()), new DaoMundial().buscarMundial(rs.getInt("codigoMundial")), rs.getBoolean("estado"), rs.getString("tipo"));
            ligas.add(liga);
        }
        rs.close();
        return ligas;
    }

    public void registrarLiga(Liga miLiga) throws Exception {
        ArrayList<Object> data = new ArrayList<>();
        data.add(miLiga.getId());
        data.add(miLiga.getNombre());
        data.add(miLiga.getFechaCreacion());
        data.add(miLiga.getMundial().getId());
        data.add(miLiga.getEstado());
        data.add(miLiga.getTipo());

        new Conector().getConector().ejecutarSQL(data, "{call insertLeague(?,?,?,?,?,?)}");
    }

    public Liga buscarLiga(int id) throws java.sql.SQLException, Exception {
        Liga miLiga = null;
        java.sql.ResultSet rs;
        rs = new Conector().getConector().ejecutarSQL(id, "{call searchLeague(?)}", true);
        if (rs.next()) {
            ArrayList<Usuario> usuariosTemp = new ArrayList<>();
            for (Usuario tmpUsuario : new DaoUsuario().listarUsuarios()) {
                if (tmpUsuario.getLigaPublica() == rs.getInt("id") || tmpUsuario.getLigaPrivada() == rs.getInt("id")) {
                    usuariosTemp.add(tmpUsuario);
                }
            }
            miLiga = new Liga(rs.getInt("id"), rs.getString("nombre"), usuariosTemp, (rs.getDate("fechacreacion").toLocalDate()), new DaoMundial().buscarMundial(rs.getInt("codigoMundial")), rs.getBoolean("estado"), rs.getString("tipo"));

        }
        rs.close();
        return miLiga;
    }

    public void actualizarLiga(Liga miLiga) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        ArrayList<Object> data = new ArrayList<>();
        data.add(miLiga.getId());
        data.add(miLiga.getNombre());
        data.add(miLiga.getFechaCreacion());
        data.add(miLiga.getMundial().getId());
        data.add(miLiga.getEstado());
        data.add(miLiga.getTipo());

        new Conector().getConector().ejecutarSQL(data, "{call updateLeague(?,?,?,?,?,?)}");
    }

    public void borrarLiga(int codigo) throws java.sql.SQLException, Exception {
        new Conector().getConector().ejecutarSQL(codigo, "{call deleteLeague(?)}");
    }
}

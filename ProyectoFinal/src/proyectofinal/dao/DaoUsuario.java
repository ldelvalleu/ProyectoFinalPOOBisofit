package proyectofinal.dao;

import accesobd.Conector;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectofinal.cl.Usuario;

public class DaoUsuario {

    public ArrayList<Usuario> listarUsuarios() throws SQLException, Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;
        java.sql.ResultSet rs;

        rs = (new Conector()).getConector().ejecutarSQL("{call listUsers()}", true);
        while (rs.next()) {
            usuario = new Usuario(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correoelectronico"),
                    rs.getString("avatar"),
                    rs.getString("nombreusuario"),
                    rs.getString("equipofavorito"),
                    rs.getString("contrasenna"),
                    rs.getInt("ligapublica"),
                    rs.getInt("ligaprivada")
            );
            usuarios.add(usuario);
        }
        rs.close();
        return usuarios;
    }

    public void registrarUsuario(Usuario miUsuario) throws Exception {
        ArrayList<Object> data = new ArrayList<>();

        data.add(miUsuario.getId());
        data.add(miUsuario.getNombre());
        data.add(miUsuario.getApellidos());
        data.add(miUsuario.getCorreoElectronico());
        data.add(miUsuario.getAvatar());
        data.add(miUsuario.getNombreUsuario());
        data.add(miUsuario.getEquipoFavorito());
        data.add(miUsuario.getContrasenna());
        data.add(miUsuario.getLigaPublica());
        data.add(miUsuario.getLigaPrivada());

        (new Conector()).getConector().ejecutarSQL(data, "{call insertUser(?,?,?,?,?,?,?,?,?,?)}");
    }

    public Usuario buscarUsuario(int id) throws java.sql.SQLException, Exception {
        Usuario miUsuario = null;
        java.sql.ResultSet rs;
        rs = (new Conector()).getConector().ejecutarSQL(id, "{call searchUser(?)}", true);
        if (rs.next()) {
            miUsuario = new Usuario(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correoelectronico"),
                    rs.getString("avatar"),
                    rs.getString("nombreusuario"),
                    rs.getString("equipofavorito"),
                    rs.getString("contrasenna"),
                    rs.getInt("ligapublica"),
                    rs.getInt("ligaprivada")
            );
        }
        rs.close();
        return miUsuario;
    }

    public Usuario buscarUsuario(String usr) throws java.sql.SQLException, Exception {
        Usuario miUsuario = null;
        java.sql.ResultSet rs;
        String dataS[];
        dataS = usr.split(",");

        rs = (new Conector()).getConector().ejecutarSQL(dataS[0], dataS[1], "{call `searchUserEmailPass`(?,?)}", true);
        if (rs.next()) {
            miUsuario = new Usuario(rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("correoelectronico"),
                    rs.getString("avatar"),
                    rs.getString("nombreusuario"),
                    rs.getString("equipofavorito"),
                    rs.getString("contrasenna"),
                    rs.getInt("ligapublica"),
                    rs.getInt("ligaprivada")
            );
        }
        rs.close();
        return miUsuario;
    }

    public void actualizarUsuario(Usuario miUsuario) throws java.sql.SQLException, Exception {
        java.sql.ResultSet rs;
        ArrayList<Object> data = new ArrayList<>();
        data.add(miUsuario.getId());
        data.add(miUsuario.getNombre());
        data.add(miUsuario.getApellidos());
        data.add(miUsuario.getCorreoElectronico());
        data.add(miUsuario.getAvatar());
        data.add(miUsuario.getNombreUsuario());
        data.add(miUsuario.getEquipoFavorito());
        data.add(miUsuario.getContrasenna());
        data.add(miUsuario.getLigaPublica());
        data.add(miUsuario.getLigaPrivada());

        (new Conector()).getConector().ejecutarSQL(data, "{call updateUser(?,?,?,?,?,?,?,?,?,?)}");

    }

    public void borrarUsuario(int id) throws java.sql.SQLException, Exception {
        (new Conector()).getConector().ejecutarSQL(id, "{call deleteUser(?)}");
    }
}

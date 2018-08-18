package proyectofinalui.gestor;

import java.util.ArrayList;
import proyectofinal.cl.Usuario;
import proyectofinal.dao.DaoUsuario;

public class GestorUsuario {

    public GestorUsuario() {
    }

    public Boolean registrarUsuario(String nombre, String apellidos, String correoElectronico, String avatar, String nombreUsuario, String equipoFavorito, String contrasenna) throws Exception {
        Boolean resp = false;
        int id = listarUsuarios().size() + 1;
        int cont = 0;
        for (Usuario usuarioTemp : listarUsuariosIn()) {
            if (usuarioTemp.getCorreoElectronico().equals(correoElectronico)) {
                cont++;
            }
        }
        if (cont == 0) {
            Usuario miUsuario = new Usuario(id, nombre, apellidos, correoElectronico, avatar, nombreUsuario, equipoFavorito, contrasenna);
            new DaoUsuario().registrarUsuario(miUsuario);
            resp = true;
        }
        return resp;
    }

    public void actualizarUsuario(int id, String nombre, String apellidos, String correoElectronico, String avatar, String nombreUsuario, String equipoFavorito, String contrasenna) throws Exception {
        Usuario miUsuario = new Usuario(id, nombre, apellidos, correoElectronico, avatar, nombreUsuario, equipoFavorito, contrasenna);
        new DaoUsuario().actualizarUsuario(miUsuario);
    }

    public void borrarUsuario(int id) throws Exception {
        new DaoUsuario().borrarUsuario(id);
    }

    public String buscarUsuario(int id) throws Exception {
        Usuario miUsuario = new DaoUsuario().buscarUsuario(id);
        String resp = miUsuario.toString();
        return resp;
    }

    public ArrayList<String> listarUsuarios() throws Exception {
        ArrayList<String> usuariosString = new ArrayList<>();
        for (Usuario miUsuario : (new DaoUsuario()).listarUsuarios()) {
            usuariosString.add(miUsuario.toString());
        }
        return usuariosString;
    }

    public ArrayList<Usuario> listarUsuariosIn() throws Exception {
        ArrayList<Usuario> usuariostemp = new ArrayList<>();
        for (Usuario miUsuario : (new DaoUsuario()).listarUsuarios()) {
            usuariostemp.add(miUsuario);
        }
        return usuariostemp;
    }

    public ArrayList<String> listarUsuariosLogin() throws Exception {
        ArrayList<String> usuariosString = new ArrayList<>();
        for (Usuario miUsuario : (new DaoUsuario()).listarUsuarios()) {
            usuariosString.add(miUsuario.getCorreoElectronico() + "," + miUsuario.getContrasenna() + "," + miUsuario.getId());
        }
        return usuariosString;
    }
}

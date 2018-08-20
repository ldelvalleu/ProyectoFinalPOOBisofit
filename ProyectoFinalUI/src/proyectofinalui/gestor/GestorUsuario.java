package proyectofinalui.gestor;

import java.util.ArrayList;
import proyectofinal.cl.Grupo;
import proyectofinal.cl.Usuario;
import proyectofinal.dao.DaoUsuario;

public class GestorUsuario {

    public GestorUsuario() {
    }

    public Boolean registrarUsuario(String nombre, String apellidos, String correoElectronico,
            String avatar, String nombreUsuario, String equipoFavorito, String contrasenna)
            throws Exception, IndexOutOfBoundsException {
        Boolean resp = false;
        int id = listarUsuarios().size();
        int cont = 0;
        for (Usuario usuarioTemp : listarUsuariosIn()) {
            if (usuarioTemp.getCorreoElectronico().equals(correoElectronico)) {
                cont++;
            }
        }
        if (cont == 0) {

            Usuario miUsuario = new Usuario(id, nombre, apellidos, correoElectronico, avatar,
                    nombreUsuario, equipoFavorito, contrasenna, 100);
            miUsuario.setLigaPublica(new GestorLiga().buscarLigaTipo("Publica").getId());
            new DaoUsuario().registrarUsuario(miUsuario);
            resp = true;
        }
        return resp;
    }

    public void actualizarUsuario(int id, String nombre, String apellidos, String correoElectronico,
            String avatar, String nombreUsuario, String equipoFavorito, String contrasenna)
            throws Exception, IndexOutOfBoundsException {
        Usuario miUsuario = new Usuario(id, nombre, apellidos, correoElectronico, avatar,
                nombreUsuario, equipoFavorito, contrasenna, buscarUsuarioIn(id).getPuntos());
        miUsuario.setLigaPublica(new GestorLiga().buscarLigaTipo("Publica").getId());
        if (buscarUsuarioIn(id).getLigaPrivada() != 0) {
            miUsuario.setLigaPrivada(new GestorLiga().buscarLigaTipo("Privada").getId());
        }
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

    public Usuario buscarUsuarioIn(int id) throws Exception {
        return new DaoUsuario().buscarUsuario(id);
    }

    public ArrayList<String> listarUsuarios() throws Exception {
        ArrayList<String> usuariosString = new ArrayList<>();
        for (Usuario miUsuario : (new DaoUsuario()).listarUsuarios()) {
            usuariosString.add(miUsuario.toStringList());
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

    public ArrayList<Object> iniciarSesion(String usr) throws Exception, IndexOutOfBoundsException {
        ArrayList<Object> resp = new ArrayList<>();
        for (Usuario usrTemp : listarUsuariosIn()) {
            String temp = usrTemp.getCorreoElectronico() + usrTemp.getContrasenna();
            if (temp.equals(usr)) {
                resp.add(true);
                resp.add(usrTemp.getId());
                if (usr.equals("admin@admin.comadmin12345")) {
                    resp.add(true);
                } else {
                    resp.add(false);

                }
            }
        }
        return resp;
    }

    public String getCronograma(int usr, int grupo) throws Exception {
        ArrayList<Grupo> grupos = new GestorMundial().buscarMundialIn(new GestorLiga().buscarLigaIn(buscarUsuarioIn(usr).getLigaPublica()).getIdMundial()).getGrupos();
        grupos.get(grupo).generarCronograma();
        return grupos.get(grupo).getCronograma();
    }

    public String getResultado(int usr, int partido, int grupo) throws Exception {
        ArrayList<Grupo> grupos = new GestorMundial().buscarMundialIn(new GestorLiga().
                buscarLigaIn(buscarUsuarioIn(usr).getLigaPublica())
                .getIdMundial()).getGrupos();
        grupos.get(grupo-1).generarCronograma();
        return grupos.get(grupo-1).getCronogramaIn().getResultado(partido);
    }

    public String getNombreEquipoPrediccion(int usr, int partido) throws Exception {
        ArrayList<Grupo> grupos = new GestorMundial().buscarMundialIn(new GestorLiga().buscarLigaIn(buscarUsuarioIn(usr).getLigaPublica()).getIdMundial()).getGrupos();
        return grupos.get(partido).getNombre();
    }

    public String getLigaPublica(int usr) throws Exception {
        return new GestorLiga().buscarLigaIn(buscarUsuarioIn(usr).getLigaPublica()).toStringList();
    }

    public String getLigaPrivada(int usr) throws Exception {
        return new GestorLiga().buscarLigaIn(buscarUsuarioIn(usr).getLigaPrivada()).toStringList();
    }

    public int revGrupo(int usr) throws Exception {
        return new GestorMundial().buscarMundialIn(new GestorLiga().buscarLigaIn(buscarUsuarioIn(usr).
                getLigaPublica()).getIdMundial()).getGrupos().size();
    }

    public void registrarLigaPrivadaAUsuario(int id, int ligaprivada) throws Exception,
            IndexOutOfBoundsException {
        new DaoUsuario().actualizarLigaUsuario(id, ligaprivada);
    }
    
    public void actualizarPuntosUsuario(int id, int puntos, Boolean operacion) throws Exception,
            IndexOutOfBoundsException {
        if(operacion){
            new DaoUsuario().actualizarPuntosUsuario(id, (buscarUsuarioIn(id).getPuntos() + puntos));
        }
        else{
            new DaoUsuario().actualizarPuntosUsuario(id, (buscarUsuarioIn(id).getPuntos() - puntos));
        }
        
    }
    
}

package proyectofinal.cl;

public class Usuario {

    int id;
    String nombre;
    String apellidos;
    String correoElectronico;
    String avatar;
    String nombreUsuario;
    String equipoFavorito;
    String contrasenna;
    int ligaPublica;
    int ligaPrivada;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, String correoElectronico, String avatar, String nombreUsuario, String equipoFavorito, String contrasenna, int ligaPublica, int ligaPrivada) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.avatar = avatar;
        this.nombreUsuario = nombreUsuario;
        this.equipoFavorito = equipoFavorito;
        this.contrasenna = contrasenna;
        this.ligaPublica = ligaPublica;
        this.ligaPrivada = ligaPrivada;
    }

    public Usuario(int id, String nombre, String apellidos, String correoElectronico, String avatar, String nombreUsuario, String equipoFavorito, String contrasenna) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.avatar = avatar;
        this.nombreUsuario = nombreUsuario;
        this.equipoFavorito = equipoFavorito;
        this.contrasenna = contrasenna;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEquipoFavorito() {
        return equipoFavorito;
    }

    public void setEquipoFavorito(String equipoFavorito) {
        this.equipoFavorito = equipoFavorito;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public int getLigaPublica() {
        return ligaPublica;
    }

    public void setLigaPublica(int ligaPublica) {
        this.ligaPublica = ligaPublica;
    }

    public int getLigaPrivada() {
        return ligaPrivada;
    }

    public void setLigaPrivada(int ligaPrivada) {
        this.ligaPrivada = ligaPrivada;
    }

    @Override
    public String toString() {
        return id+"," +nombre + "," + apellidos + "," + correoElectronico + "," + avatar + "," + nombreUsuario + "," + equipoFavorito + "," + contrasenna + "," + ligaPublica + "," + ligaPrivada;
    }
    
    public String toStringList() {
        return id+"," +nombre + "," + apellidos + "," + correoElectronico + "," + avatar + "," + nombreUsuario + "," + equipoFavorito + "," + ligaPublica + "," + ligaPrivada;
    }

}

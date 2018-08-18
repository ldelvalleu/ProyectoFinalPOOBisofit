package proyectofinal.cl;

public class Equipo {

    private int codigo;
    private String nombrePais;
    private int rankingFifa;
    private String bandera;
    private int grupo;

    public Equipo() {
    }

    public Equipo(int codigo, String nombrePais, int rankingFifa, String bandera, int grupo) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.rankingFifa = rankingFifa;
        this.bandera = bandera;
        this.grupo = grupo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public int getRankingFifa() {
        return rankingFifa;
    }

    public void setRankingFifa(int rankingFifa) {
        this.rankingFifa = rankingFifa;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "codigo=" + codigo + ", nombrePais=" + nombrePais + ", rankingFifa=" + rankingFifa + ", bandera=" + bandera + ", grupo=" + grupo + '}';
    }
}

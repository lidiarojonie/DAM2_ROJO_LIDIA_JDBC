package src.examen.rojo.lidia.beans;

public class DetalleSatelite {
    // ATRIBUTOS
    private int id;
    private int velocidadMaxima;
    private int combustible;
    private int diasVidaUtil;

    public DetalleSatelite(int id, int velocidadMaxima, int combustible, int diasVidaUtil) {
        this.id = id;
        this.velocidadMaxima = velocidadMaxima;
        this.combustible = combustible;
        this.diasVidaUtil = diasVidaUtil;
    }

    public DetalleSatelite(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    public int getCombustible() {
        return combustible;
    }
    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }
    public int getDiasVidaUtil() {
        return diasVidaUtil;
    }
    public void setDiasVidaUtil(int diasVidaUtil) {
        this.diasVidaUtil = diasVidaUtil;
    }

    @Override
    public String toString() {
        return "DetalleSatelite{" +
                "id=" + id +
                ", velocidadMaxima=" + velocidadMaxima +
                ", combustible=" + combustible +
                ", diasVidaUtil=" + diasVidaUtil +
                '}';
    }
}

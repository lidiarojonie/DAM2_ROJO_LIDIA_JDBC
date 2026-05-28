package src.examen.rojo.lidia.beans;

public class Satelite {
    // ATRIBUTOS
    private int id;
    private String nombre;
    private String orbita;
    private int peso;
    private double coste;
    private boolean activo;
    private Agencia agencia;
    private DetalleSatelite detalle;

    public Satelite(int id, String nombre, String orbita, int peso, double coste, boolean activo, Agencia agencia, DetalleSatelite detalle) {
        this.id = id;
        this.nombre = nombre;
        this.orbita = orbita;
        this.peso = peso;
        this.coste = coste;
        this.activo = activo;
        this.agencia = agencia;
        this.detalle = detalle;
    }

    public Satelite(){}

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
    public String getOrbita() {
        return orbita;
    }
    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public double getCoste() {
        return coste;
    }
    public void setCoste(double coste) {
        this.coste = coste;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public Agencia getAgencia() {
        return agencia;
    }
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    public DetalleSatelite getDetalle() {
        return detalle;
    }
    public void setDetalle(DetalleSatelite detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orbita='" + orbita + '\'' +
                ", peso=" + peso +
                ", coste=" + coste +
                ", activo=" + activo +
                ", agencia=" + agencia +
                ", detalle=" + detalle +
                '}';
    }
}

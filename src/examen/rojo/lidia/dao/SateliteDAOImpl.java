package src.examen.rojo.lidia.dao;

import src.examen.rojo.lidia.beans.Satelite;
import src.examen.rojo.lidia.beans.Agencia;
import src.examen.rojo.lidia.motores.MotorSQL;
import src.examen.rojo.lidia.motores.MotorFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SateliteDAOImpl
        extends AbstractDAO<Satelite> {
    private static final String SQL_FIND_DETALLE_SATELITE =
            "SELECT " +
                    "S.ID, " +
                    "S.NOMBRE, " +
                    "S.ORBITA, " +
                    "S.PESO, " +
                    "S.COSTE, " +
                    "S.ACTIVO, " +
                    "S.AGENCIA, " +

                    "D.ID DETALLE_ID, " +
                    "D.SINOPSIS, " +
                    "D.PRESUPUESTO, " +
                    "D.RECAUDACION, " +
                    "D.IDIOMA_ORIGINAL " +

                    "FROM SATELITES S " +

                    "INNER JOIN DETALLE_SATELITES D " +
                    "ON S.ID = D.SATELITE_ID " +

                    "WHERE P.ID = ? " +

                    "ORDER BY P.ID";

    private static final String SQL_FIND_ALL =
            "SELECT * " +
                    "FROM SATELITES " +
                    "ORDER BY id";

    private static final String SQL_FIND =
            "SELECT * " +
                    "FROM SATELITES " +
                    "WHERE id = ?";

    private static final String SQL_INSERT =
            "INSERT INTO SATELITES " +
                    "(" +
                    "nombre, " +
                    "orbita, " +
                    "peso, " +
                    "coste, " +
                    ") " +
                    "VALUES " +
                    "(" +
                    "?, ?, ?, ?" +
                    ")";

    private static final String SQL_UPDATE =
            "UPDATE satelites " +
                    "SET " +
                    "nombre = ?, " +
                    "orbita = ?, " +
                    "peso = ?, " +
                    "coste = ?, " +
                    "activo = ? " +
                    "WHERE id = ?";

    private static final String SQL_DELETE =
            "DELETE FROM satelites " +
                    "WHERE id = ?";

    private static final String SQL_FIND_BY_AGENCIA =
            "SELECT * " +
                    "FROM satelites " +
                    "WHERE agencia = ? " +
                    "ORDER BY nombre";


    public void check() {
        try {
             motorSQL.connect();
            if (motorSQL.conn != null &&
                    !motorSQL.conn.isClosed()) {
                System.out.println("CONEXION OK");
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    public SateliteDAOImpl(
            MotorSQL motorSQL) {
        super(motorSQL);
    }

    /*
     * =========================
     * CRUD
     * =========================
     */

    @Override
    public void add(Satelite satelite) {
        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);
            motorSQL.getPs().setString(1, satelite.getNombre());
            motorSQL.getPs().setString(2, satelite.getOrbita());
            motorSQL.getPs().setInt(3, satelite.getPeso());
            motorSQL.getPs().setDouble(4, satelite.getCoste());

            int rows = motorSQL.executeUpdate();
            System.out.println(
                    "INSERTADOS: " +
                            rows);

        }catch (Exception e){

            printError(e);

        }finally {

            motorSQL.close();
        }
    }

    @Override
    public void update(
            int id,
            Satelite satelite) {
        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);
            motorSQL.getPs().setString(
                    1,
                    satelite.getNombre());
            motorSQL.getPs().setString(
                    2,
                    satelite.getOrbita());
            motorSQL.getPs().setInt(
                    3,
                    satelite.getPeso());
            motorSQL.getPs().setDouble(
                    4,
                    satelite.getCoste());
            motorSQL.getPs().setBoolean(
                    5,
                    satelite.isActivo());
            motorSQL.getPs().setInt(
                    6,
                    id);
            int rows =
                    motorSQL.executeUpdate();
            System.out.println(
                    "ACTUALIZADOS: " +
                            rows);
        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }
    }

    @Override
    public void delete(int id) {

        try{

            motorSQL.connect();

            motorSQL.prepare(SQL_DELETE);

            motorSQL.getPs().setInt(
                    1,
                    id);

            int rows =
                    motorSQL.executeUpdate();

            System.out.println(
                    "BORRADOS: " +
                            rows);

        }catch (Exception e){

            printError(e);

        }finally {

            motorSQL.close();
        }
    }

    @Override
    public Pelicula find(int id) {

        Pelicula pelicula = null;

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(
                    1,
                    id);
            ResultSet rs =
                    motorSQL.executeQuery();
            if(rs.next()){

                pelicula =
                        mapPelicula(rs);
            }

        }catch (Exception e){

            printError(e);

        }finally {

            motorSQL.close();
        }

        return pelicula;
    }

    @Override
    public ArrayList<Pelicula> findAll() {

        ArrayList<Pelicula> peliculas =
                new ArrayList<>();

        try{

            motorSQL.connect();

            motorSQL.prepare(SQL_FIND_ALL);

            ResultSet rs =
                    motorSQL.executeQuery();

            while(rs.next()){

                peliculas.add(
                        mapPelicula(rs));
            }

        }catch (Exception e){

            printError(e);

        }finally {

            motorSQL.close();
        }

        return peliculas;
    }

    /*
     * =========================
     * CONSULTAS AVANZADAS
     * =========================
     */

    @Override
    public ArrayList<Pelicula> findByGenero(String genero) {

        ArrayList<Pelicula> peliculas =
                new ArrayList<>();

        try{

            motorSQL.connect();

            motorSQL.prepare(
                    SQL_FIND_BY_GENERO);

            motorSQL.getPs().setString(
                    1,
                    genero);

            ResultSet rs =
                    motorSQL.executeQuery();

            while(rs.next()){

                peliculas.add(
                        mapPelicula(rs));
            }

        }catch (Exception e){

            printError(e);

        }finally {

            motorSQL.close();
        }

        return peliculas;
    }

    @Override
    public ArrayList<Pelicula> findByDirector(String director) {

        ArrayList<Pelicula> peliculas =
                new ArrayList<>();
        try{
            motorSQL.connect();
            motorSQL.prepare(
                    SQL_FIND_BY_DIRECTOR);
            motorSQL.getPs().setString(
                    1,
                    director);
            ResultSet rs =
                    motorSQL.executeQuery();
            while(rs.next()){
                peliculas.add(
                        mapPelicula(rs));
            }
        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return peliculas;
    }

    @Override
    public Pelicula findDetallePeliculaByPelicula(int idPelicula) {
        Pelicula pelicula = new Pelicula();
        try{
            motorSQL.connect();
            motorSQL.prepare(
                    SQL_DETALLE_PELICULA);
            motorSQL.getPs().setInt(
                    1,
                    idPelicula);
            ResultSet rs =
                    motorSQL.executeQuery();
            if(rs.next()){
                    pelicula.setId(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setGenero(rs.getString(4));
                    pelicula.setAnyo(rs.getInt(5));
                    pelicula.setDuracion(rs.getInt(6));

                    pelicula.getDetallePelicula().
                            setId(rs.getInt(7));
                    pelicula.getDetallePelicula().
                            setText(rs.getString(8));

                    pelicula.getDetallePelicula().
                        setPresupuesto(rs.getLong(9));
                pelicula.getDetallePelicula().
                        setRecaudacion(rs.getLong(10));
                pelicula.getDetallePelicula().
                        setIdioma(rs.getString(11));
            }
        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }
        return pelicula;
    }

    /*
     * =========================
     * MAPPING
     * =========================
     */

    private Pelicula mapPelicula(
            ResultSet rs)
            throws Exception {

        Pelicula pelicula =
                new Pelicula();

        pelicula.setId(
                rs.getInt("id"));

        pelicula.setTitulo(
                rs.getString("titulo"));

        pelicula.setDirector(
                rs.getString("director"));

        pelicula.setGenero(
                rs.getString("genero"));

        pelicula.setAnyo(
                rs.getInt("anyo"));

        pelicula.setDuracion(
                rs.getInt("duracion"));

        return pelicula;
    }
public static void main(String[] args){
        PeliculaDAOImpl peliculaDAO =
                new PeliculaDAOImpl(MotorFactory.
                        create(MotorFactory.ORACLE));
}

}
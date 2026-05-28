package src.examen.rojo.lidia.dao;

import src.examen.rojo.lidia.beans.Satelite;
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

                    "D.ID, " +
                    "D.VELOCIDAD_MAXIMA, " +
                    "D.COMBUSTIBLE, " +
                    "D.DIAS_VIDA_UTIL " +

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
    public Satelite find(int id) {

        Satelite satelite = null;

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(
                    1,
                    id);
            ResultSet rs =
                    motorSQL.executeQuery();
            if(rs.next()){

                satelite =
                        mapSatelite(rs);
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return satelite;
    }

    @Override
    public ArrayList<Satelite> findAll() {

        ArrayList<Satelite> satelites =
                new ArrayList<>();

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);
            ResultSet rs =
                    motorSQL.executeQuery();

            while(rs.next()){

                satelites.add(
                        mapSatelite(rs));
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return satelites;
    }

    /*
     * =========================
     * CONSULTAS AVANZADAS
     * =========================
     */

    @Override
    public ArrayList<Satelite> findByAgencia(String agencia) {

        ArrayList<Satelite> peliculas =
                new ArrayList<>();

        try{
            motorSQL.connect();
            motorSQL.prepare(
                    SQL_FIND_BY_AGENCIA);

            motorSQL.getPs().setString(
                    1,
                    agencia);

            ResultSet rs =
                    motorSQL.executeQuery();

            while(rs.next()){

                peliculas.add(
                        mapSatelite(rs));
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }
        return peliculas;
    }

    @Override
    public Satelite findDetalleSatelite(int id) {
        Satelite satelite = new Satelite();
        try{
            motorSQL.connect();
            motorSQL.prepare(
                SQL_FIND_DETALLE_SATELITE);
            motorSQL.getPs().setInt(
                    1,
                    id);
            ResultSet rs =
                    motorSQL.executeQuery();
            if(rs.next()){
                    satelite.setId(rs.getInt(1));
                    satelite.setNombre(rs.getString(2));
                    satelite.setOrbita(rs.getString(3));
                    satelite.setPeso(rs.getInt(4));
                    satelite.setCoste(rs.getDouble(5));
                    satelite.setActivo(rs.getBoolean(6));

                    satelite.getDetalle().
                        setId(rs.getInt(7));
                    satelite.getDetalle().
                        setVelocidadMaxima(rs.getInt(8));
                    satelite.getDetalle().
                        setCombustible(rs.getInt(9));
                    satelite.getDetalle().
                        setDiasVidaUtil(rs.getInt(10));
            }
        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }
        return satelite;
    }

    /*
     * =========================
     * MAPPING
     * =========================
     */

    private Satelite mapSatelite(
            ResultSet rs)
            throws Exception {

        Satelite satelite =
                new Satelite();

        satelite.setId(
                rs.getInt("id"));

        satelite.setNombre(
                rs.getString("nombre"));

        satelite.setOrbita(
                rs.getString("orbita"));

        satelite.setPeso(
                rs.getInt("peso"));

        satelite.setCoste(
                rs.getInt("coste"));

        satelite.setActivo(
                rs.getBoolean("activo"));

        return satelite;
    }
public static void main(String[] args){
    SateliteDAOImpl sateliteDAO = new SateliteDAOImpl(MotorFactory.
                        create(MotorFactory.ORACLE));
}

}
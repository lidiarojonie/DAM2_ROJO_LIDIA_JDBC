package src.examen.rojo.lidia.dao;

import src.examen.rojo.lidia.beans.Agencia;
import src.examen.rojo.lidia.beans.Satelite;
import src.examen.rojo.lidia.motores.MotorSQL;
import src.examen.rojo.lidia.motores.MotorFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AgenciaDAOImpl
        extends AbstractDAO<Agencia> {

    private static final String SQL_FIND_ALL =
            "SELECT * " +
                    "FROM AGENCIAS " +
                    "ORDER BY id";

    private static final String SQL_FIND =
            "SELECT * " +
                    "FROM AGENCIAS " +
                    "WHERE id = ?";

    private static final String SQL_INSERT =
            "INSERT INTO AGENCIAS " +
                    "(" +
                    "nombre, " +
                    "pais " +
                    "fecha_fundacion " +
                    ") " +
                    "VALUES " +
                    "(" +
                    "?, ?, ?, ?" +
                    ")";

    private static final String SQL_UPDATE =
            "UPDATE AGENCIAS " +
                    "SET " +
                    "nombre = ?, " +
                    "pais = ? " +
                    "WHERE id = ?";

    private static final String SQL_DELETE =
            "DELETE FROM agencias " +
                    "WHERE id = ?";

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

    public AgenciaDAOImpl(
            MotorSQL motorSQL) {
        super(motorSQL);
    }

    /*
     * =========================
     * CRUD
     * =========================
     */

    @Override
    public void add(Agencia agencia) {
        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);
            motorSQL.getPs().setString(1, agencia.getNombre());
            motorSQL.getPs().setString(2, agencia.getPais());

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
            Agencia agencia) {
        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);
            motorSQL.getPs().setString(
                    1,
                    agencia.getNombre());
            motorSQL.getPs().setString(
                    2,
                    agencia.getPais());  
            motorSQL.getPs().setInt(
                    3,
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
    public Agencia find(int id) {

        Agencia agencia = null;

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(
                    1,
                    id);
            ResultSet rs =
                    motorSQL.executeQuery();
            if(rs.next()){
                agencia = mapAgencia(rs);
            }

        }catch (Exception e){
            printError(e);

        }finally {
            motorSQL.close();
        }
        return agencia;
    }

    @Override
    public ArrayList<Agencia> findAll() {

        ArrayList<Agencia> agencias = new ArrayList<>();

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);

            ResultSet rs = motorSQL.executeQuery();

            while(rs.next()){
                agencias.add(mapAgencia(rs));
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }
        return agencias;
    }

    /*
     * =========================
     * MAPPING
     * =========================
     */

    private Agencia mapAgencia(ResultSet rs)
        throws Exception {

            Agencia pelicula = new Agencia();

            pelicula.setId(rs.getInt("id"));
            pelicula.setNombre(rs.getString("nombre"));
            pelicula.setPais(rs.getString("pais"));

            return pelicula;
        }

    public static void main(String[] args){
        AgenciaDAOImpl agenciaDAO = new AgenciaDAOImpl(MotorFactory.create(MotorFactory.ORACLE));
    }



    
    @Override
    public ArrayList<Agencia> findByAgencia(String agencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAgencia'");
    }

    @Override
    public Satelite findDetalleSatelite(int idSatelite) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findDetalleSatelite'");
    }
}
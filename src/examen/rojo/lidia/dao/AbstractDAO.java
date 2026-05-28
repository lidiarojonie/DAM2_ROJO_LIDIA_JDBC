package src.examen.rojo.lidia.dao;

import java.util.ArrayList;

import src.examen.rojo.lidia.beans.Satelite;
import src.examen.rojo.lidia.motores.MotorSQL;

public abstract class AbstractDAO<T>
        implements DAO<T> {
    protected MotorSQL motorSQL;
    public AbstractDAO(MotorSQL motorSQL) {
        this.motorSQL = motorSQL;
    }
    protected void printError(Exception e){
        System.out.println(
                "[ERROR] " +
                        e.getMessage());
    }
   
    public abstract ArrayList<T> findByAgencia(String agencia);
    public abstract Satelite findDetalleSatelite(int idSatelite);
}
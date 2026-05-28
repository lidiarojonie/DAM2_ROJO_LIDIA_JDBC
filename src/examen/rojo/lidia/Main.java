package src.examen.rojo.lidia;

import java.util.ArrayList;

import src.examen.rojo.lidia.beans.Agencia;
import src.examen.rojo.lidia.dao.AgenciaDAOImpl;
import src.examen.rojo.lidia.dao.SateliteDAOImpl;
import src.examen.rojo.lidia.motores.MotorFactory;

public class Main {
    public static void main(String[] args) {
        AgenciaDAOImpl agenciaDAO = new AgenciaDAOImpl(MotorFactory.
                        create(
                                MotorFactory.POSTGRE));

        agenciaDAO.check();
        // Prueba Unitaria: ADD
        Agencia agencia = new Agencia();
        agencia.setNombre("JKS");
        agencia.setPais("España");
        agenciaDAO.add(agencia);
        // Fin Prueba Unitaria: ADD 
        
        // Prueba Unitaria: ELIMINAR
            agenciaDAO.delete(9);
        // Prueba Unitaria: FIN ELIMINAR
        // Fin Prueba Unitaria: ELIMINAR

        // Prueba Unitaria: FIND
        agenciaDAO.find(2);
        // Prueba Unitaria: FIND

        // Prueba Unitaria: UPDATE
        agenciaDAO.update(2, "Nasa2");
        // Prueba Unitaria: UPDATE
     
        
        SateliteDAOImpl sateliteDAO = new SateliteDAOImpl(MotorFactory.
        create(
                MotorFactory.POSTGRE));

        sateliteDAO.find(2);    
        
        ArrayList<Satelite> lstSatelite = sateliteDAO.findAll();
        for (Satelite satelite:lstSatelite
             ) {
            System.out.println(satelite.toString());
        }
    }
}

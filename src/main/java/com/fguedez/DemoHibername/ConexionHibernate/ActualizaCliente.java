package com.fguedez.DemoHibername.ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ActualizaCliente {
    public static void main(String[] args) {
        SessionFactory miFactory=new Configuration().
                                     configure("hibernate.cfg.xml").
                                     addAnnotatedClass(Cliente.class).
                                     buildSessionFactory();
        Session miSession=miFactory.openSession();
        try{
            int ClienteId=4;
            //Comenzar la trasacción
            miSession.beginTransaction();
         /*   Cliente miCliente=miSession.get(Cliente.class,ClienteId);
            miCliente.setNombre("Fran");*/
          //  miSession.createQuery("update Cliente set apellidos='Marin' where apellidos LIKE 'G%' ").executeUpdate();
            miSession.createQuery("delete Cliente  where direccion='Goya' ").executeUpdate();
            miSession.getTransaction().commit();
            System.out.println("Registro Eliminado Correctamente en BD");
            //Lectura de registros

            System.out.println("Terminado");
            miSession.close();
        }
        finally {
            miFactory.close();
        }


    }
}

package com.fguedez.DemoHibername.ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BorrarCliente {
    public static void main(String[] args) {
        SessionFactory miFactory=new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Cliente.class).
                addAnnotatedClass(DetalleCliente.class).
                buildSessionFactory();
        Session miSession=miFactory.openSession();
        try{

            //Comenzar la trasacción
            miSession.beginTransaction();
            Cliente elCliente=miSession.get(Cliente.class,5);
            if (elCliente!=null){
                System.out.println("Voy a eliminar el cliente "+elCliente.getNombre());
                miSession.delete(elCliente);
            }
            miSession.getTransaction().commit();

            if (elCliente!=null) System.out.println("Registro Eliminado Correctamente en BD");
            else System.out.println("No se encontró el cliente");
            System.out.println("Terminado");
            miSession.close();
        }
        finally {
            miFactory.close();
        }
    }
}

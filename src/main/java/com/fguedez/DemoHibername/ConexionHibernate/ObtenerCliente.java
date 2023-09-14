package com.fguedez.DemoHibername.ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ObtenerCliente {
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

            //Obtener DetalleCliente
            Cliente cliente=miSession.get(Cliente.class,4);
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getDetalleCliente().getWeb());
            miSession.getTransaction().commit();
            System.out.println("Terminado");
            miSession.close();

        }
        finally {
            miFactory.close();
        }
    }
}

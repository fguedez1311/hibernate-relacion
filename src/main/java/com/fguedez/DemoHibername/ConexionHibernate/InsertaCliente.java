package com.fguedez.DemoHibername.ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertaCliente {
    public static void main(String[] args) {
        SessionFactory miFactory=new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Cliente.class).
                addAnnotatedClass(DetalleCliente.class).
                buildSessionFactory();
        Session miSession=miFactory.openSession();
        try{
            Cliente cliente=new Cliente("Paco","Gomez","Calle princesa");
            DetalleCliente detalleCliente=new DetalleCliente("www.pildorasinformatica.es","3334555","Segundo cliente");
            cliente.setDetalleCliente(detalleCliente);
            //Comenzar la trasacción
            miSession.beginTransaction();
            //Esto guarda la información de las dos tablas relacionadas
            miSession.save(cliente);
            miSession.getTransaction().commit();
            System.out.println("Registro Insertado Correctamente en BD");
            System.out.println("Terminado");
            miSession.close();
        }
        finally {
            miFactory.close();
        }
    }
}

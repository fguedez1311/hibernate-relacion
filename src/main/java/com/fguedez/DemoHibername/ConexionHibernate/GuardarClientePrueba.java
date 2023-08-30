package com.fguedez.DemoHibername.ConexionHibernate;

import com.fguedez.DemoHibername.ConexionHibernate.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GuardarClientePrueba {
    public static void main(String[] args) {
        SessionFactory miFactory=new Configuration().
                                     configure("hibernate.cfg.xml").
                                     addAnnotatedClass(Cliente.class).
                                     buildSessionFactory();
        Session miSession=miFactory.openSession();
        try{
            Cliente cliente=new Cliente("Felipe","Guedez","El Saman");
            //Comenzar la trasacción
            miSession.beginTransaction();
            miSession.save(cliente);
            miSession.getTransaction().commit();
            System.out.println("Registro Insertado Correctamente en BD");
            //Lectura de registros
            miSession.beginTransaction();
            System.out.println("Lectura del registro con id: "+cliente.getId());
            Cliente clienteInsertado=miSession.get(Cliente.class,cliente.getId());
            System.out.printf("Registro: %s\n",clienteInsertado);
            miSession.getTransaction().commit();
            System.out.println("Terminado");
            miSession.close();
        }
        finally {
            miFactory.close();
        }


    }
}

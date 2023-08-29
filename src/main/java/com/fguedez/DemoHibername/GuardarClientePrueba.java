package com.fguedez.DemoHibername;

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
            Cliente cliente=new Cliente("Francisco","Guedez","Delfín Mendoza");
            //Comenzar la trasacción
            miSession.beginTransaction();
            miSession.save(cliente);
            miSession.getTransaction().commit();
            System.out.println("Registro Insertado Correctamente en BD");
            miSession.close();
        }
        finally {
            miFactory.close();
        }


    }
}

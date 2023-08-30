package com.fguedez.DemoHibername.ConexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ConsultaClientes {
    public static void main(String[] args) {
        SessionFactory miFactory=new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Cliente.class).
                buildSessionFactory();
        Session miSession=miFactory.openSession();
        try{
            //Comenzar Sesión
            miSession.beginTransaction();
            //Consulta de clientes
            List<Cliente> losClientes=miSession.createQuery("from Cliente").getResultList();
            //Mostrar los clientes

            imprimirClientesConsultados(losClientes);
            //dame los Guedez
            losClientes=miSession.createQuery("from Cliente cl where cl.apellidos='Guedez'").getResultList();
            //Mostrar los Guedez
            imprimirClientesConsultados(losClientes);
            //commit
            miSession.getTransaction().commit();
            System.out.println("Terminado");
            //Cerrar la session
            miSession.close();
        }
        finally {
            miFactory.close();
        }
    }

    private static void imprimirClientesConsultados(List<Cliente> losClientes) {
        for(Cliente unCliente: losClientes){
            System.out.println(unCliente);
        }
    }
}

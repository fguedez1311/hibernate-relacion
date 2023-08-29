package com.fguedez.DemoHibername;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class PruebasJDBC {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/pruebashibernate?useSSL=false";
		String usuario="root";
		String contra="admin";
		try{
			System.out.println("Intentando Conectar con la BD");
			Connection miConexion= DriverManager.getConnection(jdbcUrl,usuario,contra);
			System.out.println("Conexion exitosa");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}

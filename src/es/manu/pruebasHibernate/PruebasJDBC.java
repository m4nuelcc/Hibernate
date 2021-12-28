package es.manu.pruebasHibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/pruebasHibernate?useSSL=false";

		String usuario = "root";

		String contra = "root";

		try {

			System.out.println("Intentando conectar con la DDBB" + url);

			Connection miConexion = DriverManager.getConnection(url, usuario, contra);

			System.out.println("conexion exitosa");

		} catch (Exception e) {

			System.out.println("Error");
			e.printStackTrace();

		}

	}
}



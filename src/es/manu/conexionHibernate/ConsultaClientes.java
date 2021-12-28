package es.manu.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	public static void main(String[] args) {
		

		// 1 crear un objeto tipo sessionFactory para leer el archivo de configuracion

		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		
		// 2 crear el objeto de tipo Session
		
		Session miSesion=myFactory.openSession();
		
		//3 Comenzar Sesion
		
		miSesion.beginTransaction();
		
		//4 consulta de Clientes
		
		List <Clientes> elCliente = miSesion.createQuery("from Clientes").getResultList();
		
		//5 Mostar los clientes
		
		for (Clientes clientes: elCliente) {
			
			System.out.println(clientes);
		}

		
		try {
			
			
		}finally {
			
			
			miSesion.close();
			myFactory.close();
		}
	}

}

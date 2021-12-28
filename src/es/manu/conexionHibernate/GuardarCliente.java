package es.manu.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 crear un objeto tipo sessionFactory para leer el archivo de configuracion

		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		
		// 2 crear el objeto de tipo Session
		
		Session miSesion=myFactory.openSession();
		
		// 3 Crear el objeto tipo cliente comenzar la transacion guardar el objeto
		
		try {
			
			Clientes cliente1 = new Clientes("Renee", "Schmidt", "la Rivera");
			
			miSesion.beginTransaction();
			
			miSesion.save(cliente1);
			
			miSesion.getTransaction().commit();
			
			System.out.println(cliente1.toString());
			
			System.out.println("Registro insertado Correctamente");
			
		}finally {
			
			miSesion.close();
			myFactory.close();
		}
	}

}

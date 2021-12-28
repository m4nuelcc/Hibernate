package es.manu.conexionHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardarCliente {

	public static void main(String[] args) {

		// 1 crear un objeto tipo sessionFactory para leer el archivo de configuracion

		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class)
				.buildSessionFactory();
		
		// 2 crear el objeto de tipo Session
		
		Session miSesion=myFactory.openSession();
		
		// 3 Crear el objeto tipo cliente comenzar la transacion guardar el objeto
		
		try {
			
			Clientes cliente1 = new Clientes("Vannesa", "Cara", "Villa");
			
			miSesion.beginTransaction();
			
			miSesion.save(cliente1);
			
			miSesion.getTransaction().commit();
			
			System.out.println(cliente1.toString());
			
			System.out.println("Registro insertado Correctamente");
			
		//Lectura de registro
			
			miSesion.beginTransaction();
			
			System.out.println("Lectura del registro con Id: " +  cliente1.getId());
			
			Clientes clientesInsetado = miSesion.get(Clientes.class, cliente1.getId());
			
			System.out.println("Registro: " + clientesInsetado);
			
			miSesion.getTransaction().commit();
			
			System.out.println("Terminado");
			
		}finally {
			
			miSesion.close();
			myFactory.close();
		}
	}

}

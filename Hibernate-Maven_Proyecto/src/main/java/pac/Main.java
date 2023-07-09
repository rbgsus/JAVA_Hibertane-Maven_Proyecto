package pac;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		System.out.println("INICIO DEL PROGRAMA");

		Configuration configuration = new Configuration().configure();

		// Instancia de sessionFactory que es única
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		System.out.println("CONFIGURACIÓN REALIZADA");

		// Abro la transaccion y realizo los insert de los modulos

		Transaction tx = session.beginTransaction();
		Modulo m1 = new Modulo();
		m1.setNombre("Programacion B");
		m1.setCodigo("M03B");
		session.save(m1);
		Modulo m2 = new Modulo();
		m2.setNombre("Acceso a Datos");
		m2.setCodigo("M06");
		session.save(m2);
		Modulo m3 = new Modulo();
		m3.setNombre("Desarrollo de aplicaciones móviles");
		m3.setCodigo("M08");
		session.save(m3);
		Modulo m4 = new Modulo();
		m4.setNombre("Servicios y procesos");
		m4.setCodigo("M09");
		session.save(m4);

		// Realizo los insert del profesor con el constructor vacio
		Profesor p1 = new Profesor();
		p1.setNombre("Alvaro");
		p1.setSexo("Hombre");
		session.save(p1);
		
		// Realizo los insert de los alumnos un constructor que he creado si en id
		Alumno a1 = new Alumno("Juan", "Espaniola", 26, "Hombre");
		Set<Modulo> moduloa1 = new HashSet<Modulo>();
		moduloa1.add(m1);
		moduloa1.add(m2);
		moduloa1.add(m3);
		moduloa1.add(m4);
		a1.setModulos(moduloa1);
		session.save(a1);

		Alumno a2 = new Alumno("Pedro", "Andorrana", 21, "Hombre");
		Set<Modulo> moduloa2 = new HashSet<Modulo>();
		moduloa2.add(m1);
		moduloa2.add(m2);
		moduloa2.add(m4);
		a2.setModulos(moduloa2);
		session.save(a2);

		Alumno a3 = new Alumno("Marta", "Espaniola", 19, "Mujer");
		Set<Modulo> moduloa3 = new HashSet<Modulo>();
		moduloa3.add(m3);
		moduloa3.add(m4);
		a3.setModulos(moduloa3);
		session.save(a3);

		Alumno a4 = new Alumno("Carla", "Francesa", 35, "Mujer");
		Set<Modulo> moduloa4 = new HashSet<Modulo>();
		moduloa4.add(m2);
		moduloa4.add(m3);
		moduloa4.add(m4);
		a4.setModulos(moduloa4);
		session.save(a4);

		tx.commit();
		
		List<Alumno> alumnos = session.createQuery("From Alumno").list();
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno a =  alumnos.get(i);
			System.out.println("Insert into alumno, nombre: " + a.getNombre() + ", nacionalidad: " + a.getNacionalidad()
			+ ", edad " + a.getEdad() + ", sexo: " + a.getSexo() + ", modulos: " + a.getModulos().size());
		//	System.out.println(alumnos.get(i).toString());
		}
		
		List<Modulo> modulos = session.createQuery("From Modulo").list();
		for (int i = 0; i < modulos.size(); i++) {
			Modulo m = modulos.get(i);			
			System.out.println("Insert into modulo, nombre: " + m.getNombre() + ", codigo: " + m.getCodigo());	
		//	System.out.println(modulos.get(i).toString());
		}
		
		List<Profesor> profesores = session.createQuery("From Profesor").list();
		for (int i = 0; i < profesores.size(); i++) {
			Profesor p = profesores.get(i);
			System.out.println("Insert into profesor, nombre: " + p.getNombre() + ", sexo: " + p.getSexo());
		//	System.out.println(modulos.get(i).toString());
		}

		session.close();
		sessionFactory.close();

	}

}

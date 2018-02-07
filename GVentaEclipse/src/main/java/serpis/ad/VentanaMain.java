package serpis.ad;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import serpis.ad.clases.Categoria;
import serpis.ad.clases.Cliente;
import serpis.ad.clases.Pedido;



public class VentanaMain {

	
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) throws MySQLIntegrityConstraintViolationException {


		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.GVentaEclipse");
		ventaDao.init(entityManagerFactory);
		
		int opc=-1;
		do {
			opc=menu();
		} while (opc!=-1);
		//entityManagerFactory.close();
		

		// modify(23L);

		// remove (2L);
		
		

//		try {
//			int numero;
//			System.out.println("Dime una numero para la categoria ");
//			numero = scanner.nextInt();
//			newCategoria(numero);
//		} catch (MySQLIntegrityConstraintViolationException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Esa categoria ya existe ");
//
//		}
//
		ventaDao.showCategoria();
//
//		showArticulos();
//
//		showCliente();
//
//		showPedido();
//
//		showPedidolinea();
//
		//entityManagerFactory.close();
		
		//ventaDao.close();

	}

	private static int menu() throws MySQLIntegrityConstraintViolationException {
		System.out.println(" 1.Ver Articulo "
							+ "\n 2.Ver Categoria "
							+ "\n 3.Ver Cliente "
							+ "\n 4.Ver Pedido"
							+ "\n 5.Ver Pedido Linea"
							+ "\n 6.Nueva Articulo"
							+ "\n 7.Nueva Categoria"
							+ "\n 8.Nuevo Cliente"
							+ "\n 9.Nuevo Pedido"
							+ "\n 10.Nuevo PedidoLinea ");
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			ventaDao.showArticulos();
			return 1;
		case 2:
			ventaDao.showCategoria();
			return 1;
		case 3:
			ventaDao.showCliente();
			return 1;
		case 4:
			ventaDao.showPedido();
			return 1;
		case 5:
			ventaDao.showPedidolinea();
			return 1;
		case 6:
			//nuevo Articulo 
			newCategoria();
			return 1;
		case 7:
			newCategoria();
			return 1;
		case 8:
			newCliente();
			
			return 1;
		case 9:
			newPedido();
			//Nuevo pedido
			return 1;
		case 10:
			//Nuevo pedido lineaç
			return 1;
		
			
//		case -1:
//			ventaDao.newPedido();
//			return -1;

		default:
			return -1;
			
		
		}
		
	}
	

	private static void newCategoria() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			int numero;
			System.out.println("Dime una numero para la categoria ");
			numero = scanner.nextInt();
			ventaDao.newCategoria(numero);
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("Esa categoria ya existe ");

		}
		
	}
	
	private static void newPedido() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Lista de clientes");
			ventaDao.showCliente();
			System.out.println("--- Pedido nuevo ---");
			System.out.println("ID del cliente: ");
			String idcliente = scanner.next();
			ventaDao.newPedido(idcliente);
			
			
		} catch (Exception e) {
			System.out.println("El cliente que has introducido no existe");
		}
	}
	
//	public static void newCliente1(String nombre) throws MySQLIntegrityConstraintViolationException {
//	
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction hola= entityManager.getTransaction();
//		hola.begin();
//		System.out.println("aaa");
//		Cliente cliente = new Cliente();
//		System.out.println("bbb");
//		cliente.setNombre(nombre);
//		System.out.println("ccc");
//		entityManager.persist(cliente);
//		System.out.println("Creado cliente " + cliente);
////		entityManager.getTransaction().commit();
//		hola.commit();
//
//	}
//	
//	public static void nuevo_cliente(){
//		Scanner scanner = new Scanner(System.in);
//		String nombre;
//		System.out.println("Dime el nombre ");
//		nombre=scanner.nextLine();
//		
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//			
//		Cliente cliente = new Cliente(nombre);
//		//cliente.setNombre(nombre);
//		entityManager.persist(cliente);
//		
//		entityManager.getTransaction().commit();
//		
//			
//}
	public static void newCategoria(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando categoria nueva");
		Categoria categoria = new Categoria();
		categoria.setNombre("Categoria " + numero);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		System.out.println("Creada " + categoria);
		entityManager.getTransaction().commit();

	}
	
	public static void newCliente1(int numero) throws MySQLIntegrityConstraintViolationException {
		Cliente cliente = new Cliente();
		cliente.setNombre("Cliente " + numero);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		System.out.println("Creada " + cliente);
		entityManager.getTransaction().commit();

	}
	
	private static void newCliente() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			int numero;
			System.out.println("Dime una numero para el cliente ");
			numero = scanner.nextInt();
			newCliente1(numero);
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("Esa categoria ya existe ");

		}
		
	}
	
	
	
	
}

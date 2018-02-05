package serpis.ad;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

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
							+ "\n 6.Nuevo Pedido"
							+ "\n 7.Nueva Categoria"
							+ "\n 8.Nueva Pedido");
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
			//ventaDao.newPedido();
			return 1;
		case 7:
			newCategoria();
			return 1;
		case 8:
			System.out.println("Lista de clientes");
			ventaDao.showCliente();
			System.out.println();
			System.out.println("Vas a insertar un pedido");
			BigDecimal importe;
			String idcliente;
			System.out.println("Dime el id del cliente ");
			idcliente = scanner.next();
			System.out.println("Dime el importe del pedido ");
			importe = scanner.nextBigDecimal();
			insert_pedido(idcliente);
			
			
			
//			System.out.println("--- Pedido nuevo ---");
//			System.out.println("ID del cliente: ");
//			String idcliente = scanner.next();
//			insert_pedido( idcliente);
		
//		case -1:
//			ventaDao.newPedido();
//			return -1;

		default:
			return -1;
			
		
		}
		
	}
	
	
	protected static void insert_pedido ( String idcliente){
		// Insertamos pedido
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Pedido pedido = new Pedido();
		Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
		pedido.setCliente(cliente);
		Calendar calendar = Calendar.getInstance();
		pedido.setFecha(calendar);
//		BigDecimal importe = new BigDecimal(precio);
//		pedido.setImporte(importe);
		entityManager.persist(pedido);	
		entityManager.getTransaction().commit();
		
	}
	
//	public static void nuevo_pedido(String idcliente, BigDecimal importe){
//			
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			entityManager.getTransaction().begin();
//			Cliente cliente = entityManager.getReference(Cliente.class, Long.parseLong(idcliente));
//			
//			Pedido pedido = new Pedido();
//			pedido.setCliente(cliente);
//			
//			java.util.Date dat = Calendar.getInstance().getTime();
//			Date date = new Date(dat.getDate());
//			pedido.setFecha(date);
//			pedido.setImporte(importe);
//			entityManager.persist(pedido);
//			
//			entityManager.getTransaction().commit();		
//			//entityManager.close();
//				
//		}

	
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
	private static void newCliente() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			int numero;
			System.out.println("Dime una numero para el cliente ");
			numero = scanner.nextInt();
			ventaDao.newCategoria(numero);
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			System.out.println("Esa categoria ya existe ");

		}
		
	}
	
	
	
}

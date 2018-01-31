package serpis.ad;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;



public class VentanaMain {

	
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) throws MySQLIntegrityConstraintViolationException {


		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.GVentaEclipse");
		ventaDao.init(entityManagerFactory);
		
//		int opc=-1;
//		do {
//			opc=menu();
//		} while (opc!=-1);
//		entityManagerFactory.close();
//		

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
		
		ventaDao.close();

	}

//	private static int menu() throws MySQLIntegrityConstraintViolationException {
//		System.out.println("1.Ver Articulo "
//							+ "\n 2.Ver Categoria "
//							+ "\n 3.Ver Cliente "
//							+ "\n 4.Ver Pedido"
//							+ "\n 5.Ver Pedido Linea");
//		Scanner scanner = new Scanner(System.in);
//		int opcion = scanner.nextInt();
//		switch (opcion) {
//		case 1:
//			ventaDao.showArticulos();
//			return 1;
//		case 2:
//			ventaDao.showCategoria();
//			return 1;
//		case 3:
//			ventaDao.showCliente();
//			return 1;
//		case 4:
//			ventaDao.showPedido();
//			return 1;
//		case 5:
//			ventaDao.showPedidolinea();
//			return 1;
//		case 6:
//			newCategoria();
//			return 1;
//			
//		case -1:
//			ventaDao.newPedido();
//			return -1;
//
//		default:
//			return -1;
//			
//		
//		}
//		
//	}
//	
	
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

}

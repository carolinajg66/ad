package serpis.ad;

//import java.util.Date;
//import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

//import serpis.ad.ventaDao;

public class VentanaMain {

	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {

		//Scanner scanner = new Scanner(System.in);

		Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.GVentaEclipse");
		int opc=-1;
		do {
			opc=menu();
		} while (opc!=-1);
		
		

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
//		showCategoria();
//
//		showArticulos();
//
//		showCliente();
//
//		showPedido();
//
//		showPedidolinea();
//
//		entityManagerFactory.close();

	}

	private static int menu() {
		System.out.println("1.Ver Articulo "
							+ "\n 2.Ver Categoria "
							+ "\n 3.Ver Cliente "
							+ "\n 4.Ver Pedido"
							+ "\n 5.Ver Pedido Linea");
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

			return 1;
			
		case -1:
			return -1;

		default:
			return -1;
			
		
		}
		
	}
	// private static void showCategoria() {
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// List<Categoria> categorias = entityManager.createQuery("from Categoria order
	// by id", Categoria.class)
	// .getResultList();
	// System.out.println("-------------------------------------CATEGORIA-------------------------------------\n");
	// for (Categoria categoria : categorias)
	// System.out.println(categoria);
	//
	// entityManager.getTransaction().commit();
	// }
	//
	// private static void showArticulos() {
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// List<Articulo> Articulos = entityManager.createQuery("from Articulo order by
	// id", Articulo.class)
	// .getResultList();
	// System.out.println("\n-------------------------------------ARTICULO-------------------------------------
	// \n");
	// for (Articulo articulo : Articulos)
	// System.out.println(articulo);
	//
	// entityManager.getTransaction().commit();
	// }
	//
	// private static void showCliente() {
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// List<Cliente> Clientes = entityManager.createQuery("from Cliente order by
	// id", Cliente.class).getResultList();
	// System.out.println("\n-------------------------------------CLIENTE-------------------------------------\n");
	// for (Cliente cliente : Clientes)
	// System.out.println(cliente);
	//
	// entityManager.getTransaction().commit();
	// }
	//
	// private static void showPedido() {
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// List<Pedido> Pedidos = entityManager.createQuery("from Pedido order by id",
	// Pedido.class).getResultList();
	// System.out.println("\n-------------------------------------PEDIDO-------------------------------------\n");
	// for (Pedido pedido : Pedidos)
	// System.out.println(pedido);
	//
	// entityManager.getTransaction().commit();
	// }
	//
	// private static void showPedidolinea() {
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// List<Pedidolinea> Pedidolineas = entityManager.createQuery("from Pedidolinea
	// order by id", Pedidolinea.class)
	// .getResultList();
	// System.out
	// .println("\n-------------------------------------PEDIDO
	// LINEA-------------------------------------\n");
	// for (Pedidolinea pedidolinea : Pedidolineas)
	// System.out.println(pedidolinea);
	//
	// entityManager.getTransaction().commit();
	//
	//
	// }
	//
	// // private static void newCategoria() {
	// // System.out.println("creando categoria nueva");
	// // Categoria categoria= new Categoria();
	// // categoria.setNombre("nuevo " + new Date() );
	// // EntityManager entityManager = entityManagerFactory.createEntityManager();
	// // entityManager.getTransaction().begin();
	// // System.out.println("Creando "+ categoria);
	// // entityManager.persist(categoria);
	// // System.out.println("Creada "+ categoria );
	// // entityManager.getTransaction().commit();
	// // }
	//
	// private static void newCategoria(int numero) throws
	// MySQLIntegrityConstraintViolationException {
	// System.out.println("creando categoria nueva");
	// Categoria categoria = new Categoria();
	// categoria.setNombre("Categoria " + numero);
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// // System.out.println("Creando "+ categoria);
	// entityManager.persist(categoria);
	// System.out.println("Creada " + categoria);
	// entityManager.getTransaction().commit();
	//
	// }
	//

}

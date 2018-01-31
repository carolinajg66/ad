package serpis.ad;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import serpis.ad.clases.Articulo;
import serpis.ad.clases.Categoria;
import serpis.ad.clases.Cliente;
import serpis.ad.clases.Pedido;
import serpis.ad.clases.Pedidolinea;

public class ventaDao {
	
	private static EntityManagerFactory entityManagerFactory =
			Persistence.createEntityManagerFactory("serpis.ad.GVentaEclipse");
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void showCategoria() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Categoria> categorias = entityManager.createQuery("from Categoria order by id", Categoria.class)
				.getResultList();
		System.out.println("-------------------------------------CATEGORIA-------------------------------------\n");
		for (Categoria categoria : categorias)
			System.out.println(categoria);

		entityManager.getTransaction().commit();
	}

	public static void showArticulos() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Articulo> Articulos = entityManager.createQuery("from Articulo order by id", Articulo.class)
				.getResultList();
		System.out.println("\n-------------------------------------ARTICULO------------------------------------- \n");
		for (Articulo articulo : Articulos)
			System.out.println(articulo);

		entityManager.getTransaction().commit();
	}

	public static void showCliente() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Cliente> Clientes = entityManager.createQuery("from Cliente order by id", Cliente.class).getResultList();
		System.out.println("\n-------------------------------------CLIENTE-------------------------------------\n");
		for (Cliente cliente : Clientes)
			System.out.println(cliente);

		entityManager.getTransaction().commit();
	}

	public static void showPedido() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pedido> Pedidos = entityManager.createQuery("from Pedido order by id", Pedido.class).getResultList();
		System.out.println("\n-------------------------------------PEDIDO-------------------------------------\n");
		for (Pedido pedido : Pedidos)
			System.out.println(pedido);

		entityManager.getTransaction().commit();
	}

	public static void showPedidolinea() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pedidolinea> Pedidolineas = entityManager.createQuery("from Pedidolinea order by id", Pedidolinea.class)
				.getResultList();
		System.out
				.println("\n-------------------------------------PEDIDO LINEA-------------------------------------\n");
		for (Pedidolinea pedidolinea : Pedidolineas)
			System.out.println(pedidolinea);

		entityManager.getTransaction().commit();

		
	}

	// private static void newCategoria() {
	// System.out.println("creando categoria nueva");
	// Categoria categoria= new Categoria();
	// categoria.setNombre("nuevo " + new Date() );
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// System.out.println("Creando "+ categoria);
	// entityManager.persist(categoria);
	// System.out.println("Creada "+ categoria );
	// entityManager.getTransaction().commit();
	// }

	public static void newCategoria(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando categoria nueva");
		Categoria categoria = new Categoria();
		categoria.setNombre("Categoria " + numero);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// System.out.println("Creando "+ categoria);
		entityManager.persist(categoria);
		System.out.println("Creada " + categoria);
		entityManager.getTransaction().commit();

	}
	

	
	/*public static void newArticulo(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando Articulo nueva");
		Articulo Articulo = new Articulo();
		Articulo.setCategoria(categoria);
		Articulo.setNombre("Articulo " + numero);
		Articulo.setPrecio(precio);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// System.out.println("Creando "+ Articulo);
		entityManager.persist(Articulo);
		System.out.println("Creada " + Articulo);
		entityManager.getTransaction().commit();

	}*/
	public static void newCliente(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando Cliente nueva");
		Cliente Cliente = new Cliente();
		Cliente.setNombre("Cliente " + numero);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// System.out.println("Creando "+ Cliente);
		entityManager.persist(Cliente);
		System.out.println("Creada " + Cliente);
		entityManager.getTransaction().commit();

	}
	/*public static void newPedido(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando Pedido nueva");
		Pedido Pedido = new Pedido();
		Pedido.setNombre("Pedido " + String.valueOf(numero));
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// System.out.println("Creando "+ Pedido);
		entityManager.persist(Pedido);
		System.out.println("Creada " + Pedido);
		entityManager.getTransaction().commit();

	}*/
	
	public static void newPedido() throws MySQLIntegrityConstraintViolationException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Pedido pedido = new Pedido();
		Cliente cliente=entityManager.getReference(Cliente.class, 1L);
		pedido.setCliente(cliente);
		Pedidolinea pedidoLinea1= new Pedidolinea();
		//Ojo las dos sentencias siguiente mantienen sincronizada la asociación 
		//pedido.getPedidolineas().add(pedidoLinea1);
		//pedidoLinea1.setPedido(pedido);
		pedido.add(pedidoLinea1);
		Articulo articulo = entityManager.getReference(Articulo.class, 1L);
		pedidoLinea1.setArticulo(articulo);
		
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		for (Pedidolinea pedidolinea : pedido.getPedidolineas())
			System.out.println(pedidolinea);

	}
	
	
	/*
	public static void newPedidolinea(int numero) throws MySQLIntegrityConstraintViolationException {
		System.out.println("creando Pedidolinea nueva");
		Pedidolinea Pedidolinea = new Pedidolinea();
		Pedidolinea.setNombre("Pedidolinea " + numero);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// System.out.println("Creando "+ Pedidolinea);
		entityManager.persist(Pedidolinea);
		System.out.println("Creada " + Pedidolinea);
		entityManager.getTransaction().commit();

	}*/


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpis.ad;


import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import serpis.ad.clases.Articulo;


public class Pedidos {

	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
	Logger.getLogger("org.hibernate").setLevel(Level.OFF);
	entityManagerFactory=
			Persistence.createEntityManagerFactory("serpis.ad.GVenta");
        
      

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//                
//         Query query = entityManager.createQuery("from Articulo");
//           List<Articulo> articulos = query.getResultList();
//           for (Articulo  articulo : articulos) {
//           System.out.println(articulo.toString());
//        }
           
           
           
//	showAll();
	
//	modify(23L);
	
//	remove (2L);
	
//	newCategoria();
	
//	showAll();
	
//	entityManagerFactory.close();
		 
		
		
	}
        
        
//	private static void newPedido() {
//		System.out.println("creando pedido nuevo");
//		Pedidos pedidos= new Pedidos();
//		Pedidos.setNombre("nuevo " + new Date() );
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		System.out.println("Creando "+ categoria);
//		entityManager.persist(categoria);
//		System.out.println("Creada "+ categoria );
//		entityManager.getTransaction().commit();
//	}
//	private static void modify(long id) {
//		System.out.println("modificando categoría "+id);
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		//Categoria categoria = entityManager.find(Categoria.class, id);
//		Categoria categoria = new Categoria();
//		categoria.setId(id);
//		categoria.setNombre("modificado"+ new Date());
//		entityManager.persist(categoria);
//		entityManager.getTransaction().commit();
//	}
//	
//	private static void remove(long id) {
//		System.out.println("eliminando categoría "+id);
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		//Categoria categoria = entityManager.find(Categoria.class, id);
//		Categoria categoria = entityManager.getReference(Categoria.class, id);
//		//categoria.setId(id);
//		entityManager.remove(categoria);
//		entityManager.getTransaction().commit();
//	}
//	
//	private static void showAll () {
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		List<Pedidos> categorias= entityManager.
//				createQuery("from Categoria order by id", Pedidos.class).getResultList();
//		for (Pedidos categoria : categorias)
//			System.out.println(categoria);
//		
//		
//		entityManager.getTransaction().commit();
//	}

}


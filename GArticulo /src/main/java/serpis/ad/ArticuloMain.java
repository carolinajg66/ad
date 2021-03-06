package serpis.ad;

import java.sql.SQLException;

import java.util.Scanner;

import javax.net.ssl.ExtendedSSLSession;

import org.omg.CORBA.PUBLIC_MEMBER;

import serpis.ad.ArticuloDao;

public class ArticuloMain {

	
	public enum Option {Salir, Nuevo, Editar, Eliminar, Consultar, Listar};
	public enum State {Vacío, Medio, Lleno};
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException{
		
		//Articulo articulo = new Articulo();

			new Menu()
			.add("Salir", null)
			.add("Nuevo", () -> nuevo())
			.add("Editar", () -> modificar())
			.add("Eliminar", () -> eliminar())
			.add("Consular", () -> consultar())
			.add("Listar", () -> listar())
			.run();
		
				

		
//		Runnable runnable = () ->  nuevo();
//		runnable.run();
	
		
	
//		while (true) {
//			
//			Option option = ArticuloDao.scanOption();
//			
//			if(option == Option.Salir)
//				break;
//			else if (option == Option.Nuevo)
//				ArticuloDao.nuevo();
//				
//			else if (option == Option.Editar)
//				ArticuloDao.modificar();
//				
//			else if (option == Option.Eliminar)
//				ArticuloDao.borrar();
//				
//			else if (option == Option.Consultar)
//				ArticuloDao.consultar();
//				
//			else if (option == Option.Listar)
//				ArticuloDao.listar();
//				
//		
//				
//		}
		
	}

	private static void listar() {
		try {
			ArticuloDao.listar();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

	private static void consultar() {
		try {
			ArticuloDao.consultar();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
	}

	private static void eliminar() {
		try {
			ArticuloDao.borrar();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
	}

	private static void modificar()  {
		try {
			ArticuloDao.modificar();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
	}

	private static void nuevo()  {
		try {
			ArticuloDao.nuevo();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		
		
	}
		
	
		
	
//	public static Option scanOption() {
//		for (int index = 0; index < Option.values().length; index++)
//			System.out.printf("%s - %s\n", index, Option.values()[index]);
//		String options = String.format("^[0-%s]$", Option.values().length - 1);
//		while (true) {
//			System.out.println("Elige opción: ");
//			String line = scanner.nextLine();
//			if(line.matches(options))
//				return Option.values()[Integer.parseInt(line)];
//			System.out.println("OPción inválida. Vuelve a introducir");
//		}
//}
	
	
	
}

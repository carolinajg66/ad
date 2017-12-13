package serpis.ad;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import serpis.ad.ArticuloMain.Option;

import com.google.common.util.concurrent.Service.State;


public class ArticuloDao {
	
	private static Connection connection;
	private static Scanner scanner = new Scanner(System.in);
	
	public static Connection conecta() throws SQLException{
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/dbprueba", "root", "sistemas"
				);
		return connection;
	}

	public static long  scanId(String label) {
		while(true) {
			try {
				System.out.print(label);
				String line = scanner.nextLine();
				return Long.parseLong(line);
			} catch (NumberFormatException ex) {
				System.out.println("Debe ser un número. Introduce de nuevo");
			}
		}
	}
	
	public static Option scanOption() {
		for (int index = 0; index < Option.values().length; index++)
			System.out.printf("%s - %s\n", index, Option.values()[index]);
		String options = String.format("^[0-%s]$", Option.values().length - 1);
		while (true) {
			System.out.println("Elige opción: ");
			String line = scanner.nextLine();
			if(line.matches(options))
				return Option.values()[Integer.parseInt(line)];
			System.out.println("OPción inválida. Vuelve a introducir");
		}
	}
	
	public static State scanState() {
		for (int index = 0; index < State.values().length; index++)
			System.out.printf("%s - %s\n", index, State.values()[index]);
		String options = String.format("^[0-%s]$", State.values().length - 1);
		while (true) {
			System.out.println("Elige opción: ");
			String line = scanner.nextLine();
			if(line.matches(options))
				return State.values()[Integer.parseInt(line)];
			System.out.println("Opción inválida. Vuelve a introducir");
		}
	}
	
	public static <T extends Enum<T>> T scan(Class<T> enumType){
		T[] constants = enumType.getEnumConstants();
		for(int index = 0; index < constants.length; index++)
			System.out.printf("%s - %s\n", index, constants[index]);
		String options = String.format("^[0-%s]$", constants.length - 1);
		while (true) {
			System.out.println("Elige opción: ");
			String line = scanner.nextLine();
			if(line.matches(options))
				return constants[Integer.parseInt(line)];
			System.out.println("Opción inválida. Vuelve a introducir");
		}
		
	}
	
	public static void lectura() throws SQLException{
		Statement statement = conecta().createStatement();
	    ResultSet resultset = statement.executeQuery("select * from articulo");
	    System.out.println("ID \t Nombre \t Precio \t Categoría");
	    while (resultset.next() ) {
	        String id = resultset.getString("id");
	        String nombre = resultset.getString("nombre");
	        String precio = resultset.getString("precio");
	        String categoria = resultset.getString("categoria");
	        System.out.println(id + "\t" + nombre + "\t" + precio + "\t"+"\t" + categoria);
	    }   
	}
	
	public static void nuevo () throws SQLException {
		
	
		String sql= "insert into articulo (nombre,precio,categoria) " +
                "values (?,?,?)";
		Scanner scanner = new Scanner (System.in);
		PreparedStatement statement = conecta().prepareStatement(sql);
		
		System.out.println("Introduce el nombre: ");
		String nombre=scanner.nextLine();
		System.out.println("Introduce el precio");
		String precio=scanner.nextLine();
		System.out.println("Introduce el categoria");
		String categoria=scanner.nextLine();
		
		statement.setString(1,nombre);
		statement.setString(2,precio);
		statement.setString(3,categoria);
		
//		String sql= "insert into articulo (nombre,precio,categoria) " +
//                "values (\""+nombre +"\","+precio+","+categoria+")";
		
		statement.executeUpdate();
		
		//TODO implementar
	}


	public static void modificar () throws SQLException {
		
		String sql="update articulo set nombre=?,"
				+ "precio=?,categoria=? where id= ?";
		
		Scanner scanner = new Scanner (System.in);
		PreparedStatement statement = conecta().prepareStatement(sql);
		long id=scanId("Introduce el id que quieres modificar: ");
		System.out.println("Introduce el nombre: ");
		String nombre=scanner.nextLine();
		System.out.println("Introduce el precio");
		String precio=scanner.nextLine();
		//System.out.println("Introduce el categoria: ");
		String categoria=String.valueOf(categoria());
		

		statement.setString(1,nombre);
		statement.setString(2,precio);
		statement.setString(3,categoria);
		statement.setLong(4,id);

//		String sql="update articulo set nombre=\""+nombre+"\","
//				+ "precio="+precio+","+ 
//				"categoria="+categoria+
//				" where id="+String.valueOf(id);
			
		//statement.executeQuery(sql);
		
		statement.executeUpdate();
		
		

	}
	
	public static void consultar() throws SQLException {
		
		String sql= "select id, nombre, precio, categoria "
	    		+ "from articulo where id= ?";
		PreparedStatement statement = conecta().prepareStatement(sql);
		long id=scanId("Introduce el id de los datos que quieres consular: ");
	   
		statement.setLong(1, id);
		
		
		
		ResultSet rs = statement.executeQuery();
		while (rs.next() ) {
		//rs.next();
		String idd = rs.getString("id");
		String nombree=rs.getString("nombre");
		String precioo=rs.getString("precio");
		String categoriaa=rs.getString("categoria");
		
		 System.out.println("id= "+idd + "\n" +"nombre= "+ nombree + "\n" 
		 +"precio= "+ precioo + "\n"+"categoria= " + categoriaa);
		
			
		}
	}
		

	
	public static int categoria() throws SQLException {
		
		int retorno=-1;
		System.out.println("Introduce el categoria: ");
		String categoria=scanner.nextLine();
		Statement statement = conecta().createStatement();
		ResultSet resultset = statement.executeQuery("select * from categoria ");
		   while (resultset.next() ) {
		        String id = resultset.getString("id");
		        if (categoria.equals(id)) {
		        	retorno =  Integer.parseInt(id);
		       	
		        }
		    }   
		   if(retorno==-1) {
			   retorno=categoria();
		   }
		
		return retorno;
		
		
	}
	
	public static void listar() throws SQLException {
		
		String sql= "select id, nombre, precio, categoria "
	    		+ "from articulo ";
		PreparedStatement statement = conecta().prepareStatement(sql);
		

		ResultSet rs = statement.executeQuery();
		System.out.println(String.format("%10s%20s%10s%10s","Id","Nombre", "Precio","Categoria"));
		while (rs.next() ) {
		//rs.next();
		String idd = rs.getString("id");
		String nombree=rs.getString("nombre");
		String precioo=rs.getString("precio");
		String categoriaa=rs.getString("categoria");
		
		 System.out.println(String.format("%10s%20s%10s%10s",idd,nombree, precioo,categoriaa));
		
			
		}
		
		
		
	}
	
	
	public static void borrar() throws SQLException{
		
		String sql=("delete from articulo where id = ?");
		PreparedStatement statement = conecta().prepareStatement(sql);
		long id=scanId("Introduce el id que quieres borrar: ");
		sql=("delete from articulo where id = ?");
		
		statement.setLong(1, id);
		
		statement.executeUpdate();
}

	
	
	
	
	
	
	
}

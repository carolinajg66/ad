package serpis.ad;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PruebaMySql {

	public static void main(String[] args) throws SQLException {
		// TODO conectar...

			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/dbprueba","root","sistemas");

			
			
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from categoria" );
			
			while (resultSet.next()) {
//				int numColums=resultSet.getMetaData().getColumnCount();
//				for(int i=1;i<=numColums; i++) {
//					
//					System.out.println("Categoria"+ i +"=" +resultSet.getObject(i));
//				}
				
				String id=resultSet.getString("id");
				String nombre=resultSet.getString("nombre");
				
				System.out.println("Id: "+id +"  -Nombre: "+nombre);
				//System.out.println("Nombre "+nombre);
				
			}
			connection.close();
	}

}


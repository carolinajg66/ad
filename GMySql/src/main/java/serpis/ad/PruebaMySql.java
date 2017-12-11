package serpis.ad;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;



public class PruebaMySql {

	public static void main(String[] args) throws SQLException {
		// TODO conectar...

			Connection connection = DriverManager.getConnection
					("jdbc:mysql://localhost/dbprueba","root","sistemas");

			
			//PreparedStatement preparedStatement=connection.prepareStatement("");
			
		
			Statement statement= connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from categoria order by id " );
			
			while (resultSet.next()) {
				
//				int numColums=resultSet.getMetaData().getColumnCount();
//				for(int i=1;i<=numColums; i++) {
//					
//					System.out.println("Categoria"+ i +"=" +resultSet.getObject(i));
//				}
				
				String id=resultSet.getString("id");
				String nombre=resultSet.getString("nombre");
				
				System.out.println("Id: "+id +"  -Nombre: "+nombre);
				
//				Resolución Luis
//				System.out.printf("%5s % s\n", resultSet.getObject(1),resultSet.getObject(2));
//				resultSet.close();
			
				
			}
			connection.close();
	}

}


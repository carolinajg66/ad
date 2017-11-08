using System;
using Serpis.Ad;
using System.Data;

namespace CCategoria {
    
    public class CategoriaDao {

		public const string SelectAll = "select * from categoria order by id";

        public static Categoria Load(object id){
		
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "select * from categoria where id= @id";
			DbCommandHelper.AddParemeter(dbCommand, "id", id);
			IDataReader dataReader = dbCommand.ExecuteReader();
			dataReader.Read(); //TODO tratamiento de excepciones 
			string nombre = dataReader["nombre"].ToString();
			dataReader.Close();

            Categoria c = new Categoria();
            c.Id = Convert.ToInt64(id);
            c.Nombre = nombre;
            return c;
		}
 

        public static void Save (Categoria categoria){
			
            if (categoria.Id == 0) {

                insert(categoria);

            } else {
                
                update(categoria);
            }
		}

        private static void insert (Categoria categoria){
            
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
            DbCommandHelper.AddParemeter(dbCommand, "nombre", categoria.Nombre);
			dbCommand.ExecuteNonQuery();
        }

		private static void update(Categoria categoria) {
            
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "update categoria set nombre=@nombre where id= @id";
            DbCommandHelper.AddParemeter(dbCommand, "id", categoria.Id);
            DbCommandHelper.AddParemeter(dbCommand, "nombre", categoria.Nombre);
			dbCommand.ExecuteNonQuery();
		}
     
        public static void Delete(object id){
            
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "delete from categoria where id=@id";
			DbCommandHelper.AddParemeter(dbCommand, "id", id);
			dbCommand.ExecuteNonQuery();
		}
    }
}

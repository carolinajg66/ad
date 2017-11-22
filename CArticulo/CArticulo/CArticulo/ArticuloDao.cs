using System;
using Serpis.Ad;
using System.Data;

namespace CArticulo {
		public class ArticuloDao {

			public const string SelectAll = "select * from articulo order by id";

            public static Articulo Load(object id) {

				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "select * from articulo where id= @id";
				DbCommandHelper.AddParemeter(dbCommand, "id", id);
				IDataReader dataReader = dbCommand.ExecuteReader();
				dataReader.Read(); //TODO tratamiento de excepciones 
                string nombre = (string)dataReader["nombre"];
                decimal  precio =(decimal) dataReader["precio"];
                long categoria = dataReader["categoria"] is DBNull ?
                0 : (long)dataReader["categoria"];
				dataReader.Close();

				Articulo a = new Articulo();
				a.Id = Convert.ToInt64(id);
				a.Nombre = nombre;
                a.Precio = precio;
                a.Categoria =categoria ;
          
				return a;
			}


			public static void Save(Articulo articulo) {

				if (articulo.Id == 0) {

					insert(articulo);

				} else {

					update(articulo);
				}
			}

        private static void insert(Articulo articulo) {

				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "insert into articulo (nombre,precio,categoria) " +
                "values (@nombre, @precio, @categoria)";
                DbCommandHelper.AddParemeter(dbCommand, "nombre", articulo.Nombre);
                DbCommandHelper.AddParemeter(dbCommand, "precio", articulo.Precio);
			    DbCommandHelper.AddParemeter(dbCommand, "categoria",
                articulo.Categoria == 0 ? (object)null : articulo.Categoria);

    			//object categoria = articulo.Categoria;
    			//if (articulo.Categoria == 0)
    				//categoria = null;

				dbCommand.ExecuteNonQuery();
			}

        private static void update(Articulo articulo) {

				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "update articulo set nombre=@nombre," +
                "precio=@precio, categoria=@categoria where id= @id";
                DbCommandHelper.AddParemeter(dbCommand, "id", articulo.Id);
                DbCommandHelper.AddParemeter(dbCommand, "nombre", articulo.Nombre);
                DbCommandHelper.AddParemeter(dbCommand, "precio", articulo.Precio);
                DbCommandHelper.AddParemeter(dbCommand, "categoria", articulo.Categoria
                                            == 0 ? (object)null : articulo.Categoria);
				dbCommand.ExecuteNonQuery();
			}

			public static void Delete(object id) {

				IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
				dbCommand.CommandText = "delete from articulo where id=@id";
				DbCommandHelper.AddParemeter(dbCommand, "id", id);
				dbCommand.ExecuteNonQuery();
			}
		}
    }


using System;
using Gtk;
using Serpis.Ad;
using MySql.Data.MySqlClient;
using System.Data;
using CArticulo;

	public partial class MainWindow : Gtk.Window {
		
		public MainWindow() : base(Gtk.WindowType.Toplevel) {
			Build();

			Title = "Articulo";

			deleteAction.Sensitive = false;
			editAction.Sensitive = false;

			App.Instance.Connection = new MySqlConnection("server = localhost; database = dbprueba; user = root; password = sistemas");
			App.Instance.Connection.Open();


			TreeViewHelper.Fill(treeView, ArticuloDao.SelectAll);
        //(Select id, nombre, precio,c.nombre as categoria from articulo a left 
        //join categoria c o n a.categoria=c.id order by a.id);



			treeView.Selection.Changed += delegate {
				bool hasSelected = treeView.Selection.CountSelectedRows() > 0;
				deleteAction.Sensitive = hasSelected;
				editAction.Sensitive = hasSelected;


			};

			newAction.Activated += delegate {
                Articulo articulo = new Articulo();
                   new ArticuloWindow(articulo);

			};

			refreshAction.Activated += delegate {
				TreeViewHelper.Fill(treeView, "select * from articulo order by id");
			};

			deleteAction.Activated += delegate {

				if (WindowHelper.Confirm(this, "¿Quieres eliminar el registro?")) {
					object id = TreeViewHelper.getId(treeView);
                    ArticuloDao.Delete(id);
				}
			};

			editAction.Activated += delegate {

				object id = TreeViewHelper.getId(treeView);
                Articulo articulo = ArticuloDao.Load(id);
                new ArticuloWindow(articulo);
			};


		}

		private void fillListStore(ListStore listStore) {

			listStore.Clear();
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "select * from articulo order by id";
			IDataReader dataReader = dbCommand.ExecuteReader();
			while (dataReader.Read())
				listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
			dataReader.Close();


		}

		protected void OnDeleteEvent(object sender, DeleteEventArgs a) {
			App.Instance.Connection.Close();

			Application.Quit();
			a.RetVal = true;
		}

}
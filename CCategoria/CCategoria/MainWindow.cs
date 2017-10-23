using System;
using Gtk;
using Serpis.Ad;
using MySql.Data.MySqlClient;
using System.Data;

using CCategoria;


public partial class MainWindow : Gtk.Window {
    //private IDbConnection connection;
    public MainWindow() : base(Gtk.WindowType.Toplevel) {
        Build();

        Title = "Categoria";

        deleteAction.Sensitive = false;

        string connectionString = "server=localhost;database=dbprueba;user=root;password=sistemas";
        App.Instance.Connection = new MySqlConnection(connectionString);
        App.Instance.Connection.Open();


        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);
        ListStore listStore = new ListStore(typeof(string), typeof(string));
        treeView.Model = listStore;

        fillListStore(listStore);

        treeView.Selection.Changed += delegate {
            bool hasSelected = treeView.Selection.CountSelectedRows() > 0;
            deleteAction.Sensitive = hasSelected;

           /* if (treeView.Selection.CountSelectedRows() > 0)
                deleteAction.Sensitive = true;
            else
                deleteAction.Sensitive = false;*/

        };

        newAction.Activated += delegate {
            new CategoriaWindow();
        };

        refreshAction.Activated += delegate {
            listStore.Clear();
            fillListStore(listStore);
        };

        deleteAction.Activated += delegate {
           
            if (WindowHelper.Confirm(this, "¿Quieres eliminar el registro?")) {
				delete(listStore);
            }
        };


    }

    private void fillListStore(ListStore listStore) {

        IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
        dbCommand.CommandText = "select * from categoria order by id";
        IDataReader dataReader = dbCommand.ExecuteReader();
        while (dataReader.Read())
            listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
        dataReader.Close();


    }
    private object getId(){
		TreeIter treeIter;
		treeView.Selection.GetSelected(out treeIter);
        return treeView.Model.GetValue(treeIter, 0);

	}

    protected void delete(ListStore listStore){

        object id = getId();
		IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
		dbCommand.CommandText = "delete from categoria where id=@id";
		DbCommandHelper.AddParemeter(dbCommand, "id", id);
        dbCommand.ExecuteNonQuery();

    }

    protected void update(ListStore listStore){

		/*string nombre = entryNombre.Text;
		IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
		dbCommand.CommandText = "update from categoria set nombre=@nombre where id=@id";
		DbCommandHelper.AddParemeter(dbCommand, "nombre", nombre);
		dbCommand.ExecuteNonQuery();*/
	}





    protected void OnDeleteEvent(object sender, DeleteEventArgs a) {
        App.Instance.Connection.Close();

        Application.Quit();
        a.RetVal = true;
    }
}

using System;
using Gtk;
using MySql.Data.MySqlClient;
using System.Data;

using CCategoria;


public partial class MainWindow : Gtk.Window
{
    //private IDbConnection connection;
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

        string connectionString = "server=localhost;database=dbprueba;user=root;password=sistemas";
        App.Instance.Connection = new MySqlConnection(connectionString);
        App.Instance.Connection.Open();


        treeView.AppendColumn("id", new CellRendererText(), "text", 0);
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);
        ListStore listStore = new ListStore(typeof(string), typeof(string));
        treeView.Model = listStore;


        /*IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
        dbCommand.CommandText = "select * from categoria order by id";
        IDataReader dataReader = dbCommand.ExecuteReader();
        while (dataReader.Read())
            listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
        dataReader.Close();*/

        fillListStore(listStore);

        newAction.Activated += delegate
        {

            new CategoriaWindow();
        };

        refreshAction.Activated += delegate
        {
            listStore.Clear();
            /*dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "select * from categoria order by id";
			dataReader = dbCommand.ExecuteReader();
			while (dataReader.Read())
                
				listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
			dataReader.Close();*/
            fillListStore(listStore);

		};

    }

    private void fillListStore(ListStore listStore){

		IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
		dbCommand.CommandText = "select * from categoria order by id";
		IDataReader dataReader = dbCommand.ExecuteReader();
		while (dataReader.Read())
			listStore.AppendValues(dataReader["id"].ToString(), dataReader["nombre"]);
		dataReader.Close();


	}

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        App.Instance.Connection.Close();

        Application.Quit();
        a.RetVal = true;
    }
}

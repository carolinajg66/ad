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
        editAction.Sensitive = false;

        App.Instance.Connection = new MySqlConnection("server = localhost; database = dbprueba; user = root; password = sistemas");
        App.Instance.Connection.Open();


        TreeViewHelper.Fill(treeView, CategoriaDao.SelectAll);


        treeView.Selection.Changed += delegate {
            bool hasSelected = treeView.Selection.CountSelectedRows() > 0;
            deleteAction.Sensitive = hasSelected;
            editAction.Sensitive = hasSelected;

          

        };

        newAction.Activated += delegate {
            Categoria categoria = new Categoria();
			new CategoriaWindow(categoria);

        };

        refreshAction.Activated += delegate {
			TreeViewHelper.Fill(treeView, "select * from categoria order by id");
        };

        deleteAction.Activated += delegate {

			if (WindowHelper.Confirm(this, "¿Quieres eliminar el registro?")) {
				object id = TreeViewHelper.getId(treeView);
				CategoriaDao.Delete(id);
			}
        };

        editAction.Activated += delegate {

			object id = TreeViewHelper.getId(treeView);
            Categoria categoria = CategoriaDao.Load (id);
            new CategoriaWindow(categoria);
        };


    }

    private void fillListStore(ListStore listStore) {

        listStore.Clear();
        IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
        dbCommand.CommandText = "select * from categoria order by id";
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

using System;
using System.Data;
using Serpis.Ad;
namespace CCategoria {
    public partial class CategoriaWindow : Gtk.Window {

        object id;
        public CategoriaWindow(object id) : base(Gtk.WindowType.Toplevel) {
            this.Build();

            this.id = id;

            Categoria categoria = CategoriaDao.Load(id);
            entryNombre.Text = categoria.Nombre;

            saveAction.Activated += delegate {
                categoria.Nombre = entryNombre.Text;
                CategoriaDao.Save(categoria); 
                Destroy();
            };

        }

        public CategoriaWindow() : base(Gtk.WindowType.Toplevel) {
            this.Build();
            Categoria categoria = new Categoria();

            saveAction.Activated += delegate {
                categoria.Nombre = entryNombre.Text;
                CategoriaDao.Save(categoria);
                Destroy();
            };
        }
       // protected void insert() {
            //string nombre = entryNombre.Text;
            //IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
            //dbCommand.CommandText = "insert into categoria (nombre) values (@nombre)";
            //DbCommandHelper.AddParemeter(dbCommand, "nombre", nombre);
            //dbCommand.ExecuteNonQuery();

       // }
       // protected void update() {
            

            //string nombre = entryNombre.Text;
            //IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
            //dbCommand.CommandText = "update categoria set nombre=@nombre where id= @id";
            //DbCommandHelper.AddParemeter(dbCommand, "id", id);
            //DbCommandHelper.AddParemeter(dbCommand, "nombre", nombre);
            //dbCommand.ExecuteNonQuery();
        //}
    }
}
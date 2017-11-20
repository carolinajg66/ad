using System;
namespace CArticulo {
    public partial class ArticuloWindow : Gtk.Window {
        public ArticuloWindow(Articulo articulo ) :base(Gtk.WindowType.Toplevel) {
            this.Build();
            entryNombre.Text = articulo.Nombre;
            spinbutton1.Text = articulo.Precio.ToString();


            saveAction.Activated += delegate {
                articulo.Nombre = entryNombre.Text;
                articulo.Precio = Decimal.Parse(spinbutton1.Text);
                //articulo.Categoria = long.Parse(combobox1.ToString());
              
                ArticuloDao.Save(articulo);
                Destroy();
            };
        }
    }
}

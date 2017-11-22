using System;
using Serpis.Ad;
using Gtk;


namespace CArticulo {
    public partial class ArticuloWindow : Gtk.Window {
        public ArticuloWindow(Articulo articulo ) :base(Gtk.WindowType.Toplevel) {
            this.Build();
            entryNombre.Text = articulo.Nombre;
            spinbutton1.Text = articulo.Precio.ToString();
            ComboBoxHelper.Fill(ComboBoxC, "select id, nombre from categoria order by id", articulo.Categoria);
           

            saveAction.Activated += delegate {
                articulo.Nombre = entryNombre.Text;
                articulo.Precio = Decimal.Parse(spinbutton1.Text);
                articulo.Categoria = long.Parse(ComboBoxHelper.GetId(ComboBoxC).ToString());
				//articulo.Categoria = long.Parse(entryCategoria.Text);
              
                ArticuloDao.Save(articulo);
                Destroy();
            };
        }
    }
}

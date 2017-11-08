using System;
namespace CArticulo {
	public partial class ArticuloWindow : Gtk.Window {

		public CategoriaWindow(CArticulo articulo ) : base(Gtk.WindowType.Toplevel) {
			this.Build();

			entryNombre.Text = articulo.Nombre ?? "";

			saveAction.Activated += delegate {
                articulo.Nombre = entryNombre.Text;
                ArticuloDao.Save(articulo);
				Destroy();

			};


		}

	}
}


// This file has been generated by the GUI designer. Do not modify.
namespace CArticulo
{
	public partial class CategoriaWindow
	{
		private global::Gtk.UIManager UIManager;

		private global::Gtk.Action saveAction;

		private global::Gtk.VBox vbox2;

		private global::Gtk.Toolbar toolbar2;

		private global::Gtk.Table table1;

		private global::Gtk.Entry entry2;

		private global::Gtk.Entry entry3;

		private global::Gtk.Entry entryNombre;

		private global::Gtk.Label label1;

		private global::Gtk.Label label2;

		private global::Gtk.Label label3;

		protected virtual void Build()
		{
			global::Stetic.Gui.Initialize(this);
			// Widget CArticulo.CategoriaWindow
			this.UIManager = new global::Gtk.UIManager();
			global::Gtk.ActionGroup w1 = new global::Gtk.ActionGroup("Default");
			this.saveAction = new global::Gtk.Action("saveAction", null, null, "gtk-save");
			w1.Add(this.saveAction, null);
			this.UIManager.InsertActionGroup(w1, 0);
			this.AddAccelGroup(this.UIManager.AccelGroup);
			this.Name = "CArticulo.CategoriaWindow";
			this.Title = global::Mono.Unix.Catalog.GetString("CategoriaWindow");
			this.WindowPosition = ((global::Gtk.WindowPosition)(4));
			// Container child CArticulo.CategoriaWindow.Gtk.Container+ContainerChild
			this.vbox2 = new global::Gtk.VBox();
			this.vbox2.Name = "vbox2";
			this.vbox2.Spacing = 6;
			// Container child vbox2.Gtk.Box+BoxChild
			this.UIManager.AddUiFromString("<ui><toolbar name=\'toolbar2\'><toolitem name=\'saveAction\' action=\'saveAction\'/></t" +
					"oolbar></ui>");
			this.toolbar2 = ((global::Gtk.Toolbar)(this.UIManager.GetWidget("/toolbar2")));
			this.toolbar2.Name = "toolbar2";
			this.toolbar2.ShowArrow = false;
			this.vbox2.Add(this.toolbar2);
			global::Gtk.Box.BoxChild w2 = ((global::Gtk.Box.BoxChild)(this.vbox2[this.toolbar2]));
			w2.Position = 0;
			w2.Expand = false;
			w2.Fill = false;
			// Container child vbox2.Gtk.Box+BoxChild
			this.table1 = new global::Gtk.Table(((uint)(3)), ((uint)(3)), false);
			this.table1.Name = "table1";
			this.table1.RowSpacing = ((uint)(6));
			this.table1.ColumnSpacing = ((uint)(6));
			// Container child table1.Gtk.Table+TableChild
			this.entry2 = new global::Gtk.Entry();
			this.entry2.CanFocus = true;
			this.entry2.Name = "entry2";
			this.entry2.IsEditable = true;
			this.entry2.InvisibleChar = '•';
			this.table1.Add(this.entry2);
			global::Gtk.Table.TableChild w3 = ((global::Gtk.Table.TableChild)(this.table1[this.entry2]));
			w3.TopAttach = ((uint)(1));
			w3.BottomAttach = ((uint)(2));
			w3.LeftAttach = ((uint)(1));
			w3.RightAttach = ((uint)(2));
			w3.YOptions = ((global::Gtk.AttachOptions)(4));
			// Container child table1.Gtk.Table+TableChild
			this.entry3 = new global::Gtk.Entry();
			this.entry3.CanFocus = true;
			this.entry3.Name = "entry3";
			this.entry3.IsEditable = true;
			this.entry3.InvisibleChar = '•';
			this.table1.Add(this.entry3);
			global::Gtk.Table.TableChild w4 = ((global::Gtk.Table.TableChild)(this.table1[this.entry3]));
			w4.TopAttach = ((uint)(2));
			w4.BottomAttach = ((uint)(3));
			w4.LeftAttach = ((uint)(1));
			w4.RightAttach = ((uint)(2));
			w4.YOptions = ((global::Gtk.AttachOptions)(4));
			// Container child table1.Gtk.Table+TableChild
			this.entryNombre = new global::Gtk.Entry();
			this.entryNombre.CanFocus = true;
			this.entryNombre.Name = "entryNombre";
			this.entryNombre.IsEditable = true;
			this.entryNombre.InvisibleChar = '•';
			this.table1.Add(this.entryNombre);
			global::Gtk.Table.TableChild w5 = ((global::Gtk.Table.TableChild)(this.table1[this.entryNombre]));
			w5.LeftAttach = ((uint)(1));
			w5.RightAttach = ((uint)(2));
			w5.YOptions = ((global::Gtk.AttachOptions)(4));
			// Container child table1.Gtk.Table+TableChild
			this.label1 = new global::Gtk.Label();
			this.label1.Name = "label1";
			this.label1.LabelProp = global::Mono.Unix.Catalog.GetString("Nombre");
			this.table1.Add(this.label1);
			global::Gtk.Table.TableChild w6 = ((global::Gtk.Table.TableChild)(this.table1[this.label1]));
			w6.XOptions = ((global::Gtk.AttachOptions)(4));
			w6.YOptions = ((global::Gtk.AttachOptions)(4));
			// Container child table1.Gtk.Table+TableChild
			this.label2 = new global::Gtk.Label();
			this.label2.Name = "label2";
			this.label2.LabelProp = global::Mono.Unix.Catalog.GetString("Precio");
			this.table1.Add(this.label2);
			global::Gtk.Table.TableChild w7 = ((global::Gtk.Table.TableChild)(this.table1[this.label2]));
			w7.TopAttach = ((uint)(1));
			w7.BottomAttach = ((uint)(2));
			w7.XOptions = ((global::Gtk.AttachOptions)(4));
			w7.YOptions = ((global::Gtk.AttachOptions)(4));
			// Container child table1.Gtk.Table+TableChild
			this.label3 = new global::Gtk.Label();
			this.label3.Name = "label3";
			this.label3.LabelProp = global::Mono.Unix.Catalog.GetString("Categoria");
			this.table1.Add(this.label3);
			global::Gtk.Table.TableChild w8 = ((global::Gtk.Table.TableChild)(this.table1[this.label3]));
			w8.TopAttach = ((uint)(2));
			w8.BottomAttach = ((uint)(3));
			w8.XOptions = ((global::Gtk.AttachOptions)(4));
			w8.YOptions = ((global::Gtk.AttachOptions)(4));
			this.vbox2.Add(this.table1);
			global::Gtk.Box.BoxChild w9 = ((global::Gtk.Box.BoxChild)(this.vbox2[this.table1]));
			w9.Position = 1;
			w9.Expand = false;
			w9.Fill = false;
			this.Add(this.vbox2);
			if ((this.Child != null))
			{
				this.Child.ShowAll();
			}
			this.DefaultWidth = 400;
			this.DefaultHeight = 176;
			this.Show();
		}
	}
}

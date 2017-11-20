using System;
using Gtk;
using System.Data;

namespace Serpis.Ad {
    public class ComboBoxHelper {

        public const string NullLabel = "<sin asignar>";
        public static void Fill (ComboBox comboBox, String selectSql, object id){

			CellRendererText labelCellRendererText = new CellRendererText();
			comboBox.PackStart(labelCellRendererText, false);
			comboBox.AddAttribute(labelCellRendererText, "text", 1);

			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = selectSql;
			IDataReader dataReader = dbCommand.ExecuteReader();

			ListStore listStore = new ListStore(typeof(String), typeof(String));
			comboBox.Model = listStore;

            TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
			listStore.AppendValues("1", "cat 1");
			listStore.AppendValues("2", "cat 2");
			listStore.AppendValues("3", "cat 3");

			comboBox.SetActiveIter(treeIter);
        }

		public static object getId(TreeView treeView) {
			TreeIter treeIter;
			treeView.Selection.GetSelected(out treeIter);
			return treeView.Model.GetValue(treeIter, 0);

		}
    }
}

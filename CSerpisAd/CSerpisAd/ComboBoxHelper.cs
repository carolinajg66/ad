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

            //TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
            //while (dataReader.Read()){
                //TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(),
                //                                           dataReader[1].ToString());
                //if (id.Equals(dataReader[0].ToString()))
                    //initialTreeIter = treeIter;
            }
            dataReader.Close();
			comboBox.SetActiveIter(initialTreeIter);
        }

		//public static object getId(TreeView treeView) {
		//	TreeIter treeIter;
		//	treeView.Selection.GetSelected(out treeIter);
		//	return treeView.Model.GetValue(treeIter, 0);

		//}
        private static void Init (ComboBox comboBox) {
            CellRendererText cellRendererText = new CellRendererText();
            comboBox.PackStart(cellRendererText, false);
            comboBox.AddAttribute(cellRendererText, "text", 1);
            ListStore listStore = new ListStore(typeof(String), typeof(String));
            comboBox.Model = listStore;
        }



        private static void fill(ComboBox comboBox, IDataReader dataReader, object id) {
            id = id.ToString();
            ListStore listStore = (ListStore)comboBox.Model;
            TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
            while (dataReader.Read()){
                TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(),
                                                           dataReader[1].ToString());
                if (id.Equals(dataReader[0].ToString()))
                    initialTreeIter = treeIter;
            }


        }
    }
}

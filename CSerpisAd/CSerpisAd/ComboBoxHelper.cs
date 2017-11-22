using System;
using Gtk;
using System.Data;

namespace Serpis.Ad {
    public class ComboBoxHelper {

        public const string NullLabel = "<sin asignar>";
 
		public static void Fill(ComboBox comboBox, String selectSql, object id) {

			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = selectSql;
			IDataReader dataReader = dbCommand.ExecuteReader();

			init(comboBox);
			fill(comboBox, dataReader, id);
			dataReader.Close();

		}

		private static void init (ComboBox comboBox) {
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
			comboBox.SetActiveIter(initialTreeIter);
        }
   //     public static void Seleccionar (ComboBox comboBox, long id){

			//IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			//dbCommand.CommandText = "select id from categoria ";
			//IDataReader dataReader = dbCommand.ExecuteReader();

			//int contador = 0;
        //    while (dataReader.Read()){

        //        if (long.Parse(dataReader["id"].ToString())==id){
        //            TreeIter treeIter;
        //            comboBox.Model.IterNthChild(out treeIter,contador);
        //            comboBox.SetActiveIter(treeIter);
        //        }
        //        contador++;
        //    }
        //    dataReader.Close();
        //}

        public static object GetId(ComboBox comboBox){
            TreeIter treeIter;
            comboBox.GetActiveIter(out treeIter);
            object item = comboBox.Model.GetValue(treeIter, 0);
            return item;
            
        }
    }
}

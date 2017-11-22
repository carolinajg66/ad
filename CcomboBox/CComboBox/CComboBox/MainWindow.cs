using System;
using Gtk;



public partial class MainWindow : Gtk.Window {
    public MainWindow() : base(Gtk.WindowType.Toplevel) {
        Build();

        App.Instance.Connection = new MySqlConnection
            ("server = localhost; database = dbprueba; user = root; password = sistemas");

        App.Connection.Open;

    protected void OnDeleteEvent(object sender, DeleteEventArgs a) {
        Application.Quit();
        a.RetVal = true;
    }
}

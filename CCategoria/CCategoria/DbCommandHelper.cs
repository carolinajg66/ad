using System;
using System.Data;
namespace CCategoria
{
    public class DbCommandHelper
    {
        public static void AddParemeter(IDbCommand dbCommand, string nombre, object value){
			//TODO implementar 

			IDbDataParameter dbDataParemeter = dbCommand.CreateParameter();
			dbDataParemeter.ParameterName = nombre;
            dbDataParemeter.Value = value;
			dbCommand.Parameters.Add(dbDataParemeter);
        }



        }

    }


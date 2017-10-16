using System;
using System.Data;
namespace CCategoria
{
    public class DbCommandHelper
    {
        public static void AddParemeter(IDbCommand dbCommand, string name, object value){
			 
			IDbDataParameter dbDataParemeter = dbCommand.CreateParameter();
            dbDataParemeter.ParameterName = name;
            dbDataParemeter.Value = value;
			dbCommand.Parameters.Add(dbDataParemeter);
        }



        }

    }


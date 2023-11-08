package DB_Connection;

import java.sql.SQLException;

public class Ej2 {

    public Ej2() throws SQLException {
        // Crear una base de datos 
		FunctionsSQL.crearBaseDeDatos("ClientesRobert");

		// Seleccionar la base de datos
		FunctionsSQL.seleccionarBaseDeDatos("ClientesRobert");
		
		String sqlClientes = "DROP TABLE IF EXISTS cliente; " +
                "CREATE TABLE cliente (" +
                " id INT AUTO_INCREMENT PRIMARY KEY," +
                " nombre VARCHAR(250) DEFAULT NULL," +
                " apellido VARCHAR(250) DEFAULT NULL," +
                " direccion VARCHAR(250) DEFAULT NULL," +
                " dni INT DEFAULT NULL," +
                " fecha DATE DEFAULT NULL" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8; " +
                "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES " +
                "('Juan', 'Pérez', 'Calle A, Ciudad', 12345678, '2023-10-01')," +
                "('María', 'López', 'Calle B, Ciudad', 98765432, '2023-10-02')," +
                "('Pedro', 'Gómez', 'Calle C, Ciudad', 55555555, '2023-10-03')," +
                "('Laura', 'Martínez', 'Calle D, Ciudad', 11111111, '2023-10-04')," +
                "('Carlos', 'Rodríguez', 'Calle E, Ciudad', 99999999, '2023-10-05');";
		
		String sqlVideos = "DROP TABLE IF EXISTS videos; " +
                "CREATE TABLE videos (" +
                " id INT(11) AUTO_INCREMENT PRIMARY KEY," +
                " title VARCHAR(250) DEFAULT NULL," +
                " director VARCHAR(250) DEFAULT NULL," +
                " cli_id INT(11) DEFAULT NULL," +
                " CONSTRAINT videos_fk FOREIGN KEY (cli_id) REFERENCES cliente (id) " +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8; " +
                "INSERT INTO videos (title, director, cli_id) VALUES " +
                "('Call of duty', 'Grefg', 1)," +
                "('Minecraft', 'Alexelcapo', 2)," +
                "('League of legends', 'Elmillor', 3)," +
                "('Batalla de gallos', 'Chuty', 4)," +
                "('Dead by Daylight', 'ReudigRuediger', 5);";

		//Ejecutar la sentencia SQL para crear las tablas y hacer las inserciones
		FunctionsSQL.ejecutarSQL(sqlClientes);
		FunctionsSQL.ejecutarSQL(sqlVideos);


		
		/* Mostrar todos los datos de la tabla
		List<String> columnas = new ArrayList<>();
		columnas.add("*"); // Esto seleccionará todas las columnas
		FunctionsSQL.mostrarDatos("cliente", columnas);*/

		// Cerrar la conexión después de todas las operaciones
		//ConnectionDB.closeConnection();
    }
}

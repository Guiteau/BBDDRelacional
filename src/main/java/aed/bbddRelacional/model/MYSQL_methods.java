package aed.bbddRelacional.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import aed.bbddRelacional.connections.MYSQL_connection;

public class MYSQL_methods {
	
	private MYSQL_connection mysql_connection;

	public MYSQL_methods() {
		
		mysql_connection = new MYSQL_connection();
		
		mysql_connection.connectMYSQL();
		
	}

	public String visualizarEquipos_nombreLiga() {
		
		String result = "==================" + "\n";

		Statement statement_MYSQL;
		ResultSet resultSet_MYSQL;

		try {

			statement_MYSQL = mysql_connection.getConnection().createStatement();

			resultSet_MYSQL = statement_MYSQL.executeQuery(
					"SELECT  *, NOMLIGA FROM T_EQUIPOS INNER JOIN T_LIGAS ON T_EQUIPOS.CODLIGA = T_LIGAS.CODLIGA ORDER BY CODEQUIPO ASC");

			while (resultSet_MYSQL.next()) {

				result += String.format("Cod. Equipo: %s", resultSet_MYSQL.getInt("CODEQUIPO") + "\n");
				result += String.format("Nombre Equipo: %s", resultSet_MYSQL.getString("NOMEQUIPO") + "\n");
				result += String.format("Cod. Liga: %s", resultSet_MYSQL.getString("CODLIGA") + "\n");
				result += String.format("Localidad: %s", resultSet_MYSQL.getString("LOCALIDAD") + "\n");
				result += String.format("Internacional: %s", resultSet_MYSQL.getInt("INTERNACIONAL") + "\n");
				result += String.format("Nombre Liga: %s", resultSet_MYSQL.getString("NOMLIGA") + "\n");
				result += "==================" + "\n";

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta MYSQL: " + e.getMessage());

		}

		return result;
		
	}

	public boolean insertarEquipo(String nombreEquipo, String codLiga, String localidad, int internacional) {

		boolean insertaEquipo = true;
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = this.mysql_connection.getConnection().prepareStatement(
					"INSERT INTO T_EQUIPOS (NOMEQUIPO, CODLIGA, LOCALIDAD, INTERNACIONAL) VALUES (?, ?, ?, ?)");

			preparedStatement.setString(1, nombreEquipo);
			preparedStatement.setString(2, codLiga);
			preparedStatement.setString(3, localidad);
			preparedStatement.setInt(4, internacional);

			if (!preparedStatement.execute()) {

				insertaEquipo = false;
			}

		} catch (SQLException e) {

			System.out.println("Error durante la ejecución de la inserción MySQL: " + e.getMessage());

			insertaEquipo = false;

		}

		return insertaEquipo;

	}

	public boolean eliminarEquipo(String nombreEquipo) {

		boolean eliminado = true;
		PreparedStatement preparedStatement;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("DELETE FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error al intentar eliminar registro de la base de datos MySQL: " + e.getMessage());

			eliminado = false;
		}

		return eliminado;
	}

	public boolean eliminarEquipoYContratos(String nombreEquipo) {

		boolean eliminado = true;
		String resultCodEquipo = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_msyql;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT CODEQUIPO FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			resultSet_msyql = preparedStatement.executeQuery();

			while (resultSet_msyql.next()) {

				resultCodEquipo = resultSet_msyql.getString("CODEQUIPO");

			}

			if (this.eliminarEquipo(nombreEquipo)) {

				preparedStatement = this.mysql_connection.getConnection()
						.prepareStatement("DELETE FROM T_CONTRATOS WHERE CODEQUIPO = ?");

				preparedStatement.setString(1, resultCodEquipo);

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			System.out.println(
					"Error durante la eliminación del equipo en la tabla contratos de Transact SQL: " + e.getMessage());

			eliminado = false;

		}

		return eliminado;

	}

	public boolean modificarEquipo(int codEquipo, String nomEquipo, String codLiga, String localidad,
			int internacional) {

		boolean modificado = true;

		PreparedStatement preparedStatement;

		try {

			preparedStatement = this.mysql_connection.getConnection().prepareStatement(
					"UPDATE T_EQUIPOS SET NOMEQUIPO = ?, CODLIGA = ?, LOCALIDAD = ?, INTERNACIONAL = ? WHERE CODEQUIPO = ?");

			preparedStatement.setString(1, nomEquipo);
			preparedStatement.setString(2, codLiga);
			preparedStatement.setString(3, localidad);
			preparedStatement.setInt(4, internacional);
			preparedStatement.setInt(5, codEquipo);

			if (preparedStatement.executeUpdate() == 0) {

				modificado = false;

			}

		} catch (SQLException e) {

			System.out.println(
					"Error durante la actualización del equipo en la tabla equipos de MySQL: " + e.getMessage());

			modificado = false;

		}

		return modificado;

	}

	public int [] procedimientoInsertarEquipo(String nomEquipo, String codLiga, String localidad, int internacional) {
		
		int [] salida = new int [2];
		
		try {
			
			CallableStatement cs = mysql_connection.getConnection().prepareCall("{CALL SP_INSERTA_EQUIPO(?, ?, ?, ?, ?, ?)}");
			
			cs.setString(1, nomEquipo);
			cs.setString(2, codLiga);
			cs.setString(3, localidad);
			cs.setInt(4, internacional);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			
			cs.execute();
			
			salida[0] = cs.getInt(5);
			salida[1] = cs.getInt(6);
			
		} catch (SQLException e) {
			
			System.out.println("Error durante el intento de ejecución del procedimiento P_INSERTA_EQUIPO en SQL Server: "+ e.getMessage());

		}
		
		return salida;
		
	}
	
	public String procedimientoVisualizarListaContratos(String dni_nie) {
		
		String result = "";
		
		CallableStatement  cs;
		ResultSet rs;
		
		try {
			cs = mysql_connection.getConnection().prepareCall("{CALL SP_LISTAR_CONTRATOS_FUTBOLISTA(?)}");
			
			cs.setString(1, dni_nie);
			
			rs = cs.executeQuery();
			
			while (rs.next()) {

				result += String.format("Cod. Equipo: %s", rs.getInt("CODCONTRATO") + "\n");
				result += String.format("Nombre Equipo: %s", rs.getString("NOMEQUIPO") + "\n");
				result += String.format("Cod. Liga: %s", rs.getString("NOMLIGA") + "\n");
				result += String.format("Fecha Iniciop: %s", rs.getDate("FECHAINICIO") + "\n");
				result += String.format("Fecha Fin: %s", rs.getDate("FECHAFIN") + "\n");
				result += String.format("Precio Anual: %s", rs.getInt("PRECIOANUAL") + "\n");
				result += String.format("Precio Rescisión: %s", rs.getInt("PRECIORESCISION") + "\n");
				result += "==================" + "\n";

			}
			
		} catch (SQLException e) {
			System.out.println("Error durante el intento de ejecución del procedimiento P_LISTA_CONTRATOS en SQL Server: "+ e.getMessage());
		}
				
		return result;
	}

	public int [] procedimientoCantidadFutbolistas(String nomEquipo, int precioAnual, int precioRescision) {
		
		int [] salida = new int [2];
		
		try {
			
			CallableStatement cs = mysql_connection.getConnection().prepareCall("{CALL SP_FUTBOLISTAS_ACTIVOS(?, ?, ?, ?, ?)}");
			
			cs.setString(1, nomEquipo);
			cs.setInt(2, precioAnual);
			cs.setInt(3, precioRescision);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			
			cs.execute();
			
			salida[0] = cs.getInt(4);
			salida[1] = cs.getInt(5);
			
		} catch (SQLException e) {
			
			System.out.println("Error durante el intento de ejecución del procedimiento P_CANTIDAD_FUTBOLISTAS en SQL Server: "+ e.getMessage());

		}
		
		return salida;
		
	}
	
	public int funcionCantidadMeses(String dniONie) {
		
		int cantidadMeses = 0;
		
		CallableStatement callableStatement;
		
		try {
			
			callableStatement = mysql_connection.getConnection().prepareCall("{? = CALL F_MESES_TOTALES (?)}");
			
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			
			callableStatement.setString(2, dniONie);
						
			callableStatement.execute();
			
			cantidadMeses = callableStatement.getInt(1);

		} catch (SQLException e) {
			
			System.out.println("Error durante la ejecución de la función F_MESES_TOTALES en Transact SQL: " + e.getMessage());
		}
		
		return cantidadMeses;
		
	}

	public List<String> get_dni_futbolistas(){
		
		List<String> dniONies = new ArrayList<String>();
		
		PreparedStatement preparedStatement;
		ResultSet resultSet_sqlServer;

		try {
			
			preparedStatement = mysql_connection.getConnection()
					.prepareStatement("SELECT CODDNIONIE FROM T_FUTBOLISTAS");

			resultSet_sqlServer = preparedStatement.executeQuery();

			while (resultSet_sqlServer.next()) {

				dniONies.add(resultSet_sqlServer.getString("CODDNIONIE"));

			}

		} catch (SQLException e) {

			System.out.println("Error obteniendo listado de DNI o NIE de futbolistas: "
					+ e.getMessage());

		}
		
		return dniONies;
	}
	
	public String get_codigo_liga(String nombreLiga) {

		String resultCodLiga = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_mysql;

		nombreLiga = nombreLiga.replaceAll("\\s+$", "");

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT CODLIGA FROM T_LIGAS WHERE NOMLIGA = ?");

			preparedStatement.setString(1, nombreLiga);

			resultSet_mysql = preparedStatement.executeQuery();

			while (resultSet_mysql.next()) {

				resultCodLiga = resultSet_mysql.getString("CODLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error durante la ejecución de la inserción MySQL: " + e.getMessage());

		}

		return resultCodLiga;

	}

	public int get_codigo_equipo(String nombreEquipo) {

		int codEquipo = 0;

		PreparedStatement preparedStatement;
		ResultSet resultSet_mysql;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT CODEQUIPO FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			resultSet_mysql = preparedStatement.executeQuery();

			while (resultSet_mysql.next()) {

				codEquipo = resultSet_mysql.getInt("CODEQUIPO");

			}

		} catch (SQLException e) {

			System.out.println("Error código de equipo en base de datos MySQL: " + e.getMessage());

		}

		return codEquipo;
	}

	public String get_codigo_liga(int codEquipo) {

		String codigoLiga = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_mysql;

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT CODLIGA FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_mysql = preparedStatement.executeQuery();

			while (resultSet_mysql.next()) {

				codigoLiga = resultSet_mysql.getString("CODLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error código de liga en base de datos MySQL: " + e.getMessage());

		}

		return codigoLiga;

	}

	public String get_nombre_liga(String codLiga) {
		
		String nombreLiga = "";
		
		PreparedStatement preparedStatement;
		ResultSet resultSet_mysql;

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT NOMLIGA FROM T_LIGAS WHERE CODLIGA = ?");

			preparedStatement.setString(1, codLiga);

			resultSet_mysql = preparedStatement.executeQuery();

			while (resultSet_mysql.next()) {

				nombreLiga = resultSet_mysql.getString("NOMLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error al intentar obtener nombre de liga en base de datos MySQL: " + e.getMessage());

		}
		
		return nombreLiga;
		
	}
	
	public String get_localidad_equipo(int codEquipo) {

		String localidad = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_myqsl;

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT LOCALIDAD FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_myqsl = preparedStatement.executeQuery();

			while (resultSet_myqsl.next()) {

				localidad = resultSet_myqsl.getString("LOCALIDAD");

			}

		} catch (SQLException e) {

			System.out.println(
					"Error obteniendo dato de localidad de equipo en base de datos MySQL: " + e.getMessage());

		}

		return localidad;

	}

	public int get_internacional_equipo(int codEquipo) {

		int internacional = 00000;

		PreparedStatement preparedStatement;
		ResultSet resultSet_mysql;

		try {

			preparedStatement = this.mysql_connection.getConnection()
					.prepareStatement("SELECT INTERNACIONAL FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_mysql = preparedStatement.executeQuery();

			while (resultSet_mysql.next()) {

				internacional = resultSet_mysql.getInt("INTERNACIONAL");

			}

		} catch (SQLException e) {

			System.out.println("Error obtiendo dato de participación internacional en base de datos MySQL: "
					+ e.getMessage());

		}

		return internacional;

	}

	public String[] array_nombreLigas() {

		String[] ligas = null;
		int cont = 0, cantidadLigas = 0;

		Statement statement_mysql;
		ResultSet resultSet_mysql;

		try {

			statement_mysql = this.mysql_connection.getConnection().createStatement();

			resultSet_mysql = statement_mysql.executeQuery("SELECT COUNT(*) FROM T_LIGAS");

			while (resultSet_mysql.next()) {

				cantidadLigas = resultSet_mysql.getInt(1);

			}

			ligas = new String[cantidadLigas];

			resultSet_mysql = statement_mysql.executeQuery("SELECT NOMLIGA FROM T_LIGAS");

			while (resultSet_mysql.next()) {

				ligas[cont] = resultSet_mysql.getString(1);

				cont++;

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta MySQL: " + e.getMessage());

		}

		return ligas;

	}

	public String[] array_nombreEquipos() {

		String[] equipos = null;
		int cont = 0, cantidadEquipos = 0;

		Statement statement_mysql;
		ResultSet resultSet_mysql;

		try {

			statement_mysql = this.mysql_connection.getConnection().createStatement();

			resultSet_mysql = statement_mysql.executeQuery("SELECT COUNT(*) FROM T_EQUIPOS");

			while (resultSet_mysql.next()) {

				cantidadEquipos = resultSet_mysql.getInt(1);

			}

			equipos = new String[cantidadEquipos];

			resultSet_mysql = statement_mysql.executeQuery("SELECT NOMEQUIPO FROM T_EQUIPOS");

			while (resultSet_mysql.next()) {

				equipos[cont] = resultSet_mysql.getString(1);

				cont++;

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta MySQL: " + e.getMessage());

		}

		return equipos;

	}

	
	public MYSQL_connection getMysql_connection() {
		return mysql_connection;
	}
	
}

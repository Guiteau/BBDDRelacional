package aed.bbddRelacional.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aed.bbddRelacional.connections.Access_connection;

public class Access_methods {

	private Access_connection access_connection;
	
	public Access_methods() {
		
		access_connection = new Access_connection();
		
		access_connection.connectAccess();		
		
	}
	
	
	/**
	 * Connects Access database
	 * 
	 * @return the resultant String of the query
	 **/

	public String visualizarEquipos_nombreLiga() {

		String result = "==================" + "\n";

		Statement statement_access;
		ResultSet resultSet_access;

		try {

			statement_access = access_connection.getConnection().createStatement();

			resultSet_access = statement_access.executeQuery(
					"SELECT  CODEQUIPO, NOMEQUIPO, CODLIGA, LOCALIDAD, INTERNACIONAL, NOMLIGA FROM T_EQUIPOS INNER JOIN T_LIGAS ON T_EQUIPOS.CODLIGA = T_LIGAS.CODLIGA");

			while (resultSet_access.next()) {

				result += String.format("Cod. Equipo: %s", resultSet_access.getInt("CODEQUIPO") + "\n");
				result += String.format("Nombre Equipo: %s", resultSet_access.getString("NOMEQUIPO") + "\n");
				result += String.format("Cod. Liga: %s", resultSet_access.getString("CODLIGA") + "\n");
				result += String.format("Localidad: %s", resultSet_access.getString("LOCALIDAD") + "\n");
				result += String.format("Internacional: %s", resultSet_access.getInt("INTERNACIONAL") + "\n");
				result += String.format("Nombre Liga: %s", resultSet_access.getString("NOMLIGA") + "\n");
				result += "==================" + "\n";

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta Access: " + e.getMessage());

		}

		return result;

	}

	public boolean insertarEquipo(String nombreEquipo, String codLiga, String localidad, int internacional) {

		boolean insertaEquipo = true;
		int codigoEquipo = this.get_mayor_codigoEquipo();
		PreparedStatement preparedStatement = null;
		
		try {

			preparedStatement = access_connection.getConnection().prepareStatement(
					"INSERT INTO T_EQUIPOS (CODEQUIPO, NOMEQUIPO, CODLIGA, LOCALIDAD, INTERNACIONAL) VALUES (?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, codigoEquipo);
			preparedStatement.setString(2, nombreEquipo);
			preparedStatement.setString(3, codLiga);
			preparedStatement.setString(4, localidad);
			preparedStatement.setInt(5, internacional);

			if (!preparedStatement.execute()) {

				insertaEquipo = false;
			}

		} catch (SQLException e) {

			System.out.println("Error durante la ejecución de la inserción en Access: " + e.getMessage());

			insertaEquipo = false;

		}

		return insertaEquipo;

	}

	public boolean eliminarEquipo(String nombreEquipo) {

		boolean eliminado = true;
		PreparedStatement preparedStatement;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = this.access_connection.getConnection()
					.prepareStatement("DELETE FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error al intentar eliminar registro de la base de datos de Access: " + e.getMessage());

			eliminado = false;
		}

		return eliminado;
	}

	public boolean eliminarEquipoYContratos(String nombreEquipo) {

		boolean eliminado = true;
		String resultCodEquipo = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT CODEQUIPO FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				resultCodEquipo = resultSet_access.getString("CODEQUIPO");

			}

			if (this.eliminarEquipo(nombreEquipo)) {

				preparedStatement = this.access_connection.getConnection()
						.prepareStatement("DELETE FROM T_CONTRATOS WHERE CODEQUIPO = ?");

				preparedStatement.setString(1, resultCodEquipo);

				preparedStatement.executeUpdate();

			}

		} catch (SQLException e) {

			System.out.println(
					"Error durante la eliminación del equipo en la tabla contratos de Access: " + e.getMessage());

			eliminado = false;

		}

		return eliminado;

	}

	public boolean modificarEquipo(int codEquipo, String nomEquipo, String codLiga, String localidad,
			int internacional) {

		boolean modificado = true;

		PreparedStatement preparedStatement;

		try {

			preparedStatement = access_connection.getConnection().prepareStatement(
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
					"Error durante la actualización del equipo en la tabla equipos de Access: " + e.getMessage());

			modificado = false;

		}

		return modificado;

	}

	public int get_mayor_codigoEquipo() {
		
		int codigoEquipo_mayor = 0;
		
		Statement stmt;
		try {
			
			stmt = access_connection.getConnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(CODEQUIPO) FROM T_EQUIPOS");
			
			while (rs.next()) {

				codigoEquipo_mayor = rs.getInt(1);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante la obtención del código de equipo mayor de la tabla equipos en Access "+e.getMessage());
		}
		
		
		return codigoEquipo_mayor+1;
		
	}
	
	public String get_codigo_liga(String nombreLiga) {

		String resultCodLiga = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		nombreLiga = nombreLiga.replaceAll("\\s+$", "");

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT CODLIGA FROM T_LIGAS WHERE NOMLIGA = ?");

			preparedStatement.setString(1, nombreLiga);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				resultCodLiga = resultSet_access.getString("CODLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error durante la ejecución de la inserción en Access: " + e.getMessage());

		}

		return resultCodLiga;

	}

	public int get_codigo_equipo(String nombreEquipo) {

		int codEquipo = 0;

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		nombreEquipo = nombreEquipo.replaceAll("\\s+$", "");

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT CODEQUIPO FROM T_EQUIPOS WHERE NOMEQUIPO = ?");

			preparedStatement.setString(1, nombreEquipo);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				codEquipo = resultSet_access.getInt("CODEQUIPO");

			}

		} catch (SQLException e) {

			System.out.println("Error código de equipo en base de datos Transact SQL: " + e.getMessage());

		}

		return codEquipo;
	}

	public String get_codigo_liga(int codEquipo) {

		String codigoLiga = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT CODLIGA FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				codigoLiga = resultSet_access.getString("CODLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error código de liga en base de datos Access: " + e.getMessage());

		}

		return codigoLiga;

	}

	public String get_nombre_liga(String codLiga) {
		
		String nombreLiga = "";
		
		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT NOMLIGA FROM T_LIGAS WHERE CODLIGA = ?");

			preparedStatement.setString(1, codLiga);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				nombreLiga = resultSet_access.getString("NOMLIGA");

			}

		} catch (SQLException e) {

			System.out.println("Error al intentar obtener nombre de liga en base de datos de Access: " + e.getMessage());

		}
		
		return nombreLiga;
		
	}
	
	public String get_localidad_equipo(int codEquipo) {

		String localidad = "";

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT LOCALIDAD FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				localidad = resultSet_access.getString("LOCALIDAD");

			}

		} catch (SQLException e) {

			System.out.println(
					"Error obteniendo dato de localidad de equipo en base de datos de Access: " + e.getMessage());

		}

		return localidad;

	}

	public int get_internacional_equipo(int codEquipo) {

		int internacional = 00000;

		PreparedStatement preparedStatement;
		ResultSet resultSet_access;

		try {

			preparedStatement = access_connection.getConnection()
					.prepareStatement("SELECT INTERNACIONAL FROM T_EQUIPOS WHERE CODEQUIPO = ?");

			preparedStatement.setInt(1, codEquipo);

			resultSet_access = preparedStatement.executeQuery();

			while (resultSet_access.next()) {

				internacional = resultSet_access.getInt("INTERNACIONAL");

			}

		} catch (SQLException e) {

			System.out.println("Error obtiendo dato de participación internacional en base de datos de Access: "
					+ e.getMessage());

		}

		return internacional;

	}

	public String[] array_nombreLigas() {

		String[] ligas = null;
		int cont = 0, cantidadLigas = 0;

		Statement statement_access;
		ResultSet resultset_access;

		try {

			statement_access = access_connection.getConnection().createStatement();

			resultset_access = statement_access.executeQuery("SELECT COUNT(*) FROM T_LIGAS");

			while (resultset_access.next()) {

				cantidadLigas = resultset_access.getInt(1);

			}

			ligas = new String[cantidadLigas];

			resultset_access = statement_access.executeQuery("SELECT NOMLIGA FROM T_LIGAS");

			while (resultset_access.next()) {

				ligas[cont] = resultset_access.getString(1);

				cont++;

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta de Access: " + e.getMessage());

		}

		return ligas;

	}

	public String[] array_nombreEquipos() {

		String[] equipos = null;
		int cont = 0, cantidadEquipos = 0;

		Statement statement_access;
		ResultSet resultSet_access;

		try {

			statement_access = access_connection.getConnection().createStatement();

			resultSet_access = statement_access.executeQuery("SELECT COUNT(*) FROM T_EQUIPOS");

			while (resultSet_access.next()) {

				cantidadEquipos = resultSet_access.getInt(1);

			}

			equipos = new String[cantidadEquipos];

			resultSet_access = statement_access.executeQuery("SELECT NOMEQUIPO FROM T_EQUIPOS");

			while (resultSet_access.next()) {

				equipos[cont] = resultSet_access.getString(1);

				cont++;

			}

		} catch (Exception e) {

			System.out.println("Error durante la ejecución de la consulta de Access: " + e.getMessage());

		}

		return equipos;

	}


	
	public Access_connection getAccess_connection() {
		return access_connection;
	}

}

package aed.bbddRelacional.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access_connection {
	
	private String url;
	private String filePath;
	private Connection connection;
	private boolean connectionStatus;

	public Access_connection() {

		this.setUrl("jdbc:ucanaccess://");
		this.setFilePath("bdFutbol.accdb");
		this.setConnection(null);
		
		this.setConnectionStatus(true);

	}
	
	/**Connects Access database
	 * @return true if connection is stablished and working or false if not
	 * **/

	public boolean connectAccess() {


		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			this.setConnection(DriverManager.getConnection(this.getUrl()+this.getFilePath()));
			
			if(this.getConnection().isClosed())
				
				this.setConnectionStatus(false);

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(
					"Error en intento de conexión a base de datos Access. Descripción de error: " + e.getMessage());

			connectionStatus = false;
		}

		return connectionStatus;

	}

	/**Disconnects from Access database
	 * @return true if connection is closed() or false if not
	 * **/
	
	public boolean disconnectAccess() {
		
		boolean connectionClosed = false;
		
		try {
			
			if(!this.getConnection().isClosed()) {
				
				this.getConnection().close();
				
				connectionClosed = true;
				
			}
		} catch (SQLException e) {

			System.out.println("Error en intento de desconexión de la base de datos Access. Descripción de error: " + e.getMessage());
			
			this.setConnectionStatus(false);

		}
		
		return connectionClosed;
		
	}
	
	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}

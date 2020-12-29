package aed.bbddRelacional.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQL_connection {

	private String url;
	private String user;
	private String password;
	private String serverName;
	private String databaseName;
	private Connection connection;
	private boolean connection_status;

	public MYSQL_connection() {

		this.setUrl("jdbc:mysql://");
		this.setUser("root");
		this.setPassword("");
		this.setServerName("localhost:3306");
		this.setDatabaseName("bdfutbol");
		this.setConnection(null);
		
		this.setConnection_status(true);

	}
	
	/**Connects MYSQL database
	 * @return true if connection is stablished and working or false if not
	 * **/

	public boolean connectMYSQL() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			this.setConnection(DriverManager.getConnection(this.getUrl() + this.getServerName() + "/"+ this.getDatabaseName(), this.getUser(), this.getPassword()));
			
			if(this.getConnection().isClosed())
				
				this.setConnection_status(false);

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println(
					"Error en intento de conexión a base de datos MYSQL. Descripción de error: " + e.getMessage());

			this.setConnection_status(false);
		}

		return connection_status;

	}

	/**Disconnects from MYSQL database
	 * @return true if connection is closed() or false if not
	 * **/
	
	public boolean disconnectMYSQL() {
		
		boolean connectionClosed = false;
		
		try {
			
			if(!this.getConnection().isClosed()) {
				
				this.getConnection().close();
				
				connectionClosed = true;
				
			}
		} catch (SQLException e) {

			System.out.println("Error en intento de desconexión de la base de datos MYSQL "+this.getDatabaseName() + ". Descripción de error: " + e.getMessage());

		}
		
		return connectionClosed;
		
	}
	
	public void setConnection_status(boolean connection_status) {
		this.connection_status = connection_status;
	}
	
	public boolean isConnection_status() {
		return connection_status;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	
}

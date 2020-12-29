import aed.bbddRelacional.connections.Access_connection;
import aed.bbddRelacional.connections.MYSQL_connection;
import aed.bbddRelacional.connections.SQLServer_connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class SQL_connection_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SQLServer_connection sql = new SQLServer_connection();
		
		System.out.println(sql.connectSQLServer());
		
		MYSQL_connection mysql = new MYSQL_connection();
		
		System.out.println(mysql.connectMYSQL());
		
		Access_connection access = new Access_connection();
		
		System.out.println(access.connectAccess());
		
		ObservableList<String> options = 
		        FXCollections.observableArrayList(
		            "Option 1",
		            "Option 2",
		            "Option 3"
		        );
		
		ComboBox<String> combo = new ComboBox<>();
		
		combo.setItems(options);

	}

}

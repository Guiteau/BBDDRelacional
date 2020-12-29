package aed.bbddRelacional.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import aed.bbddRelacional.model.Access_methods;
import aed.bbddRelacional.model.MYSQL_methods;
import aed.bbddRelacional.model.SQLServer_methods;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable {

	// MODEL

	private Access_methods access = new Access_methods();

	private MYSQL_methods mysql = new MYSQL_methods();

	private SQLServer_methods sqlServer = new SQLServer_methods();

	// VIEW

	@FXML
	private VBox view;

	@FXML
	private TabPane opcionesTabPane;

	@FXML
	private Tab mysqlTab;

	@FXML
	private HBox mysqlHBox;

	@FXML
	private VBox mysqlVBox;

	@FXML
	private Button visualizarButtonMYSQL;

	@FXML
	private Button insertarButtonMYSQL;

	@FXML
	private Button eliminarButtonMYSQL;

	@FXML
	private Button modificarButtonMYSQL;

	@FXML
	private Button procedimientoButtonMYSQL;

	@FXML
	private ProgressIndicator progresoButtonMYSQL = new ProgressIndicator();

	@FXML
	private TextArea mysqlArea;

	@FXML
	private Tab sqlServerTab;

	@FXML
	private HBox sqlHBox;

	@FXML
	private VBox sqlVBox;

	@FXML
	private Button visualizarButtonSQLServer;

	@FXML
	private Button insertarButtonSQLServer;

	@FXML
	private Button eliminarButtonSQLServer;

	@FXML
	private Button modificarButtonSQLServer;

	@FXML
	private Button procedimientoButtonSQLServer;

	@FXML
	private ProgressIndicator progresoButtonSQLServer = new ProgressIndicator();

	@FXML
	private TextArea sqlServerArea;

	@FXML
	private Tab accessTab;

	@FXML
	private HBox accessHBox;

	@FXML
	private VBox accessVBox;

	@FXML
	private Button visualizarButtonAccess;

	@FXML
	private Button insertarButtonAccess;

	@FXML
	private Button eliminarButtonAccess;

	@FXML
	private Button modificarButtonAccess;

	@FXML
	private ProgressIndicator progresoButtonAccess = new ProgressIndicator();

	@FXML
	private TextArea accessArea;

	@FXML
	private Label insertaSQL_label_nomEquipo;

	@FXML
	private TextField insertaSQL_textField_nomEquipo;

	@FXML
	private Label insertaSQL_label_nomLiga;

	@FXML
	private ComboBox<String> insertaSQL_comboBox_nomLiga;

	@FXML
	private Label insertaSQL_label_localidad;

	@FXML
	private TextField insertaSQL_textField_localidad;

	@FXML
	private Label insertaSQL_label_internacional;

	@FXML
	private CheckBox insertaSQL_checkBox_internacional;

	@FXML
	private Button insertaSQL_buttonAccept;

	@FXML
	private Button insertaSQL_buttonCancel;

	@FXML
	private ComboBox<String> combo_eliminar_sqlServer;

	@FXML
	private Button button_SQLServer_eliminar_eliminaEquipo;

	@FXML
	private Button button_SQLServer_cancelar_eliminaEquipo;

	@FXML
	private ComboBox<String> combo_modificar_sqlServer;

	@FXML
	private Button button_SQLServer_modificar_modificaEquipo;

	@FXML
	private Button button_SQLServer_cancelar_modificaEquipo;

	@FXML
	private Label modificaSQL_label_codEquipo;

	@FXML
	private TextField modificaSQL_textField_codEquipo;

	@FXML
	private Label modificaSQL_label_nomEquipo;

	@FXML
	private TextField modificaSQL_textField_nomEquipo;

	@FXML
	private Label modificaSQL_label_nomLiga;

	@FXML
	private ComboBox<String> modificaSQL_comboBox_nomLiga;

	@FXML
	private Label modificaSQL_label_localidad;

	@FXML
	private TextField modificaSQL_textField_localidad;

	@FXML
	private Label modficaSQL_label_internacional;

	@FXML
	private CheckBox modificaSQL_checkBox_internacional;

	@FXML
	private Button modificaSQL_buttonCancel;

	@FXML
	private Button modificaSQL_buttonAccept;

	@FXML
	private Label insertaAccess_label_nomEquipo;

	@FXML
	private TextField insertaAccess_textField_nomEquipo;

	@FXML
	private Label insertaAccess_label_nomLiga;

	@FXML
	private ComboBox<String> insertaAccess_comboBox_nomLiga;

	@FXML
	private Label insertaAccess_label_localidad;

	@FXML
	private TextField insertaAccess_textField_localidad;

	@FXML
	private Label insertaAccess_label_internacional;

	@FXML
	private CheckBox insertaAccess_checkBox_internacional;

	@FXML
	private Button insertaAccess_buttonCancel;

	@FXML
	private Button insertaAccess_buttonAccept;

	@FXML
	private ComboBox<String> combo_eliminar_access;

	@FXML
	private Button button_access_eliminar_access;

	@FXML
	private Button button_access_cancelar_access;

	@FXML
	private ComboBox<String> combo_modificar_access;

	@FXML
	private Button button_access_modificar_modificaEquipo;

	@FXML
	private Button button_access_cancelar_modificaEquipo;

	@FXML
	private Label modificaAccess_codEquipo;

	@FXML
	private TextField modificaAccess_textField_codEquipo;

	@FXML
	private Label modificaAccess_label_nomEquipo;

	@FXML
	private TextField modificaAccess_textField_nomEquipo;

	@FXML
	private Label modificaAccess_label_nomLiga;

	@FXML
	private ComboBox<String> modificaAccess_comboBox_nomLiga;

	@FXML
	private Label modificaAccess_label_localidad;

	@FXML
	private TextField modificaAccess_textField_localidad;

	@FXML
	private Label modficaAccess_label_internacional;

	@FXML
	private CheckBox modificaAccess_checkBox_internacional;

	@FXML
	private Button modificaAccess_buttonCancel;

	@FXML
	private Button modificaAccess_buttonAccept;

	@FXML
	private Label insertaMysql_label_nomEquipo;

	@FXML
	private TextField insertaMysql_textField_nomEquipo;

	@FXML
	private Label insertaMysql_label_nomLiga;

	@FXML
	private ComboBox<String> insertaMysql_comboBox_nomLiga;

	@FXML
	private Label insertaMysql_label_localidad;

	@FXML
	private TextField insertaMysql_textField_localidad;

	@FXML
	private Label insertaMysql_label_internacional;

	@FXML
	private CheckBox insertaMysql_checkBox_internacional;

	@FXML
	private Button insertaMysql_buttonCancel;

	@FXML
	private Button insertaMysql_buttonAccept;

	@FXML
	private ComboBox<String> combo_eliminar_mysql;

	@FXML
	private Button button_mysql_eliminar_eliminaEquipo;

	@FXML
	private Button button_mysql_cancelar_eliminaEquipo;

	@FXML
	private Label modificaMysql_label_codEquipo;

	@FXML
	private TextField modificaMysql_textField_codEquipo;

	@FXML
	private Label modificaMysql_label_nomEquipo;

	@FXML
	private TextField modificaMysql_textField_nomEquipo;

	@FXML
	private Label modificaMysql_label_nomLiga;

	@FXML
	private ComboBox<String> modificaMysql_comboBox_nomLiga;

	@FXML
	private Label modificaMysql_label_localidad;

	@FXML
	private TextField modificaMysql_textField_localidad;

	@FXML
	private Label modficaMysql_label_internacional;

	@FXML
	private CheckBox modificaMysql_checkBox_internacional;

	@FXML
	private Button modificaMysql_buttonCancel;

	@FXML
	private Button modificaMysql_buttonAccept;

	@FXML
	private ComboBox<String> combo_modificar_mysql;

	@FXML
	private Button button_mysql_modificar_modificaEquipo;

	@FXML
	private Button button_mysql_cancelar_modificaEquipo;

	@FXML
	private Button procedimiento_button_sqlServer_insertaEquipo;

	@FXML
	private Button procedimiento_button_sqlServer_visualizaContratos;

	@FXML
	private Button procedimiento_button_sqlServer_cantidadFutbolistas;

	@FXML
	private Button procedimiento_button_sqlServer_cantidadMeses;

	@FXML
	private Button procedimiento_button_salir;

	@FXML
	private Label insertaSQL_procedimiento_label_nomEquipo;

	@FXML
	private TextField insertaSQL_procedimiento_textField_nomEquipo;

	@FXML
	private Label insertaSQL_procedimiento_label_nomLiga;

	@FXML
	private TextField insertaSQL_procedimiento_textField_nomLiga;

	@FXML
	private Label insertaSQL_procedimiento_label_localidad;

	@FXML
	private TextField insertaSQL_procedimiento_textField_localidad;

	@FXML
	private Label insertaSQL_procedimiento_label_internacional;

	@FXML
	private CheckBox insertaSQL_procedimiento_checkBox_internacional;

	@FXML
	private Button insertaSQL_procedimiento_buttonCancel;

	@FXML
	private Button insertaSQL_procedimiento_buttonAccept;
	
    @FXML
    private Label insertaSQL_procedimientoCantidadFutbolistas_label_nomEquipo;

    @FXML
    private TextField insertaSQL_procedimientoCantidadFutbolistas_textField_nomEquipo;

    @FXML
    private Label insertaSQL_procedimientoCantidadFutbolistas_label_precioAnual;

    @FXML
    private TextField insertaSQL_procedimientoCantidadFutbolistas_textField_precioAnual;

    @FXML
    private Label insertaSQL_procedimientoCantidadFutbolistas_label_precioRescision;

    @FXML
    private TextField insertaSQL_procedimientoCantidadFutbolistas_textField_precioRescision;

    @FXML
    private Button insertaSQL_procedimientoCantidadFutbolistas_buttonCancel;

    @FXML
    private Button insertaSQL_procedimientoCantidadFutbolistas_buttonAccept;
    
    @FXML
    private Label insertaMysql_procedimiento_label_nomEquipo;

    @FXML
    private TextField insertaMysql_procedimiento_textField_nomEquipo;

    @FXML
    private Label insertaMysql_procedimiento_label_nomLiga;

    @FXML
    private TextField insertaMysql_procedimiento_textField_nomLiga;

    @FXML
    private Label insertaMysql_procedimiento_label_localidad;

    @FXML
    private TextField insertaMysql_procedimiento_textField_localidad;

    @FXML
    private Label insertaMysql_procedimiento_label_internacional;

    @FXML
    private CheckBox insertaMysql_procedimiento_checkBox_internacional;

    @FXML
    private Button insertaMysql_procedimiento_buttonCancel;

    @FXML
    private Button insertaMysql_procedimiento_buttonAccept;
    
    @FXML
    private Label insertaMysql_procedimientoCantidadFutbolistas_label_nomEquipo;

    @FXML
    private TextField insertaMysql_procedimientoCantidadFutbolistas_textField_nomEquipo;

    @FXML
    private Label insertaMysql_procedimientoCantidadFutbolistas_label_precioAnual;

    @FXML
    private TextField insertaMysql_procedimientoCantidadFutbolistas_textField_precioAnual;

    @FXML
    private Label insertaMysql_procedimientoCantidadFutbolistas_label_precioRescision;

    @FXML
    private TextField insertaMysql_procedimientoCantidadFutbolistas_textField_precioRescision;

    @FXML
    private Button insertaMysql_procedimientoCantidadFutbolistas_buttonCancel;

    @FXML
    private Button insertaMysql_procedimientoCantidadFutbolistas_buttonAccept;
    
    @FXML
    private Button procedimiento_button_mysql_insertaEquipo;

    @FXML
    private Button procedimiento_button_mysql_visualizaContratos;

    @FXML
    private Button procedimiento_button_mysql_cantidadFutbolistas;

    @FXML
    private Button procedimiento_button_mysql_cantidadMeses;

    @FXML
    private Button procedimiento_button_mysql_salir;


	public Controller() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();

		// EVENTOS SQL Server

		visualizarButtonSQLServer.setOnAction(e -> sqlServer_visualizaButton());

		insertarButtonSQLServer.setOnAction(e -> {
			try {
				sqlServer_insertarButton();
			} catch (IOException e1) {
				System.out.println(
						"Error en la captura de evento correspondiente a insertarButtonSQLServer: " + e1.getMessage());
			}
		});

		eliminarButtonSQLServer.setOnAction(e -> sqlServer_eliminarButton());

		modificarButtonSQLServer.setOnAction(e -> sqlServer_modificarButton());

		procedimientoButtonSQLServer.setOnAction(e -> sqlServer_procedimientoButton());

		// EVENTOS MYSQL

		visualizarButtonMYSQL.setOnAction(e -> mysql_visualizaButton());

		insertarButtonMYSQL.setOnAction(e -> mysql_insertarButton());

		eliminarButtonMYSQL.setOnAction(e -> mysql_eliminarButton());

		modificarButtonMYSQL.setOnAction(e -> mysql_modificarButton());

		procedimientoButtonMYSQL.setOnAction(e -> mysql_procedimientoButton());
		
		// EVENTOS ACESS

		visualizarButtonAccess.setOnAction(e -> access_visualizarButton());

		insertarButtonAccess.setOnAction(e -> access_insertarButton());

		eliminarButtonAccess.setOnAction(e -> access_eliminarButton());

		modificarButtonAccess.setOnAction(e -> access_modificarButton());

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		if (sqlServer.getSqlServer_connection().isConnectionStatus())

			progresoButtonSQLServer.setProgress(100.0);

		if (mysql.getMysql_connection().isConnection_status())

			progresoButtonMYSQL.setProgress(100.0);

		if (access.getAccess_connection().isConnectionStatus())

			progresoButtonAccess.setProgress(100.0);

	}

	// SQL SERVER

	private void sqlServer_visualizaButton() {

		sqlServerArea.setText(sqlServer.visualizarEquipos_nombreLiga());

	}

	private void sqlServer_insertarButton() throws IOException {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/SQL_Server/insertar_sqlServer.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Insertar equipo");
			stage.setScene(scene);
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			insertaSQL_comboBox_nomLiga.setItems(FXCollections.observableArrayList(sqlServer.array_nombreLigas()));

			insertaSQL_comboBox_nomLiga.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			insertaSQL_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					if ((insertaSQL_textField_nomEquipo.getText() == null
							|| insertaSQL_textField_localidad.getText().trim().isEmpty())) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Aviso");
						alert.setHeaderText(null);
						alert.setContentText("Ningún campo puede quedar vacío");

						alert.showAndWait();

					} else {

						int internacional = 0;
						String nombreLiga = insertaSQL_comboBox_nomLiga.getSelectionModel().getSelectedItem();

						if (insertaSQL_checkBox_internacional.isSelected()) {

							internacional = 1;

						}

						sqlServer.insertarEquipo(insertaSQL_textField_nomEquipo.getText(),
								sqlServer.get_codigo_liga(nombreLiga), insertaSQL_textField_localidad.getText(),
								internacional);

						stage.close();

					}

				}
			});

			insertaSQL_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void sqlServer_eliminarButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/sql_server/Eliminar_sqlServer.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Eliminar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_eliminar_sqlServer.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_eliminar_sqlServer.setItems(FXCollections.observableArrayList(sqlServer.array_nombreEquipos()));

			combo_eliminar_sqlServer.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			button_SQLServer_eliminar_eliminaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar equipo");
					// alert.setHeaderText("Look, a Confirmation Dialog");
					alert.setContentText("¿Quisieras eliminar también los contratos asociados?");

					ButtonType buttonType_si = new ButtonType("Sí");
					ButtonType buttonType_soloEquipo = new ButtonType("Sólo el equipo");
					ButtonType buttonType_cancelar = new ButtonType("Cancelar");

					alert.getButtonTypes().setAll(buttonType_si, buttonType_soloEquipo, buttonType_cancelar);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonType_soloEquipo) {

						sqlServer.eliminarEquipo(combo_eliminar_sqlServer.getSelectionModel().getSelectedItem());

						stage.close();

					} else if (result.get() == buttonType_si) {

						sqlServer.eliminarEquipoYContratos(combo_eliminar_sqlServer.getSelectionModel().getSelectedItem());

						stage.close();

					}
				}
			});

			button_SQLServer_cancelar_eliminaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private void sqlServer_modificarButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/SQL_Server/Modificar_sqlServer.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Modificar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_modificar_sqlServer.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_modificar_sqlServer.setItems(FXCollections.observableArrayList(sqlServer.array_nombreEquipos()));

			combo_modificar_sqlServer.getSelectionModel().selectFirst();

			FXMLLoader fxmlLoader_1 = new FXMLLoader();
			fxmlLoader_1.setLocation(getClass().getResource("/fxml/SQL_Server/Modificar_mostrarEquipo_sqlServer.fxml"));
			fxmlLoader_1.setController(this);

			Scene scene_1;

			scene_1 = new Scene(fxmlLoader_1.load(), 600, 400);

			button_SQLServer_modificar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				final class Modificaciones {

					String nombreEquipo;
					int codigoEquipo;
					String localidad;
					int internacional;
					String codigoLiga;
					String nombreLiga;

					public String getNombreEquipo() {
						return nombreEquipo;
					}

					public void setNombreEquipo(String nombreEquipo) {
						this.nombreEquipo = nombreEquipo;
					}

					public int getCodigoEquipo() {
						return codigoEquipo;
					}

					public void setCodigoEquipo(int codigoEquipo) {
						this.codigoEquipo = codigoEquipo;
					}

					public String getLocalidad() {
						return localidad;
					}

					public void setLocalidad(String localidad) {
						this.localidad = localidad;
					}

					public int getInternacional() {
						return internacional;
					}

					public void setInternacional(int internacional) {
						this.internacional = internacional;
					}

					public String getCodigoLiga() {
						return codigoLiga;
					}

					public void setCodigoLiga(String codigoLiga) {
						this.codigoLiga = codigoLiga;
					}

					public String getNombreLiga() {
						return nombreLiga;
					}

					public void setNombreLiga(String nombreLiga) {
						this.nombreLiga = nombreLiga;
					}

				}

				public void handle(ActionEvent event) {

					Modificaciones modificaciones = new Modificaciones();

					Stage stage_1 = new Stage();
					stage_1.setTitle("Modificar equipo");
					stage_1.setScene(scene_1);
					stage_1.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
					stage_1.show();

					// código de equipo

					modificaciones.setCodigoEquipo(sqlServer
							.get_codigo_equipo(combo_modificar_sqlServer.getSelectionModel().getSelectedItem()));

					modificaSQL_textField_codEquipo.setEditable(false);

					modificaSQL_textField_codEquipo.setText(Integer.toString(modificaciones.getCodigoEquipo()));

					// Nombre de equipo

					modificaciones.setNombreEquipo(
							combo_modificar_sqlServer.getSelectionModel().getSelectedItem().replaceAll("\\s+$", ""));

					modificaSQL_textField_nomEquipo.setText(modificaciones.getNombreEquipo());

					// Código liga

					modificaciones.setCodigoLiga(sqlServer.get_codigo_liga(modificaciones.getCodigoEquipo()));

					// Nombres ligas de fútbol (combo box)

					modificaciones.setNombreLiga(sqlServer.get_nombre_liga(modificaciones.getCodigoLiga()));

					modificaSQL_comboBox_nomLiga
							.setItems(FXCollections.observableArrayList(sqlServer.array_nombreLigas()));

					modificaSQL_comboBox_nomLiga.setValue(modificaciones.getNombreLiga());

					// Localidad

					modificaciones.setLocalidad(sqlServer.get_localidad_equipo(modificaciones.getCodigoEquipo()));

					modificaSQL_textField_localidad.setText(modificaciones.getLocalidad());

					// Internacional

					modificaciones.setInternacional(0);

					if (sqlServer.get_internacional_equipo(modificaciones.getCodigoEquipo()) == 1) {

						modificaSQL_checkBox_internacional.fire();

						modificaciones.setInternacional(1);

					}

					modificaSQL_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							stage_1.close();

						}
					});

					modificaSQL_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							int internacional = modificaciones.getInternacional();
							int codigoEquipo = modificaciones.getCodigoEquipo();
							String codigoLiga = modificaSQL_comboBox_nomLiga.getSelectionModel().getSelectedItem();
							String localidad = modificaSQL_textField_localidad.getText();
							String nombreEquipo = modificaSQL_textField_nomEquipo.getText();

							if (modificaSQL_checkBox_internacional.isSelected()) {

								internacional = 1;

							} else {

								internacional = 0;

							}

							// Código liga

							codigoLiga = sqlServer.get_codigo_liga(
									modificaSQL_comboBox_nomLiga.getSelectionModel().getSelectedItem());

							sqlServer.modificarEquipo(codigoEquipo, nombreEquipo, codigoLiga, localidad, internacional);

							stage_1.close();
							stage.close();
						}
					});
				}
			});

			button_SQLServer_cancelar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private void sqlServer_procedimientoButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/sql_server/Procedimientos_menu_sqlServer.fxml"));
			fxmlLoader.setController(this);
			
			FXMLLoader fxmlLoader_1 = new FXMLLoader(); //procedimiento de "Insertar Equipo"
			fxmlLoader_1.setLocation(
			getClass().getResource("/fxml/SQL_Server/insertar_procedimiento_sqlServer.fxml"));
			fxmlLoader_1.setController(this);

			FXMLLoader fxmlLoader_2 = new FXMLLoader(); //procedimiento de "Cantidad Futbolistas"
			fxmlLoader_2.setLocation(
			getClass().getResource("/fxml/SQL_Server/Procedimiento_cantidadFutbolistas_sqlServer.fxml"));
			fxmlLoader_2.setController(this);
			
			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Elegir procedimiento");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			procedimiento_button_sqlServer_insertaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					try {

						Scene scene_1 = new Scene(fxmlLoader_1.load(), 600, 400);

						Stage stage_1 = new Stage();
						stage_1.setTitle("Insertar equipo");
						stage_1.setScene(scene_1);
						stage_1.show();

						insertaSQL_procedimiento_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {
								
								int [] resultado = null;
								
								if ((insertaSQL_procedimiento_textField_nomEquipo.getText() == null
										|| insertaSQL_procedimiento_textField_localidad.getText().trim().isEmpty())) {

									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Aviso");
									alert.setHeaderText(null);
									alert.setContentText("Ningún campo puede quedar vacío");

									alert.showAndWait();

								} else {

									int internacional = 0;
									String nombreLiga = insertaSQL_procedimiento_textField_nomLiga.getText().replaceAll("\\s","");

									if (insertaSQL_procedimiento_checkBox_internacional.isSelected()) {

										internacional = 1;

									}
									
									resultado = sqlServer.procedimientoInsertarEquipo(
											insertaSQL_procedimiento_textField_nomEquipo.getText().replaceAll("\\s",""),
											nombreLiga,
											insertaSQL_procedimiento_textField_localidad.getText().replaceAll("\\s",""), internacional);
									
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setHeaderText(null);
									alert.setContentText("Existe liga > > "+resultado[0] + "    |    " + " Inserción realizada > > "+resultado[1]);

									alert.showAndWait();

									stage_1.close();
									
									stage.close();

								}

							}
						});

						insertaSQL_procedimiento_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								stage_1.close();
							}
						});

					} catch (IOException e) {
						System.out.println(e.getMessage());
					}

				}
			});

			procedimiento_button_sqlServer_visualizaContratos.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					List<String> choices = sqlServer.get_dni_futbolistas();

					ChoiceDialog<String> dialog = new ChoiceDialog<>("24695203B", choices);
					dialog.setTitle("Visualizar Contratos según DNI o NIE");
					dialog.setHeaderText("Listado de futbolistas por DNI o NIE");
					dialog.setContentText("Elige un futbolista:");

					Optional<String> result = dialog.showAndWait();
					
					if (result.isPresent()){
						
						sqlServerArea.setText(sqlServer.procedimientoVisualizarListaContratos(result.get()));
						
						dialog.close();
						
					} else {
						
						dialog.close();
						
					}

					
					stage.close();
				}
			});

			procedimiento_button_sqlServer_cantidadFutbolistas.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					
					Scene scene_2;
					try {
						scene_2 = new Scene(fxmlLoader_2.load(), 600, 400);
						
						Stage stage_2 = new Stage();
						stage_2.setTitle("Cantidad de futbolistas");
						stage_2.setScene(scene_2);
						stage_2.show();
						
						insertaSQL_procedimientoCantidadFutbolistas_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {
								
								int [] resultado = null;
								
								if ((insertaSQL_procedimientoCantidadFutbolistas_textField_nomEquipo.getText() == null
										|| insertaSQL_procedimientoCantidadFutbolistas_textField_nomEquipo.getText().trim().isEmpty())| (insertaSQL_procedimientoCantidadFutbolistas_textField_precioAnual.getText() == null
										|| insertaSQL_procedimientoCantidadFutbolistas_textField_precioAnual.getText().trim().isEmpty()) | (insertaSQL_procedimientoCantidadFutbolistas_textField_precioRescision.getText() == null
										|| insertaSQL_procedimientoCantidadFutbolistas_textField_precioRescision.getText().trim().isEmpty())) {

									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Aviso");
									alert.setHeaderText(null);
									alert.setContentText("Ningún campo puede quedar vacío");

									alert.showAndWait();

								} else {

									String nombreEquipo = insertaSQL_procedimientoCantidadFutbolistas_textField_nomEquipo.getText().replaceAll("\\s","");
									
									int precioAnual = Integer.parseInt((insertaSQL_procedimientoCantidadFutbolistas_textField_precioAnual.getText().replaceAll("\\s","")));
									
									int precioRescision = Integer.parseInt((insertaSQL_procedimientoCantidadFutbolistas_textField_precioRescision.getText().replaceAll("\\s","")));

									
									resultado = sqlServer.procedimientoCantidadFutbolistas(nombreEquipo, precioAnual, precioRescision);
									
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setHeaderText(null);
									alert.setContentText("Futbolistas en activo > > "+resultado[0] + "    |    " + " Futbolistas en activo con precio menor > > "+resultado[1]);

									alert.showAndWait();

									stage_2.close();
									
									stage.close();

								}

							}
						});

						insertaSQL_procedimientoCantidadFutbolistas_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								stage_2.close();
							}
						});

						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});

			procedimiento_button_sqlServer_cantidadMeses.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					
					List<String> choices = sqlServer.get_dni_futbolistas();

					ChoiceDialog<String> dialog = new ChoiceDialog<>("24695203B", choices);
					dialog.setTitle("Visualizar cantidad de meses");
					dialog.setHeaderText("Listado de futbolistas por DNI o NIE");
					dialog.setContentText("Elige un futbolista:");

					Optional<String> result = dialog.showAndWait();
					
					String futbolista = "";
					
					if (result.isPresent()){
						
						futbolista = result.get();
												
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Cantidad de meses");
						alert.setHeaderText(null);
						alert.setContentText("Cantidad de meses > > > "+sqlServer.funcionCantidadMeses(futbolista));

						alert.showAndWait();
						
						dialog.close();
						
					} else {
						
						dialog.close();
						
					}

					stage.close();
				}
			});

			procedimiento_button_salir.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}


	// MYSQL

	private void mysql_visualizaButton() {

		mysqlArea.setText(mysql.visualizarEquipos_nombreLiga());

	}

	private void mysql_insertarButton() {

		try {

			FXMLLoader fxmlLoader_1 = new FXMLLoader();
			fxmlLoader_1.setLocation(getClass().getResource("/fxml/MySQL/Insertar_mysql.fxml"));
			fxmlLoader_1.setController(this);

			Scene scene = new Scene(fxmlLoader_1.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Insertar equipo");
			stage.setScene(scene);
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			insertaMysql_comboBox_nomLiga.setItems(FXCollections.observableArrayList(mysql.array_nombreLigas()));

			insertaMysql_comboBox_nomLiga.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			insertaMysql_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					if ((insertaMysql_textField_nomEquipo.getText() == null
							|| insertaMysql_textField_localidad.getText().trim().isEmpty())) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Aviso");
						alert.setHeaderText(null);
						alert.setContentText("Ningún campo puede quedar vacío");

						alert.showAndWait();

					} else {

						int internacional = 0;
						String nombreLiga = insertaMysql_comboBox_nomLiga.getSelectionModel().getSelectedItem();

						if (insertaMysql_checkBox_internacional.isSelected()) {

							internacional = 1;

						}

						mysql.insertarEquipo(insertaMysql_textField_nomEquipo.getText(),
								mysql.get_codigo_liga(nombreLiga), insertaMysql_textField_localidad.getText(),
								internacional);

						stage.close();

					}

				}
			});

			insertaMysql_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private void mysql_eliminarButton() {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/mysql/Eliminar_mysql.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Eliminar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_eliminar_mysql.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_eliminar_mysql.setItems(FXCollections.observableArrayList(mysql.array_nombreEquipos()));

			combo_eliminar_mysql.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			button_mysql_eliminar_eliminaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar equipo");
					// alert.setHeaderText("Look, a Confirmation Dialog");
					alert.setContentText("¿Quisieras eliminar también los contratos asociados?");

					ButtonType buttonType_si = new ButtonType("Sí");
					ButtonType buttonType_soloEquipo = new ButtonType("Sólo el equipo");
					ButtonType buttonType_cancelar = new ButtonType("Cancelar");

					alert.getButtonTypes().setAll(buttonType_si, buttonType_soloEquipo, buttonType_cancelar);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonType_soloEquipo) {

						mysql.eliminarEquipo(combo_eliminar_mysql.getSelectionModel().getSelectedItem());

						stage.close();

					} else if (result.get() == buttonType_si) {

						mysql.eliminarEquipoYContratos(combo_eliminar_mysql.getSelectionModel().getSelectedItem());

						stage.close();

					}
				}
			});

			button_mysql_cancelar_eliminaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private void mysql_modificarButton() {
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/mysql/Modificar_mysql.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Modificar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_modificar_mysql.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_modificar_mysql.setItems(FXCollections.observableArrayList(mysql.array_nombreEquipos()));

			combo_modificar_mysql.getSelectionModel().selectFirst();

			FXMLLoader fxmlLoader_1 = new FXMLLoader();
			fxmlLoader_1.setLocation(getClass().getResource("/fxml/mysql/Modificar_mostrarEquipo_mysql.fxml"));
			fxmlLoader_1.setController(this);

			Scene scene_1;

			scene_1 = new Scene(fxmlLoader_1.load(), 600, 400);

			button_mysql_modificar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				final class Modificaciones_1 {

					String nombreEquipo;
					int codigoEquipo;
					String localidad;
					int internacional;
					String codigoLiga;
					String nombreLiga;

					public String getNombreEquipo() {
						return nombreEquipo;
					}

					public void setNombreEquipo(String nombreEquipo) {
						this.nombreEquipo = nombreEquipo;
					}

					public int getCodigoEquipo() {
						return codigoEquipo;
					}

					public void setCodigoEquipo(int codigoEquipo) {
						this.codigoEquipo = codigoEquipo;
					}

					public String getLocalidad() {
						return localidad;
					}

					public void setLocalidad(String localidad) {
						this.localidad = localidad;
					}

					public int getInternacional() {
						return internacional;
					}

					public void setInternacional(int internacional) {
						this.internacional = internacional;
					}

					public String getCodigoLiga() {
						return codigoLiga;
					}

					public void setCodigoLiga(String codigoLiga) {
						this.codigoLiga = codigoLiga;
					}

					public String getNombreLiga() {
						return nombreLiga;
					}

					public void setNombreLiga(String nombreLiga) {
						this.nombreLiga = nombreLiga;
					}

				}

				public void handle(ActionEvent event) {

					Modificaciones_1 modificaciones = new Modificaciones_1();

					Stage stage_1 = new Stage();
					stage_1.setTitle("Modificar equipo");
					stage_1.setScene(scene_1);
					stage_1.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
					stage_1.show();

					// código de equipo

					modificaciones.setCodigoEquipo(
							mysql.get_codigo_equipo(combo_modificar_mysql.getSelectionModel().getSelectedItem()));

					modificaMysql_textField_codEquipo.setEditable(false);

					modificaMysql_textField_codEquipo.setText(Integer.toString(modificaciones.getCodigoEquipo()));

					// Nombre de equipo

					modificaciones.setNombreEquipo(
							combo_modificar_mysql.getSelectionModel().getSelectedItem().replaceAll("\\s+$", ""));

					modificaMysql_textField_nomEquipo.setText(modificaciones.getNombreEquipo());

					// Código liga

					modificaciones.setCodigoLiga(mysql.get_codigo_liga(modificaciones.getCodigoEquipo()));

					// Nombres ligas de fútbol (combo box)

					modificaciones.setNombreLiga(mysql.get_nombre_liga(modificaciones.getCodigoLiga()));

					modificaMysql_comboBox_nomLiga
							.setItems(FXCollections.observableArrayList(mysql.array_nombreLigas()));

					modificaMysql_comboBox_nomLiga.setValue(modificaciones.getNombreLiga());

					// Localidad

					modificaciones.setLocalidad(mysql.get_localidad_equipo(modificaciones.getCodigoEquipo()));

					modificaMysql_textField_localidad.setText(modificaciones.getLocalidad());

					// Internacional

					modificaciones.setInternacional(0);

					if (mysql.get_internacional_equipo(modificaciones.getCodigoEquipo()) == 1) {

						modificaMysql_checkBox_internacional.fire();

						modificaciones.setInternacional(1);

					}

					modificaMysql_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							stage_1.close();

						}
					});

					modificaMysql_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							int internacional = modificaciones.getInternacional();
							int codigoEquipo = modificaciones.getCodigoEquipo();
							String codigoLiga = modificaMysql_comboBox_nomLiga.getSelectionModel().getSelectedItem();
							String localidad = modificaMysql_textField_localidad.getText();
							String nombreEquipo = modificaMysql_textField_nomEquipo.getText();

							if (modificaMysql_checkBox_internacional.isSelected()) {

								internacional = 1;

							} else {

								internacional = 0;

							}

							// Código liga

							codigoLiga = mysql.get_codigo_liga(
									modificaMysql_comboBox_nomLiga.getSelectionModel().getSelectedItem());

							mysql.modificarEquipo(codigoEquipo, nombreEquipo, codigoLiga, localidad, internacional);

							stage_1.close();
							stage.close();
						}
					});
				}
			});

			button_mysql_cancelar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void mysql_procedimientoButton() {
		
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/mysql/Procedimientos_menu_mysql.fxml"));
			fxmlLoader.setController(this);
			
			FXMLLoader fxmlLoader_1 = new FXMLLoader(); //procedimiento de "Insertar Equipo"
			fxmlLoader_1.setLocation(
			getClass().getResource("/fxml/mysql/insertar_procedimiento_mysql.fxml"));
			fxmlLoader_1.setController(this);

			FXMLLoader fxmlLoader_2 = new FXMLLoader(); //procedimiento de "Cantidad Futbolistas"
			fxmlLoader_2.setLocation(
			getClass().getResource("/fxml/mysql/Procedimiento_cantidadFutbolistas_mysql.fxml"));
			fxmlLoader_2.setController(this);
			
			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Elegir procedimiento");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			procedimiento_button_mysql_insertaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					try {

						Scene scene_1 = new Scene(fxmlLoader_1.load(), 600, 400);

						Stage stage_1 = new Stage();
						stage_1.setTitle("Insertar equipo");
						stage_1.setScene(scene_1);
						stage_1.show();

						insertaMysql_procedimiento_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {
								
								int [] resultado = null;
								
								if ((insertaMysql_procedimiento_textField_nomEquipo.getText() == null
										|| insertaMysql_procedimiento_textField_localidad.getText().trim().isEmpty())) {

									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Aviso");
									alert.setHeaderText(null);
									alert.setContentText("Ningún campo puede quedar vacío");

									alert.showAndWait();

								} else {

									int internacional = 0;
									String nombreLiga = insertaMysql_procedimiento_textField_nomLiga.getText().replaceAll("\\s","");

									if (insertaMysql_procedimiento_checkBox_internacional.isSelected()) {

										internacional = 1;

									}
									
									resultado = mysql.procedimientoInsertarEquipo(
											insertaMysql_procedimiento_textField_nomEquipo.getText().replaceAll("\\s",""),
											nombreLiga,
											insertaMysql_procedimiento_textField_localidad.getText().replaceAll("\\s",""), internacional);
									
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setHeaderText(null);
									alert.setContentText("Existe liga > > "+resultado[0] + "    |    " + " Inserción realizada > > "+resultado[1]);

									alert.showAndWait();

									stage_1.close();
									
									stage.close();

								}

							}
						});

						insertaMysql_procedimiento_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								stage_1.close();
							}
						});

					} catch (IOException e) {
						System.out.println(e.getMessage());
					}

				}
			});

			procedimiento_button_mysql_visualizaContratos.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					List<String> choices = mysql.get_dni_futbolistas();

					ChoiceDialog<String> dialog = new ChoiceDialog<>("24695203B", choices);
					dialog.setTitle("Visualizar Contratos según DNI o NIE");
					dialog.setHeaderText("Listado de futbolistas por DNI o NIE");
					dialog.setContentText("Elige un futbolista:");

					Optional<String> result = dialog.showAndWait();
					
					if (result.isPresent()){
						
						mysqlArea.setText(mysql.procedimientoVisualizarListaContratos(result.get()));
						
						dialog.close();
						
					} else {
						
						dialog.close();
						
					}

					
					stage.close();
				}
			});

			procedimiento_button_mysql_cantidadFutbolistas.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					
					Scene scene_2;
					try {
						scene_2 = new Scene(fxmlLoader_2.load(), 600, 400);
						
						Stage stage_2 = new Stage();
						stage_2.setTitle("Cantidad de futbolistas");
						stage_2.setScene(scene_2);
						stage_2.show();
						
						insertaMysql_procedimientoCantidadFutbolistas_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {
								
								int [] resultado = null;
								
								if ((insertaMysql_procedimientoCantidadFutbolistas_textField_nomEquipo.getText() == null
										|| insertaMysql_procedimientoCantidadFutbolistas_textField_nomEquipo.getText().trim().isEmpty())| (insertaMysql_procedimientoCantidadFutbolistas_textField_precioAnual.getText() == null
										|| insertaMysql_procedimientoCantidadFutbolistas_textField_precioAnual.getText().trim().isEmpty()) | (insertaMysql_procedimientoCantidadFutbolistas_textField_precioRescision.getText() == null
										|| insertaMysql_procedimientoCantidadFutbolistas_textField_precioRescision.getText().trim().isEmpty())) {

									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Aviso");
									alert.setHeaderText(null);
									alert.setContentText("Ningún campo puede quedar vacío");

									alert.showAndWait();

								} else {

									String nombreEquipo = insertaMysql_procedimientoCantidadFutbolistas_textField_nomEquipo.getText().replaceAll("\\s","");
									
									int precioAnual = Integer.parseInt((insertaMysql_procedimientoCantidadFutbolistas_textField_precioAnual.getText().replaceAll("\\s","")));
									
									int precioRescision = Integer.parseInt((insertaMysql_procedimientoCantidadFutbolistas_textField_precioRescision.getText().replaceAll("\\s","")));

									
									resultado = mysql.procedimientoCantidadFutbolistas(nombreEquipo, precioAnual, precioRescision);
									
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setHeaderText(null);
									alert.setContentText("Futbolistas en activo > > "+resultado[0] + "    |    " + " Futbolistas en activo con precio menor > > "+resultado[1]);

									alert.showAndWait();

									stage_2.close();
									
									stage.close();

								}

							}
						});

						insertaMysql_procedimientoCantidadFutbolistas_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

							public void handle(ActionEvent event) {

								stage_2.close();
							}
						});

						
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});

			procedimiento_button_mysql_cantidadMeses.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {
					
					List<String> choices = mysql.get_dni_futbolistas();

					ChoiceDialog<String> dialog = new ChoiceDialog<>("24695203B", choices);
					dialog.setTitle("Visualizar cantidad de meses");
					dialog.setHeaderText("Listado de futbolistas por DNI o NIE");
					dialog.setContentText("Elige un futbolista:");

					Optional<String> result = dialog.showAndWait();
					
					String futbolista = "";
					
					if (result.isPresent()){
						
						futbolista = result.get();
												
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Cantidad de meses");
						alert.setHeaderText(null);
						alert.setContentText("Cantidad de meses > > > "+mysql.funcionCantidadMeses(futbolista));

						alert.showAndWait();
						
						dialog.close();
						
					} else {
						
						dialog.close();
						
					}

					stage.close();
				}
			});

			procedimiento_button_mysql_salir.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// ACCESS

	private void access_visualizarButton() {

		accessArea.setText(access.visualizarEquipos_nombreLiga());

	}

	private void access_insertarButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/Access/Insertar_access.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Insertar equipo");
			stage.setScene(scene);
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			insertaAccess_comboBox_nomLiga.setItems(FXCollections.observableArrayList(access.array_nombreLigas()));

			insertaAccess_comboBox_nomLiga.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			insertaAccess_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					if ((insertaAccess_textField_nomEquipo.getText() == null
							|| insertaAccess_textField_localidad.getText().trim().isEmpty())) {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Aviso");
						alert.setHeaderText(null);
						alert.setContentText("Ningún campo puede quedar vacío");

						alert.showAndWait();

					} else {

						int internacional = 0;
						String nombreLiga = insertaAccess_comboBox_nomLiga.getSelectionModel().getSelectedItem();

						if (insertaAccess_checkBox_internacional.isSelected()) {

							internacional = 1;

						}

						access.insertarEquipo(insertaAccess_textField_nomEquipo.getText(),
								access.get_codigo_liga(nombreLiga), insertaAccess_textField_localidad.getText(),
								internacional);

						stage.close();

					}

				}
			});

			insertaAccess_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private void access_eliminarButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/access/Eliminar_access.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Eliminar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_eliminar_access.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_eliminar_access.setItems(FXCollections.observableArrayList(access.array_nombreEquipos()));

			combo_eliminar_access.getSelectionModel().selectFirst();

			///////////////// \\\\\\\\\\\\\\\\

			button_access_eliminar_access.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Eliminar equipo");
					// alert.setHeaderText("Look, a Confirmation Dialog");
					alert.setContentText("¿Quisieras eliminar también los contratos asociados?");

					ButtonType buttonType_si = new ButtonType("Sí");
					ButtonType buttonType_soloEquipo = new ButtonType("Sólo el equipo");
					ButtonType buttonType_cancelar = new ButtonType("Cancelar");

					alert.getButtonTypes().setAll(buttonType_si, buttonType_soloEquipo, buttonType_cancelar);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == buttonType_soloEquipo) {

						access.eliminarEquipo(combo_eliminar_access.getSelectionModel().getSelectedItem());

						stage.close();

					} else if (result.get() == buttonType_si) {

						access.eliminarEquipoYContratos(combo_eliminar_access.getSelectionModel().getSelectedItem());

						stage.close();

					}
				}
			});

			button_access_cancelar_access.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	private void access_modificarButton() {

		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/fxml/Access/Modificar_access.fxml"));
			fxmlLoader.setController(this);

			Scene scene = new Scene(fxmlLoader.load(), 600, 400);

			Stage stage = new Stage();
			stage.setTitle("Modificar equipo");
			stage.setScene(scene);
			stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
			stage.show();

			// COMBO BOX DE LIGAS DE FUTBOL\\

			combo_modificar_access.setStyle(
					"-fx-alignment: CENTER; -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n"
							+ "    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n"
							+ "        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); -fx-text-fill: -fx-text-inner-color;");

			combo_modificar_access.setItems(FXCollections.observableArrayList(access.array_nombreEquipos()));

			combo_modificar_access.getSelectionModel().selectFirst();

			FXMLLoader fxmlLoader_1 = new FXMLLoader();
			fxmlLoader_1.setLocation(getClass().getResource("/fxml/Access/Modificar_mostrarEquipo_access.fxml"));
			fxmlLoader_1.setController(this);

			Scene scene_1;

			scene_1 = new Scene(fxmlLoader_1.load(), 600, 400);

			button_access_modificar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				final class Modificaciones_1 {

					String nombreEquipo;
					int codigoEquipo;
					String localidad;
					int internacional;
					String codigoLiga;
					String nombreLiga;

					public String getNombreEquipo() {
						return nombreEquipo;
					}

					public void setNombreEquipo(String nombreEquipo) {
						this.nombreEquipo = nombreEquipo;
					}

					public int getCodigoEquipo() {
						return codigoEquipo;
					}

					public void setCodigoEquipo(int codigoEquipo) {
						this.codigoEquipo = codigoEquipo;
					}

					public String getLocalidad() {
						return localidad;
					}

					public void setLocalidad(String localidad) {
						this.localidad = localidad;
					}

					public int getInternacional() {
						return internacional;
					}

					public void setInternacional(int internacional) {
						this.internacional = internacional;
					}

					public String getCodigoLiga() {
						return codigoLiga;
					}

					public void setCodigoLiga(String codigoLiga) {
						this.codigoLiga = codigoLiga;
					}

					public String getNombreLiga() {
						return nombreLiga;
					}

					public void setNombreLiga(String nombreLiga) {
						this.nombreLiga = nombreLiga;
					}

				}

				public void handle(ActionEvent event) {

					Modificaciones_1 modificaciones = new Modificaciones_1();

					Stage stage_1 = new Stage();
					stage_1.setTitle("Modificar equipo");
					stage_1.setScene(scene_1);
					stage_1.getIcons().add(new Image(getClass().getResourceAsStream("/images/pelota.png")));
					stage_1.show();

					// código de equipo

					modificaciones.setCodigoEquipo(
							access.get_codigo_equipo(combo_modificar_access.getSelectionModel().getSelectedItem()));

					modificaAccess_textField_codEquipo.setEditable(false);

					modificaAccess_textField_codEquipo.setText(Integer.toString(modificaciones.getCodigoEquipo()));

					// Nombre de equipo

					modificaciones.setNombreEquipo(
							combo_modificar_access.getSelectionModel().getSelectedItem().replaceAll("\\s+$", ""));

					modificaAccess_textField_nomEquipo.setText(modificaciones.getNombreEquipo());

					// Código liga

					modificaciones.setCodigoLiga(access.get_codigo_liga(modificaciones.getCodigoEquipo()));

					// Nombres ligas de fútbol (combo box)

					modificaciones.setNombreLiga(access.get_nombre_liga(modificaciones.getCodigoLiga()));

					modificaAccess_comboBox_nomLiga
							.setItems(FXCollections.observableArrayList(access.array_nombreLigas()));

					modificaAccess_comboBox_nomLiga.setValue(modificaciones.getNombreLiga());

					// Localidad

					modificaciones.setLocalidad(access.get_localidad_equipo(modificaciones.getCodigoEquipo()));

					modificaAccess_textField_localidad.setText(modificaciones.getLocalidad());

					// Internacional

					modificaciones.setInternacional(0);

					if (access.get_internacional_equipo(modificaciones.getCodigoEquipo()) == 1) {

						modificaAccess_checkBox_internacional.fire();

						modificaciones.setInternacional(1);

					}

					modificaAccess_buttonCancel.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							stage_1.close();

						}
					});

					modificaAccess_buttonAccept.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							int internacional = modificaciones.getInternacional();
							int codigoEquipo = modificaciones.getCodigoEquipo();
							String codigoLiga = modificaAccess_comboBox_nomLiga.getSelectionModel().getSelectedItem();
							String localidad = modificaAccess_textField_localidad.getText();
							String nombreEquipo = modificaAccess_textField_nomEquipo.getText();

							if (modificaAccess_checkBox_internacional.isSelected()) {

								internacional = 1;

							} else {

								internacional = 0;

							}

							// Código liga

							codigoLiga = access.get_codigo_liga(
									modificaAccess_comboBox_nomLiga.getSelectionModel().getSelectedItem());

							access.modificarEquipo(codigoEquipo, nombreEquipo, codigoLiga, localidad, internacional);

							stage_1.close();
							stage.close();
						}
					});
				}
			});

			button_access_cancelar_modificaEquipo.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent event) {

					stage.close();
				}
			});

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public VBox getView() {
		return view;
	}

}

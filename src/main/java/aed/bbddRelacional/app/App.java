package aed.bbddRelacional.app;

import aed.bbddRelacional.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		controller = new Controller();

		Scene escena = new Scene(controller.getView());

		primaryStage.setTitle("BBDD Relacionales Diego Méndez");
		primaryStage.setScene(escena);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}

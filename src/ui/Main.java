package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		MenuControllerGUI controller = new MenuControllerGUI();
		loader.setController(controller);
		Parent root = loader.load();
		Scene sc = new Scene(root);
		
		//Parent root = FXMLLoader.load(getClass().getResource("TemperatureConverter.fxml"));
		//Scene sc = new Scene(root);
		primaryStage.setScene(sc);
		primaryStage.setTitle("Contact Manager");
		primaryStage.show();
		
	}

}

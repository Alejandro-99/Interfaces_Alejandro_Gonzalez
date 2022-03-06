package ch.makery.address;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ch.makery.address.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	
	private ObservableList<Map<String,Object>> mapData = FXCollections.observableArrayList();
	
	public Main() {	
		
		Map<String, Object> item1 = new HashMap<>();
		item1.put("firstName", "Hans");
		item1.put("lastName" , "Muster");

		mapData.add(item1);

		Map<String, Object> item2 = new HashMap<>();
		item2.put("firstName", "Ruth");
		item2.put("lastName" , "Mueller");

		mapData.add(item2);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		showPersonOverview();
	}

	
	public void initRootLayout() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void showPersonOverview() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			
			rootLayout.setCenter(personOverview);
			
			
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	public ObservableList<Map<String,Object>> getMapData() {
		return mapData;
	}
	
	
}
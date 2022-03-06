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

	// Alternativa con maps para incluir el listado de personas
	private ObservableList<Map<String,Object>> mapData = FXCollections.observableArrayList();
	
	public Main() {	
		// Probamos el map con solo dos �tems, ya que como se puede observar requiere m�s l�neas de c�digo que la altenrativa anterior
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

	/**
	 * Inicializa el dise�o de la pantalla principal.
	 */
	public void initRootLayout() {
		try {
			// Carga el XML con el dise�o principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se a�ade el dise�o principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el dise�o de PersonOverview dentro de la pantalla principal
	 */
	public void showPersonOverview() {
		try {
			// Cargamos el archivo PersonOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Se sit�a en el centro del dise�o principal
			rootLayout.setCenter(personOverview);
			
			// Damos al controlador acceso a la aplicaic�n principal
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * M�todo get para obtener el listado de personas (versi�n mapa)
	 * @return
	 */
	public ObservableList<Map<String,Object>> getMapData() {
		return mapData;
	}
	
	
}
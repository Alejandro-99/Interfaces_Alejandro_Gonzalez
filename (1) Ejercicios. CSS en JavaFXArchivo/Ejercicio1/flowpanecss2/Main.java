package flowpanecss2;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
	private FlowPane rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("FlowPaneLayout.fxml"));
			rootLayout = (FlowPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			scene.getStylesheets().add("flowpanecss2/style.css");
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
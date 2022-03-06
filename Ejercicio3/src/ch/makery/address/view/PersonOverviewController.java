package ch.makery.address.view;

import java.util.Map;

import ch.makery.address.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
	// Versi�n con map
	@FXML
    private TableView<Map<String,Object>> personTable;
    @FXML
    private TableColumn<Map<String,Object>, String> firstNameColumn;
    @FXML
    private TableColumn<Map<String,Object>, String> lastNameColumn;
	
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Referencia a la aplicaci�n principal
    private Main mainApp;    
    
    /**
     * M�todo para inicializar el controlador que se llama cuando se carga el FXML
     */
	@FXML
    private void initialize() {    		
    	// Versi�n con map 
    	// Se crea un objeto que herede de ObservableValue
    	firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("firstName").toString()));
    	lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("lastName").toString()));
    	
    	// Se puede usar MapValueFactory, pero para que funcione hay que declarar Map sin par�metros
    	// Como en este caso el Map tiene los pares clave-valor de tipos String y Object, entonces no funciona MapValueFactory con String como par�metro
    	// Para solucionarlo basta con quitar los par�metros, pero tenemos advertencias a la hora de compilar
    	//firstNameColumn.setCellValueFactory(new MapValueFactory("firstName"));
    	//lastNameColumn.setCellValueFactory(new MapValueFactory("lastName"));
    	
    }

    /**
     * Referencia a la aplicaci�n principal
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        
        // Versi�n con map
        personTable.setItems(this.mainApp.getMapData()); 
    }
}
package choiceEjercicio;

import java.util.Arrays;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class Controlador {

    @FXML
    private Button boton;

    @FXML
    private ListView<String> lista;
    
    
    @FXML
    void click(MouseEvent event) {
    	
    	boton.setDisable(lista.getSelectionModel().getSelectedItems().isEmpty());

    }
    
    @FXML
    void ratonOut(MouseEvent event) {
    	
    	if(boton.isDisable()) {
    	
    	Alert infoAlert = new Alert(AlertType.INFORMATION);

    	infoAlert.setTitle("Ejemplo de diálogo");
    	infoAlert.setHeaderText("Alert informativo");
    	infoAlert.setContentText("Esto es un ejemplo de diálogos en Java FX...");
    	
        infoAlert.showAndWait();
    	}

    }
   
    @FXML
    void initialize() {
    	
    	lista.getItems().addAll("Opcion 1","Opcion 2","Opcion 3","Opcion 4","Opcion 5","Opcion 6","Opcion 7","Opcion 8","Opcion 9","Opcion 10");
    	lista.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	
    	boton.setOnAction(e -> {
    		List<String> dialogData = lista.getSelectionModel().getSelectedItems();
    		ChoiceDialog<String> choiceDialog = new ChoiceDialog<String>(dialogData.get(0),dialogData);
        	choiceDialog.setTitle("Ejemplo de diálogo");
        	choiceDialog.setHeaderText("Seleccione un valor...");
    	
    	choiceDialog.showAndWait().ifPresent(response -> {
    	
    		lista.getSelectionModel().clearSelection();
    		lista.getSelectionModel().select(response);
          
    	});;
    	});
    	

    }

}

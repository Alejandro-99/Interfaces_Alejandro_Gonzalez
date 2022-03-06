package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EjercicioController {

	@FXML
    private ListView<String> qualificationsList;

	@FXML
	private ComboBox<String> langChoice;
	
    @FXML
    private ChoiceBox<Object> locationChoice;
        
    @FXML
    private TreeView<String> dataTree;
    
  
    private ObservableList<String> names = FXCollections.observableArrayList();
    private ObservableList<String> data = FXCollections.observableArrayList();
    
    @FXML
    private void initialize() {   
    	names.addAll("Objects", "Classes", "Functions", "Variables", "Compiler", "Debugger", 
    			"Projects", "Beans", "Libraries", "Modules", "JARs");

    	for (int i = 0; i < 10; i++) {
            data.add("Indeterminate (pick a choice)");
        }
    	
    	
    	qualificationsList.setItems(data);
    	qualificationsList.setCellFactory(ComboBoxListCell.forListView(names)); 
    	
    	
    	langChoice.getItems().addAll("English", "Japanese", "Spanish");
    	langChoice.setValue("Select a language");
    	
    	
    	locationChoice.setItems(FXCollections.observableArrayList("New York", "Orlando", 
    		    new Separator(), "London", "Manchester"));
    	locationChoice.setValue("Select a value...");
    	
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream("img/Folder.PNG");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    	
    	ImageView imageView = new ImageView(new Image(fis)); 
    	imageView.setPreserveRatio(true);
    	imageView.setFitHeight(20);
	    	
    	
    	TreeItem<String> rootItem = new TreeItem<String> ("Inbox", imageView);
    	rootItem.setExpanded(true);
    	
    	List<String> treeListItems = new ArrayList<String>(Arrays.asList("Sales", 
    			"Marketing", "Distribution", "Costs"));
    	
    	
        for (String item : treeListItems) {
            TreeItem<String> treeItem = new TreeItem<String>(item);            
            rootItem.getChildren().add(treeItem);
        }     
        
        dataTree.setRoot(rootItem);
        
    }
    
}

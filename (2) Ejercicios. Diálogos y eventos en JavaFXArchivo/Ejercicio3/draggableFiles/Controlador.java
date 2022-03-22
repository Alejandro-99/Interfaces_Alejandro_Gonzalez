package draggableFiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

public class Controlador {

	@FXML
	private Text fin;

	@FXML
	private ImageView imagen;

	@FXML
	private Text inicio;
    
    @FXML
    private void initialize() { 
    	
    }
    @FXML
    void handleDragDetected(MouseEvent event) {
    	Dragboard db = inicio.startDragAndDrop(TransferMode.ANY);
    	
    	ClipboardContent cb = new ClipboardContent();
    	cb.putString(inicio.getText());
    	db.setContent(cb);
    	
    	event.consume();

    }
    
    @FXML
    void handleDragOverFin(DragEvent event) {
    	
    	if(event.getDragboard().hasString()) {
        	event.acceptTransferModes(TransferMode.ANY);
        }

    }
    
    @FXML
    void handleDragDroppedFin(DragEvent event) {
    	
    	String str = event.getDragboard().getString();
    	fin.setText(str);

    }
    
    @FXML
    void handleDragDone(DragEvent event) {
    	
    	inicio.setText("Operacion drag terminada");

    }

    @FXML
    void handleDragOver(DragEvent event) {
    	
    	if(event.getDragboard().hasFiles()) {
    	event.acceptTransferModes(TransferMode.ANY);
    	}

    }
    @FXML
    void handleDragDropped(DragEvent event) throws FileNotFoundException {
    	
    	List<File> files =  event.getDragboard().getFiles();
    	Image img = new Image(new FileInputStream(files.get(0)));
    	imagen.setImage(img);

    }

}

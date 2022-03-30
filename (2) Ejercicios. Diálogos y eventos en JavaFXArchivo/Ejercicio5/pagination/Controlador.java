package pagination;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Controlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Pagination paginador;
    
    @FXML
    private ProgressBar barraP;
    
    private String[] p = new String[23];

    public VBox createPage(int pageIndex) {  
    	 
    	 for (int i = 0; i < p.length; i++) {
			p[i] = Persona.getFullName();
		}
        int itemsPerPage = 5;
        VBox box = new VBox();
        int page = pageIndex * itemsPerPage;         
        for (int i = page; i < page + itemsPerPage; i++) {            
            
        	if(p.length>i) {
            Label text = new Label( (i+1) + ".- " + p[i]);
                
            box.getChildren().add(text);
        	}
        }
        return box;
    }

    @FXML
    void initialize() {
    	
    	paginador.setMaxPageIndicatorCount(4);
    	
    	if(p.length%2==0) {
    		paginador.setPageCount((p.length/5));
    	}else {
    		paginador.setPageCount((p.length/5)+1);
    	}
        
    	paginador.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(pageIndex);
            }
        });
    	
    	paginador.currentPageIndexProperty().addListener((observable, oldValue, newValue) -> {
            
    		barraP.setProgress((newValue.doubleValue()+1)/paginador.getPageCount());
    		
        });
    	

    	
    	
    }

}
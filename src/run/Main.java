package run;


import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.Sdata;

public class Main extends Application {
    BorderPane root;
    
    layout.Login loginLayout;
    
    
    @Override
    public void start(Stage primaryStage) {
        
    	
        loginLayout=new layout.Login(primaryStage);
        root = new BorderPane();
        layout.LayoutManager.applyLayout(loginLayout, root);
        loadAliases();
 	    
        primaryStage.show();
 
        
        
    }
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void loadAliases(){
    	Sdata.aliases=new ArrayList<LinkedList<String>>();
    	for(int i=0;i<12;i++){
    		Sdata.aliases.add(new LinkedList<String>());
    		Sdata.aliases.get(i).add("test");
    	}
    }
}
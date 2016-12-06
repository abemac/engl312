package run;


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
        Sdata.init();
 	    
        primaryStage.show();
 
        
        
    }
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
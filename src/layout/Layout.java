package layout;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class Layout {

	protected Stage primaryStage;
	
	public Layout(Stage primaryStage){
		this.primaryStage=primaryStage;
	}
	
	
	public abstract void applyTo(BorderPane bp);
	
}

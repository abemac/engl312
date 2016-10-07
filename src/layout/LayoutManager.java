package layout;

import javafx.scene.layout.BorderPane;

public class LayoutManager {
	
	private static Layout current;
	
	public static void applyLayout(Layout layout,BorderPane bp){
		
		current = layout;
		layout.applyTo(bp);
		
	}
	
	
	
	public static Layout getCurrentLayout(){
		return current;
	}
}
